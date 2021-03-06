/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;

import java.util.Objects;

/**
 *
 * @author anderson
 */
public class Email {
    private int id;
    private String endereco;
    private int ativo;
    
    /*--------- Construtores ---------*/
    public Email(){
        this.ativo = 1;
        this.endereco = "";
        this.id = 0;
    }

    public Email(int id, String endereco) {
        this.id = id;
        this.endereco = endereco;
    }
    
        
    /*---------------------------------*/

    public int getId() {
        return id;
    }

    public void setId(int id) throws ErroValidacaoException{
        if (id < 0) {
            throw new ErroValidacaoException("O id não pode ser menor que 0 !");
        }
        else {
            this.id = id;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    
    @Override
    public String toString() {
        return "Email{" + "endereco=" + endereco + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.endereco);
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
        final Email other = (Email) obj;
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return true;
    }
    
    
            
}
