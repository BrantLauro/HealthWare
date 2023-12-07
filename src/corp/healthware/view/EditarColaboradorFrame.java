package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.AlunoController;
import corp.healthware.controller.ColaboradorController;
import corp.healthware.controller.ModalidadeController;
import corp.healthware.controller.ServicoController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aluno;
import corp.healthware.model.entity.Colaborador;
import corp.healthware.model.entity.Modalidade;
import corp.healthware.model.entity.Servico;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class EditarColaboradorFrame extends javax.swing.JPanel {

    private int cod_c;

    public EditarColaboradorFrame(Colaborador c) {
        UIManager.put("Component.arrowType", "triangle");
        UIManager.put("ComboBox.selectionBackground", new Color(212, 81, 93));
        UIManager.put("ComboBox.buttonBackground", new Color(212, 81, 93));
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jTextFieldNome.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldTel.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldData.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldEspecialidade.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldEmail.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldSenha.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        
        initComboBoxAdm();
        cod_c = c.getCod_c();
        jLabelTitulo.setText(c.getNome_c());
        jTextFieldNome.setText(c.getNome_c());
        //jTextFieldPreco.setText(s.getPreco());

    }

    private void initComboBoxAdm() {
        jComboBoxAdm.addItem("Sim");
        jComboBoxAdm.addItem("Não");
    }

    private void voltar() {
        ServicoCentralFrame central = new ServicoCentralFrame();
        central.setSize(820, 570);
        central.setLocation(0, 0);
        removeAll();
        add(central, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldTel = new javax.swing.JFormattedTextField();
        jLabelTel = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JFormattedTextField();
        jLabelData = new javax.swing.JLabel();
        jTextFieldEspecialidade = new javax.swing.JTextField();
        jLabelEspecialidade = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelEspecialidade1 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JTextField();
        jLabelEspecialidade2 = new javax.swing.JLabel();
        jComboBoxAdm = new javax.swing.JComboBox<>();
        jLabelModalidade = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(820, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jPanel.setBackground(new java.awt.Color(223, 223, 223));

        jButtonSalvar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonSalvar.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonSalvar.setText("SALVAR");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonVoltar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonVoltar.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonVoltar.setText("VOLTAR");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(223, 223, 223));
        jPanel1.setPreferredSize(new java.awt.Dimension(773, 550));

        jLabelTitulo.setBackground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setText("Editar");

        jTextFieldNome.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldNome.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldNome.setText("Lucas");
        jTextFieldNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNomeFocusGained(evt);
            }
        });
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabelNome.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(41, 41, 41));
        jLabelNome.setText("Nome");

        jTextFieldTel.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldTel.setForeground(new java.awt.Color(139, 137, 137));
        try {
            jTextFieldTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldTel.setText("(38) 99958-2856");
        jTextFieldTel.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldTel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldTelFocusGained(evt);
            }
        });
        jTextFieldTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelActionPerformed(evt);
            }
        });

        jLabelTel.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelTel.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTel.setText("Telefone");

        jTextFieldData.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldData.setForeground(new java.awt.Color(139, 137, 137));
        try {
            jTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldData.setText("25/11/1986");
        jTextFieldData.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldDataFocusGained(evt);
            }
        });
        jTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataActionPerformed(evt);
            }
        });

        jLabelData.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(41, 41, 41));
        jLabelData.setText("Data de Nascimento");

        jTextFieldEspecialidade.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldEspecialidade.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldEspecialidade.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldEspecialidade.setText("Massagem");
        jTextFieldEspecialidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEspecialidadeFocusGained(evt);
            }
        });
        jTextFieldEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEspecialidadeActionPerformed(evt);
            }
        });

        jLabelEspecialidade.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelEspecialidade.setForeground(new java.awt.Color(41, 41, 41));
        jLabelEspecialidade.setText("Especialidade");

        jTextFieldEmail.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldEmail.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldEmail.setText("teste@dominio.com");
        jTextFieldEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEmailFocusGained(evt);
            }
        });
        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jLabelEspecialidade1.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelEspecialidade1.setForeground(new java.awt.Color(41, 41, 41));
        jLabelEspecialidade1.setText("E-mail");

        jTextFieldSenha.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldSenha.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldSenha.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldSenha.setText("**********");
        jTextFieldSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldSenhaFocusGained(evt);
            }
        });
        jTextFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSenhaActionPerformed(evt);
            }
        });

        jLabelEspecialidade2.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelEspecialidade2.setForeground(new java.awt.Color(41, 41, 41));
        jLabelEspecialidade2.setText("Senha");

        jComboBoxAdm.setBackground(new java.awt.Color(239, 239, 239));
        jComboBoxAdm.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jComboBoxAdm.setForeground(new java.awt.Color(41, 41, 41));
        jComboBoxAdm.setMaximumRowCount(30);
        jComboBoxAdm.setPreferredSize(new java.awt.Dimension(68, 26));
        jComboBoxAdm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAdmActionPerformed(evt);
            }
        });

        jLabelModalidade.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelModalidade.setForeground(new java.awt.Color(41, 41, 41));
        jLabelModalidade.setText("Administrador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(335, 335, 335))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldNome)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelNome)
                                .addComponent(jLabelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelEspecialidade)
                                .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelData)
                                .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jTextFieldEspecialidade)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelEspecialidade1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelEspecialidade2)
                                .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelModalidade))))
                    .addGap(44, 44, 44)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addContainerGap(499, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addComponent(jLabelNome)
                    .addGap(2, 2, 2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTel)
                        .addComponent(jLabelData))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jLabelEspecialidade)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextFieldEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEspecialidade1)
                        .addComponent(jLabelEspecialidade2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabelModalidade)
                    .addGap(2, 2, 2)
                    .addComponent(jComboBoxAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(108, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 212, Short.MAX_VALUE)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(476, 476, 476)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonVoltar))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            String nome_c = jTextFieldNome.getText();
            String tel = jTextFieldTel.getText();
            String data = jTextFieldData.getText();
            String esp = jTextFieldEspecialidade.getText();
            String email = jTextFieldEmail.getText();
            String senha = jTextFieldSenha.getText();
            String admin = (String) jComboBoxAdm.getSelectedItem();
            boolean adm = false;
            
            if (admin.equals("Sim")){
                adm = true;
            }
            else if(admin.equals("Não")){
                adm = false;
            }
            if (!nome_c.equals("")) {
                ColaboradorController colabCtrl = new ColaboradorController();
                if (colabCtrl.update(nome_c, tel, data, esp, email, senha, adm) != 0) {
                    voltar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (DAOexception | SQLException ex) {
            System.out.println("Erro criacao statement: " + ex);
            System.exit(0);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        voltar();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextFieldNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeFocusGained

        if (jTextFieldNome.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldNome.setForeground(new Color(41, 41, 41));
            jTextFieldNome.setText("");
        }
    }//GEN-LAST:event_jTextFieldNomeFocusGained

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldTelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTelFocusGained
        if (jTextFieldTel.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldTel.setForeground(new Color(41, 41, 41));
            jTextFieldTel.setText("");
        }
    }//GEN-LAST:event_jTextFieldTelFocusGained

    private void jTextFieldTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelActionPerformed

    private void jTextFieldDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataFocusGained
        if (jTextFieldData.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldData.setForeground(new Color(41, 41, 41));
            jTextFieldData.setText("");
        }
    }//GEN-LAST:event_jTextFieldDataFocusGained

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldDataActionPerformed

    private void jTextFieldEspecialidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEspecialidadeFocusGained
        // TODO add your handling code here:
        if (jTextFieldEspecialidade.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldEspecialidade.setForeground(new Color(41, 41, 41));
            jTextFieldEspecialidade.setText("");
        }
    }//GEN-LAST:event_jTextFieldEspecialidadeFocusGained

    private void jTextFieldEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEspecialidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEspecialidadeActionPerformed

    private void jTextFieldEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusGained
        // TODO add your handling code here:
        if (jTextFieldEmail.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldEmail.setForeground(new Color(41, 41, 41));
            jTextFieldEmail.setText("");
        }
    }//GEN-LAST:event_jTextFieldEmailFocusGained

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jTextFieldSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldSenhaFocusGained
        // TODO add your handling code here:
        if (jTextFieldSenha.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldSenha.setForeground(new Color(41, 41, 41));
            jTextFieldSenha.setText("");
        }
    }//GEN-LAST:event_jTextFieldSenhaFocusGained

    private void jTextFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSenhaActionPerformed

    private void jComboBoxAdmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAdmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAdmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxAdm;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelEspecialidade;
    private javax.swing.JLabel jLabelEspecialidade1;
    private javax.swing.JLabel jLabelEspecialidade2;
    private javax.swing.JLabel jLabelModalidade;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JFormattedTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEspecialidade;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JFormattedTextField jTextFieldTel;
    // End of variables declaration//GEN-END:variables
}
