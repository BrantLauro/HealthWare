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
import corp.healthware.view.cell.buttons.TableActionCellEditor;
import corp.healthware.view.cell.buttons.TableActionCellRender;
import corp.healthware.view.cell.buttons.TableActionEvent;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ColaboradoresCentralFrame extends javax.swing.JPanel {
    

    public ColaboradoresCentralFrame() {
        initComponents();
        initTableColaborador("");
    }

    private void initTableColaborador(String pesquisa) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableColaborador.getModel();
            tableModel.setRowCount(0);
            String[] columns = {"Cod.", "Nome", "Telefone", "Email", "Especialidade", "Ação"};
            tableModel.setColumnIdentifiers(columns);
            jTableColaborador.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableColaborador.getColumnModel().getColumn(2).setPreferredWidth(1);
            jTableColaborador.getColumnModel().getColumn(5).setPreferredWidth(1);
            ArrayList<Colaborador> colab;
            ColaboradorController colabCtrl = new ColaboradorController();
            if(pesquisa.equals("")) colab = colabCtrl.findAll();
            else colab = colabCtrl.search(pesquisa);
            colab.forEach((Colaborador c) -> {
                tableModel.addRow(new Object[]{c.getCod_c(), c.getNome_c(), c.getTel_c(), c.getEmail(), c.getEsp()});
            });
            jTableColaborador.setModel(tableModel);
        } catch (SQLException | DAOexception ex) {
            System.out.println("ERROR: " + ex);

        } catch (NumberFormatException ex) {
            System.out.println("ERROR: " + ex);
        }
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onMais(int row) {
                System.out.println("Novo  para " + row);
            }

            @Override
            public void onView(int row) {
                ColaboradorController colabCtrl = new ColaboradorController();
                EditarColaboradorFrame edColab;
                try {
                    MostrarColaboradorFrame colab = new MostrarColaboradorFrame(colabCtrl.findOne((int) jTableColaborador.getValueAt(row, 0)));
                    colab.setSize(820, 570);
                    colab.setLocation(0, 0);
                    removeAll();
                    add(colab, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                } catch (DAOexception ex) {
                    Logger.getLogger(ServicoCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ServicoCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onEdit(int row) {
                ColaboradorController colabCtrl = new ColaboradorController();
                EditarColaboradorFrame edColab;
                try {
                    edColab = new EditarColaboradorFrame(colabCtrl.findOne((int) jTableColaborador.getValueAt(row, 0)));
                    edColab.setSize(820, 570);
                    edColab.setLocation(0, 0);
                    removeAll();
                    add(edColab, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                } catch (DAOexception ex) {
                    Logger.getLogger(ServicoCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ServicoCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onDelete(int row) {
                System.out.println("Apagando Colaborador");
                int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse colaborador?\nIsso apagará todos os seus dados e suas aulas!", "Excluir Aluno", 0);
                if (resultado == JOptionPane.YES_OPTION) {
                    try {
                        if (jTableColaborador.isEditing()) {
                            jTableColaborador.getCellEditor().stopCellEditing();
                        }
                        DefaultTableModel model = (DefaultTableModel) jTableColaborador.getModel();
                        ColaboradorController colabCtrl = new ColaboradorController();
                        int cod_c = (int) model.getValueAt(row, 0);
                        colabCtrl.delete(cod_c);
                        model.removeRow(row);
                    } catch (NumberFormatException ex) {
                        System.out.println("ERROR: " + ex);
                    } catch (DAOexception | SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                }

            }
        };
        jTableColaborador.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        jTableColaborador.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableColaborador = new javax.swing.JTable();
        jButtonRegistros = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabelPesquisa = new javax.swing.JLabel();

        setBackground(new java.awt.Color(239, 239, 239));
        setPreferredSize(new java.awt.Dimension(797, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jScrollPaneTabela.setBackground(new java.awt.Color(223, 223, 223));
        jScrollPaneTabela.setToolTipText("");
        jScrollPaneTabela.setFocusable(false);

        jTableColaborador.setBackground(new java.awt.Color(239, 239, 239));
        jTableColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Telefone", "Email", "Especialidade", "Ação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneTabela.setViewportView(jTableColaborador);
        if (jTableColaborador.getColumnModel().getColumnCount() > 0) {
            jTableColaborador.getColumnModel().getColumn(0).setResizable(false);
            jTableColaborador.getColumnModel().getColumn(1).setResizable(false);
            jTableColaborador.getColumnModel().getColumn(2).setResizable(false);
            jTableColaborador.getColumnModel().getColumn(3).setResizable(false);
            jTableColaborador.getColumnModel().getColumn(4).setResizable(false);
            jTableColaborador.getColumnModel().getColumn(5).setResizable(false);
        }

        jButtonRegistros.setBackground(new java.awt.Color(212, 81, 93));
        jButtonRegistros.setFont(new java.awt.Font("Rosario", 1, 18)); // NOI18N
        jButtonRegistros.setForeground(new java.awt.Color(239, 239, 239));
        jButtonRegistros.setText("Voltar");
        jButtonRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrosActionPerformed(evt);
            }
        });

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

        jLabelPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar.png"))); // NOI18N
        jLabelPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPesquisaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addComponent(jTextFieldPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPesquisa)
                    .addComponent(jLabelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButtonRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
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

    private void jLabelPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisaMouseClicked
        String pesquisa = jTextFieldPesquisa.getText();
            initTableColaborador(pesquisa);
    }//GEN-LAST:event_jLabelPesquisaMouseClicked

    private void jButtonRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrosActionPerformed
        // TODO add your handling code here:
        ServicoCentralFrame central = new ServicoCentralFrame();
        central.setSize(800, 570);
        central.setLocation(0, 0);
        removeAll();
        add(central, BorderLayout.CENTER);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonRegistrosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistros;
    private javax.swing.JLabel jLabelPesquisa;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableColaborador;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
