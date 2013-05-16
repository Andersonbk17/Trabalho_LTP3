/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;

import java.util.Objects;

/**
 *
 * @author modric
 */
public class FormasPagamento {
    private int id;
    private String nome;
    private boolean alterado;
    private short ativo;
    
    public FormasPagamento(){
        this.id = 0;
        this.nome = "";
        this.alterado = true;
        this.ativo = 1;
    }

    public FormasPagamento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public FormasPagamento(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAlterado() {
        return alterado;
    }

    public void setAlterado(boolean alterado) {
        this.alterado = alterado;
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
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + (this.alterado ? 1 : 0);
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
        final FormasPagamento other = (FormasPagamento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return  nome ;
    }
    
    
    
}
