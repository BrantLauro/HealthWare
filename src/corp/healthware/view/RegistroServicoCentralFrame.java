package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.AlunoController;
import corp.healthware.controller.ColaboradorController;
import corp.healthware.controller.ModalidadeController;
import corp.healthware.controller.RegistroServicoController;
import corp.healthware.controller.ServicoController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aluno;
import corp.healthware.model.entity.Colaborador;
import corp.healthware.model.entity.Modalidade;
import corp.healthware.model.entity.RegistroServico;
import corp.healthware.model.entity.Servico;
import corp.healthware.view.cell.buttons.TableActionCellEditor;
import corp.healthware.view.cell.buttons.TableActionCellEditorNoView;
import corp.healthware.view.cell.buttons.TableActionCellEditorNoViewNoMais;
import corp.healthware.view.cell.buttons.TableActionCellRender;
import corp.healthware.view.cell.buttons.TableActionCellRenderNoView;
import corp.healthware.view.cell.buttons.TableActionCellRenderNoViewNoMais;
import corp.healthware.view.cell.buttons.TableActionEvent;
import corp.healthware.view.cell.buttons.TableActionEventNoView;
import corp.healthware.view.cell.buttons.TableActionEventNoViewNoMais;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class RegistroServicoCentralFrame extends javax.swing.JPanel {
    

    public RegistroServicoCentralFrame(RegistroServico cod_rs) {
        
        initComponents();
        initTableRegistroServicos("");
        
    }

    private void initTableRegistroServicos(String pesquisa) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableRegistroServicos.getModel();
            tableModel.setRowCount(0);
            String[] columns = {"Cod.", "Data", "Horario", "Nome do Cliente", "Ação"};
            tableModel.setColumnIdentifiers(columns);
            jTableRegistroServicos.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableRegistroServicos.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTableRegistroServicos.getColumnModel().getColumn(4).setPreferredWidth(1);
            ArrayList<RegistroServico> reg;
            RegistroServicoController regCtrl = new RegistroServicoController();
            if(pesquisa.equals("")) reg = regCtrl.findAll();
            else reg = regCtrl.search(pesquisa);
            reg.forEach((RegistroServico r) -> {
                tableModel.addRow(new Object[]{r.getCod_rs(), r.getData(), r.getHora(), r.getNome_cliente()});
            });
            jTableRegistroServicos.setModel(tableModel);
        } catch (SQLException | DAOexception ex) {
            System.out.println("ERROR: " + ex);

        } catch (NumberFormatException ex) {
            System.out.println("ERROR: " + ex);
        }
        TableActionEventNoViewNoMais event = new TableActionEventNoViewNoMais() {

            @Override
            public void onEdit(int row) {
                RegistroServicoController regCtrl = new RegistroServicoController();
                EditarRegistroServicoFrame edRegistro;
                try {
                    edRegistro = new EditarRegistroServicoFrame(regCtrl.findOne((int) jTableRegistroServicos.getValueAt(row, 0)));
                    edRegistro.setSize(820, 570);
                    edRegistro.setLocation(0, 0);
                    removeAll();
                    add(edRegistro, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                } catch (DAOexception ex) {
                    Logger.getLogger(RegistroServicoCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(RegistroServicoCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Apagando ALuno");
                int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse aluno?\nIsso apagará todos os seus dados e suas aulas!", "Excluir Aluno", 0);
                if (resultado == JOptionPane.YES_OPTION) {
                    try {
                        if (jTableRegistroServicos.isEditing()) {
                            jTableRegistroServicos.getCellEditor().stopCellEditing();
                        }
                        DefaultTableModel model = (DefaultTableModel) jTableRegistroServicos.getModel();
                        ServicoController servicoCtrl = new ServicoController();
                        int cod_s = (int) model.getValueAt(row, 0);
                        servicoCtrl.delete(cod_s);
                        model.removeRow(row);
                    } catch (NumberFormatException ex) {
                        System.out.println("ERROR: " + ex);
                    } catch (DAOexception | SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                }

            }
        };
        jTableRegistroServicos.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRenderNoViewNoMais());
        jTableRegistroServicos.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditorNoViewNoMais(event));
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableRegistroServicos = new javax.swing.JTable();
        jButtonVoltar = new javax.swing.JButton();
        jButtonPesquisa = new javax.swing.JButton();

        setBackground(new java.awt.Color(239, 239, 239));
        setPreferredSize(new java.awt.Dimension(797, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jTextFieldPesquisa.setBackground(new java.awt.Color(223, 223, 223));
        jTextFieldPesquisa.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jTextFieldPesquisa.setForeground(new java.awt.Color(41, 41, 41));
        jTextFieldPesquisa.setText("Pesquisar");
        jTextFieldPesquisa.setToolTipText("");
        jTextFieldPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPesquisaFocusGained(evt);
            }
        });
        jTextFieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisaActionPerformed(evt);
            }
        });

        jScrollPaneTabela.setBackground(new java.awt.Color(223, 223, 223));
        jScrollPaneTabela.setToolTipText("");
        jScrollPaneTabela.setFocusable(false);

        jTableRegistroServicos.setBackground(new java.awt.Color(239, 239, 239));
        jTableRegistroServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Horário", "Nome do Cliente", "Ação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRegistroServicos.setRowHeight(40);
        jScrollPaneTabela.setViewportView(jTableRegistroServicos);
        if (jTableRegistroServicos.getColumnModel().getColumnCount() > 0) {
            jTableRegistroServicos.getColumnModel().getColumn(0).setResizable(false);
            jTableRegistroServicos.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableRegistroServicos.getColumnModel().getColumn(1).setResizable(false);
            jTableRegistroServicos.getColumnModel().getColumn(1).setPreferredWidth(1);
            jTableRegistroServicos.getColumnModel().getColumn(2).setResizable(false);
            jTableRegistroServicos.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTableRegistroServicos.getColumnModel().getColumn(3).setResizable(false);
            jTableRegistroServicos.getColumnModel().getColumn(3).setPreferredWidth(1);
            jTableRegistroServicos.getColumnModel().getColumn(4).setResizable(false);
            jTableRegistroServicos.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jButtonVoltar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonVoltar.setFont(new java.awt.Font("Rosario", 1, 18)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonPesquisa.setBackground(new java.awt.Color(223, 223, 223));
        jButtonPesquisa.setFont(new java.awt.Font("Rosario", 1, 20)); // NOI18N
        jButtonPesquisa.setForeground(new java.awt.Color(239, 239, 239));
        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar.png"))); // NOI18N
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPesquisa)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaFocusGained
        jTextFieldPesquisa.setText("");
    }//GEN-LAST:event_jTextFieldPesquisaFocusGained

    private void jTextFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisaActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        ServicoCentralFrame central = new ServicoCentralFrame();
        central.setSize(790, 570);
        central.setLocation(0, 0);
        removeAll();
        add(central, BorderLayout.CENTER);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        // TODO add your handling code here:
        String pesquisa = jTextFieldPesquisa.getText();
        initTableRegistroServicos(pesquisa);
    }//GEN-LAST:event_jButtonPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableRegistroServicos;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
