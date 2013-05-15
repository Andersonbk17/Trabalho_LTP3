/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Cliente;
import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.Pessoa;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
    
}
