/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Email;
import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class EmailDAO {
    private Bd banco;
    
    public EmailDAO(){
        banco = new Bd();
    }
    
    public boolean Salvar(Email obj, int idPessoa) {
        try{
            
            if(obj.getId() == 0){
                PreparedStatement comando = banco.getConexao()
                        .prepareStatement("INSERT INTO emails (endereco,"
                        + "id_pessoa,ativo) VALUES (?,?,?)");
                comando.setString(1, obj.getEndereco());
                comando.setInt(2, idPessoa);
                comando.setInt(3, obj.getAtivo());
                comando.executeUpdate();
                comando.getConnection().commit();
            }else{
                PreparedStatement comando = banco.getConexao()
                        .prepareStatement("UPDATE emails SET endereco = ?,id_pessoa = ?,ativo = ? WHERE id = ?");
                comando.setString(1, obj.getEndereco());
                comando.setInt(2, idPessoa);
                comando.setInt(3, obj.getAtivo());
                comando.setInt(4, idPessoa);
                comando.executeUpdate();
                comando.getConnection().commit();
            
            }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Email Abrir(int id){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM emails WHERE id = ? AND ativo = 1");
            comando.setInt(1, id);
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            Email tmp = null;
            if(consulta.first()){
                tmp = new Email();
                tmp.setEndereco(consulta.getString("endereco"));
                tmp.setId(consulta.getInt("id"));
                
                
            }
            return tmp;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }catch(ErroValidacaoException ex){
            ex.printStackTrace();
            return null;
        }
     
    
    }
    
    public boolean Apagar(Email obj){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("UPDATE emails SET ativo = ? WHERE id = ?");
            comando.setInt(1, 0);
            comando.setInt(2, obj.getId());
            comando.executeUpdate();
            comando.getConnection().commit();
            return true;
                    
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    
    public List<Email> listarTodos(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM emails WHERE id_pessoa = ? AND "
                    + " ativo = 1");
            comando.setInt(1, idPessoa);
            ResultSet consulta = comando.executeQuery();
            
            List<Email> listaEmails = new LinkedList<>();
            while(consulta.next()){
                Email tmp = new Email();
                
                tmp.setEndereco(consulta.getString("endereco"));
                tmp.setId(consulta.getInt("id"));
                listaEmails.add(tmp);
            }
            return listaEmails;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }catch(ErroValidacaoException ex){
            ex.printStackTrace();
            return null;
        }
    
    }
    
    public boolean ApagarTodosQuandoExcluiPessoa(int idPessoa){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("UPDATE emails SET ativo = ? WHERE id = ?");
            comando.setInt(1, 0);
            comando.setInt(2, idPessoa);
            comando.executeUpdate();
            comando.getConnection().commit();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    
    
}
