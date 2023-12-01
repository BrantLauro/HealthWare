
package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.model.entity.Aluno;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;

public class EditarAlunoFrame extends javax.swing.JPanel {

    public EditarAlunoFrame(Aluno a) {
        UIManager.put( "Component.arrowType", "triangle" );
        UIManager.put( "ComboBox.selectionBackground", new Color(212,81,93));
        UIManager.put( "ComboBox.buttonBackground", new Color(212,81,93));
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jTextFieldData.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldObj.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldObs.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldTel.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldEndereco.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jLabelTitulo.setText(a.getNome_a());
        jTextFieldData.setText(a.getData_nasc_a());
        jTextFieldEndereco.setText(a.getEndereco());
        jTextFieldObj.setText(a.getObj());
        jTextFieldObs.setText(a.getObs());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabelObs = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelTel = new javax.swing.JLabel();
        jLabelModalidade = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelObj = new javax.swing.JLabel();
        jLabelPagamento = new javax.swing.JLabel();
        jTextFieldData = new javax.swing.JTextField();
        jTextFieldObj = new javax.swing.JTextField();
        jTextFieldObs = new javax.swing.JTextField();
        jTextFieldTel = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jComboBoxPilates = new javax.swing.JComboBox<>();
        jComboBoxPagamento = new javax.swing.JComboBox<>();
        jLabelHorario = new javax.swing.JLabel();
        jComboBoxHorario = new javax.swing.JComboBox<>();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jButtonSalvar1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(820, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jPanel.setBackground(new java.awt.Color(223, 223, 223));

        jLabelTitulo.setBackground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setText("Editar");

        jLabelData.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(41, 41, 41));
        jLabelData.setText("Data de Nascimento");

        jLabelObs.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelObs.setForeground(new java.awt.Color(41, 41, 41));
        jLabelObs.setText("Observações");

        jLabelStatus.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(41, 41, 41));
        jLabelStatus.setText("Status");

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

        jTextFieldData.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldData.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldData.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldData.setText("08/03/1980");
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

        jTextFieldTel.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldTel.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldTel.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldTel.setText("(38) 9958-2856");
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

        jComboBoxPilates.setBackground(new java.awt.Color(239, 239, 239));
        jComboBoxPilates.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jComboBoxPilates.setForeground(new java.awt.Color(41, 41, 41));
        jComboBoxPilates.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilates", "Circuito", "Yoga" }));
        jComboBoxPilates.setPreferredSize(new java.awt.Dimension(68, 26));

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

        jComboBoxStatus.setBackground(new java.awt.Color(239, 239, 239));
        jComboBoxStatus.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jComboBoxStatus.setForeground(new java.awt.Color(41, 41, 41));
        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo", "Devedor" }));
        jComboBoxStatus.setPreferredSize(new java.awt.Dimension(68, 26));

        jButtonSalvar1.setBackground(new java.awt.Color(212, 81, 93));
        jButtonSalvar1.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonSalvar1.setForeground(new java.awt.Color(239, 239, 239));
        jButtonSalvar1.setText("VOLTAR");
        jButtonSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvar1ActionPerformed(evt);
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
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxPilates, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(jLabelStatus)
                                .addGap(313, 313, 313)
                                .addComponent(jLabelData)))))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jButtonSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelTitulo)
                .addGap(21, 21, 21)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatus)
                    .addComponent(jLabelData))
                .addGap(2, 2, 2)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTel)
                            .addComponent(jLabelModalidade))
                        .addGap(2, 2, 2)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPilates, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelLayout.createSequentialGroup()
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
                .addGap(28, 28, 28)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonSalvar1))
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataActionPerformed

    private void jTextFieldObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObjActionPerformed

    private void jTextFieldObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldObsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldObsActionPerformed

    private void jTextFieldTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelActionPerformed

    private void jTextFieldEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        /*MainFrame main = new MainFrame();
        main.setSize(1000, 570);
        main.setLocation(0, 0);
        jPanelContent.removeAll();
        jPanelContent.add(main, BorderLayout.CENTER);
        jPanelContent.revalidate();
        jPanelContent.repaint();*/
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jTextFieldDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataFocusGained
        if(jTextFieldData.getForeground().equals(new Color(139,137,137))) {
            jTextFieldData.setForeground(new Color(41,41,41));
            jTextFieldData.setText("");
        }
    }//GEN-LAST:event_jTextFieldDataFocusGained

    private void jTextFieldTelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldTelFocusGained
        if(jTextFieldTel.getForeground().equals(new Color(139,137,137))) {
            jTextFieldTel.setForeground(new Color(41,41,41));
            jTextFieldTel.setText("");
        }
    }//GEN-LAST:event_jTextFieldTelFocusGained

    private void jTextFieldEnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoFocusGained
       if(jTextFieldEndereco.getForeground().equals(new Color(139,137,137))) {
            jTextFieldEndereco.setForeground(new Color(41,41,41));
            jTextFieldEndereco.setText("");
        }
    }//GEN-LAST:event_jTextFieldEnderecoFocusGained

    private void jTextFieldObjFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldObjFocusGained
        if(jTextFieldObj.getForeground().equals(new Color(139,137,137))) {
            jTextFieldObj.setForeground(new Color(41,41,41));
            jTextFieldObj.setText("");
        }
    }//GEN-LAST:event_jTextFieldObjFocusGained

    private void jTextFieldObsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldObsFocusGained
        if(jTextFieldObs.getForeground().equals(new Color(139,137,137))) {
            jTextFieldObs.setForeground(new Color(41,41,41));
            jTextFieldObs.setText("");
        }
    }//GEN-LAST:event_jTextFieldObsFocusGained

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed
        AlunosCentralFrame central = new AlunosCentralFrame();
        central.setSize(820, 570);
        central.setLocation(0, 0);
        removeAll();
        add(central, BorderLayout.CENTER);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonSalvar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSalvar1;
    private javax.swing.JComboBox<String> jComboBoxHorario;
    private javax.swing.JComboBox<String> jComboBoxPagamento;
    private javax.swing.JComboBox<String> jComboBoxPilates;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelModalidade;
    private javax.swing.JLabel jLabelObj;
    private javax.swing.JLabel jLabelObs;
    private javax.swing.JLabel jLabelPagamento;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldObj;
    private javax.swing.JTextField jTextFieldObs;
    private javax.swing.JTextField jTextFieldTel;
    // End of variables declaration//GEN-END:variables
}
