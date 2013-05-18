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
                        .prepareStatement("INSERT INTO tipos_pagamento "
                        + "(nome,ativo) VALUES (?,?)");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getAtivo());

                comando.executeUpdate();
                comando.getConnection().commit();
            }else {
                comando = banco.getConexao()
                        .prepareStatement("UPDATE tipos_pagamento SET nome = ?, "
                        + "ativo = ? WHERE id = ?");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getAtivo());
                comando.setInt(3, obj.getId());

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
                    .prepareStatement("SELECT * FROM tipos_pagamento WHERE id = ? ");
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
    
    public boolean Apagar(FormasPagamento obj) {
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("UPDATE tipos_pagamento SET ativo = 0 "
                    + "WHERE id = ?");
            comando.setInt(1, obj.getId());
            comando.executeUpdate();
            comando.getConnection().commit();
                
           
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public List<FormasPagamento> ListarTodos(){
        try{
            PreparedStatement comando = banco.getConexao()
                    .prepareStatement("SELECT * FROM tipos_pagamento WHERE ativo "
                    + "= 1");
           ResultSet rs = comando.executeQuery();
           
           List<FormasPagamento> formasPagamento = new LinkedList<>();
           
           while(rs.next()){
               FormasPagamento temp = new FormasPagamento();
               temp.setId(rs.getInt("id"));
               temp.setNome(rs.getString("nome"));
               temp.setAtivo(rs.getInt("ativo"));
               
               formasPagamento.add(temp);
           
           }
           return formasPagamento;
           
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    
    }
    
    
}

