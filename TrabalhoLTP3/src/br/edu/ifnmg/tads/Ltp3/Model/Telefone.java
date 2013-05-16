/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;

/**
 *
 * @author anderson
 */
public class Telefone {
    private int id;
    private int ddd;
    private int numero;
    private short ativo;
    
    /*-------- Construtores ----*/
    public Telefone(){
        this.id = 0;
        this.ddd = 0;
        this.numero = 0;
        this.ativo = 1;
    }
    
    public Telefone(int id, int ddd, int numero) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
    }
    
    /*---------------------------*/

    public int getId() {
        return id;
    }

    public void setId(int id) throws ErroValidacaoException {
        if(id >0) {
            this.id = id;
        }
        else {
            throw new ErroValidacaoException("O id não pode ser menor que 0 !");
        }
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public short getAtivo() {
        return ativo;
    }

    public void setAtivo(short ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        hash = 67 * hash + this.ddd;
        hash = 67 * hash + this.numero;
        hash = 67 * hash + this.ativo;
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
        final Telefone other = (Telefone) obj;
        if (this.ddd != other.ddd) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Telefone{" + "ddd=" + ddd + ", numero=" + numero + '}';
    }

}
