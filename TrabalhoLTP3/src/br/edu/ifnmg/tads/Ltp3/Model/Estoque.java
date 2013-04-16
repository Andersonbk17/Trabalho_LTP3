/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;

/**
 *
 * @author anderson
 */
public class Estoque {
    private int id;
    private int quantidade;
    
    public Estoque(){}

    public Estoque(int id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws ErroValidacaoException{
        if (this.id < 0)
            throw new ErroValidacaoException("O id não pode ser menor que 0 !");
        else
            this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws ErroValidacaoException{
        if(quantidade < 0){
            throw new ErroValidacaoException("A quantidade não pode ser menor que 0");
        }else {
            this.quantidade = quantidade;
        }
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.quantidade;
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
        final Estoque other = (Estoque) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estoque{" + "quantidade=" + quantidade + '}';
    }
    
    
    
    
}
