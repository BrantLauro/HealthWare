
package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;

public class EditarModFrame extends javax.swing.JPanel {

    public EditarModFrame() {
        UIManager.put( "Component.arrowType", "triangle" );
        UIManager.put( "ComboBox.selectionBackground", new Color(212,81,93));
        UIManager.put( "ComboBox.buttonBackground", new Color(212,81,93));
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jTextFieldPreco.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalvar1 = new javax.swing.JButton();
        jPanelCentral = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jComboBoxResp = new javax.swing.JComboBox<>();
        jLabelResp = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelPreco = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();

        jButtonSalvar1.setBackground(new java.awt.Color(212, 81, 93));
        jButtonSalvar1.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonSalvar1.setForeground(new java.awt.Color(239, 239, 239));
        jButtonSalvar1.setText("VOLTAR");
        jButtonSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvar1ActionPerformed(evt);
            }
        });

        setPreferredSize(new java.awt.Dimension(820, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jPanel.setBackground(new java.awt.Color(223, 223, 223));
        jPanel.setPreferredSize(new java.awt.Dimension(773, 550));

        jLabelTitulo.setBackground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setText("Editar");

        jButtonSalvar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonSalvar.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonSalvar.setText("SALVAR");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jComboBoxResp.setBackground(new java.awt.Color(239, 239, 239));
        jComboBoxResp.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jComboBoxResp.setForeground(new java.awt.Color(41, 41, 41));
        jComboBoxResp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cecília Brant", "Clever" }));
        jComboBoxResp.setPreferredSize(new java.awt.Dimension(68, 26));

        jLabelResp.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelResp.setForeground(new java.awt.Color(41, 41, 41));
        jLabelResp.setText("Responsável");

        jTextFieldPreco.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldPreco.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldPreco.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldPreco.setText("160.00");
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

        jLabelPreco.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelPreco.setForeground(new java.awt.Color(41, 41, 41));
        jLabelPreco.setText("Preço R$");

        jButtonVoltar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonVoltar.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonVoltar.setText("VOLTAR");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPreco))
                        .addGap(30, 30, 30)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxResp, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelResp))
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelTitulo)
                .addGap(193, 193, 193)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPreco)
                    .addComponent(jLabelResp))
                .addGap(2, 2, 2)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxResp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
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
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
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

    private void jTextFieldPrecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecoFocusGained

    private void jTextFieldPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        /*MainFrame main = new MainFrame();
        main.setSize(1000, 570);
        main.setLocation(0, 0);
        jPanelContent.removeAll();
        jPanelContent.add(main, BorderLayout.CENTER);
        jPanelContent.revalidate();
        jPanelContent.repaint();*/
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvar1ActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        AlunosCentralFrame central = new AlunosCentralFrame();
        central.setSize(820, 570);
        central.setLocation(0, 0);
        removeAll();
        add(central, BorderLayout.CENTER);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSalvar1;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxResp;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelResp;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables
}
