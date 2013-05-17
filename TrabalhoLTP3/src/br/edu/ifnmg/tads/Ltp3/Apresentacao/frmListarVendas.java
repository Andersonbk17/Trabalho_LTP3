/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Apresentacao;

import br.edu.ifnmg.tads.Ltp3.DataAccess.VendaDAO;
import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.ItemVenda;
import br.edu.ifnmg.tads.Ltp3.Model.Venda;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anderson
 */
public class frmListarVendas extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmListarVendas
     */
    public frmListarVendas() {
        initComponents();
        lblNome.setVisible(false);
        txtFiltro.setVisible(false);
        btnFiltrar.setVisible(false);
        lblDataDe.setVisible(false);
        preencheTabela(carregaDadosDoBanco());
        
    }
    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
        lblFiltro = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox();
        lblNome = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        lblDataDe = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setTitle("Listagem de Vendas");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

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
        jScrollPane1.setViewportView(tblListagem);

        lblFiltro.setText("Filtro:");

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Cliente", "Vendedor", "Valor", "Data" }));
        cbxFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxFiltroItemStateChanged(evt);
            }
        });

        lblNome.setText("Nome");
        lblNome.setFocusable(false);

        btnFiltrar.setText("Filtrar");

        lblDataDe.setText("Data de :");
        lblDataDe.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblFiltro)
                        .addGap(31, 31, 31)
                        .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDataDe)
                        .addGap(5, 5, 5)
                        .addComponent(lblNome)
                        .addGap(34, 34, 34)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 731, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltro)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar)
                    .addComponent(lblNome)
                    .addComponent(lblDataDe))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void cbxFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxFiltroItemStateChanged
        /*JOptionPane.showMessageDialog(rootPane,"ssdfs");
        lblFiltro.setVisible(false);*/
        
        if(cbxFiltro.getSelectedItem().equals("Selecione")){
            lblNome.setVisible(false);
            txtFiltro.setVisible(false);
            btnFiltrar.setVisible(false);
            lblDataDe.setVisible(false);

        }else if(cbxFiltro.getSelectedItem().equals("Cliente")){
                lblNome.setVisible(true);
                txtFiltro.setVisible(true);
                btnFiltrar.setVisible(true);
                lblDataDe.setVisible(false);

        }else if(cbxFiltro.getSelectedItem().equals("Vendedor")){
                lblNome.setVisible(true);
                txtFiltro.setVisible(true);
                btnFiltrar.setVisible(true);
                lblDataDe.setVisible(false);


        }else if(cbxFiltro.getSelectedItem().equals("Valor")){
            txtFiltro.setVisible(true);
            btnFiltrar.setVisible(true);
            lblDataDe.setVisible(false);

        }else if(cbxFiltro.getSelectedItem().equals("Data")){
            lblDataDe.setVisible(true);
            btnFiltrar.setVisible(true);
            

        }
    }//GEN-LAST:event_cbxFiltroItemStateChanged

    private void preencheTabela(List<Venda> lista){
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Cliente");
        modelo.addColumn("Usuario");
        modelo.addColumn("Horario");
        modelo.addColumn("Forma de Pagamento");
        modelo.addColumn("Valor Total");
        
        
     
        ItemVenda iv;
        //ItemVendaDAO
        for(Venda u : lista){
            Vector v = new Vector();
            v.add(0,u.getId());
            v.add(1,u.getCliente().getNome());
            v.add(2,u.getUsuario().getNome());
            v.add(3,u.getHorario());
            v.add(4, u.getFormaPagamento().getNome());
            
            //faltou a logica do valorde venda
            
            JOptionPane.showMessageDialog(rootPane, u.calCulaValorVenda());
            modelo.addRow(v);
            
        }
        this.tblListagem.setModel(modelo);
        this.tblListagem.repaint();
        
        
    }
    
    private  List <Venda> carregaDadosDoBanco(){
        this.dao = new VendaDAO();
        try{
            List<Venda> lista = dao.listarTodas();
          // System.out.print(lista);
            return lista;
        }catch(ErroValidacaoException ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            return null;
        }catch(Exception ex){
             JOptionPane.showMessageDialog(rootPane, ex.getMessage());
             return null;
        }
        
    
    }
    
    
    
    List<Venda> listaDeVendas;    
    DefaultTableModel modelo;
    VendaDAO dao;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox cbxFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDataDe;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    

}
