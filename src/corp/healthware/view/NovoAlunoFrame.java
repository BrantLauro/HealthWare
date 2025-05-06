package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.AlunoController;
import corp.healthware.controller.ModalidadeController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Modalidade;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class NovoAlunoFrame extends javax.swing.JPanel {

    public NovoAlunoFrame() {
        UIManager.put("Component.arrowType", "triangle");
        UIManager.put("ComboBox.selectionBackground", new Color(212, 81, 93));
        UIManager.put("ComboBox.buttonBackground", new Color(212, 81, 93));
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jTextFieldNome.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldData.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldObj.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldObs.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldTel.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldEndereco.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        initComboBoxMod();
    }
    
    private void voltar() {
        AlunosCentralFrame central = new AlunosCentralFrame();
        central.setSize(820, 570);
        central.setLocation(0, 0);
        removeAll();
        add(central, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void initComboBoxMod() {
        try {
            ModalidadeController modController = new ModalidadeController();
            ArrayList<Modalidade> mods = modController.findAll();
            mods.forEach((Modalidade mod) -> {

                jComboBoxModalidade.addItem("Cod. " + mod.getCod_m() + ": " + mod.getNome_m() + " " + mod.getVezes_semana() + " Vezes na semana");
            });
        } catch (SQLException | DAOexception ex) {
            Logger.getLogger(NovoAlunoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelObs = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelTel = new javax.swing.JLabel();
        jLabelModalidade = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelObj = new javax.swing.JLabel();
        jLabelPagamento = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldObj = new javax.swing.JTextField();
        jTextFieldObs = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jComboBoxModalidade = new javax.swing.JComboBox<>();
        jComboBoxPagamento = new javax.swing.JComboBox<>();
        jLabelHorario = new javax.swing.JLabel();
        jComboBoxHorario = new javax.swing.JComboBox<>();
        jButtonVoltar = new javax.swing.JButton();
        jTextFieldData = new javax.swing.JFormattedTextField();
        jTextFieldTel = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(820, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jPanel.setBackground(new java.awt.Color(223, 223, 223));

        jLabelTitulo.setBackground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setText("Cadastro de Aluno");

        jLabelData.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(41, 41, 41));
        jLabelData.setText("Data de Nascimento");

        jLabelObs.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelObs.setForeground(new java.awt.Color(41, 41, 41));
        jLabelObs.setText("Observações");

        jLabelNome.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(41, 41, 41));
        jLabelNome.setText("Nome");

        jLabelTel.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelTel.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTel.setText("Telefone");

        jLabelModalidade.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelModalidade.setForeground(new java.awt.Color(41, 41, 41));
        jLabelModalidade.setText("Modalidade");

        jLabelEndereco.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelEndereco.setForeground(new java.awt.Color(41, 41, 41));
        jLabelEndereco.setText("Endereço");

        jLabelObj.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelObj.setForeground(new java.awt.Color(41, 41, 41));
        jLabelObj.setText("Objetivo");

        jLabelPagamento.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelPagamento.setForeground(new java.awt.Color(41, 41, 41));
        jLabelPagamento.setText("Dia do Pagamento");

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

        jTextFieldObj.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldObj.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldObj.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldObj.setText("Emagrecer");
        jTextFieldObj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldObjFocusGained(evt);
            }
        });
        jTextFieldObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObjActionPerformed(evt);
            }
        });

        jTextFieldObs.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldObs.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldObs.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldObs.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldObs.setText("Problema na coluna");
        jTextFieldObs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldObsFocusGained(evt);
            }
        });
        jTextFieldObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldObsActionPerformed(evt);
            }
        });

        jTextFieldEndereco.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldEndereco.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldEndereco.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldEndereco.setText("Avenida Olímpio Teixeira, 514");
        jTextFieldEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEnderecoFocusGained(evt);
            }
        });
        jTextFieldEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEnderecoActionPerformed(evt);
            }
        });

        jButtonSalvar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonSalvar.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonSalvar.setText("SALVAR");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jComboBoxModalidade.setBackground(new java.awt.Color(239, 239, 239));
        jComboBoxModalidade.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jComboBoxModalidade.setForeground(new java.awt.Color(41, 41, 41));
        jComboBoxModalidade.setMaximumRowCount(30);
        jComboBoxModalidade.setPreferredSize(new java.awt.Dimension(68, 26));

        jComboBoxPagamento.setBackground(new java.awt.Color(239, 239, 239));
        jComboBoxPagamento.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jComboBoxPagamento.setForeground(new java.awt.Color(41, 41, 41));
        jComboBoxPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBoxPagamento.setPreferredSize(new java.awt.Dimension(68, 26));

        jLabelHorario.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelHorario.setForeground(new java.awt.Color(41, 41, 41));
        jLabelHorario.setText("Horário");

        jComboBoxHorario.setBackground(new java.awt.Color(239, 239, 239));
        jComboBoxHorario.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jComboBoxHorario.setForeground(new java.awt.Color(41, 41, 41));
        jComboBoxHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07:00", "08:00", "09:00", "10:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));
        jComboBoxHorario.setPreferredSize(new java.awt.Dimension(68, 26));

        jButtonVoltar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonVoltar.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonVoltar.setText("VOLTAR");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabelEndereco))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jTextFieldObs, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabelObs, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelObj, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldObj, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(350, 350, 350))))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabelNome)
                        .addGap(313, 313, 313)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelData)
                            .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelTitulo)
                .addGap(21, 21, 21)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelData))
                .addGap(2, 2, 2)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextFieldData))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTel)
                            .addComponent(jLabelModalidade))
                        .addGap(2, 2, 2)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jLabelHorario)
                        .addGap(2, 2, 2)
                        .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLabelEndereco)
                .addGap(4, 4, 4)
                .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelObj)
                    .addComponent(jLabelPagamento))
                .addGap(2, 2, 2)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldObj, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabelObs)
                .addGap(2, 2, 2)
                .addComponent(jTextFieldObs, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonVoltar))
                .addContainerGap(29, Short.MAX_VALUE))
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
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObjActionPerformed

    private void jTextFieldObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObsActionPerformed

    private void jTextFieldEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoActionPerformed

    private String formatarData() {
        String str = jTextFieldData.getText();
        return str.substring(6) + "-" + str.substring(3, 5) + "-" + str.substring(0, 2);
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            String nome = jTextFieldNome.getText();
            String dataNascimento = formatarData();
            String telefone = jTextFieldTel.getText();
            int modalidade = Integer.parseInt(jComboBoxModalidade.getSelectedItem().toString().substring(5, 7));
            String horario = (String) jComboBoxHorario.getSelectedItem();
            String endereco = jTextFieldEndereco.getText();
            int diaPag = Integer.parseInt((String) jComboBoxPagamento.getSelectedItem());
            String obs = "";
            String obj = "";
            if (!jTextFieldObj.getForeground().equals(new Color(139, 137, 137))) {
                obj = jTextFieldObj.getText();
            }
            if (!jTextFieldObs.getForeground().equals(new Color(139, 137, 137))) {
                obs = jTextFieldObs.getText();
            }
            if (!nome.equals("") && !jTextFieldNome.getForeground().equals(new Color(139, 137, 137))
                    && !dataNascimento.equals("    -  -  ") && !jTextFieldData.getForeground().equals(new Color(139, 137, 137))
                    && !telefone.equals("(  )      -    ") && !jTextFieldTel.getForeground().equals(new Color(139, 137, 137))
                    && !endereco.equals("") && !jTextFieldEndereco.getForeground().equals(new Color(139, 137, 137))) {
                AlunoController alunoCtrl = new AlunoController();
                if(alunoCtrl.insert(nome, dataNascimento, diaPag, obs, 1, telefone, obj, modalidade, endereco, horario) != 0)
                    voltar();
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

    private void jTextFieldNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeFocusGained

        if (jTextFieldNome.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldNome.setForeground(new Color(41, 41, 41));
            jTextFieldNome.setText("");
        }
    }//GEN-LAST:event_jTextFieldNomeFocusGained

    private void jTextFieldEnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoFocusGained
        if (jTextFieldEndereco.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldEndereco.setForeground(new Color(41, 41, 41));
            jTextFieldEndereco.setText("");
        }
    }//GEN-LAST:event_jTextFieldEnderecoFocusGained

    private void jTextFieldObjFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldObjFocusGained
        if (jTextFieldObj.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldObj.setForeground(new Color(41, 41, 41));
            jTextFieldObj.setText("");
        }
    }//GEN-LAST:event_jTextFieldObjFocusGained

    private void jTextFieldObsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldObsFocusGained
        if (jTextFieldObs.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldObs.setForeground(new Color(41, 41, 41));
            jTextFieldObs.setText("");
        }
    }//GEN-LAST:event_jTextFieldObsFocusGained

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        voltar();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextFieldDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataFocusGained
        if (jTextFieldData.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldData.setForeground(new Color(41, 41, 41));
            jTextFieldData.setText("");
        }
    }//GEN-LAST:event_jTextFieldDataFocusGained

    private void jTextFieldTelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTelFocusGained
        if (jTextFieldTel.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldTel.setForeground(new Color(41, 41, 41));
            jTextFieldTel.setText("");
        }
    }//GEN-LAST:event_jTextFieldTelFocusGained

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataActionPerformed

    private void jTextFieldTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxHorario;
    private javax.swing.JComboBox<String> jComboBoxModalidade;
    private javax.swing.JComboBox<String> jComboBoxPagamento;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelModalidade;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelObj;
    private javax.swing.JLabel jLabelObs;
    private javax.swing.JLabel jLabelPagamento;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JFormattedTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldObj;
    private javax.swing.JTextField jTextFieldObs;
    private javax.swing.JFormattedTextField jTextFieldTel;
    // End of variables declaration//GEN-END:variables
}
