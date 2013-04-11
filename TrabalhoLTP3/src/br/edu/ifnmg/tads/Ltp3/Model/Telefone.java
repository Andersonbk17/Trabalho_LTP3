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
    
    /*-------- Construtores ----*/
    public Telefone(){}
    
    public Telefone(int id, int ddd, int numero) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
    }
    
    /*---------------------------*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.ddd;
        hash = 97 * hash + this.numero;
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
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "ddd=" + ddd + ", numero=" + numero + '}';
    }

    
    
    
    
}
