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
import javax.swing.table.DefaultTableModel;

public class ServicoCentralFrame extends javax.swing.JPanel {
    
    private boolean tServico = true;

    public ServicoCentralFrame() {
        initComponents();
        initTableServicos("");

    }

    private void initTableServicos(String pesquisa) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableServicos.getModel();
            tableModel.setRowCount(0);
            String[] columns = {"Cod.", "Serviço", "Data", "Horário", "Responsável"};
            tableModel.setColumnIdentifiers(columns);
            jTableServicos.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableServicos.getColumnModel().getColumn(3).setPreferredWidth(1);
            jTableServicos.getColumnModel().getColumn(4).setPreferredWidth(1);
            ArrayList<Servico> servicos;
            ServicoController servicoCtrl = new ServicoController();
            if(pesquisa.equals("")) servicos = servicoCtrl.findAll();
            else servicos = servicoCtrl.search(pesquisa);
            servicos.forEach((Servico s) -> {
                tableModel.addRow(new Object[]{s.getCod_s(), s.getNome_s(), s.getPreco(), s.getResp()});
            });
            jTableServicos.setModel(tableModel);
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
                ServicoController servicoCtrl = new ServicoController();
                EditarServicoFrame edServico;
                try {
                    MostrarServicoFrame servico = new MostrarServicoFrame(servicoCtrl.findOne((int) jTableServicos.getValueAt(row, 0)));
                    servico.setSize(820, 570);
                    servico.setLocation(0, 0);
                    removeAll();
                    add(servico, BorderLayout.CENTER);
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
                ServicoController servicoCtrl = new ServicoController();
                EditarServicoFrame edServico;
                try {
                    edServico = new EditarServicoFrame(servicoCtrl.findOne((int) jTableServicos.getValueAt(row, 0)));
                    edServico.setSize(820, 570);
                    edServico.setLocation(0, 0);
                    removeAll();
                    add(edServico, BorderLayout.CENTER);
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
                        if (jTableServicos.isEditing()) {
                            jTableServicos.getCellEditor().stopCellEditing();
                        }
                        DefaultTableModel model = (DefaultTableModel) jTableServicos.getModel();
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
        jTableServicos.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        jTableServicos.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }
    
    private void initTableColaboradores(String pesquisa) {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableServicos.getModel();
            tableModel.setRowCount(0);
            String[] columns = {"Cod. C", "Nome", "Especialidade", "Telefone", "Email"};
            tableModel.setColumnIdentifiers(columns);
            jTableServicos.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableServicos.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTableServicos.getColumnModel().getColumn(3).setPreferredWidth(1);
            ColaboradorController colabCtrl =  new ColaboradorController();
            ArrayList<Colaborador> colab;
            if(pesquisa.equals("")) colab = colabCtrl.findAll();
            else colab = colabCtrl.search(pesquisa);
            colab.forEach((Colaborador c) -> {
                tableModel.addRow(new Object[]{c.getCod_c(), c.getNome_c(), c.getEsp(),c.getTel_c(), c.getEmail()});
            });
            jTableServicos.setModel(tableModel);
        } catch (SQLException | DAOexception ex) {
            System.out.println("ERROR: " + ex);

        } catch (NumberFormatException ex) {
            System.out.println("ERROR: " + ex);
        }
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onMais(int row) {
                System.out.println("Nova aula para " + row);
            }

            @Override
            public void onView(int row) {
                ColaboradorController colabCtrl = new ColaboradorController();
                EditarColaboradorFrame edColab;
                try {
                    MostrarColaboradorFrame aluno = new MostrarAlunoFrame(colabCtrl.findOne((int) jTableServicos.getValueAt(row, 0)));
                    aluno.setSize(820, 570);
                    aluno.setLocation(0, 0);
                    removeAll();
                    add(aluno, BorderLayout.CENTER);
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
                AlunoController alunoCtrl = new AlunoController();
                EditarAlunoFrame edAluno;
                try {
                    edAluno = new EditarAlunoFrame(alunoCtrl.findOne((int) jTableServicos.getValueAt(row, 0)));
                    edAluno.setSize(820, 570);
                    edAluno.setLocation(0, 0);
                    removeAll();
                    add(edAluno, BorderLayout.CENTER);
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
                int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir essa Modalidade?", "Excluir Modalidade", 0);
                if (resultado == JOptionPane.YES_OPTION) {
                    try {
                        if (jTableServicos.isEditing()) {
                            jTableServicos.getCellEditor().stopCellEditing();
                        }
                        DefaultTableModel model = (DefaultTableModel) jTableServicos.getModel();
                        ModalidadeController modCtrl = new ModalidadeController();
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
        jTableServicos.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        jTableServicos.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabelPesquisa = new javax.swing.JLabel();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableServicos = new javax.swing.JTable();
        jButtonChange = new javax.swing.JButton();

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

        jTableServicos.setBackground(new java.awt.Color(223, 223, 223));
        jTableServicos.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTableServicos.setForeground(new java.awt.Color(41, 41, 41));
        jTableServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Serviço", "Data", "Horário", "Responsável"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableServicos.setFocusable(false);
        jTableServicos.setGridColor(new java.awt.Color(239, 239, 239));
        jTableServicos.setRowHeight(40);
        jTableServicos.setSelectionBackground(new java.awt.Color(239, 239, 239));
        jTableServicos.setSelectionForeground(new java.awt.Color(41, 41, 41));
        jTableServicos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableServicos.setShowGrid(false);
        jTableServicos.setShowHorizontalLines(true);
        jTableServicos.setShowVerticalLines(true);
        jTableServicos.getTableHeader().setResizingAllowed(false);
        jTableServicos.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTabela.setViewportView(jTableServicos);
        if (jTableServicos.getColumnModel().getColumnCount() > 0) {
            jTableServicos.getColumnModel().getColumn(0).setResizable(false);
            jTableServicos.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableServicos.getColumnModel().getColumn(1).setResizable(false);
            jTableServicos.getColumnModel().getColumn(2).setResizable(false);
            jTableServicos.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTableServicos.getColumnModel().getColumn(3).setResizable(false);
            jTableServicos.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTableServicos.getColumnModel().getColumn(4).setResizable(false);
            jTableServicos.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        jButtonChange.setBackground(new java.awt.Color(223, 223, 223));
        jButtonChange.setFont(new java.awt.Font("Rosario", 1, 20)); // NOI18N
        jButtonChange.setForeground(new java.awt.Color(239, 239, 239));
        jButtonChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/change.png"))); // NOI18N
        jButtonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonChange, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldPesquisa)
                        .addComponent(jLabelPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonChange, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
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
        if (tServico) {
            initTableServicos(pesquisa);
        } else {
            initTableColaboradores(pesquisa);
        }
    }//GEN-LAST:event_jLabelPesquisaMouseClicked

    private void jButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeActionPerformed
        // TODO add your handling code here:
        if(tServico) {
            initTableServicos("");
            tServico = false;
        } else {
            initTableColaboradores("");
            tServico = true;
        }
    }//GEN-LAST:event_jButtonChangeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChange;
    private javax.swing.JLabel jLabelPesquisa;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableServicos;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
