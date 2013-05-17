/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Apresentacao;

import br.edu.ifnmg.tads.Ltp3.Model.Produto;

/**
 *
 * @author modric
 */
public class frmEditarProduto extends frmCadastroProduto {

    /**
     * Creates new form frmEditarProduto
     */
    public frmEditarProduto(Produto obj) {
        initComponents();
        
        txtNome.setText(obj.getNome());
        txtQuantidade.setText(String.
                valueOf(obj.getEstoque().getQuantidade()));
        TxtAreaDescricao.setText(obj.getDescricao());
        txtValorCompra.setText(String.valueOf(obj.getValorUnidadeCompra()));
        txtValorUnitario.setText(String.valueOf(obj.getValorUnidadeVenda()));
        idProduto = obj.getId();
        
        
        
    }

}
