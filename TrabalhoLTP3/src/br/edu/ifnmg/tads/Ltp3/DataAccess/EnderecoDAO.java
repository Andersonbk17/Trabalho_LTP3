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
    
    public boolean Salvar(Endereco obj){
        try{
            PreparedStatement comando = banco.getConexao().prepareStatement("INSERT INTO enderecos (nome)");
        }catch(SQLException ex){
        
        }
    return true;
    
    /*
     
     * falta implementar tudo
     
     
     */
    
    }
    
}
