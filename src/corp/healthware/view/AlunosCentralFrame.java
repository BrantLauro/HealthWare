package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.AlunoController;
import corp.healthware.controller.ModalidadeController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aluno;
import corp.healthware.model.entity.Modalidade;
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

public class AlunosCentralFrame extends javax.swing.JPanel {

    private boolean tAluno = true;

    public AlunosCentralFrame() {
        initComponents();
        jTextFieldPesquisa.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        initTableAlunos("");

    }

    private void initTableAlunos(String pesquisa) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableAlunos.getModel();
            tableModel.setRowCount(0);
            String[] columns = {"Cod.", "Nome", "Modalidade", "Status", "Vencimento", "Ação"};
            tableModel.setColumnIdentifiers(columns);
            jTableAlunos.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableAlunos.getColumnModel().getColumn(3).setPreferredWidth(1);
            jTableAlunos.getColumnModel().getColumn(4).setPreferredWidth(1);
            ArrayList<Aluno> alunos;
            AlunoController alunoCtrl = new AlunoController();
            if (pesquisa.equals("")) {
                alunos = alunoCtrl.findAll();
            } else {
                alunos = alunoCtrl.search(pesquisa);
            }
            alunos.forEach((Aluno a) -> {
                tableModel.addRow(new Object[]{a.getCod_a(), a.getNome_a(), a.getNomeModalidade(), a.getStatusNome(), "Dia " + a.getDia_pag()});
            });
            jTableAlunos.setModel(tableModel);
        } catch (SQLException | DAOexception ex) {
            System.out.println("ERROR: " + ex);

        } catch (NumberFormatException ex) {
            System.out.println("ERROR: " + ex);
        }
        TableActionEvent event = new TableActionEvent() {
            AlunoController alunoCtrl = new AlunoController();

            @Override
            public void onMais(int row) {
                NovaAulaFrame aula = new NovaAulaFrame((int) jTableAlunos.getValueAt(row, 0));
                aula.setSize(820, 570);
                aula.setLocation(0, 0);
                removeAll();
                add(aula, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

            @Override
            public void onView(int row) {
                try {
                    MostrarAlunoFrame aluno = new MostrarAlunoFrame(alunoCtrl.findOne((int) jTableAlunos.getValueAt(row, 0)));
                    aluno.setSize(820, 570);
                    aluno.setLocation(0, 0);
                    removeAll();
                    add(aluno, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                } catch (DAOexception ex) {
                    Logger.getLogger(AlunosCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AlunosCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onEdit(int row) {
                EditarAlunoFrame edAluno;
                try {
                    edAluno = new EditarAlunoFrame(alunoCtrl.findOne((int) jTableAlunos.getValueAt(row, 0)));
                    edAluno.setSize(820, 570);
                    edAluno.setLocation(0, 0);
                    removeAll();
                    add(edAluno, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                } catch (DAOexception ex) {
                    Logger.getLogger(AlunosCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AlunosCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onDelete(int row) {
                int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse aluno?\nIsso apagará todos os seus dados e suas aulas!", "Excluir Aluno", 0);
                if (resultado == JOptionPane.YES_OPTION) {
                    try {
                        if (jTableAlunos.isEditing()) {
                            jTableAlunos.getCellEditor().stopCellEditing();
                        }
                        DefaultTableModel model = (DefaultTableModel) jTableAlunos.getModel();
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
        jTableAlunos.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        jTableAlunos.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }

    private void initTableModalidade(String pesquisa) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableAlunos.getModel();
            tableModel.setRowCount(0);
            String[] columns = {"Cod.", "Nome", "Vezes na Semana", "Preço", "Responsável", "Ação"};
            tableModel.setColumnIdentifiers(columns);
            jTableAlunos.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableAlunos.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTableAlunos.getColumnModel().getColumn(3).setPreferredWidth(1);
            ModalidadeController modalidadeCtrl = new ModalidadeController();
            ArrayList<Modalidade> mods;
            if (pesquisa.equals("")) {
                mods = modalidadeCtrl.findAll();
            } else {
                mods = modalidadeCtrl.search(pesquisa);
            }
            mods.forEach((Modalidade m) -> {
                tableModel.addRow(new Object[]{m.getCod_m(), m.getNome_m(), m.getVezes_semana() + " Vezes", NumberFormat.getCurrencyInstance().format(m.getPreco()), m.getNomeResp()});
            });
            jTableAlunos.setModel(tableModel);
        } catch (SQLException | DAOexception ex) {
            System.out.println("ERROR: " + ex);

        } catch (NumberFormatException ex) {
            System.out.println("ERROR: " + ex);
        }
        TableActionEventNoView event = new TableActionEventNoView() {
            ModalidadeController modCtrl = new ModalidadeController();
            @Override
            public void onMais(int row) {
                NovoAlunoFrame tCAluno = new NovoAlunoFrame();

                tCAluno.setSize(820, 570);
                tCAluno.setLocation(0, 0);
                removeAll();
                add(tCAluno, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

            @Override
            public void onEdit(int row) {
                EditarModFrame edMod;
                try {
                    edMod = new EditarModFrame(modCtrl.findOne((int) jTableAlunos.getValueAt(row, 0)));
                    edMod.setSize(820, 570);
                    edMod.setLocation(0, 0);
                    removeAll();
                    add(edMod, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                } catch (DAOexception ex) {
                    Logger.getLogger(AlunosCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AlunosCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onDelete(int row) {
                int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir essa Modalidade?", "Excluir Modalidade", 0);
                if (resultado == JOptionPane.YES_OPTION) {
                    try {
                        if (jTableAlunos.isEditing()) {
                            jTableAlunos.getCellEditor().stopCellEditing();
                        }
                        DefaultTableModel model = (DefaultTableModel) jTableAlunos.getModel();
                        int cod_m = (int) model.getValueAt(row, 0);
                        modCtrl.delete(cod_m);
                        model.removeRow(row);
                    } catch (NumberFormatException ex) {
                        System.out.println("ERROR: " + ex);
                    } catch (DAOexception | SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                }

            }
        };
        jTableAlunos.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderNoView());
        jTableAlunos.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorNoView(event));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jButtonChange = new javax.swing.JButton();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableAlunos = new javax.swing.JTable();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonPesquisa = new javax.swing.JButton();

        setBackground(new java.awt.Color(239, 239, 239));
        setPreferredSize(new java.awt.Dimension(797, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jButtonChange.setBackground(new java.awt.Color(223, 223, 223));
        jButtonChange.setFont(new java.awt.Font("Rosario", 1, 20)); // NOI18N
        jButtonChange.setForeground(new java.awt.Color(239, 239, 239));
        jButtonChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change.png"))); // NOI18N
        jButtonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeActionPerformed(evt);
            }
        });

        jScrollPaneTabela.setBackground(new java.awt.Color(223, 223, 223));
        jScrollPaneTabela.setToolTipText("");
        jScrollPaneTabela.setFocusable(false);

        jTableAlunos.setBackground(new java.awt.Color(223, 223, 223));
        jTableAlunos.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTableAlunos.setForeground(new java.awt.Color(41, 41, 41));
        jTableAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Nome", "Modalidade", "Status", "Vencimento", "Ação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAlunos.setFocusable(false);
        jTableAlunos.setGridColor(new java.awt.Color(41, 41, 41));
        jTableAlunos.setRowHeight(40);
        jTableAlunos.setSelectionBackground(new java.awt.Color(239, 239, 239));
        jTableAlunos.setSelectionForeground(new java.awt.Color(41, 41, 41));
        jTableAlunos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableAlunos.setShowGrid(false);
        jTableAlunos.getTableHeader().setResizingAllowed(false);
        jTableAlunos.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTabela.setViewportView(jTableAlunos);
        if (jTableAlunos.getColumnModel().getColumnCount() > 0) {
            jTableAlunos.getColumnModel().getColumn(0).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableAlunos.getColumnModel().getColumn(1).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(2).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(3).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableAlunos.getColumnModel().getColumn(4).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTableAlunos.getColumnModel().getColumn(5).setResizable(false);
        }

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
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonChange, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonChange, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPesquisa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(10, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1, 1, 1)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaFocusGained
        jTextFieldPesquisa.setText("");
    }//GEN-LAST:event_jTextFieldPesquisaFocusGained

    private void jTextFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisaActionPerformed

    private void jButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeActionPerformed
        if (tAluno) {
            initTableModalidade("");
            tAluno = false;
        } else {
            initTableAlunos("");
            tAluno = true;
        }
    }//GEN-LAST:event_jButtonChangeActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        String pesquisa = jTextFieldPesquisa.getText();
        if (tAluno) {
            initTableAlunos(pesquisa);
        } else {
            initTableModalidade(pesquisa);
        }
    }//GEN-LAST:event_jButtonPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChange;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableAlunos;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
