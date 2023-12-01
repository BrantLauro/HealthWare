
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

public class NovoRegistroServicoFrame extends javax.swing.JPanel {

    public NovoRegistroServicoFrame() {
        UIManager.put( "Component.arrowType", "triangle" );
        UIManager.put( "ComboBox.selectionBackground", new Color(212,81,93));
        UIManager.put( "ComboBox.buttonBackground", new Color(212,81,93));
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jTextFieldNome.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldPreco.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        initComboBoxResp();
        
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
    
    private void initComboBoxResp() {
        try {
            ColaboradorController respCtrl = new ColaboradorController();
            ArrayList<Colaborador> resp = respCtrl.findAll();
            resp.forEach((Colaborador col) -> {

                jComboBoxResp.addItem(col.getNome_c());
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
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jLabelHora = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelData = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jTextFieldHora = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(820, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jPanel.setBackground(new java.awt.Color(223, 223, 223));
        jPanel.setPreferredSize(new java.awt.Dimension(773, 550));

        jLabelTitulo.setBackground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setText("Registro de Serviço");

        jLabelNome.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(41, 41, 41));
        jLabelNome.setText("Nome do Cliente");

        jTextFieldNome.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldNome.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldNome.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldNome.setText("Naninha");
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

        jLabelHora.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelHora.setForeground(new java.awt.Color(41, 41, 41));
        jLabelHora.setText("Hora");

        jTextFieldPreco.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldPreco.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldPreco.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldPreco.setText("30/11/2023");
        jTextFieldPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPrecoFocusGained(evt);
            }
        });
        jTextFieldPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecoActionPerformed(evt);
            }
        });

        jLabelData.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(41, 41, 41));
        jLabelData.setText("Data");

        jButtonVoltar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonVoltar.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonVoltar.setText("VOLTAR");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jTextFieldHora.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldHora.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldHora.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldHora.setText("16:00");
        jTextFieldHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldHoraFocusGained(evt);
            }
        });
        jTextFieldHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHoraActionPerformed(evt);
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
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldNome)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelData))
                        .addGap(30, 30, 30)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHora)
                            .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelTitulo)
                .addGap(155, 155, 155)
                .addComponent(jLabelNome)
                .addGap(2, 2, 2)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData)
                    .addComponent(jLabelHora))
                .addGap(2, 2, 2)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
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

    private void jTextFieldPrecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecoFocusGained
        if(jTextFieldPreco.getForeground().equals(new Color(139,137,137))) {
            jTextFieldPreco.setForeground(new Color(41,41,41));
            jTextFieldPreco.setText("");
        }
    }//GEN-LAST:event_jTextFieldPrecoFocusGained

    private void jTextFieldPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            String nome = jTextFieldNome.getText();
            int vezes_semana = Integer.parseInt(jComboBoxVSem.getSelectedItem().toString().substring(0, 1));
            double preco = Double.parseDouble(jTextFieldPreco.getText().replace(',', '.'));
            int resp = (int) jComboBoxResp.getSelectedIndex() + 1;
            if (!nome.equals("") && !jTextFieldNome.getForeground().equals(new Color(139, 137, 137))) {
                ModalidadeController modCtrl = new ModalidadeController();
                modCtrl.insert(resp, nome, vezes_semana, preco);
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

    private void jTextFieldHoraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldHoraFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHoraFocusGained

    private void jTextFieldHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables
}
