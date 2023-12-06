package corp.healthware.view;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class MainServicos extends javax.swing.JPanel {

    public MainServicos() {
        UIManager.put("ScrollBar.thumbArc", 10);
        UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
        initComponents();
        ServicoCentralFrame central = new ServicoCentralFrame();
        central.setSize(820, 570);
        central.setLocation(0, 0);
        jPanelCentral.removeAll();
        jPanelCentral.add(central, BorderLayout.CENTER);
        jPanelCentral.revalidate();
        jPanelCentral.repaint();
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContent = new javax.swing.JPanel();
        jPanelLateral = new javax.swing.JPanel();
        jButtonVoltar = new javax.swing.JButton();
        jButtonNovoColaborador = new javax.swing.JButton();
        jButtonNovoServico = new javax.swing.JButton();
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

        jButtonNovoColaborador.setBackground(new java.awt.Color(239, 239, 239));
        jButtonNovoColaborador.setFont(new java.awt.Font("Rosario", 1, 18)); // NOI18N
        jButtonNovoColaborador.setForeground(new java.awt.Color(41, 41, 41));
        jButtonNovoColaborador.setText("Novo Colaborador");
        jButtonNovoColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoColaboradorActionPerformed(evt);
            }
        });

        jButtonNovoServico.setBackground(new java.awt.Color(239, 239, 239));
        jButtonNovoServico.setFont(new java.awt.Font("Rosario", 1, 18)); // NOI18N
        jButtonNovoServico.setForeground(new java.awt.Color(41, 41, 41));
        jButtonNovoServico.setText("Novo Serviço");
        jButtonNovoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoServicoActionPerformed(evt);
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
                        .addGroup(jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonNovoColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jButtonNovoServico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jButtonVoltar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLateralLayout.setVerticalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLateralLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jButtonNovoColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
        );

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        MainFrame main = new MainFrame();
        main.setSize(1000, 570);
        main.setLocation(0, 0);
        jPanelContent.removeAll();
        jPanelContent.add(main, BorderLayout.CENTER);
        jPanelContent.revalidate();
        jPanelContent.repaint();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonNovoColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoColaboradorActionPerformed
        NovoColaboradorFrame tCColaborador = new NovoColaboradorFrame();
        
        tCColaborador.setSize(820, 570);
        tCColaborador.setLocation(0, 0);
        jPanelCentral.removeAll();
        jPanelCentral.add(tCColaborador, BorderLayout.CENTER);
        jPanelCentral.revalidate();
        jPanelCentral.repaint();
    }//GEN-LAST:event_jButtonNovoColaboradorActionPerformed

    private void jButtonNovoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoServicoActionPerformed
        NovoServicoFrame tCServico = new NovoServicoFrame();
        tCServico.setSize(820, 570);
        tCServico.setLocation(0, 0);
        jPanelCentral.removeAll();
        jPanelCentral.add(tCServico, BorderLayout.CENTER);
        jPanelCentral.revalidate();
        jPanelCentral.repaint();
    }//GEN-LAST:event_jButtonNovoServicoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNovoColaborador;
    private javax.swing.JButton jButtonNovoServico;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelLateral;
    // End of variables declaration//GEN-END:variables
}
