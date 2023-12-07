package corp.healthware.view;

import corp.healthware.model.entity.Colaborador;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class MainColab extends javax.swing.JPanel {

    Colaborador user;
    
    public MainColab(Colaborador user) {
        UIManager.put("ScrollBar.thumbArc", 10);
        UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
        initComponents();
        ColabCentralFrame central = new ColabCentralFrame();
        central.setSize(820, 570);
        central.setLocation(0, 0);
        jPanelCentral.removeAll();
        jPanelCentral.add(central, BorderLayout.CENTER);
        jPanelCentral.revalidate();
        jPanelCentral.repaint();
        this.user = user;
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContent = new javax.swing.JPanel();
        jPanelLateral = new javax.swing.JPanel();
        jButtonVoltar = new javax.swing.JButton();
        jButtonNovoColab = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        jPanelCentral = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(100, 570));

        jPanelContent.setBackground(new java.awt.Color(239, 239, 239));
        jPanelContent.setPreferredSize(new java.awt.Dimension(1000, 570));

        jPanelLateral.setBackground(new java.awt.Color(212, 81, 93));

        jButtonVoltar.setBackground(new java.awt.Color(239, 239, 239));
        jButtonVoltar.setFont(new java.awt.Font("Rosario", 1, 18)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(41, 41, 41));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonNovoColab.setBackground(new java.awt.Color(239, 239, 239));
        jButtonNovoColab.setFont(new java.awt.Font("Rosario", 1, 17)); // NOI18N
        jButtonNovoColab.setForeground(new java.awt.Color(41, 41, 41));
        jButtonNovoColab.setText("Novo Colaborador");
        jButtonNovoColab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoColabActionPerformed(evt);
            }
        });

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo50px_branca.png"))); // NOI18N

        javax.swing.GroupLayout jPanelLateralLayout = new javax.swing.GroupLayout(jPanelLateral);
        jPanelLateral.setLayout(jPanelLateralLayout);
        jPanelLateralLayout.setHorizontalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLateralLayout.createSequentialGroup()
                .addGroup(jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLateralLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabelLogo))
                    .addGroup(jPanelLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLateralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonNovoColab, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLateralLayout.setVerticalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLateralLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelLogo)
                .addGap(157, 157, 157)
                .addComponent(jButtonNovoColab, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 896, Short.MAX_VALUE)
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addComponent(jPanelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        MainFrame main = new MainFrame(user);
        main.setSize(1000, 570);
        main.setLocation(0, 0);
        jPanelContent.removeAll();
        jPanelContent.add(main, BorderLayout.CENTER);
        jPanelContent.revalidate();
        jPanelContent.repaint();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonNovoColabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoColabActionPerformed
        NovoColabFrame tColab = new NovoColabFrame();
        
        tColab.setSize(820, 570);
        tColab.setLocation(0, 0);
        jPanelCentral.removeAll();
        jPanelCentral.add(tColab, BorderLayout.CENTER);
        jPanelCentral.revalidate();
        jPanelCentral.repaint();
    }//GEN-LAST:event_jButtonNovoColabActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNovoColab;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelLateral;
    // End of variables declaration//GEN-END:variables
}
