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
public class Endereco {
    private int id;
    private String rua;
    private String bairro;
    //private String cidade;
    private int numero;
    private int cep;

    
    /*----------- Construtores -------------*/
    public Endereco() {}

    public Endereco(int id, String rua, String bairro, int numero, int cep) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
    }
    /*-------------------------------------*/
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) throws ErroValidacaoException{
        if (this.id < 0)
            throw new ErroValidacaoException("O id não pode ser menor que 0 !");
        else
            this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws ErroValidacaoException{
        if (this.numero < 0)
            throw new ErroValidacaoException("O id não pode ser menor que 0 !");
        else
            this.id = id;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua + ", bairro=" + bairro + ", numero=" + numero + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.rua);
        hash = 29 * hash + Objects.hashCode(this.bairro);
        hash = 29 * hash + this.numero;
        hash = 29 * hash + this.cep;
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (this.cep != other.cep) {
            return false;
        }
        return true;
    }
    
    
    
}
