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
    private int ativo;

    /*-----------Contrutores ------------------------*/
    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(){
        this.idCliente = 0;
        this.ativo = 1;
    }
    /*-----------------------------------------------*/

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) throws ErroValidacaoException  {
        if(idCliente < 0 ) {
            throw new ErroValidacaoException("O id não pode ser menor que 0 !");
        }
        else {
            this.idCliente = idCliente;
        }
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idCliente;
        hash = 53 * hash + this.ativo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }
    
    
    
    
}
