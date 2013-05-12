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
    
    public FormasPagamento(){
        this.id = 0;
        this.nome = "";
        this.alterado = true;
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
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nome);
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormasPagamento{" + "nome=" + nome + '}';
    }
    
    
    
}
