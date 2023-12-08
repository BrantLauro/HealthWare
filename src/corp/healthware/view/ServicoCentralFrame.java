package corp.healthware.view;

import corp.healthware.controller.RegistroServicoController;
import corp.healthware.controller.ServicoController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Servico;
import corp.healthware.view.cell.buttons.TableActionCellEditor;
import corp.healthware.view.cell.buttons.TableActionCellRender;
import corp.healthware.view.cell.buttons.TableActionEvent;
import java.awt.BorderLayout;
import java.sql.SQLException;
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
            String[] columns = {"Cod.", "Serviço", "Preço", "Responsável", "Ação"};
            tableModel.setColumnIdentifiers(columns);
            //jTableServicos.getColumnModel().getColumn(0).setPreferredWidth(1);
            //jTableServicos.getColumnModel().getColumn(2).setPreferredWidth(1);
            //jTableServicos.getColumnModel().getColumn(3).setPreferredWidth(1);
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
                int codigo = (int) jTableServicos.getValueAt(row, 0);
                NovoRegistroServicoFrame servico = new NovoRegistroServicoFrame(codigo);
                servico.setSize(820, 570);
                servico.setLocation(0, 0);
                removeAll();
                add(servico, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

            @Override
            public void onView(int row) {
                RegistroServicoController regCtrl = new RegistroServicoController();
                EditarRegistroServicoFrame edRegistro;
                try {
                    int codigo = (int) jTableServicos.getValueAt(row, 0);
                    RegistroServicoCentralFrame registro = new RegistroServicoCentralFrame(regCtrl.findAll(codigo));
                    //System.out.println(codigo);
                    registro.setSize(820, 570);
                    registro.setLocation(0, 0);
                    removeAll();
                    add(registro, BorderLayout.CENTER);
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
                System.out.println("Apagando Serviço");
                int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse Serviço?\nIsso apagará todos os seus dados!", "Excluir AColaborador", 0);
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
        jTableServicos.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        jTableServicos.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
    }
    
    /*private void initTableColaboradores(String pesquisa) {
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
                NovoServicoFrame tCMod = new NovoServicoFrame();
                tCMod.setSize(820, 570);
                tCMod.setLocation(0, 0);
                removeAll();
                add(tCMod, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

            @Override
            public void onView(int row) {
                ColaboradorController colabCtrl = new ColaboradorController();
                EditarColaboradorFrame edColab;
                try {
                    MostrarColaboradorFrame colab = new MostrarColaboradorFrame(colabCtrl.findOne((int) jTableServicos.getValueAt(row, 0)));
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
                    edColab = new EditarColaboradorFrame(colabCtrl.findOne((int) jTableServicos.getValueAt(row, 0)));
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
                int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse Colaborador?", "Excluir Colaborador", 0);
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
    }*/
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableServicos = new javax.swing.JTable();
        jButtonColaboradores = new javax.swing.JButton();
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

        jTableServicos.setBackground(new java.awt.Color(239, 239, 239));
        jTableServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Serviço", "Preço", "Responsável", "Ação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableServicos.setRowHeight(40);
        jScrollPaneTabela.setViewportView(jTableServicos);
        if (jTableServicos.getColumnModel().getColumnCount() > 0) {
            jTableServicos.getColumnModel().getColumn(0).setResizable(false);
            jTableServicos.getColumnModel().getColumn(1).setResizable(false);
            jTableServicos.getColumnModel().getColumn(2).setResizable(false);
            jTableServicos.getColumnModel().getColumn(2).setPreferredWidth(2);
            jTableServicos.getColumnModel().getColumn(3).setResizable(false);
            jTableServicos.getColumnModel().getColumn(3).setPreferredWidth(1);
            jTableServicos.getColumnModel().getColumn(4).setResizable(false);
        }

        jButtonColaboradores.setBackground(new java.awt.Color(212, 81, 93));
        jButtonColaboradores.setFont(new java.awt.Font("Rosario", 1, 18)); // NOI18N
        jButtonColaboradores.setForeground(new java.awt.Color(239, 239, 239));
        jButtonColaboradores.setText("Colaboradores");
        jButtonColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonColaboradoresActionPerformed(evt);
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
                    .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addComponent(jTextFieldPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonColaboradores)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPesquisa)
                    .addComponent(jButtonColaboradores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addComponent(jButtonPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void jButtonColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonColaboradoresActionPerformed
        // TODO add your handling code here:
        ColaboradoresCentralFrame central = new ColaboradoresCentralFrame();
        central.setSize(800, 570);
        central.setLocation(0, 0);
        removeAll();
        add(central, BorderLayout.CENTER);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonColaboradoresActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        // TODO add your handling code here:
        String pesquisa = jTextFieldPesquisa.getText();
        initTableServicos(pesquisa);
    }//GEN-LAST:event_jButtonPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonColaboradores;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableServicos;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
