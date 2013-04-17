/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;

/**
 *
 * @author anderson
 */
public class Cliente extends Pessoa{
    private int idCliente;

    /*-----------Contrutores ------------------------*/
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(){}
    /*-----------------------------------------------*/

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) throws ErroValidacaoException  {
        if(idCliente < 0 )
               throw new ErroValidacaoException("O id não pode ser menor que 0 !");
        else
            this.idCliente = idCliente;
    }
    
    
    
    
}
