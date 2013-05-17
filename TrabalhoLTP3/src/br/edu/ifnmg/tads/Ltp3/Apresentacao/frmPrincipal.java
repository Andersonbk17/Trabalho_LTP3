/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Apresentacao;


import br.edu.ifnmg.tads.Ltp3.DataAccess.UsuarioSistemaDAO;
import br.edu.ifnmg.tads.Ltp3.Model.UsuarioSistema;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 *
 * @author anderson
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal(int idUsuario) {
        initComponents();
        UsuarioSistemaDAO dao = new UsuarioSistemaDAO();
        try {
            usuarioAtual = dao.Abrir(idUsuario);
        } catch (Exception ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
         this.setExtendedState(JFrame.MAXIMIZED_BOTH);
         
         //Implementar a busca de usuario
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        MenuSuperior = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuNovo = new javax.swing.JMenu();
        MenuItemUsuario = new javax.swing.JMenuItem();
        MenuItemCliente = new javax.swing.JMenuItem();
        MenuItemProduto = new javax.swing.JMenuItem();
        MenuItemTipoPagamento = new javax.swing.JMenuItem();
        MenuItemSair = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuItemFechar = new javax.swing.JMenuItem();
        MenuVendas = new javax.swing.JMenu();
        MenuItemNovaVanda = new javax.swing.JMenuItem();
        MenuItemHistorico = new javax.swing.JMenuItem();
        MenuClientes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuItemListagemProdutos = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Vendas");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jMenu1.setText("Sistema");

        MenuNovo.setText("Novo");

        MenuItemUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemUsuario.setText("Usuário");
        MenuItemUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemUsuarioActionPerformed(evt);
            }
        });
        MenuNovo.add(MenuItemUsuario);

        MenuItemCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemCliente.setText("Cliente");
        MenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemClienteActionPerformed(evt);
            }
        });
        MenuNovo.add(MenuItemCliente);

        MenuItemProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemProduto.setText("Produto");
        MenuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemProdutoActionPerformed(evt);
            }
        });
        MenuNovo.add(MenuItemProduto);

        MenuItemTipoPagamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemTipoPagamento.setText("Tipo de Pagamento");
        MenuItemTipoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemTipoPagamentoActionPerformed(evt);
            }
        });
        MenuNovo.add(MenuItemTipoPagamento);

        jMenu1.add(MenuNovo);

        MenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemSair.setText("Sair");
        MenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemSair);
        jMenu1.add(jSeparator1);

        MenuItemFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        MenuItemFechar.setText("Fechar");
        MenuItemFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemFecharActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemFechar);

        MenuSuperior.add(jMenu1);

        MenuVendas.setText("Vendas");

        MenuItemNovaVanda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemNovaVanda.setText("Nova");
        MenuItemNovaVanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemNovaVandaActionPerformed(evt);
            }
        });
        MenuVendas.add(MenuItemNovaVanda);

        MenuItemHistorico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK));
        MenuItemHistorico.setText("Histórico");
        MenuItemHistorico.setMaximumSize(new java.awt.Dimension(820, 620));
        MenuItemHistorico.setMinimumSize(new java.awt.Dimension(820, 820));
        MenuItemHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemHistoricoActionPerformed(evt);
            }
        });
        MenuVendas.add(MenuItemHistorico);

        MenuSuperior.add(MenuVendas);

        MenuClientes.setText("Listagem");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setText("Usuários");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuClientes.add(jMenuItem1);

        MenuItemListagemProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        MenuItemListagemProdutos.setText("Produtos");
        MenuItemListagemProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemListagemProdutosActionPerformed(evt);
            }
        });
        MenuClientes.add(MenuItemListagemProdutos);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem2.setText("Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuClientes.add(jMenuItem2);

        MenuSuperior.add(MenuClientes);

        jMenu2.setText("Ajuda");

        jMenuItem3.setText("Sobre");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        MenuSuperior.add(jMenu2);

        setJMenuBar(MenuSuperior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSairActionPerformed
        this.dispose();
        frmLogin janela = new frmLogin(this, rootPaneCheckingEnabled);
        janela.setVisible(true);
    }//GEN-LAST:event_MenuItemSairActionPerformed

    private void MenuItemTipoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemTipoPagamentoActionPerformed
        frmCadastroFormasPagamento janela = new frmCadastroFormasPagamento();
        janela.setVisible(true);
        add(janela);
    }//GEN-LAST:event_MenuItemTipoPagamentoActionPerformed

    private void MenuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemProdutoActionPerformed
       frmCadastroProduto janela = new frmCadastroProduto();
       janela.setVisible(true);
       add(janela);
    }//GEN-LAST:event_MenuItemProdutoActionPerformed

    private void MenuItemUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemUsuarioActionPerformed
        frmCadastroUsuarioSistema janela = new frmCadastroUsuarioSistema();
        janela.setVisible(true);
        add(janela);
    }//GEN-LAST:event_MenuItemUsuarioActionPerformed

    private void MenuItemHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemHistoricoActionPerformed
        frmListarVendas janela = new frmListarVendas();
        janela.setVisible(true);
        add(janela);
    }//GEN-LAST:event_MenuItemHistoricoActionPerformed

    private void MenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemClienteActionPerformed
        frmCadastroCliente janela = new frmCadastroCliente();
        janela.setVisible(true);
        add(janela);
    }//GEN-LAST:event_MenuItemClienteActionPerformed

    private void MenuItemNovaVandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemNovaVandaActionPerformed
        frmVenda janela = new frmVenda(usuarioAtual);
        janela.setVisible(true);
        /*try {
            janela.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        add(janela);
    }//GEN-LAST:event_MenuItemNovaVandaActionPerformed

    private void MenuItemFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemFecharActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja fechar","",JOptionPane.OK_CANCEL_OPTION) == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_MenuItemFecharActionPerformed

    private void MenuItemListagemProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemListagemProdutosActionPerformed
     frmListarProduto janela = new frmListarProduto();
      janela.setVisible(true);
      add(janela);
    }//GEN-LAST:event_MenuItemListagemProdutosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       frmListarClientes janela = new frmListarClientes();
       janela.setVisible(true);
       add(janela);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      JOptionPane.showMessageDialog(rootPane, "Sistema de venda BugSis");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       frmListarUsuariosSistema janela = new frmListarUsuariosSistema();
       janela.setVisible(true);
       add(janela);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private UsuarioSistema usuarioAtual;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuClientes;
    private javax.swing.JMenuItem MenuItemCliente;
    private javax.swing.JMenuItem MenuItemFechar;
    private javax.swing.JMenuItem MenuItemHistorico;
    private javax.swing.JMenuItem MenuItemListagemProdutos;
    private javax.swing.JMenuItem MenuItemNovaVanda;
    private javax.swing.JMenuItem MenuItemProduto;
    private javax.swing.JMenuItem MenuItemSair;
    private javax.swing.JMenuItem MenuItemTipoPagamento;
    private javax.swing.JMenuItem MenuItemUsuario;
    private javax.swing.JMenu MenuNovo;
    private javax.swing.JMenuBar MenuSuperior;
    private javax.swing.JMenu MenuVendas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
