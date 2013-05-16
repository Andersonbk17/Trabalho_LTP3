/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.Estoque;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

/**
 *
 * @author modric
 */
public class EstoqueDAO {
    private Bd conexao;
    
    public EstoqueDAO(){
        conexao = new Bd();
    }
    
    public boolean Salvar(Estoque obj , int idPessoa){
        try{
            boolean retorno= false;
            if(obj.getId() == 0){
                PreparedStatement comando = conexao
                        .getConexao().prepareStatement("INSERT INTO estoques (id,quantidade) VALUES (?,?)");
                comando.setInt(1, idPessoa);
                comando.setInt(2, obj.getQuantidade());
                comando.executeUpdate();
                comando.getConnection().commit();
                
                retorno = true;
            }else{
                    PreparedStatement comando = conexao
                        .getConexao().prepareStatement("UPDATE  estoques SET id = ?,quantidade =? WHERE id = ?");
                comando.setInt(1, idPessoa);
                comando.setInt(2, obj.getQuantidade());
                comando.setInt(3, idPessoa);
                comando.executeUpdate();
                comando.getConnection().commit();
                retorno = true;
            
            }
            
            
            return retorno;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    
    
    }
    
    public Estoque Abrir(int id)  throws ErroValidacaoException,Exception{
        try{
            PreparedStatement comando = conexao
                    .getConexao().prepareStatement("SELECT * FROM estoques");
            ResultSet consulta = comando.executeQuery();
            comando.getConnection().commit();
            Estoque tmp = null;
            if(consulta.first()){
                tmp = new Estoque();
                tmp.setId(consulta.getInt("id"));
                tmp.setQuantidade(consulta.getInt("quantidade"));
            }
            return tmp;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    
    
    }
    
}
