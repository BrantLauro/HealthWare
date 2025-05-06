package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.AlunoController;
import corp.healthware.controller.AulaController;
import corp.healthware.controller.ModalidadeController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aluno;
import corp.healthware.model.entity.Aula;
import corp.healthware.model.entity.Modalidade;
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

public class MostrarAulasFrame extends javax.swing.JPanel {

    private int cod_a;
    
    public MostrarAulasFrame(int cod_a) {
        this.cod_a = cod_a;
        initComponents();
        initTableAulas();
    }

    private String formatarDataShow(String data) {
        return data.substring(8) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4);
    }
    
    private void initTableAulas() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) jTableAulas.getModel();
            tableModel.setRowCount(0);
            ArrayList<Aula> aulas;
            AulaController aulaCtrl = new AulaController();
            aulas = aulaCtrl.findAll(this.cod_a);
            aulas.forEach((Aula a) -> {
                tableModel.addRow(new Object[]{formatarDataShow(a.getData_au()), a.getHora_au(), a.getDescricao()});
            });
            jTableAulas.setModel(tableModel);
        } catch (SQLException | DAOexception ex) {
            System.out.println("ERROR: " + ex);

        } catch (NumberFormatException ex) {
            System.out.println("ERROR: " + ex);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCentral = new javax.swing.JPanel();
        jScrollPaneTabela = new javax.swing.JScrollPane();
        jTableAulas = new javax.swing.JTable();
        jButtonVoltar = new javax.swing.JButton();

        setBackground(new java.awt.Color(239, 239, 239));
        setPreferredSize(new java.awt.Dimension(797, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jScrollPaneTabela.setBackground(new java.awt.Color(223, 223, 223));
        jScrollPaneTabela.setToolTipText("");
        jScrollPaneTabela.setFocusable(false);

        jTableAulas.setBackground(new java.awt.Color(223, 223, 223));
        jTableAulas.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTableAulas.setForeground(new java.awt.Color(41, 41, 41));
        jTableAulas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Horário", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAulas.setFocusable(false);
        jTableAulas.setGridColor(new java.awt.Color(239, 239, 239));
        jTableAulas.setRowHeight(40);
        jTableAulas.setSelectionBackground(new java.awt.Color(239, 239, 239));
        jTableAulas.setSelectionForeground(new java.awt.Color(41, 41, 41));
        jTableAulas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableAulas.setShowGrid(false);
        jTableAulas.setShowHorizontalLines(true);
        jTableAulas.setShowVerticalLines(true);
        jTableAulas.getTableHeader().setResizingAllowed(false);
        jTableAulas.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTabela.setViewportView(jTableAulas);
        if (jTableAulas.getColumnModel().getColumnCount() > 0) {
            jTableAulas.getColumnModel().getColumn(0).setResizable(false);
            jTableAulas.getColumnModel().getColumn(1).setResizable(false);
            jTableAulas.getColumnModel().getColumn(2).setResizable(false);
            jTableAulas.getColumnModel().getColumn(2).setPreferredWidth(500);
        }

        jButtonVoltar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonVoltar.setFont(new java.awt.Font("Rosario", 1, 24)); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPaneTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonVoltar)
                .addGap(33, 33, 33))
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

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        try {
            AlunoController alunoCtrl = new AlunoController();
            MostrarAlunoFrame mA = new MostrarAlunoFrame(alunoCtrl.findOne(cod_a));
            mA.setSize(820, 570);
            mA.setLocation(0, 0);
            removeAll();
            add(mA, BorderLayout.CENTER);
            revalidate();
            repaint();
        } catch (DAOexception ex) {
            Logger.getLogger(MostrarAulasFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarAulasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JScrollPane jScrollPaneTabela;
    private javax.swing.JTable jTableAulas;
    // End of variables declaration//GEN-END:variables
}
