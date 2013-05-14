/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.FormasPagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author modric
 */
public class FormasPagamentoDAO {
    private Bd banco;
    
    public FormasPagamentoDAO(){
        banco = new Bd();
    
    }
    
    
    public boolean Salvar(FormasPagamento obj){
        PreparedStatement comando;
        try{
            if(obj.getId() == 0){
                comando = banco.getConexao()
                        .prepareStatement("INSERT INTO tipo_pagamento (nome) VALUES (?)");
                comando.setString(1, obj.getNome());

                comando.executeUpdate();
                comando.getConnection().commit();
            }else if (obj.isAlterado()){
                comando = banco.getConexao()
                        .prepareStatement("UPDATE tipo_pagamento SET nome = ? WHERE id = ?");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getId());

                comando.executeUpdate();
                comando.getConnection().commit();
                        
            }
            return true;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
            
        }
            
    
    }
    
    
    public FormasPagamento Abrir(int id){
        try{
            FormasPagamento fp = new FormasPagamento();
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM tipo_pagamento WHERE id = ?");
            comando.setInt(1, id);
            
            ResultSet rs = comando.executeQuery();
            //comando.getConnection().commit();//verificar
            rs.first();
             
             fp.setId(id);
             fp.setNome(rs.getString("nome"));
            return fp;
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    }
    
    public boolean Apagar(FormasPagamento obj){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("DELETE FROM tipo_pagamento WHERE id = ?");
            comando.setInt(1, obj.getId());
            if(comando.executeUpdate() == 1) {
                comando.getConnection().commit();
                return true;
            }
            else {
                comando.getConnection().rollback();
                return false;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    
    }
    
    public List<FormasPagamento> ListarTodos(){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM tipo_pagamento");
           ResultSet rs = comando.executeQuery();
           
           List<FormasPagamento> formasPagamento = new LinkedList<>();
           
           while(rs.next()){
               FormasPagamento temp = new FormasPagamento();
               temp.setId(rs.getInt("id"));
               temp.setNome(rs.getString("nome"));
               
               formasPagamento.add(temp);
           
           }
           return formasPagamento;
           
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    
    }
    
    
}
