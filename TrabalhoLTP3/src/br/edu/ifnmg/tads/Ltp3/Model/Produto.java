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
public class Produto {
    private int id;
    private String descricao;
    private String nome;
    private double valorUnidadeCompra;
    private double valorUnidadeVenda;
    
    /*----- Construtores ---------------*/
    private Produto(){}
    
    public Produto(int id, String descricao, String nome, int valorUnidadeCompra, int valorUnidadeVenda) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.valorUnidadeCompra = valorUnidadeCompra;
        this.valorUnidadeVenda = valorUnidadeVenda;
    }
    
    /*-------------------------------------*/

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnidadeCompra() {
        return valorUnidadeCompra;
    }

    public void setValorUnidadeCompra(int valorUnidadeCompra) {
        this.valorUnidadeCompra = valorUnidadeCompra;
    }

    public double getValorUnidadeVenda() {
        return valorUnidadeVenda;
    }

    public void setValorUnidadeVenda(int valorUnidadeVenda) {
        this.valorUnidadeVenda = valorUnidadeVenda;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valorUnidadeVenda=" + valorUnidadeVenda + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.descricao);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.valorUnidadeCompra) ^ (Double.doubleToLongBits(this.valorUnidadeCompra) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.valorUnidadeVenda) ^ (Double.doubleToLongBits(this.valorUnidadeVenda) >>> 32));
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
   
    
}
