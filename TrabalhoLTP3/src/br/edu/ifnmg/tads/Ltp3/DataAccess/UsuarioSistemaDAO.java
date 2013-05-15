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
    
}
