
package corp.healthware.view.cell.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPanel extends javax.swing.JPanel {


    public ActionPanel() {
        initComponents();
    }

    public void initEvent(TableActionEvent event, int row) {
        cmdMais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onMais(row);
            }
        });
        
        cmdView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onView(row);
            }
        });
        
        cmdEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onEdit(row);
            }
        });

        cmdDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                event.onDelete(row);
            }
        });

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdEdit = new corp.healthware.view.cell.buttons.ActionButton();
        cmdDelete = new corp.healthware.view.cell.buttons.ActionButton();
        cmdView = new corp.healthware.view.cell.buttons.ActionButton();
        cmdMais = new corp.healthware.view.cell.buttons.ActionButton();

        setBackground(new java.awt.Color(223, 223, 223));

        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit_white.png"))); // NOI18N
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });

        cmdDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_white.png"))); // NOI18N

        cmdView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view_white.png"))); // NOI18N

        cmdMais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mais_white.png"))); // NOI18N
        cmdMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cmdView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmdMais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdEditActionPerformed

    private void cmdMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdMaisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private corp.healthware.view.cell.buttons.ActionButton cmdDelete;
    private corp.healthware.view.cell.buttons.ActionButton cmdEdit;
    private corp.healthware.view.cell.buttons.ActionButton cmdMais;
    private corp.healthware.view.cell.buttons.ActionButton cmdView;
    // End of variables declaration//GEN-END:variables
}
