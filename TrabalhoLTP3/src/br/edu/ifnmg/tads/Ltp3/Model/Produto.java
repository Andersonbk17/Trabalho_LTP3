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
    private Estoque estoque;
    
    /*----- Construtores ---------------*/
    private Produto(){
        this.descricao = "";
        this.estoque = new Estoque();
        this.id = 0;
        this.nome = "";
        this.valorUnidadeCompra = 0;
        this.valorUnidadeVenda = 0;
    
    }

    public Produto(int id, String descricao, String nome, double valorUnidadeCompra, double valorUnidadeVenda, Estoque estoque) {
        this.id = id;
        this.descricao = descricao;
        this.nome = nome;
        this.valorUnidadeCompra = valorUnidadeCompra;
        this.valorUnidadeVenda = valorUnidadeVenda;
        this.estoque = estoque;
    }
    
    
    
    /*-------------------------------------*/

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) throws ErroValidacaoException {
        if(id < 0) {
            throw new ErroValidacaoException("O id não pode ser menor que 0!");
        }
        else {
            this.id = id;
        }
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

    public void setNome(String nome) throws ErroValidacaoException{
        if(nome.length()<3 || nome.length()<255) {
            throw new ErroValidacaoException("O nome não deve ser menor que 3 caracteres e maior que 255 caracteres !");
        }
        else {
            this.nome = nome;
        }
    }

    public double getValorUnidadeCompra() {
        return valorUnidadeCompra;
    }

    public void setValorUnidadeCompra(int valorUnidadeCompra) throws ErroValidacaoException{
        if(valorUnidadeCompra >0) {
            this.valorUnidadeCompra = valorUnidadeCompra;
        }
        else {
            throw new ErroValidacaoException("O valor de Compra deve ser Maior que 0 !");
        }
    }

    public double getValorUnidadeVenda() {
        return valorUnidadeVenda;
    }

    public void setValorUnidadeVenda(int valorUnidadeVenda) throws ErroValidacaoException{
        if(valorUnidadeVenda >0) {
            this.valorUnidadeVenda = valorUnidadeVenda;
        }
        else {
            throw new ErroValidacaoException("O valor de Venda deve ser Maior que 0 !");
        }
            
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valorUnidadeCompra) ^ (Double.doubleToLongBits(this.valorUnidadeCompra) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valorUnidadeVenda) ^ (Double.doubleToLongBits(this.valorUnidadeVenda) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.estoque);
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
        if (Double.doubleToLongBits(this.valorUnidadeCompra) != Double.doubleToLongBits(other.valorUnidadeCompra)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorUnidadeVenda) != Double.doubleToLongBits(other.valorUnidadeVenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valorUnidadeCompra=" + valorUnidadeCompra + ", valorUnidadeVenda=" + valorUnidadeVenda + '}';
    }

    
    
   
    
}
