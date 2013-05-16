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
public class ItemVenda {
    private int id;
    private int quantidade;
    private Produto produto;
    private short ativo;
    
    /*-------------Construtores--------------------*/
    
    public ItemVenda(){
        id = 0;
        quantidade = 0;
        produto = new Produto();
        this.ativo = 1;
    }
    
     public ItemVenda(int id, int quantidade, Produto produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
    }
    /*---------------------------------------------------*/

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws  ErroValidacaoException{
        if(quantidade < 0) {
            throw new ErroValidacaoException("A quantidade deve ser maior que 0");
        }
        else {
            this.quantidade = quantidade;
        }
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return  produto.toString();
    }

    public short getAtivo() {
        return ativo;
    }

    public void setAtivo(short ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + this.quantidade;
        hash = 37 * hash + Objects.hashCode(this.produto);
        hash = 37 * hash + this.ativo;
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
        final ItemVenda other = (ItemVenda) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }
    
}
