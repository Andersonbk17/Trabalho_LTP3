/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author modric
 */
public class LoginDAO {
    private Bd conexao;
    
    public LoginDAO(){
        this.conexao = new Bd();
    }
    
    public int autenticar(String usuario,String senha) throws ErroValidacaoException, SQLException{
        PreparedStatement comando = null;
        try{
            comando = conexao
                    .getConexao().prepareStatement("SELECT id FROM usuarios_sistema WHERE usuario = ? AND senha = ?");
            comando.setString(1, usuario);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            
            if(!rs.last()){
                throw new ErroValidacaoException("Usuário não encontrado !");
            }else{
                return rs.getInt("id"); //erro verificar
            }
        
        }catch(SQLException ex){
            throw new ErroValidacaoException(ex.getMessage());
       
        }finally{
            comando.getConnection().close();
        }
    }
}
