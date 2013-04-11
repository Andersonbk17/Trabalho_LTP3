/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Model;

/**
 *
 * @author anderson
 */
public class Produto {
    private int id;
    private String descricao;
    private String nome;
    private int valorUnidadeCompra;
    private int valorUnidadeVenda;

    private Produto(){
    
    }
    
    public Produto(int id, String descricao, String nome, int valorUnidadeCompra, int valorUnidadeVenda) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.valorUnidadeCompra = valorUnidadeCompra;
        this.valorUnidadeVenda = valorUnidadeVenda;
    }

    
    
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

    public int getValorUnidadeCompra() {
        return valorUnidadeCompra;
    }

    public void setValorUnidadeCompra(int valorUnidadeCompra) {
        this.valorUnidadeCompra = valorUnidadeCompra;
    }

    public int getValorUnidadeVenda() {
        return valorUnidadeVenda;
    }

    public void setValorUnidadeVenda(int valorUnidadeVenda) {
        this.valorUnidadeVenda = valorUnidadeVenda;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valorUnidadeVenda=" + valorUnidadeVenda + '}';
    }
    
   
    
}
