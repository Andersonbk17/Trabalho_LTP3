/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Apresentacao;

import br.edu.ifnmg.tads.Ltp3.DataAccess.ClienteDAO;
import br.edu.ifnmg.tads.Ltp3.DataAccess.PessoaDAO;
import br.edu.ifnmg.tads.Ltp3.Model.Cliente;
import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anderson
 */
public class  frmListarClientes extends frmPadrao{

    /**
     * Creates new form frmListarClientes
     */
    public frmListarClientes() {
        initComponents();
        
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
        tblClientes = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setClosable(true);
        setTitle("Listagem de Clientes");
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnRemover)))
                .addGap(18, 18, 18)
                .addComponent(btnSair)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
       Object valueAt = tblClientes.getValueAt(tblClientes.getSelectedRow(), 0);
        this.idDoClienteParaRemover = (Integer) valueAt;
       
        
       /* 
        Object valueAt2 = tblClientes.getValueAt(tblClientes.getSelectedRow(), 2);
        this.cpfDapessoaDeletada = (String) valueAt2;
        //JOptionPane.showMessageDialog(rootPane, this.cpfDapessoaDeletada);
        * 
        * */
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
       Cliente tmp = null;
        try{
            tmp = dao.Abrir(this.idDoClienteParaRemover);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        //JOptionPane.showMessageDialog(rootPane, tmp.getId());
      
        
        //dao.Apagar(this.idDoClienteParaRemover);
        PessoaDAO daop = new PessoaDAO();
         if(JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja "
                + "apagar o cliente selecionado ?","",JOptionPane.OK_CANCEL_OPTION)== 0){
            if(dao.Apagar(this.idDoClienteParaRemover) && daop.Apagar(tmp.getId())){

                JOptionPane.showMessageDialog(rootPane, "Apagado com sucesso !");
                //this.listaDeClientes.clear();
                preencheTabela(carregaDadosDoBanco());


            }else{
                JOptionPane.showMessageDialog(rootPane, "Erro ao apagar !");
            }
             }
    }//GEN-LAST:event_btnRemoverActionPerformed

    
    private  List <Cliente> carregaDadosDoBanco(){
        this.dao = new ClienteDAO();
        try{
            List<Cliente> lista = dao.listarTodos();
          //  System.out.print(lista);
            return lista;
        }catch(ErroValidacaoException ex){
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            return null;
        }catch(Exception ex){
             JOptionPane.showMessageDialog(rootPane, ex.getMessage());
             return null;
        }
        
    
    }
    
    
    
    private void preencheTabela(List<Cliente> lista){
        this.modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Cpf");
        modelo.addColumn("Rg");
        modelo.addColumn("Data de Nascimento");
        
        /*modelo.addColumn("Endereços");
        modelo.addColumn("Telefones");
        modelo.addColumn("Emails");
        */
        for(Cliente u : lista){
            Vector v = new Vector();
            v.add(0,u.getIdCliente());
            v.add(1,u.getNome());
            v.add(2,u.getCpf());
            v.add(3,u.getRg());
            v.add(4,u.getDataNascimento());
            
            modelo.addRow(v);
            
        }
        this.tblClientes.setModel(modelo);
        this.tblClientes.repaint();
        
        
    }
    Cliente clienteQueSeraRemovido;
    List<Cliente> listaDeClientes;
    DefaultTableModel modelo;
    ClienteDAO dao;
    int idDoClienteParaRemover;
    String cpfDapessoaDeletada;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    // End of variables declaration//GEN-END:variables
}
