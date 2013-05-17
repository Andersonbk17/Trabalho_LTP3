/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Apresentacao;

import br.edu.ifnmg.tads.Ltp3.DataAccess.FormasPagamentoDAO;
import br.edu.ifnmg.tads.Ltp3.Model.FormasPagamento;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anderson
 */
public class frmCadastroFormasPagamento extends javax.swing.JInternalFrame {
    FormasPagamentoDAO dao;
     List<FormasPagamento> listaLocal;
     DefaultTableModel modelo;
     int idFormaPagamentoParaRemover;
    /**
     * Creates new form frmCadastroFormasPagamento
     */
    public frmCadastroFormasPagamento() {
        initComponents();
       //this.listaLocal = carregaDadosDoBanco(); 
       preenceTabela(carregaDadosDoBanco());
    }
    
    private List<FormasPagamento> carregaDadosDoBanco(){
        this.dao = new FormasPagamentoDAO();
        List<FormasPagamento> lista = dao.ListarTodos();
        return lista;
    
    }
    
    private void preenceTabela(List<FormasPagamento> lista){
        this.modelo = new DefaultTableModel();
        
        modelo.addColumn("id");
        modelo.addColumn("Nome");
        
        for(FormasPagamento f : lista){
            Vector valores = new Vector();
            
            valores.add(0,f.getId());
            valores.add(1,f.getNome());
            modelo.addRow(valores);
        
        }
        tblListagem.setModel(modelo);
        tblListagem.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
        lblTipoPagamento = new javax.swing.JLabel();
        txtTipoPagamento = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastrar Formas de Pagamento");
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListagemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListagem);

        lblTipoPagamento.setText("Tipo de Pagamento:");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTipoPagamento)
                        .addGap(18, 18, 18)
                        .addComponent(txtTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnAdicionar)
                        .addGap(41, 41, 41)
                        .addComponent(btnRemover)
                        .addGap(0, 116, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoPagamento)
                    .addComponent(txtTipoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnRemover))
                .addGap(84, 84, 84))
        );

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja"
                + "adicionar o item ?","",JOptionPane.OK_CANCEL_OPTION) == 0){
        
            FormasPagamento novaFormaPagamento = new FormasPagamento();
            novaFormaPagamento.setNome(txtTipoPagamento.getText());
            novaFormaPagamento.setAtivo(1);
            FormasPagamentoDAO dao = new FormasPagamentoDAO();
            dao.Salvar(novaFormaPagamento);
            
            preenceTabela(carregaDadosDoBanco());
        }
        
    
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja "
                + "sair ?","",JOptionPane.OK_CANCEL_OPTION) == 0){
            this.dispose();
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void tblListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemMouseClicked
        Object valor = tblListagem.getValueAt(tblListagem.getSelectedRow(), 0);
        this.idFormaPagamentoParaRemover = (Integer) valor;
        
      
    }//GEN-LAST:event_tblListagemMouseClicked

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
       if(JOptionPane.showConfirmDialog(rootPane,"Você tem certeza que deseja "
               + "remover o item","",JOptionPane.OK_CANCEL_OPTION) == 0){
                 FormasPagamentoDAO dao = new FormasPagamentoDAO();
                 FormasPagamento tmp = new FormasPagamento();
                 tmp.setId(this.idFormaPagamentoParaRemover);
                 dao.Apagar(tmp);
                 preenceTabela(carregaDadosDoBanco());
            
       }
    }//GEN-LAST:event_btnRemoverActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTipoPagamento;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTextField txtTipoPagamento;
    // End of variables declaration//GEN-END:variables
}
