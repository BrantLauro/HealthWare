package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.AlunoController;
import corp.healthware.controller.ColaboradorController;
import corp.healthware.controller.ModalidadeController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aluno;
import corp.healthware.model.entity.Colaborador;
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

public class ColabCentralFrame extends javax.swing.JPanel {

    public ColabCentralFrame() {
        initComponents();
        initTableColab();

    }

    private void initTableColab() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableColab.getModel();
            tableModel.setRowCount(0);
            ArrayList<Colaborador> colabs;
            ColaboradorController colabCtrl = new ColaboradorController();
            colabs = colabCtrl.findAll();
            colabs.forEach((Colaborador c) -> {
                tableModel.addRow(new Object[]{c.getCod_c(), c.getNome_c(), formatarDataShow(c.getData_nasc_c()), c.getTel_c(), c.getEsp()});
            });
            jTableColab.setModel(tableModel);
        } catch (SQLException | DAOexception ex) {
            System.out.println("ERROR: " + ex);

        } catch (NumberFormatException ex) {
            System.out.println("ERROR: " + ex);
        }
        TableActionEventNoView event = new TableActionEventNoView() {
            @Override
            public void onMais(int row) {
                NovaModFrame tCMod = new NovaModFrame();
                tCMod.setSize(820, 570);
                tCMod.setLocation(0, 0);
                removeAll();
                add(tCMod, BorderLayout.CENTER);
                revalidate();
                repaint();
            }

            @Override
            public void onEdit(int row) {
                ColaboradorController colabCtrl = new ColaboradorController();
                EditarColabFrame edColab;
                try {
                    edColab = new EditarColabFrame(colabCtrl.findOne((int) jTableColab.getValueAt(row, 0)));
                    edColab.setSize(820, 570);
                    edColab.setLocation(0, 0);
                    removeAll();
                    add(edColab, BorderLayout.CENTER);
                    revalidate();
                    repaint();
                } catch (DAOexception ex) {
                    Logger.getLogger(ColabCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ColabCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onDelete(int row) {
                int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse Colaborador?\nTodas as modalidades ministradas por esse colaborador ficarão sem responsável!", "Excluir Colaborador", 0);
                if (resultado == JOptionPane.YES_OPTION) {
                    try {
                        if (jTableColab.isEditing()) {
                            jTableColab.getCellEditor().stopCellEditing();
                        }
                        DefaultTableModel model = (DefaultTableModel) jTableColab.getModel();
                        ColaboradorController colabCtrl = new ColaboradorController();
                        int cod_c = (int) model.getValueAt(row, 0);
                        if(colabCtrl.delete(cod_c) != 0)
                            model.removeRow(row);
                    } catch (NumberFormatException ex) {
                        System.out.println("ERROR: " + ex);
                    } catch (DAOexception | SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                }

            }
        };
        jTableColab.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderNoView());
        jTableColab.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorNoView(event));
    }

    private String formatarDataShow(String data) {
        return data.substring(8) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableColab = new javax.swing.JTable();

        setBackground(new java.awt.Color(239, 239, 239));
        setPreferredSize(new java.awt.Dimension(797, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jScrollPaneTabela.setBackground(new java.awt.Color(223, 223, 223));
        jScrollPaneTabela.setToolTipText("");
        jScrollPaneTabela.setFocusable(false);

        jTableColab.setBackground(new java.awt.Color(223, 223, 223));
        jTableColab.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTableColab.setForeground(new java.awt.Color(41, 41, 41));
        jTableColab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Nome", "Nascimento", "Telefone", "Especial.", "Ação"
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
        jTableColab.setFocusable(false);
        jTableColab.setGridColor(new java.awt.Color(239, 239, 239));
        jTableColab.setRowHeight(40);
        jTableColab.setSelectionBackground(new java.awt.Color(239, 239, 239));
        jTableColab.setSelectionForeground(new java.awt.Color(41, 41, 41));
        jTableColab.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableColab.setShowGrid(false);
        jTableColab.getTableHeader().setResizingAllowed(false);
        jTableColab.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTabela.setViewportView(jTableColab);
        if (jTableColab.getColumnModel().getColumnCount() > 0) {
            jTableColab.getColumnModel().getColumn(0).setResizable(false);
            jTableColab.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableColab.getColumnModel().getColumn(1).setResizable(false);
            jTableColab.getColumnModel().getColumn(2).setResizable(false);
            jTableColab.getColumnModel().getColumn(3).setResizable(false);
            jTableColab.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableColab.getColumnModel().getColumn(4).setResizable(false);
            jTableColab.getColumnModel().getColumn(4).setPreferredWidth(10);
            jTableColab.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
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
                    .addContainerGap(24, Short.MAX_VALUE)))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableColab;
    // End of variables declaration//GEN-END:variables
}
