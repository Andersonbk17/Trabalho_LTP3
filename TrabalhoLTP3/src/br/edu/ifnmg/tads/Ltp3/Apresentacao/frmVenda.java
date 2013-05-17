/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Apresentacao;

import br.edu.ifnmg.tads.Ltp3.DataAccess.ClienteDAO;
import br.edu.ifnmg.tads.Ltp3.DataAccess.FormasPagamentoDAO;
import br.edu.ifnmg.tads.Ltp3.DataAccess.ProdutoDAO;
import br.edu.ifnmg.tads.Ltp3.DataAccess.VendaDAO;
import br.edu.ifnmg.tads.Ltp3.Model.Cliente;
import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.FormasPagamento;
import br.edu.ifnmg.tads.Ltp3.Model.ItemVenda;
import br.edu.ifnmg.tads.Ltp3.Model.Produto;
import br.edu.ifnmg.tads.Ltp3.Model.UsuarioSistema;
import br.edu.ifnmg.tads.Ltp3.Model.Venda;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anderson
 */
public class frmVenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmVenda
     */
  
    public frmVenda(UsuarioSistema usuario) {
        initComponents();
        carregaClientes();
        carregaProdutos();
        carregaFormasPagamento();
        venda = new Venda();
        venda.setUsuario(usuario);
        
        txtVendedor.setText(usuario.getNome());
        txtQuantidade.setText("1");
        
    }
    
    private void atualizaCamposFormulario(){
        lblValorTotal.setText(Double.toString(venda.getValor()));
        modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Produto");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Valor Unitário");
        
        for(ItemVenda i : venda.getItens()){
            Vector v = new Vector();
            v.add(i.getId());
            v.add(i);
            v.add(i.getQuantidade());
            v.add(i.getProduto().getValorUnidadeVenda());
            modelo.addRow(v);
        }

        tblItens.setModel(modelo);
        tblItens.repaint();

        
    
    }
    
    
    private void carregaFormasPagamento(){
        FormasPagamentoDAO dao = new FormasPagamentoDAO();
        listaFromasPagamento = dao.ListarTodos();
        
        cbxTipoPagamento.removeAllItems();
        for(FormasPagamento f : listaFromasPagamento){
            cbxTipoPagamento.addItem(f);
        }
        
    
    
    }
    
    private void carregaClientes(){
    
        ClienteDAO daoCliente = new ClienteDAO();
        try {
            listaClientes = daoCliente.listarTodos();
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        
        cbxCliente.removeAllItems();
        for(Cliente c : listaClientes){
            cbxCliente.addItem(c);
        }
        
    }
    private void carregaProdutos(){
        ProdutoDAO daoProduto = new ProdutoDAO();
        try {
            listaProdutos = daoProduto.listarTodos();
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        
        cbxProdutos.removeAllItems();
        for(Produto p : listaProdutos){
            cbxProdutos.addItem(p);
        }
    
    }
    
    
    
    /*private void maximizar(){
        try {
            this.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    * */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFnalizarCompra = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblValorTotal = new javax.swing.JLabel();
        lblR$ = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblVendedor = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox();
        txtVendedor = new javax.swing.JTextField();
        lblTipoPagamento = new javax.swing.JLabel();
        cbxTipoPagamento = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        lblProduto = new javax.swing.JLabel();
        cbxProdutos = new javax.swing.JComboBox();
        txtQuantidade = new javax.swing.JTextField();
        lblQuantidade = new javax.swing.JLabel();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        btnFnalizarCompra.setText("Finalizar Compra");
        btnFnalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFnalizarCompraActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblValorTotal.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N

        lblR$.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        lblR$.setText("R$");

        lblVendedor.setText("Vendedor:");

        lblCliente.setText("Cliente:");

        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Nome1", "Nome2" }));
        cbxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClienteActionPerformed(evt);
            }
        });

        txtVendedor.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        txtVendedor.setForeground(java.awt.SystemColor.controlLtHighlight);
        txtVendedor.setCaretColor(new java.awt.Color(254, 254, 254));
        txtVendedor.setEnabled(false);

        lblTipoPagamento.setText("Tipo Pagamento:");

        cbxTipoPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addGap(55, 55, 55)
                        .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblVendedor)
                        .addGap(18, 18, 18)
                        .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTipoPagamento)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTipoPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(374, 374, 374))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVendedor)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoPagamento)
                    .addComponent(cbxTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(255, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Gerais", jPanel1);

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblItens);

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");

        lblProduto.setText("Produto:");

        cbxProdutos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblQuantidade.setText("Qtd:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRemover, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(lblQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnAdicionar)
                        .addGap(28, 28, 28)
                        .addComponent(btnRemover))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProduto)
                            .addComponent(cbxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblQuantidade))
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Itens", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblR$, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnFnalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblR$, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFnalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar a compra ?","",JOptionPane.OK_CANCEL_OPTION) == 0){
            this.dispose();
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxClienteActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
          Produto p = (Produto) cbxProdutos.getSelectedItem();
          int qtd = Integer.parseInt(txtQuantidade.getText());
            ItemVenda item = new ItemVenda();
            
        try {
            item.setQuantidade(qtd);
            item.setProduto(p);
            
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(frmVenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }

            this.venda.addItemVenda(item);

            JOptionPane.showMessageDialog(rootPane, "Item adicionado com sucesso!");

            atualizaCamposFormulario();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnFnalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFnalizarCompraActionPerformed
        VendaDAO dao = new VendaDAO();
        venda.setCliente((Cliente)cbxCliente.getSelectedItem());
        venda.setFormaPagamento((FormasPagamento) cbxTipoPagamento.getSelectedItem());
        //venda.setHorario();
        if(dao.Salvar(venda)){
            JOptionPane.showMessageDialog(rootPane, "Venda Salva com Sucesso!");
        
        }
    }//GEN-LAST:event_btnFnalizarCompraActionPerformed
    
    List<Cliente> listaClientes;
    List<Produto> listaProdutos;
    List<FormasPagamento> listaFromasPagamento;
    DefaultTableModel modelo;
    Venda venda;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFnalizarCompra;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JComboBox cbxProdutos;
    private javax.swing.JComboBox cbxTipoPagamento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblR$;
    private javax.swing.JLabel lblTipoPagamento;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JTable tblItens;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
