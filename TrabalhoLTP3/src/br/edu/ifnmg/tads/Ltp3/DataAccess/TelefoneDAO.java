/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.Telefone;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author modric
 */
public class TelefoneDAO {
    private Bd banco;
    
    public TelefoneDAO(){
        banco = new Bd();
    }
    
    public boolean Salvar(Telefone obj){
        try{
            PreparedStatement comando = banco
                    .getConexao().prepareStatement("INSERT INTO telefones (ddd,numero,id_pessoa) VALUES(?,?,?)");
            
            comando.setInt(1, obj.getDdd());
            comando.setInt(2, obj.getNumero());
            //comando.setInt(3, obj.getDdd());
            
            comando.executeUpdate();
            return true;
        
        }catch(SQLException ex){}
    
            return false;
    
    
    }
    
}
