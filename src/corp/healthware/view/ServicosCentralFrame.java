package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.AlunoController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aluno;
import corp.healthware.view.cell.buttons.TableActionCellEditor;
import corp.healthware.view.cell.buttons.TableActionCellRender;
import corp.healthware.view.cell.buttons.TableActionEvent;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class AlunosCentralFrame extends javax.swing.JPanel {

    public AlunosCentralFrame() {
        initComponents();
        jTextFieldPesquisa.putClientProperty(FlatClientProperties.STYLE, "arc: 9");
        initTableAlunos();

    }

    private void initTableAlunos() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableAlunos.getModel();
            tableModel.setRowCount(0);
            AlunoController alunoCtrl = new AlunoController();
            ArrayList<Aluno> alunos = alunoCtrl.findAll();
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
            @Override
            public void onMais(int row) {
                System.out.println("Nova aula para " + row);
            }

            @Override
            public void onView(int row) {
                AlunoController alunoCtrl = new AlunoController();
                EditarAlunoFrame edAluno;
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
                AlunoController alunoCtrl = new AlunoController();
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
                if (jTableAlunos.isEditing()) {
                    jTableAlunos.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) jTableAlunos.getModel();
                model.removeRow(row);
            }
        };
        jTableAlunos.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        jTableAlunos.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableAlunos = new javax.swing.JTable();
        jButtonSalvar = new javax.swing.JButton();
        jButtonSalvar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(239, 239, 239));
        setPreferredSize(new java.awt.Dimension(797, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

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

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableAlunos.setFocusable(false);
        jTableAlunos.setGridColor(new java.awt.Color(239, 239, 239));
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
            jTableAlunos.getColumnModel().getColumn(3).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableAlunos.getColumnModel().getColumn(4).setResizable(false);
            jTableAlunos.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        jButtonSalvar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonSalvar.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonSalvar.setText("Servicos");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonSalvar1.setBackground(new java.awt.Color(212, 81, 93));
        jButtonSalvar1.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonSalvar1.setForeground(new java.awt.Color(239, 239, 239));
        jButtonSalvar1.setText("Colaboradores");
        jButtonSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jButtonSalvar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar1)
                    .addComponent(jButtonSalvar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 797, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1, 1, 1)))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSalvar1;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableAlunos;
    // End of variables declaration//GEN-END:variables
}
