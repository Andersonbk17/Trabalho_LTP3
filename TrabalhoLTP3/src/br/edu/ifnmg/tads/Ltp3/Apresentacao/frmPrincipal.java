/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Apresentacao;

//import com.birosoft.liquid.LiquidLookAndFeel;


/**
 *
 * @author anderson
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
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
        MenuUsuarios = new javax.swing.JMenu();
        MenuItemListarUsuarios = new javax.swing.JMenuItem();
        MenuVendas = new javax.swing.JMenu();
        MenuItemNovaVanda = new javax.swing.JMenuItem();
        MenuItemHistorico = new javax.swing.JMenuItem();
        MenuClientes = new javax.swing.JMenu();
        MenuItemListarClientes = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Vendas");
        setAlwaysOnTop(true);
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

        MenuItemTipoPagamento.setText("Tipo de Pagamento");
        MenuItemTipoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemTipoPagamentoActionPerformed(evt);
            }
        });
        MenuNovo.add(MenuItemTipoPagamento);

        jMenu1.add(MenuNovo);

        MenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        MenuItemSair.setText("Sair");
        MenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemSairActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemSair);
        jMenu1.add(jSeparator1);

        MenuSuperior.add(jMenu1);

        MenuUsuarios.setText("Usuários");

        MenuItemListarUsuarios.setText("Listar");
        MenuItemListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemListarUsuariosActionPerformed(evt);
            }
        });
        MenuUsuarios.add(MenuItemListarUsuarios);

        MenuSuperior.add(MenuUsuarios);

        MenuVendas.setText("Vendas");

        MenuItemNovaVanda.setText("Nova");
        MenuItemNovaVanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemNovaVandaActionPerformed(evt);
            }
        });
        MenuVendas.add(MenuItemNovaVanda);

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

        MenuItemListarClientes.setText("Tipos de Pagamento");
        MenuItemListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemListarClientesActionPerformed(evt);
            }
        });
        MenuClientes.add(MenuItemListarClientes);

        jMenuItem1.setText("Usuários");
        MenuClientes.add(jMenuItem1);

        MenuSuperior.add(MenuClientes);

        setJMenuBar(MenuSuperior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemSairActionPerformed
        this.dispose();
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

    private void MenuItemListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemListarUsuariosActionPerformed
        frmListarUsuariosSistema janela = new frmListarUsuariosSistema();
        janela.setVisible(true);
        add(janela);
    }//GEN-LAST:event_MenuItemListarUsuariosActionPerformed

    private void MenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemClienteActionPerformed
        frmCadastroCliente janela = new frmCadastroCliente();
        janela.setVisible(true);
        add(janela);
    }//GEN-LAST:event_MenuItemClienteActionPerformed

    private void MenuItemNovaVandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemNovaVandaActionPerformed
        frmVenda janela = new frmVenda();
        janela.setVisible(true);
        add(janela);
    }//GEN-LAST:event_MenuItemNovaVandaActionPerformed

    private void MenuItemListarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemListarClientesActionPerformed
        frmListarClientes janela = new frmListarClientes();
        janela.setVisible(true);
        add(janela);
    }//GEN-LAST:event_MenuItemListarClientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuClientes;
    private javax.swing.JMenuItem MenuItemCliente;
    private javax.swing.JMenuItem MenuItemHistorico;
    private javax.swing.JMenuItem MenuItemListarClientes;
    private javax.swing.JMenuItem MenuItemListarUsuarios;
    private javax.swing.JMenuItem MenuItemNovaVanda;
    private javax.swing.JMenuItem MenuItemProduto;
    private javax.swing.JMenuItem MenuItemSair;
    private javax.swing.JMenuItem MenuItemTipoPagamento;
    private javax.swing.JMenuItem MenuItemUsuario;
    private javax.swing.JMenu MenuNovo;
    private javax.swing.JMenuBar MenuSuperior;
    private javax.swing.JMenu MenuUsuarios;
    private javax.swing.JMenu MenuVendas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
