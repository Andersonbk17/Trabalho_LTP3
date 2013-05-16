/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Cliente;
import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author modric
 */
public class ClienteDAO {
    private Bd conexao;
   
    public ClienteDAO(){
        this.conexao = new Bd();
   }
    
   public boolean Salvar(Cliente obj)throws ErroValidacaoException, Exception{
       try{
           if(obj.getIdCliente() == 0){
               
               PessoaDAO dao = new PessoaDAO();
               Pessoa tmp = new Pessoa();
               
               tmp.setCpf(obj.getCpf());
               tmp.setDataNascimento(obj.getDataNascimento());
               tmp.setEmails(obj.getEmails());
               tmp.setEnderecos(obj.getEnderecos());
               tmp.setNome(obj.getNome());
               tmp.setRg(obj.getRg());
               tmp.setTelefones(obj.getTelefones());
               
               int idPessoa = dao.Salvar(tmp);
               
               PreparedStatement comando = conexao.getConexao()
                       .prepareStatement("INSERT INTO clientes (id_pessoa) VALUES(?)");
               comando.setInt(1, idPessoa);
               
               comando.executeUpdate();
               comando.getConnection().commit();
               
           
           }
       
           return true;
           
       }catch(SQLException ex){
           
           JOptionPane.showMessageDialog(null,ex);
           
           return false;
       }
   
   
   
   }
   
   public Cliente Abrir(int id) throws ErroValidacaoException, Exception{
       try{
           PreparedStatement comando = conexao
                   .getConexao().prepareStatement("SELECT c.id as idcliente, p.id as "
                   + "idpessoa,p.nome,p.cpf,p.rg,p.data_nascimento FROM pessoas p INNER "
                   + "JOIN clientes c on c.id_pessoa = p.id WHERE c.id = ?");
           comando.setInt(1, id);
           
           ResultSet consulta = comando.executeQuery();
           comando.getConnection().commit();
           Cliente tmp = null;
           if(consulta.first()){
               tmp = new Cliente();
               tmp.setCpf(consulta.getString("cpf"));
                tmp.setDataNascimento(consulta.getDate("data_nascimento"));
                tmp.setNome(consulta.getString("nome"));
                tmp.setId(consulta.getInt("idpessoa"));
                tmp.setRg(consulta.getString("rg"));
                tmp.setIdCliente(consulta.getInt("idcliente"));
               
           }
            return tmp;
       }catch(SQLException ex){
           ex.printStackTrace();
           return null;
       }
   
   }
   
   
   public boolean Apagar(int id ){
       try{
           
           
          // PessoaDAO pessoaDAO = new PessoaDAO();
           //pessoaDAO.Apagar(id);
           
           PreparedStatement comando = conexao
                   .getConexao().prepareStatement("DELETE FROM clientes WHERE id = ?");
           comando.setInt(1, id);
           comando.execute();
           comando.getConnection().commit();
           
           
           
           return true;
           
           
       
       }catch(SQLException ex){
           ex.printStackTrace();
           return false;
       }
   
   }
   
   
   public List<Cliente> listarTodos()throws ErroValidacaoException, Exception{
       try{
           PreparedStatement comando = conexao
                   .getConexao().prepareStatement("SELECT c.id as idcliente, p.id as "
                   + "idpessoa,p.nome,p.cpf,p.rg,p.data_nascimento FROM pessoas p INNER "
                   + "JOIN clientes c on c.id_pessoa = p.id");
           
           ResultSet consulta = comando.executeQuery();
           comando.getConnection().commit();
           
           List<Cliente> lista = new LinkedList<>();
           
           while(consulta.next()){
               Cliente tmp = new Cliente();
               
               tmp.setCpf(consulta.getString("cpf"));
                tmp.setDataNascimento(consulta.getDate("data_nascimento"));
                tmp.setNome(consulta.getString("nome"));
                tmp.setId(consulta.getInt("idpessoa"));
                tmp.setRg(consulta.getString("rg"));
                tmp.setIdCliente(consulta.getInt("idcliente"));
                lista.add(tmp);
                
           }
           return lista;
       
       }catch(SQLException ex){
           ex.printStackTrace();
           return null;
       }
   
   }
   
   
    public List<Cliente> Buscar(Cliente filtro) throws ErroValidacaoException, Exception{
        try{
            String sql = "SELECT c.id as idcliente, p.id as "
                   + "idpessoa,p.nome,p.cpf,p.rg,p.data_nascimento FROM pessoas p INNER "
                   + "JOIN clientes c on c.id_pessoa = p.id";
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
            
                        
            // sentiver o id Usuario
            if(filtro.getIdCliente() != 0){
                if(where.length() > 0){
                     where = where + " AND ";
                }
                where = where + " idcliente = "+filtro.getIdCliente();
            
            }
            
            Statement comando = conexao.getConexao().createStatement();
            ResultSet consulta = comando.executeQuery(sql);
            comando.getConnection().commit();
            
            List<Cliente> lista = null;
            if(consulta.first()){
                lista = new LinkedList<>();
                while(consulta.next()){
                    Cliente tmp = new Cliente();
                    
                tmp.setCpf(consulta.getString("cpf"));
                tmp.setDataNascimento(consulta.getDate("data_nascimento"));
                tmp.setNome(consulta.getString("nome"));
                tmp.setId(consulta.getInt("idpessoa"));
                tmp.setIdCliente(consulta.getInt("idcliente"));
                tmp.setRg(consulta.getString("rg"));
                
                
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
