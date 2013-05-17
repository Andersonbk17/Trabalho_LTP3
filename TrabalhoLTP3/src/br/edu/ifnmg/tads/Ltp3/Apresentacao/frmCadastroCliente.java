/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Ltp3.Apresentacao;

import br.edu.ifnmg.tads.Ltp3.DataAccess.ClienteDAO;
import br.edu.ifnmg.tads.Ltp3.Model.Cliente;
import br.edu.ifnmg.tads.Ltp3.Model.Email;
import br.edu.ifnmg.tads.Ltp3.Model.Endereco;
import br.edu.ifnmg.tads.Ltp3.Model.ErroValidacaoException;
import br.edu.ifnmg.tads.Ltp3.Model.Telefone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anderson
 */
public class frmCadastroCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmCadastroCliente
     */
    
   
    public frmCadastroCliente() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    protected void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnNome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblRg = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtRg = new javax.swing.JTextField();
        txtDataNascimento = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        lblRua = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        lblNumeroEndereco = new javax.swing.JLabel();
        txtNumeroEndereco = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEndereco = new javax.swing.JTable();
        btnAdicionarEndereco = new javax.swing.JButton();
        btnRemoverEndereco = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        lblDdd = new javax.swing.JLabel();
        txtDdd = new javax.swing.JTextField();
        txtNumeroTelefone = new javax.swing.JTextField();
        btnAdicionarTelefone = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTelefones = new javax.swing.JTable();
        btnRemoverTelefone = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblEnderecoEmail = new javax.swing.JLabel();
        txtEnderecoEmail = new javax.swing.JTextField();
        btnAdicionarEmail = new javax.swing.JButton();
        btnRemoverEmail = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmail = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 600));

        btnNome.setText("Nome: ");

        lblCpf.setText("CPF: ");

        lblRg.setText("RG:");

        lblData.setText("Data de Nascimento: ");

        try {
            txtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNome)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblRg)
                            .addGap(18, 18, 18)
                            .addComponent(txtRg))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblCpf)
                            .addGap(18, 18, 18)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRg)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados Gerais", jPanel1);

        lblRua.setText("Rua: ");

        lblBairro.setText("Bairro");

        lblCep.setText("Cep:");

        lblCidade.setText("Cidade:");

        lblEstado.setText("Estado:");

        lblNumeroEndereco.setText("Nº:");

        tblEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEnderecoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEndereco);

        btnAdicionarEndereco.setText("Adicionar");
        btnAdicionarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEnderecoActionPerformed(evt);
            }
        });

        btnRemoverEndereco.setText("Remover");
        btnRemoverEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverEnderecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblRua)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNumeroEndereco)
                                .addGap(18, 18, 18)
                                .addComponent(txtNumeroEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(lblCep))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                                .addGap(66, 66, 66)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblEstado)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(lblBairro)
                    .addComponent(lblCidade)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdicionarEndereco)
                            .addComponent(btnRemoverEndereco))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRua)
                    .addComponent(lblNumeroEndereco)
                    .addComponent(txtNumeroEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCep)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnAdicionarEndereco)
                        .addGap(29, 29, 29)
                        .addComponent(btnRemoverEndereco)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Endereço", jPanel2);

        lblNumero.setText("Numero:");

        lblDdd.setText("DDD:");

        btnAdicionarTelefone.setText("Adicionar");
        btnAdicionarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarTelefoneActionPerformed(evt);
            }
        });

        tblTelefones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTelefones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTelefones);

        btnRemoverTelefone.setText("Remover");
        btnRemoverTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblDdd)
                        .addGap(31, 31, 31)
                        .addComponent(txtDdd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(lblNumero)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumeroTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnAdicionarTelefone)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoverTelefone)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDdd)
                    .addComponent(txtDdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumeroTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarTelefone)
                    .addComponent(btnRemoverTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Telefone", jPanel3);

        lblEnderecoEmail.setText("Endereço:");

        btnAdicionarEmail.setText("Adicionar");
        btnAdicionarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarEmailActionPerformed(evt);
            }
        });

        btnRemoverEmail.setText("Remover");
        btnRemoverEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverEmailActionPerformed(evt);
            }
        });

        tblEmail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmailMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblEmail);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblEnderecoEmail)
                        .addGap(18, 18, 18)
                        .addComponent(txtEnderecoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnAdicionarEmail)
                        .addGap(38, 38, 38)
                        .addComponent(btnRemoverEmail)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnderecoEmail)
                    .addComponent(txtEnderecoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarEmail)
                    .addComponent(btnRemoverEmail))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Email", jPanel4);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSair))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void txtDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascimentoActionPerformed

    protected void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja cancelar?")== 0){
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    protected void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane,"Deseja Salvar os dados?") == 0){
            /*if(txtNome.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "O campo nome não pode ser vazio");
            }else if (txtCpf.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "O campo cpf não pode ser vazio");
            }else if(txtRg.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "O campo Rg não pode ser vazio");
            }else{*/
            if(validaCampos()){
                Cliente cliente = null; 

                try {
                        cliente = new Cliente();

                        cliente.setCpf(txtCpf.getText());
                        cliente.setDataNascimento(dataFormatada(txtDataNascimento.getText()));
                        cliente.setEmails(this.listaEmails);
                        cliente.setEnderecos(this.listaEnderecos);
                        cliente.setNome(txtNome.getText());
                        cliente.setRg(txtRg.getText());
                        cliente.setTelefones(this.listaTelefones);
                        cliente.setIdCliente(this.idCliente);
                        cliente.setId(this.idPessoa);

                    } catch (ErroValidacaoException ex) {
                        //Logger.getLogger(frmCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                        cliente = null;
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                        cliente = null;
                    }

                    if(cliente != null){
                        ClienteDAO dao = new ClienteDAO();
                        try{
                            if(dao.Salvar(cliente)){
                            JOptionPane.showMessageDialog(rootPane, "Cliente Salvo com sucesso !");
                            this.listaEmails.clear();
                            this.listaEnderecos.clear();
                            this.listaTelefones.clear();
                            //criar limpar os campos
                            limpaCampos();
                            this.tblEmail.repaint();
                            this.tblEndereco.repaint();
                            this.tblTelefones.repaint();
                            }
                        }catch(ErroValidacaoException ex){
                            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                        }

                    }

                }else{
                JOptionPane.showMessageDialog(rootPane, "Todos os campos devem ser preenchidos !");
            }
        }
            
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    protected void btnAdicionarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEmailActionPerformed
       Email tmp = new Email();
       
       tmp.setEndereco(txtEnderecoEmail.getText());
       //tmp.setAtivo(1);
       this.listaEmails.add(tmp);
       carregaTabelaEmails(this.listaEmails);
       
    }//GEN-LAST:event_btnAdicionarEmailActionPerformed

    protected void btnAdicionarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarTelefoneActionPerformed
        Telefone tmp = new Telefone();
        try{
            tmp.setDdd(Integer.parseInt(txtDdd.getText()));
            tmp.setNumero(Integer.parseInt(txtNumeroTelefone.getText()));
            
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "No campo ddd só é permitido caracteres numéricos !");
        }
        this.listaTelefones.add(tmp);
        carregaTabelaTelefones(this.listaTelefones);
    }//GEN-LAST:event_btnAdicionarTelefoneActionPerformed

    protected void btnAdicionarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarEnderecoActionPerformed
        Endereco tmp = new Endereco();
        
        try{
            tmp.setNumero(Integer.parseInt(txtNumeroEndereco.getText()));
            tmp.setBairro(txtBairro.getText());
            tmp.setCep(txtCep.getText());
            tmp.setCidade(txtCidade.getText());
            tmp.setEstado(txtEstado.getText());
            tmp.setRua(txtRua.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "No campo ddd só é permitido caracteres numéricos !");
        }
        this.listaEnderecos.add(tmp);
        carregaTabelaEnderecos(this.listaEnderecos);
        
    }//GEN-LAST:event_btnAdicionarEnderecoActionPerformed

    protected void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
       if(JOptionPane.showConfirmDialog(rootPane, "Você tem certeza que deseja sair ?","",JOptionPane.OK_CANCEL_OPTION) == 0){
           this.dispose();
       }
    }//GEN-LAST:event_btnSairActionPerformed

    protected void btnRemoverEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverEmailActionPerformed
        this.listaEmails.remove(this.emailParaRemover);
        carregaTabelaEmails(listaEmails);
    }//GEN-LAST:event_btnRemoverEmailActionPerformed

    protected void btnRemoverTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverTelefoneActionPerformed
        this.listaTelefones.remove(this.telefoneParaRemover);
        carregaTabelaTelefones(listaTelefones);
    }//GEN-LAST:event_btnRemoverTelefoneActionPerformed

    protected void btnRemoverEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverEnderecoActionPerformed
        this.listaEnderecos.remove(this.enderecoParaRemover);
        carregaTabelaEnderecos(listaEnderecos);
    }//GEN-LAST:event_btnRemoverEnderecoActionPerformed

    protected void tblEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEnderecoMouseClicked
        this.enderecoParaRemover = tblEndereco.getSelectedRow();
    }//GEN-LAST:event_tblEnderecoMouseClicked

    protected void tblTelefonesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonesMouseClicked
      this.telefoneParaRemover = tblTelefones.getSelectedRow();
    }//GEN-LAST:event_tblTelefonesMouseClicked

    protected void tblEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmailMouseClicked
       this.emailParaRemover = tblEmail.getSelectedRow();
    }//GEN-LAST:event_tblEmailMouseClicked

    
    protected void carregaTabelaTelefones(List<Telefone> lista){
        this.modeloTabelaTelefone = new DefaultTableModel();
        this.modeloTabelaTelefone.addColumn("DDD");
        this.modeloTabelaTelefone.addColumn("Numero");
        
        
        for(Telefone t : lista){
            Vector v = new Vector();
            v.add(0,t.getDdd());
            v.add(1,t.getNumero());
            
            this.modeloTabelaTelefone.addRow(v);
        
        }
        this.tblTelefones.setModel(modeloTabelaTelefone);
        this.tblTelefones.repaint();
    
    }
    
    protected void carregaTabelaEnderecos(List<Endereco> lista){
        this.modeloTabelaEndereco = new DefaultTableModel();
        this.modeloTabelaEndereco.addColumn("Rua");
        this.modeloTabelaEndereco.addColumn("Bairro");
        this.modeloTabelaEndereco.addColumn("Cep");
        this.modeloTabelaEndereco.addColumn("Número");
        this.modeloTabelaEndereco.addColumn("Cidade");
        this.modeloTabelaEndereco.addColumn("Estado");
        
        for(Endereco e : lista){
            Vector v = new Vector();
            v.add(0,e.getRua());
            v.add(1,e.getBairro());
            v.add(2,e.getCep());
            v.add(3,e.getNumero());
            v.add(4,e.getCidade());
            v.add(5,e.getEstado());
            
            modeloTabelaEndereco.addRow(v);
        
        }
        this.tblEndereco.setModel(modeloTabelaEndereco);
        this.tblEndereco.repaint();
        
    
    }
    
    
    protected void carregaTabelaEmails(List<Email> listaEmails){
        this.modeloTabelaEmail = new DefaultTableModel();
        modeloTabelaEmail.addColumn("Endereco");
        
       
        
        for(Email e : listaEmails){
             Vector v = new Vector();
            v.add(0,e.getEndereco());
            modeloTabelaEmail.addRow(v);
        }
        
        tblEmail.setModel(modeloTabelaEmail);
        tblEmail.repaint();
    }
    
    
    protected boolean validaCampos(){
        boolean valida = true;
        if(txtCpf.getText().isEmpty() || txtDataNascimento.getText().isEmpty() || 
            txtNome.getText().isEmpty()){
            
                valida = false;
            
        }else {
            valida = true;
        }
        
        return valida;
    
    }
    
    
    protected Date dataFormatada(String dataDesformatada) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
        
        Date dataForm = format.parse(dataDesformatada);
        
        return dataForm; 
    }
    
    
    protected void limpaCampos(){
        this.txtBairro.setText("");
        this.txtCep.setText("");
        this.txtCidade.setText("");
        this.txtCpf.setText("");
        this.txtDataNascimento.setText("");
        this.txtDdd.setText("");
        this.txtEstado.setText("");
        this.txtNome.setText("");
        this.txtNumeroTelefone.setText("");
        this.txtNumeroEndereco.setText("");
        this.txtRg.setText("");
        this.txtRua.setText("");
        
    
    }
    
    
    
    protected List<Email> listaEmails = new LinkedList<>();
    protected List<Endereco> listaEnderecos = new LinkedList<>();
    protected List<Telefone> listaTelefones = new LinkedList<>();
    
    protected DefaultTableModel modeloTabelaEmail;
    protected DefaultTableModel modeloTabelaTelefone; 
    protected DefaultTableModel modeloTabelaEndereco; 
 
    
    int telefoneParaRemover;
    int enderecoParaRemover;
    int emailParaRemover;
    protected int idCliente = 0;
    protected int idPessoa = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnAdicionarEmail;
    protected javax.swing.JButton btnAdicionarEndereco;
    protected javax.swing.JButton btnAdicionarTelefone;
    protected javax.swing.JButton btnCancelar;
    protected javax.swing.JLabel btnNome;
    protected javax.swing.JButton btnRemoverEmail;
    protected javax.swing.JButton btnRemoverEndereco;
    protected javax.swing.JButton btnRemoverTelefone;
    protected javax.swing.JButton btnSair;
    protected javax.swing.JButton btnSalvar;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    protected javax.swing.JPanel jPanel3;
    protected javax.swing.JPanel jPanel4;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JScrollPane jScrollPane3;
    protected javax.swing.JTabbedPane jTabbedPane1;
    protected javax.swing.JLabel lblBairro;
    protected javax.swing.JLabel lblCep;
    protected javax.swing.JLabel lblCidade;
    protected javax.swing.JLabel lblCpf;
    protected javax.swing.JLabel lblData;
    protected javax.swing.JLabel lblDdd;
    protected javax.swing.JLabel lblEnderecoEmail;
    protected javax.swing.JLabel lblEstado;
    protected javax.swing.JLabel lblNumero;
    protected javax.swing.JLabel lblNumeroEndereco;
    protected javax.swing.JLabel lblRg;
    protected javax.swing.JLabel lblRua;
    protected javax.swing.JTable tblEmail;
    protected javax.swing.JTable tblEndereco;
    protected javax.swing.JTable tblTelefones;
    protected javax.swing.JTextField txtBairro;
    protected javax.swing.JTextField txtCep;
    protected javax.swing.JTextField txtCidade;
    protected javax.swing.JTextField txtCpf;
    protected javax.swing.JFormattedTextField txtDataNascimento;
    protected javax.swing.JTextField txtDdd;
    protected javax.swing.JTextField txtEnderecoEmail;
    protected javax.swing.JTextField txtEstado;
    protected javax.swing.JTextField txtNome;
    protected javax.swing.JTextField txtNumeroEndereco;
    protected javax.swing.JTextField txtNumeroTelefone;
    protected javax.swing.JTextField txtRg;
    protected javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables
}
