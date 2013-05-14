/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Endereco;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author modric
 */
public class EnderecoDAO {
    private Bd banco;
    
    public EnderecoDAO (){
        banco = new Bd();
    }
    
    public boolean Salvar(Endereco obj,int idDoBanco){
        try{
            if(obj.getId() == 0){
                PreparedStatement comando = banco.getConexao()
                        .prepareStatement("INSERT INTO enderecos (rua,cep,bairro,numero,id_pessoa,cidade,estado)");
                comando.setString(1, obj.getRua());
                comando.setString(2, obj.getCep());
                comando.setString(3, obj.getBairro());
                comando.setString(4, String.valueOf(obj.getNumero()));
                comando.setInt(5, idDoBanco);
                comando.setString(6, obj.getCidade());
                comando.setString(7, obj.getEstado());
                
                comando.executeUpdate();
                comando.getConnection().commit();
            }
            
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
  
    
    }
    
    public boolean Apagar(Endereco obj){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM enderecos WHERE id= ?");
            comando.setInt(1, obj.getId());
            comando.getConnection().commit();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public boolean ApagarTodosQuandoExcluiPessoa(int id){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM enderecos WHERE id_pessoa= ?");
            comando.setInt(1, id);
            comando.getConnection().commit();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
}

