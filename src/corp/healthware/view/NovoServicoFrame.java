
package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.AlunoController;
import corp.healthware.controller.ColaboradorController;
import corp.healthware.controller.ModalidadeController;
import corp.healthware.controller.ServicoController;
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

public class NovoServicoFrame extends javax.swing.JPanel {

    public NovoServicoFrame() {
        UIManager.put( "Component.arrowType", "triangle" );
        UIManager.put( "ComboBox.selectionBackground", new Color(212,81,93));
        UIManager.put( "ComboBox.buttonBackground", new Color(212,81,93));
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jTextFieldServico.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldPreco.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        initComboBoxResp();
        
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
        jTextFieldServico = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jComboBoxResp = new javax.swing.JComboBox<>();
        jLabelResp = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelPreco = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(820, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jPanel.setBackground(new java.awt.Color(223, 223, 223));
        jPanel.setPreferredSize(new java.awt.Dimension(773, 550));

        jLabelTitulo.setBackground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setText("Cadastro de Serviço");

        jLabelNome.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(41, 41, 41));
        jLabelNome.setText("Nome do Serviço");

        jTextFieldServico.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldServico.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldServico.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldServico.setText("Pilates");
        jTextFieldServico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldServicoFocusGained(evt);
            }
        });
        jTextFieldServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldServicoActionPerformed(evt);
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

        jComboBoxResp.setBackground(new java.awt.Color(239, 239, 239));
        jComboBoxResp.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jComboBoxResp.setForeground(new java.awt.Color(41, 41, 41));
        jComboBoxResp.setPreferredSize(new java.awt.Dimension(68, 26));
        jComboBoxResp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRespActionPerformed(evt);
            }
        });

        jLabelResp.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelResp.setForeground(new java.awt.Color(41, 41, 41));
        jLabelResp.setText("Responsável");

        jTextFieldPreco.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldPreco.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldPreco.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldPreco.setText("160,00");
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
                .addGap(225, 225, 225)
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldServico)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPreco))
                        .addGap(30, 30, 30)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxResp, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelResp))))
                .addGap(48, 48, 48))
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelTitulo)
                .addGap(158, 158, 158)
                .addComponent(jLabelNome)
                .addGap(2, 2, 2)
                .addComponent(jTextFieldServico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPreco)
                    .addComponent(jLabelResp))
                .addGap(2, 2, 2)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxResp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jTextFieldServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldServicoActionPerformed

    private void jTextFieldServicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldServicoFocusGained
        
        if(jTextFieldServico.getForeground().equals(new Color(139,137,137))) {
            jTextFieldServico.setForeground(new Color(41,41,41));
            jTextFieldServico.setText("");
        }
    }//GEN-LAST:event_jTextFieldServicoFocusGained

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
            String nome = jTextFieldServico.getText();
            double preco = Double.parseDouble(jTextFieldPreco.getText().replace(',', '.'));
            int resp = (int) jComboBoxResp.getSelectedIndex() + 1;
            if (!nome.equals("") && !jTextFieldServico.getForeground().equals(new Color(139, 137, 137))) {
                ServicoController servicoCtrl = new ServicoController();
                servicoCtrl.insert(nome, preco, resp);
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

    private void jComboBoxRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRespActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxResp;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelResp;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldServico;
    // End of variables declaration//GEN-END:variables
}
