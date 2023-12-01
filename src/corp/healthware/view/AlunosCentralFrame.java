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
                MostrarAlunoFrame aluno = new MostrarAlunoFrame();
                aluno.setSize(820, 570);
                aluno.setLocation(0, 0);
                removeAll();
                add(aluno, BorderLayout.CENTER);
                revalidate();
                repaint();
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
        jTextFieldPesquisa = new javax.swing.JTextField();
        jPanelIcone = new javax.swing.JPanel();
        jLabelPesquisa = new javax.swing.JLabel();

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

        jPanelIcone.setBackground(new java.awt.Color(239, 239, 239));

        jLabelPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar.png"))); // NOI18N

        javax.swing.GroupLayout jPanelIconeLayout = new javax.swing.GroupLayout(jPanelIcone);
        jPanelIcone.setLayout(jPanelIconeLayout);
        jPanelIconeLayout.setHorizontalGroup(
            jPanelIconeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
            .addGroup(jPanelIconeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIconeLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPesquisa)
                    .addContainerGap()))
        );
        jPanelIconeLayout.setVerticalGroup(
            jPanelIconeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
            .addGroup(jPanelIconeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIconeLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPesquisa)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanelIcone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelIcone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
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

    private void jTextFieldPesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaFocusGained
        jTextFieldPesquisa.setText("");
    }//GEN-LAST:event_jTextFieldPesquisaFocusGained

    private void jTextFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelPesquisa;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelIcone;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableAlunos;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
