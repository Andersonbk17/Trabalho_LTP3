/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Email;
import br.edu.ifnmg.tads.Ltp3.Model.Endereco;
import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.Pessoa;
import br.edu.ifnmg.tads.Ltp3.Model.Telefone;
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
            tempPessoa.setId(obj.getId());
            tempPessoa.setAtivo(obj.getAtivo());
            
            if(obj.getId() == 0){
                int id = dao.Salvar(tempPessoa);
            
                PreparedStatement comando = banco.getConexao()
                        .prepareStatement("INSERT INTO usuarios_sistema"
                        + " (usuario,senha, id_pessoa,ativo) VALUES(?,?,?,?)");
                comando.setString(1, obj.getUsuario());
                comando.setString(2, obj.getSenha());
                comando.setInt(3, id);
                comando.setInt(4, obj.getAtivo());
                comando.executeUpdate();
                comando.getConnection().commit();
            
            }else{
                
                PreparedStatement comando = banco.getConexao()
                        .prepareStatement("UPDATE  usuarios_sistema SET "
                        + "usuario =? ,senha= ?, ativo = ? WHERE id = ?");
                comando.setString(1, obj.getUsuario());
                comando.setString(2, obj.getSenha());
                comando.setInt(3,obj.getAtivo());
                comando.setInt(4, obj.getId());
                comando.executeUpdate();
                comando.getConnection().commit();
            }
            return true;
        }catch(SQLException ex ){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public UsuarioSistema Abrir(int id) throws Exception{
        UsuarioSistema usuario_sistema = null;
        try{
                       
            PreparedStatement comando = banco
                    .getConexao().prepareStatement("SELECT * FROM usuarios_sistema "
                    + "WHERE id = ? AND ativo = 1");
            comando.setInt(1, id);
                    
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            
            
            Pessoa pessoa = null;
            if(consulta.first()){
                pessoa = new Pessoa();
                PessoaDAO daoPessoa = new PessoaDAO();
                pessoa = daoPessoa.Abrir(consulta.getInt("id_pessoa"));
                usuario_sistema = new UsuarioSistema();
                usuario_sistema.setIdUsuario(id);
            }
            
            if(pessoa != null){
               usuario_sistema.setAtivo(1);
               usuario_sistema.setCpf(pessoa.getCpf());
               usuario_sistema.setDataNascimento(pessoa.getDataNascimento());
               usuario_sistema.setEmails(pessoa.getEmails());
               usuario_sistema.setEnderecos(pessoa.getEnderecos());
               usuario_sistema.setNome(pessoa.getNome());
               usuario_sistema.setRg(pessoa.getRg());
               usuario_sistema.setTelefones(pessoa.getTelefones());
               usuario_sistema.setUsuario(consulta.getString("usuario"));
               
            
            }
            
            //Preencher telefones
            
            PreparedStatement comando2 = banco.getConexao()
                    .prepareStatement("SELECT * from telefones WHERE id_pessoa "
                    + "= ? AND ativo = 1");
            comando2.setInt(1, usuario_sistema.getId());

            ResultSet consulta2 = comando2.executeQuery();
            comando2.getConnection().commit();

            
            List<Telefone> listaTelefone = new LinkedList<>();
            while (consulta2.next()) {
                Telefone temp = new Telefone();
                temp.setId(consulta2.getInt("id"));
                temp.setDdd(consulta2.getInt("ddd"));
                temp.setNumero(consulta2.getInt("numero"));
                listaTelefone.add(temp);

            }
            usuario_sistema.setTelefones(listaTelefone);

            //Preencher Enderecos
            PreparedStatement comando3 = banco.getConexao()
                    .prepareStatement("SELECT * from enderecos WHERE id_pessoa "
                    + "= ? AND ativo = 1");
            comando3.setInt(1, usuario_sistema.getId());

            ResultSet consulta3 = comando3.executeQuery();
            comando3.getConnection().commit();

            List<Endereco> listaEnderecos = new LinkedList<>();
            while (consulta3.next()) {
                Endereco endereco = new Endereco();
                endereco.setBairro(consulta3.getString("bairro"));
                endereco.setCep(consulta3.getString("cep"));
                endereco.setCidade(consulta3.getString("cidade"));
                endereco.setEstado(consulta3.getString("estado"));
                endereco.setId(consulta3.getInt("id_endereco"));
                endereco.setNumero(Integer.parseInt(consulta3.getString("numero")));
                endereco.setRua(consulta3.getString("rua"));
                listaEnderecos.add(endereco);


            }

            usuario_sistema.setEnderecos(listaEnderecos);

            //Preenche emails
            PreparedStatement comando4 = banco.getConexao()
                    .prepareStatement("SELECT * FROM emails WHERE id_pessoa = ? AND ativo = 1");
            comando4.setInt(1, usuario_sistema.getId());

            ResultSet consulta4 = comando4.executeQuery();
            comando4.getConnection().commit();
            List<Email> listaEmails = new LinkedList<>();
            while (consulta4.next()) {
                Email temp = new Email();
                temp.setEndereco(consulta4.getString("endereco"));
                temp.setId(consulta4.getInt("id"));
                listaEmails.add(temp);

            }
            usuario_sistema.setEmails(listaEmails);

            return usuario_sistema;    
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
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
                   .getConexao().prepareStatement("UPDATE  usuarios_sistema SET ativo = 0 WHERE id = ?");
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
                    + "p inner join usuarios_sistema u on u.id_pessoa = p.id WHERE u.ativo = 1");
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
