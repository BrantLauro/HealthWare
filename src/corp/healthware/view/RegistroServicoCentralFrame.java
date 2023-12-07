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
import corp.healthware.view.cell.buttons.TableActionCellEditorNoView;
import corp.healthware.view.cell.buttons.TableActionCellRender;
import corp.healthware.view.cell.buttons.TableActionCellRenderNoView;
import corp.healthware.view.cell.buttons.TableActionEvent;
import corp.healthware.view.cell.buttons.TableActionEventNoView;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroServicoCentralFrame extends javax.swing.JPanel {
    
    private boolean tServico = true;

    public RegistroServicoCentralFrame() {
        initComponents();
        //initTableServicos("");

    }

    private void initTableRegistros() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableRegistros.getModel();
            tableModel.setRowCount(0);
            ArrayList<Colaborador> colabs;
            ColaboradorController colabCtrl = new ColaboradorController();
            colabs = colabCtrl.findAll();
            colabs.forEach((Colaborador c) -> {
                tableModel.addRow(new Object[]{c.getCod_c(), c.getNome_c(), c.getData_nasc_c(), c.getTel_c(), c.getEsp()});
            });
            jTableRegistros.setModel(tableModel);
        } catch (SQLException | DAOexception ex) {
            System.out.println("ERROR: " + ex);

        } catch (NumberFormatException ex) {
            System.out.println("ERROR: " + ex);
        }
        TableActionEventNoView event = new TableActionEventNoView() {
            @Override
            public void onMais(int row) {
                System.out.println("Nova aula para " + row);
            }

            @Override
            public void onEdit(int row) {
                ColaboradorController colabCtrl = new ColaboradorController();
                EditarColaboradorFrame edColab;
                try {
                    edColab = new EditarColaboradorFrame(colabCtrl.findOne((int) jTableRegistros.getValueAt(row, 0)));
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
                System.out.println("Apagando ALuno");
                int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse aluno?\nIsso apagará todos os seus dados e suas aulas!", "Excluir Aluno", 0);
                if (resultado == JOptionPane.YES_OPTION) {
                    try {
                        if (jTableRegistros.isEditing()) {
                            jTableRegistros.getCellEditor().stopCellEditing();
                        }
                        DefaultTableModel model = (DefaultTableModel) jTableRegistros.getModel();
                        AlunoController alunoCtrl = new AlunoController();
                        int cod_a = (int) model.getValueAt(row, 0);
                        alunoCtrl.delete(cod_a);
                        model.removeRow(row);
                    } catch (NumberFormatException ex) {
                        System.out.println("ERROR: " + ex);
                    } catch (DAOexception | SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                }

            }
        };
        jTableRegistros.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderNoView());
        jTableRegistros.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorNoView(event));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabelPesquisa = new javax.swing.JLabel();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableRegistros = new javax.swing.JTable();

        setBackground(new java.awt.Color(239, 239, 239));
        setPreferredSize(new java.awt.Dimension(797, 570));

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

        jScrollPaneTabela.setBackground(new java.awt.Color(223, 223, 223));
        jScrollPaneTabela.setToolTipText("");
        jScrollPaneTabela.setFocusable(false);

        jTableRegistros.setBackground(new java.awt.Color(223, 223, 223));
        jTableRegistros.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTableRegistros.setForeground(new java.awt.Color(41, 41, 41));
        jTableRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Data", "Horário", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRegistros.setFocusable(false);
        jTableRegistros.setGridColor(new java.awt.Color(239, 239, 239));
        jTableRegistros.setRowHeight(40);
        jTableRegistros.setSelectionBackground(new java.awt.Color(239, 239, 239));
        jTableRegistros.setSelectionForeground(new java.awt.Color(41, 41, 41));
        jTableRegistros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableRegistros.setShowGrid(false);
        jTableRegistros.setShowHorizontalLines(true);
        jTableRegistros.setShowVerticalLines(true);
        jTableRegistros.getTableHeader().setResizingAllowed(false);
        jTableRegistros.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTabela.setViewportView(jTableRegistros);
        if (jTableRegistros.getColumnModel().getColumnCount() > 0) {
            jTableRegistros.getColumnModel().getColumn(0).setResizable(false);
            jTableRegistros.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTableRegistros.getColumnModel().getColumn(1).setResizable(false);
            jTableRegistros.getColumnModel().getColumn(1).setPreferredWidth(15);
            jTableRegistros.getColumnModel().getColumn(2).setResizable(false);
            jTableRegistros.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTableRegistros.getColumnModel().getColumn(3).setResizable(false);
            jTableRegistros.getColumnModel().getColumn(3).setPreferredWidth(40);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPesquisa)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPesquisa)
                    .addComponent(jLabelPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
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
        //initTableColaboradores(pesquisa);

    }//GEN-LAST:event_jLabelPesquisaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelPesquisa;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableRegistros;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
