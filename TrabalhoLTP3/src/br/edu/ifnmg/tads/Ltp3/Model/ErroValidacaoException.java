/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ErroValidacaoException extends Exception{
    
    public ErroValidacaoException(String msg){
        super(msg);
        JOptionPane.showMessageDialog(null,msg);
    }
    
}
