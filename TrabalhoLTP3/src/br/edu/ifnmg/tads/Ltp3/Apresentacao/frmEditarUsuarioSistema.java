/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Apresentacao;

import br.edu.ifnmg.tads.Ltp3.Model.UsuarioSistema;

/**
 *
 * @author modric
 */
public class frmEditarUsuarioSistema extends frmCadastroUsuarioSistema {

    /**
     * Creates new form frmEditarUsuarioSistema
     */
    public frmEditarUsuarioSistema(UsuarioSistema obj) {
        initComponents();
        txtNome.setText(obj.getNome());
        txtCpf.setText(obj.getCpf());
        txtRg.setText(obj.getRg());
        txtUsuario.setText(obj.getUsuario());
        txtDataNascimento.setText(obj.getDataNascimento().toString());
        listaEmail = obj.getEmails();
        listaEnderecos = obj.getEnderecos();
        listaTelefone = obj.getTelefones();
        idPessoa = obj.getId();
        idUsuario = obj.getIdUsuario();
        
        
        
    }

   
  
}
