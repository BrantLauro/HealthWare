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

public class EditarServicoFrame extends javax.swing.JPanel {

    private int cod_s;

    public EditarServicoFrame(Servico s) {
        UIManager.put("Component.arrowType", "triangle");
        UIManager.put("ComboBox.selectionBackground", new Color(212, 81, 93));
        UIManager.put("ComboBox.buttonBackground", new Color(212, 81, 93));
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jTextFieldServico.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        jTextFieldPreco.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        initComboBoxResp();
        cod_s = s.getCod_s();
        jLabelTitulo.setText(s.getNome_s());
        jTextFieldServico.setText(s.getNome_s());
        //jTextFieldPreco.setText(s.getPreco());

    }

    private void initComboBoxResp() {
        try {
            ColaboradorController colaboradorCtrl = new ColaboradorController();
            ArrayList<Colaborador> colab = colaboradorCtrl.findAll();
            colab.forEach((Colaborador col) -> {
                jComboBoxResp.addItem(col.getNome_c());
            });
        } catch (SQLException | DAOexception ex) {
            Logger.getLogger(NovoColaboradorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabelNome = new javax.swing.JLabel();
        jTextFieldServico = new javax.swing.JTextField();
        jComboBoxResp = new javax.swing.JComboBox<>();
        jLabelResp = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelPreco = new javax.swing.JLabel();

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldServico)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNome)
                                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPreco))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxResp, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelResp))))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addGap(335, 335, 335))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(171, 171, 171)
                .addComponent(jLabelNome)
                .addGap(2, 2, 2)
                .addComponent(jTextFieldServico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPreco)
                    .addComponent(jLabelResp))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxResp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(216, Short.MAX_VALUE))
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
            String nome_s = jTextFieldServico.getText();
            double preco = Double.parseDouble(jTextFieldPreco.getText().replace(',', '.'));
            int resp = (int) jComboBoxResp.getSelectedIndex() + 1;
            if (!nome_s.equals("")) {
                ServicoController servicoCtrl = new ServicoController();
                if (servicoCtrl.update(nome_s,preco,resp) != 0) {
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

    private void jComboBoxRespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRespActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRespActionPerformed

    private void jTextFieldPrecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecoFocusGained
        if(jTextFieldPreco.getForeground().equals(new Color(139,137,137))) {
            jTextFieldPreco.setForeground(new Color(41,41,41));
            jTextFieldPreco.setText("");
        }
    }//GEN-LAST:event_jTextFieldPrecoFocusGained

    private void jTextFieldPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecoActionPerformed

    private void jTextFieldServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldServicoActionPerformed

    private void jTextFieldServicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldServicoFocusGained

        if(jTextFieldServico.getForeground().equals(new Color(139,137,137))) {
            jTextFieldServico.setForeground(new Color(41,41,41));
            jTextFieldServico.setText("");
        }
    }//GEN-LAST:event_jTextFieldServicoFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxResp;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelResp;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldServico;
    // End of variables declaration//GEN-END:variables
}