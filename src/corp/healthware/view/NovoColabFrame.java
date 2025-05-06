
package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.AlunoController;
import corp.healthware.controller.ColaboradorController;
import corp.healthware.controller.ModalidadeController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Colaborador;
import corp.healthware.model.entity.Modalidade;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class NovoColabFrame extends javax.swing.JPanel {

    public NovoColabFrame() {
        UIManager.put( "Component.arrowType", "triangle" );
        UIManager.put( "ComboBox.selectionBackground", new Color(212,81,93));
        UIManager.put( "ComboBox.buttonBackground", new Color(212,81,93));
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jTextFieldNome.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldData.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldTel.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldEmail.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldEsp.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jPasswordField.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
    }
    
    private void voltar() {
        ColabCentralFrame central = new ColabCentralFrame();
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
        jLabelTitulo = new javax.swing.JLabel();
        jLabelVSem = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jLabelResp = new javax.swing.JLabel();
        jLabelPreco = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jTextFieldTel = new javax.swing.JFormattedTextField();
        jTextFieldData = new javax.swing.JFormattedTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldEsp = new javax.swing.JTextField();
        jLabelResp1 = new javax.swing.JLabel();
        jLabelResp2 = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(820, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jPanel.setBackground(new java.awt.Color(223, 223, 223));
        jPanel.setPreferredSize(new java.awt.Dimension(773, 550));

        jLabelTitulo.setBackground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setText("Cadastro de Colaborador");

        jLabelVSem.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelVSem.setForeground(new java.awt.Color(41, 41, 41));
        jLabelVSem.setText("Data de Nascimento");

        jLabelNome.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(41, 41, 41));
        jLabelNome.setText("Nome");

        jTextFieldNome.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldNome.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldNome.setText("Lucas Colen");
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

        jButtonSalvar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonSalvar.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonSalvar.setText("SALVAR");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabelResp.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelResp.setForeground(new java.awt.Color(41, 41, 41));
        jLabelResp.setText("Senha");

        jLabelPreco.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelPreco.setForeground(new java.awt.Color(41, 41, 41));
        jLabelPreco.setText("Telefone");

        jButtonVoltar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonVoltar.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonVoltar.setText("VOLTAR");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
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

        jTextFieldEmail.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldEmail.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldEmail.setText("brantcissa@gmail.com");
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

        jTextFieldEsp.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldEsp.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldEsp.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldEsp.setText("Massagem");
        jTextFieldEsp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEspFocusGained(evt);
            }
        });
        jTextFieldEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEspActionPerformed(evt);
            }
        });

        jLabelResp1.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelResp1.setForeground(new java.awt.Color(41, 41, 41));
        jLabelResp1.setText("Especialidade");

        jLabelResp2.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelResp2.setForeground(new java.awt.Color(41, 41, 41));
        jLabelResp2.setText("E-mail");

        jPasswordField.setBackground(new java.awt.Color(239, 239, 239));
        jPasswordField.setForeground(new java.awt.Color(139, 137, 137));
        jPasswordField.setText("********");
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelPreco)
                            .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelResp1)
                            .addComponent(jTextFieldEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldData)
                                .addComponent(jLabelResp)
                                .addComponent(jLabelVSem)
                                .addComponent(jTextFieldEmail)
                                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelResp2))
                        .addGap(45, 45, 45))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelTitulo)
                .addGap(116, 116, 116)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelVSem))
                .addGap(2, 2, 2)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPreco)
                    .addComponent(jLabelResp2))
                .addGap(2, 2, 2)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelResp1)
                    .addComponent(jLabelResp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldEsp)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonVoltar))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
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
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeFocusGained
        if(jTextFieldNome.getForeground().equals(new Color(139,137,137))) {
            jTextFieldNome.setForeground(new Color(41,41,41));
            jTextFieldNome.setText("");
        }
    }//GEN-LAST:event_jTextFieldNomeFocusGained

    private String formatarData() {
        String str = jTextFieldData.getText();
        return str.substring(6) + "-" + str.substring(3, 5) + "-" + str.substring(0, 2);
    }

    
    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            String nome = jTextFieldNome.getText();
            String data_nasc = formatarData();
            String tel = jTextFieldTel.getText();
            String esp = jTextFieldEsp.getText();
            String email = jTextFieldEmail.getText();
            String senha = jPasswordField.getText();
            if (!nome.equals("") && !jTextFieldNome.getForeground().equals(new Color(139, 137, 137))
                    && !data_nasc.equals("    -  -  ") && !jTextFieldData.getForeground().equals(new Color(139, 137, 137))
                    && !tel.equals("(  )      -    ") && !jTextFieldTel.getForeground().equals(new Color(139, 137, 137))
                    && !esp.equals("") && !jTextFieldEsp.getForeground().equals(new Color(139, 137, 137))
                    && !email.equals("") && !jTextFieldEmail.getForeground().equals(new Color(139, 137, 137))
                    && !senha.equals("") && !jPasswordField.getForeground().equals(new Color(139, 137, 137))) {
                ColaboradorController colabCtrl = new ColaboradorController();
                if(colabCtrl.insert(nome, tel, data_nasc, esp, email, senha) != 0)
                    voltar();
            } else {
                JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    private void jTextFieldEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusGained
        if (jTextFieldEmail.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldEmail.setForeground(new Color(41, 41, 41));
            jTextFieldEmail.setText("");
        }
    }//GEN-LAST:event_jTextFieldEmailFocusGained

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jTextFieldEspFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEspFocusGained
        if (jTextFieldEsp.getForeground().equals(new Color(139, 137, 137))) {
            jTextFieldEsp.setForeground(new Color(41, 41, 41));
            jTextFieldEsp.setText("");
        }
    }//GEN-LAST:event_jTextFieldEspFocusGained

    private void jTextFieldEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEspActionPerformed

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusGained
        if (jPasswordField.getForeground().equals(new Color(139, 137, 137))) {
            jPasswordField.setForeground(new Color(41, 41, 41));
            jPasswordField.setText("");
        }
    }//GEN-LAST:event_jPasswordFieldFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelResp;
    private javax.swing.JLabel jLabelResp1;
    private javax.swing.JLabel jLabelResp2;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelVSem;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JFormattedTextField jTextFieldData;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEsp;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JFormattedTextField jTextFieldTel;
    // End of variables declaration//GEN-END:variables
}
