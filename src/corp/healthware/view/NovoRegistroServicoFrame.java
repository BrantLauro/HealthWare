package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.RegistroServicoController;
import corp.healthware.model.dao.DAOexception;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class NovoRegistroServicoFrame extends javax.swing.JPanel {
    
    private int cod_s;
    
    public NovoRegistroServicoFrame(int cod_s) {
        this.cod_s = cod_s;
        UIManager.put("Component.arrowType", "triangle");
        UIManager.put("ComboBox.selectionBackground", new Color(212, 81, 93));
        UIManager.put("ComboBox.buttonBackground", new Color(212, 81, 93));
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jTextFieldData.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldData.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldNomeC.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
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

/*    private void initComboBoxMod() {
        try {
            ModalidadeController modController = new ModalidadeController();
            ArrayList<Modalidade> mods = modController.findAll();
            mods.forEach((Modalidade mod) -> {

                jComboBoxModalidade.addItem("Cod. " + mod.getCod_m() + ": " + mod.getNome_m() + " " + mod.getVezes_semana() + " Vezes na semana");
            });
        } catch (SQLException | DAOexception ex) {
            Logger.getLogger(NovaAulaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelObs = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNomeC = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jLabelHorario = new javax.swing.JLabel();
        jComboBoxHorario = new javax.swing.JComboBox<>();
        jButtonVoltar = new javax.swing.JButton();
        jTextFieldData = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(820, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jPanel.setBackground(new java.awt.Color(223, 223, 223));

        jLabelTitulo.setBackground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setText("Registrar Serviço");

        jLabelObs.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelObs.setForeground(new java.awt.Color(41, 41, 41));
        jLabelObs.setText("Nome do Cliente");

        jLabelNome.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(41, 41, 41));
        jLabelNome.setText("Data");

        jTextFieldNomeC.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldNomeC.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldNomeC.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldNomeC.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNomeC.setText("Clonilda");
        jTextFieldNomeC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNomeCFocusGained(evt);
            }
        });
        jTextFieldNomeC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeCActionPerformed(evt);
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

        jLabelHorario.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelHorario.setForeground(new java.awt.Color(41, 41, 41));
        jLabelHorario.setText("Horário");

        jComboBoxHorario.setBackground(new java.awt.Color(239, 239, 239));
        jComboBoxHorario.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jComboBoxHorario.setForeground(new java.awt.Color(41, 41, 41));
        jComboBoxHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07:00", "08:00", "09:00", "10:00", "16:00", "17:00", "18:00", "19:00", "20:00" }));
        jComboBoxHorario.setPreferredSize(new java.awt.Dimension(68, 26));
        jComboBoxHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxHorarioActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabelTitulo))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelLayout.createSequentialGroup()
                                        .addComponent(jLabelNome)
                                        .addGap(309, 309, 309))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                        .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jTextFieldNomeC, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelObs))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelTitulo)
                .addGap(78, 78, 78)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHorario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNome))
                .addGap(2, 2, 2)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxHorario, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jTextFieldData))
                .addGap(18, 18, 18)
                .addComponent(jLabelObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNomeC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203)
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
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeCActionPerformed

    private String formatarData() {
        String str = jTextFieldData.getText();
        return str.substring(6) + "-" + str.substring(3, 5) + "-" + str.substring(0, 2);
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            String data_s = formatarData();
            String horario = (String) jComboBoxHorario.getSelectedItem();
            String nome_c = "";
            if (!jTextFieldNomeC.getForeground().equals(new Color(139, 137, 137))) {
                nome_c = jTextFieldNomeC.getText();
            }
            if (!data_s.equals("    -  -  ") &&
                !jTextFieldData.getForeground().equals(new Color(139, 137, 137))) {
                RegistroServicoController regCtrl = new RegistroServicoController();
                if(regCtrl.insert(cod_s,nome_c, data_s, horario) != 0)
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

    private void jTextFieldNomeCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeCFocusGained
        if (jTextFieldNomeC.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldNomeC.setForeground(new Color(41, 41, 41));
            jTextFieldNomeC.setText("");
        }
    }//GEN-LAST:event_jTextFieldNomeCFocusGained

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        voltar();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jComboBoxHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxHorarioActionPerformed

    private void jTextFieldDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDataFocusGained
        if (jTextFieldData.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldData.setForeground(new Color(41, 41, 41));
            jTextFieldData.setText("");
        }
    }//GEN-LAST:event_jTextFieldDataFocusGained

    private void jTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxHorario;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelObs;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JFormattedTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldNomeC;
    // End of variables declaration//GEN-END:variables
}
