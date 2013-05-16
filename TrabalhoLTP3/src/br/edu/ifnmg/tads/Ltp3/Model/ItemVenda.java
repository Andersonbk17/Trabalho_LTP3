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
    
    /*-------------Construtores--------------------*/
    
    public ItemVenda(){
        id = 0;
        quantidade = 0;
        produto = new Produto();
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
        if (id < 0)
            throw new ErroValidacaoException("O id não pode ser menor que 0 !");
        else
            this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws  ErroValidacaoException{
        if(quantidade < 0)
            throw new ErroValidacaoException("A quantidade deve ser maior que 0");
        else
            this.quantidade = quantidade;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + this.quantidade;
        hash = 41 * hash + Objects.hashCode(this.produto);
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
        if (this.id != other.id) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

   
    
    
    
}
