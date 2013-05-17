/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Apresentacao;

import br.edu.ifnmg.tads.Ltp3.Model.Cliente;

/**
 *
 * @author modric
 */
public class frmEditarCliente extends frmCadastroCliente {

    /**
     * Creates new form frmEditarCliente
     */
    public frmEditarCliente() {
        initComponents();
    }
    
     public frmEditarCliente(Cliente obj) {
        initComponents();
        
        listaEmails = obj.getEmails();
        listaEnderecos = obj.getEnderecos();
        listaTelefones = obj.getTelefones();
        carregaTabelaEmails(listaEmails);
        carregaTabelaEnderecos(listaEnderecos);
        
        txtNome.setText(obj.getNome());
        txtCpf.setText(obj.getCpf());
        txtDataNascimento.setText(String.valueOf(obj.getDataNascimento()));
        txtRg.setText(obj.getRg());
        idCliente = obj.getIdCliente();
        idPessoa = obj.getId();
    }

    
}
