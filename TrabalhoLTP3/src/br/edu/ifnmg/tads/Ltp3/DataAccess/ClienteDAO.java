/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Cliente;
import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
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
    
   public boolean Salvar(Cliente obj){
       try{
           if(obj.getIdCliente() == 0){
               
               PreparedStatement comando = conexao.getConexao()
                       .prepareStatement("INSERT INTO pessoas (nome,cpf,rg,data_nascimento) VALUES(?,?,?,?)");
               comando.setString(1, obj.getNome());
               comando.setString(2, obj.getCpf());
               comando.setString(3, obj.getRg());
               comando.setDate(4, new java.sql.Date(obj.getDataNascimento().getTime()));
               
               comando.executeUpdate();
               
               
               comando = conexao.getConexao()
                       .prepareStatement("INSERT INTO clientes (id_pessoa) VALUES(?)");
               comando.setInt(1, obj.getId());
               
               comando.executeUpdate();
               
           
           }
       
           return true;
           
       }catch(SQLException ex){
           
           JOptionPane.showMessageDialog(null,ex);
           
           return false;
       }
   
   
   
   }
    
    
}
