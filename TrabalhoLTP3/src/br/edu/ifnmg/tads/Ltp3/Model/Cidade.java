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
public class Cidade {
    private int id;
    private String nome;
    private String uf;
    private Estado estado;
    
    public Cidade(){
        this.id = 0;
        this.nome = "";
       this.uf = "";
        this.estado = new Estado();
    
    }

    public Cidade(int id, String nome, String uf, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.estado = estado;
    }

    public Cidade(String nome, String uf, Estado estado) {
        this.nome = nome;
       // this.uf = uf;
        this.estado = estado;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.estado);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cidade{" + "nome=" + nome + ", estado=" + estado + '}';
    }

  
    
    
    
    
}
