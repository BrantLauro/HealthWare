package corp.healthware.view;

import corp.healthware.controller.RegistroServicoController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.RegistroServico;
import corp.healthware.view.cell.buttons.TableActionCellEditorNoViewNoMais;
import corp.healthware.view.cell.buttons.TableActionCellRenderNoViewNoMais;
import corp.healthware.view.cell.buttons.TableActionEventNoView;
import corp.healthware.view.cell.buttons.TableActionEventNoViewNoMais;
import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroServicoCentralFrame extends javax.swing.JPanel {
    
    private ArrayList<RegistroServico> reg;

    public RegistroServicoCentralFrame(ArrayList<RegistroServico> reg) {
        this.reg = reg;
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
            RegistroServicoController regCtrl = new RegistroServicoController();
            if(!pesquisa.equals("")) reg = regCtrl.search(pesquisa);
            
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
            public void onDelete(int row) {
                System.out.println("Apagando Registro");
                int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse registro?\nIsso apagará todos os seus dados!", "Excluir registro", 0);
                if (resultado == JOptionPane.YES_OPTION) {
                    try {
                        if (jTableRegistroServicos.isEditing()) {
                            jTableRegistroServicos.getCellEditor().stopCellEditing();
                        }
                        DefaultTableModel model = (DefaultTableModel) jTableRegistroServicos.getModel();
                        RegistroServicoController regCtrl = new RegistroServicoController();
                        int cod_s = (int) model.getValueAt(row, 0);
                        String data = (String) model.getValueAt(row, 1);
                        String hora = (String) model.getValueAt(row, 2);
                        System.out.println(cod_s + data + hora);
                        regCtrl.delete(cod_s, data, hora);
                        model.removeRow(row);
                    } catch (NumberFormatException ex) {
                        System.out.println("ERROR: " + ex);
                    } catch (DAOexception | SQLException ex) {
                        System.out.println("ERROR: " + ex);
                    }
                }

            }

            @Override
            public void onEdit(int row) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
                    Logger.getLogger(ServicoCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ServicoCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        jTableRegistroServicos.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRenderNoViewNoMais());
        jTableRegistroServicos.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditorNoViewNoMais(event));
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableRegistroServicos = new javax.swing.JTable();
        jButtonVoltar = new javax.swing.JButton();

        setBackground(new java.awt.Color(239, 239, 239));
        setPreferredSize(new java.awt.Dimension(797, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

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

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableRegistroServicos;
    // End of variables declaration//GEN-END:variables
}
