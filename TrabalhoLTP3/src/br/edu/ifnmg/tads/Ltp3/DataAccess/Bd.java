/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class Bd {
    private Connection conexao;

    
    public Bd(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager
                  //  .getConnection("jdbc:mysql://localhost:3306/trabalho","root","aluno");
            .getConnection("jdbc:mysql://localhost:3306/trabalho","root","170737");
            conexao.setAutoCommit(false);//mudar se der erro
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Bd.class.getName()).log(Level.SEVERE, null, ex);                    
        }
    }
    
    
    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    
    
    
}
