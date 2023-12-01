package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.model.entity.Aluno;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;

public class MostrarAlunoFrame extends javax.swing.JPanel {

    public MostrarAlunoFrame(Aluno a) {
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanelMain.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanelEnd.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanelObs.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        
        jLabelTitulo.setText(a.getNome_a());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalvar1 = new javax.swing.JButton();
        jPanelCentral = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonVerAulas = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonNovaAula = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelObs = new javax.swing.JPanel();
        jPanelEnd = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jButtonSalvar1.setBackground(new java.awt.Color(212, 81, 93));
        jButtonSalvar1.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonSalvar1.setForeground(new java.awt.Color(239, 239, 239));
        jButtonSalvar1.setText("VOLTAR");
        jButtonSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvar1ActionPerformed(evt);
            }
        });

        setPreferredSize(new java.awt.Dimension(820, 570));

        jPanelCentral.setBackground(new java.awt.Color(239, 239, 239));

        jPanel.setBackground(new java.awt.Color(223, 223, 223));
        jPanel.setPreferredSize(new java.awt.Dimension(773, 550));

        jLabelTitulo.setBackground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Aluno");

        jButtonVerAulas.setBackground(new java.awt.Color(212, 81, 93));
        jButtonVerAulas.setFont(new java.awt.Font("Rosario", 1, 24)); // NOI18N
        jButtonVerAulas.setForeground(new java.awt.Color(239, 239, 239));
        jButtonVerAulas.setText("Ver Aulas");
        jButtonVerAulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerAulasActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonEditar.setFont(new java.awt.Font("Rosario", 1, 24)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonVoltar.setBackground(new java.awt.Color(212, 81, 93));
        jButtonVoltar.setFont(new java.awt.Font("Rosario", 1, 24)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(239, 239, 239));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonNovaAula.setBackground(new java.awt.Color(212, 81, 93));
        jButtonNovaAula.setFont(new java.awt.Font("Rosario", 1, 24)); // NOI18N
        jButtonNovaAula.setForeground(new java.awt.Color(239, 239, 239));
        jButtonNovaAula.setText("Nova Aula");
        jButtonNovaAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaAulaActionPerformed(evt);
            }
        });

        jPanelMain.setBackground(new java.awt.Color(239, 239, 239));

        jLabel1.setBackground(new java.awt.Color(41, 41, 41));
        jLabel1.setForeground(new java.awt.Color(41, 41, 41));
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jPanelObs.setBackground(new java.awt.Color(239, 239, 239));

        javax.swing.GroupLayout jPanelObsLayout = new javax.swing.GroupLayout(jPanelObs);
        jPanelObs.setLayout(jPanelObsLayout);
        jPanelObsLayout.setHorizontalGroup(
            jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelObsLayout.setVerticalGroup(
            jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );

        jPanelEnd.setBackground(new java.awt.Color(239, 239, 239));

        jLabel2.setBackground(new java.awt.Color(41, 41, 41));
        jLabel2.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(41, 41, 41));
        jLabel2.setText("jLabel1");

        javax.swing.GroupLayout jPanelEndLayout = new javax.swing.GroupLayout(jPanelEnd);
        jPanelEnd.setLayout(jPanelEndLayout);
        jPanelEndLayout.setHorizontalGroup(
            jPanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEndLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelEndLayout.setVerticalGroup(
            jPanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEndLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButtonNovaAula)
                .addGap(18, 18, 18)
                .addComponent(jButtonVerAulas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelObs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanelEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanelObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVerAulas)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonVoltar)
                    .addComponent(jButtonNovaAula))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerAulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerAulasActionPerformed
        /*MainFrame main = new MainFrame();
        main.setSize(1000, 570);
        main.setLocation(0, 0);
        jPanelContent.removeAll();
        jPanelContent.add(main, BorderLayout.CENTER);
        jPanelContent.revalidate();
        jPanelContent.repaint();*/
    }//GEN-LAST:event_jButtonVerAulasActionPerformed

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvar1ActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed

    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        AlunosCentralFrame central = new AlunosCentralFrame();
        central.setSize(820, 570);
        central.setLocation(0, 0);
        removeAll();
        add(central, BorderLayout.CENTER);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonNovaAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaAulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovaAulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonNovaAula;
    private javax.swing.JButton jButtonSalvar1;
    private javax.swing.JButton jButtonVerAulas;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelEnd;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelObs;
    // End of variables declaration//GEN-END:variables
}
