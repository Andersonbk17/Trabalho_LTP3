/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.Pessoa;
import br.edu.ifnmg.tads.Ltp3.Model.UsuarioSistema;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author modric
 */
public class UsuarioSistemaDAO {
    private Bd banco;
    
    public UsuarioSistemaDAO(){
        banco = new Bd();
    }
    
    public boolean Salvar(UsuarioSistema obj) throws ErroValidacaoException, Exception{
        try{
            
            PessoaDAO dao = new PessoaDAO();
            Pessoa tempPessoa = new Pessoa();
            
            tempPessoa.setCpf(obj.getCpf());
            tempPessoa.setDataNascimento(obj.getDataNascimento());
            tempPessoa.setEmails(obj.getEmails());
            tempPessoa.setEnderecos(obj.getEnderecos());
            tempPessoa.setNome(obj.getNome());
            tempPessoa.setRg(obj.getRg());
            tempPessoa.setTelefones(obj.getTelefones());
            
            int id = dao.Salvar(tempPessoa);
            
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("INSERT INTO usuarios_sistema (usuario,senha, id_pessoa) VALUES(?,?,?)");
            comando.setString(1, obj.getUsuario());
            comando.setString(2, obj.getSenha());
            comando.setInt(3, id);
            comando.executeUpdate();
            comando.getConnection().commit();
            return true;
        }catch(SQLException ex ){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    
    public boolean Apagar(int id){
        try{
           EmailDAO emailDAO = new EmailDAO();
           TelefoneDAO telefoneDAO= new TelefoneDAO();
           EnderecoDAO enderecoDAO = new EnderecoDAO();
           PessoaDAO pessoaDAO = new PessoaDAO();
           
           emailDAO.ApagarTodosQuandoExcluiPessoa(id);
           telefoneDAO.ApagarTodosQuandoExcluiPessoa(id);
           enderecoDAO.ApagarTodosQuandoExcluiPessoa(id);
           pessoaDAO.Apagar(id);
           
           PreparedStatement comando = banco
                   .getConexao().prepareStatement("DELETE FROM usuarios_sistema WHERE id = ?");
           comando.setInt(1, id);
           comando.execute();
           comando.getConnection().commit();
           
           return true;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    
    
    
    public List<UsuarioSistema> listarTodos() throws ErroValidacaoException, Exception{
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("select p.id as idpessoa,nome,cpf,rg,"
                    + "data_nascimento,u.id as idusuario, usuario from pessoas "
                    + "p inner join usuarios_sistema u on u.id_pessoa = p.id");
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            List<UsuarioSistema> Lista = new LinkedList<>();
            
            while(consulta.next()){
                UsuarioSistema tmp = new UsuarioSistema();
                tmp.setCpf(consulta.getString("cpf"));
                tmp.setDataNascimento(consulta.getDate("data_nascimento"));
                tmp.setNome(consulta.getString("nome"));
                tmp.setId(consulta.getInt("idpessoa"));
                tmp.setIdUsuario(consulta.getInt("idusuario"));
                tmp.setRg(consulta.getString("rg"));
                tmp.setUsuario(consulta.getString("usuario"));
                
                Lista.add(tmp);
                
            
            }
            return Lista;
                    
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    }
    
    
    public List<UsuarioSistema> Buscar(UsuarioSistema filtro) throws ErroValidacaoException, Exception{
        try{
            String sql = "select p.id as idpessoa,nome,cpf,rg,"
                    + "data_nascimento,u.id as idusuario, usuario from pessoas "
                    + "p inner join usuarios_sistema u on u.id_pessoa = p.id";
            String where = "";
            
            if(!filtro.getNome().isEmpty()){
                where = "nome like'%"+filtro.getNome()+"%'";
            
            }
            
            //se tiver um cpf
            if(!filtro.getCpf().isEmpty()){
                if(where.length() > 0){
                    where = where + " AND ";
                }
                where = where + " cpf = "+filtro.getCpf();
            
            }
            //se tiver RG
            if(!filtro.getRg().isEmpty()){
                if(where.length() > 0){
                    where = where + " AND ";
                }
                where = where + " rg = "+filtro.getRg();
            }
            
            //se tiver Usuário USER
            
            if(!filtro.getUsuario().isEmpty()){
                if(where.length() > 0){
                     where = where + " AND ";
                }
                where = where + " usuario = "+filtro.getUsuario();
            }
            
            // sentiver o id Usuario
            if(filtro.getIdUsuario() != 0){
                if(where.length() > 0){
                     where = where + " AND ";
                }
                where = where + " idusuario = "+filtro.getIdUsuario();
            
            }
            
            Statement comando = banco.getConexao().createStatement();
            ResultSet consulta = comando.executeQuery(sql);
            comando.getConnection().commit();
            
            List<UsuarioSistema> lista = null;
            if(consulta.first()){
                lista = new LinkedList<>();
                while(consulta.next()){
                    UsuarioSistema tmp = new UsuarioSistema();
                    
                tmp.setCpf(consulta.getString("cpf"));
                tmp.setDataNascimento(consulta.getDate("data_nascimento"));
                tmp.setNome(consulta.getString("nome"));
                tmp.setId(consulta.getInt("idpessoa"));
                tmp.setIdUsuario(consulta.getInt("idusuario"));
                tmp.setRg(consulta.getString("rg"));
                tmp.setUsuario(consulta.getString("usuario"));
                
                lista.add(tmp);
                    
                
                }
                
            }
            return lista;
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    }
    
}
