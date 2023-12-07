package corp.healthware.view;

import corp.healthware.model.entity.Colaborador;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MainFrame extends javax.swing.JPanel {

    private Colaborador user;

    public MainFrame(Colaborador user) {
        initComponents();
        UIManager.put("Button.arc", 10);
        jLabelUser.setText(user.getNome_c().toUpperCase());
        this.user = user;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContent = new javax.swing.JPanel();
        jButtonAlunos = new javax.swing.JButton();
        jButtonServicos = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelLogoUser = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelRodape = new javax.swing.JLabel();

        jPanelContent.setBackground(new java.awt.Color(239, 239, 239));
        jPanelContent.setPreferredSize(new java.awt.Dimension(1000, 570));

        jButtonAlunos.setBackground(new java.awt.Color(212, 81, 93));
        jButtonAlunos.setFont(new java.awt.Font("Rosario", 1, 30)); // NOI18N
        jButtonAlunos.setForeground(new java.awt.Color(239, 239, 239));
        jButtonAlunos.setText("ALUNOS");
        jButtonAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlunosActionPerformed(evt);
            }
        });

        jButtonServicos.setBackground(new java.awt.Color(212, 81, 93));
        jButtonServicos.setFont(new java.awt.Font("Rosario", 1, 30)); // NOI18N
        jButtonServicos.setForeground(new java.awt.Color(239, 239, 239));
        jButtonServicos.setText("SERVIÇOS");
        jButtonServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonServicosActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 50)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setText("HEALTHWARE");

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo100px.png"))); // NOI18N

        jLabelLogoUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoStudio30px.png"))); // NOI18N

        jLabelUser.setFont(new java.awt.Font("TT Hoves Pro Trial", 1, 14)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(41, 41, 41));
        jLabelUser.setText("STUDIO CECILIA BRANT");

        jLabelRodape.setFont(new java.awt.Font("TT Hoves Pro Trial", 1, 14)); // NOI18N
        jLabelRodape.setForeground(new java.awt.Color(41, 41, 41));
        jLabelRodape.setText("Produced by Healthware corp. ");

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jButtonAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelLogoUser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelUser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                        .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo)
                            .addGroup(jPanelContentLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabelLogo)))
                        .addGap(341, 341, 341))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                        .addComponent(jLabelRodape)
                        .addGap(392, 392, 392))))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContentLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogoUser))
                .addGap(78, 78, 78)
                .addComponent(jLabelLogo)
                .addGap(18, 18, 18)
                .addComponent(jLabelTitulo)
                .addGap(75, 75, 75)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabelRodape)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlunosActionPerformed
        MainAlunos tAlunos = new MainAlunos(user);
        tAlunos.setSize(1000, 570);
        tAlunos.setLocation(0, 0);
        jPanelContent.removeAll();
        jPanelContent.add(tAlunos, BorderLayout.CENTER);
        jPanelContent.revalidate();
        jPanelContent.repaint();
    }//GEN-LAST:event_jButtonAlunosActionPerformed

    private void jButtonServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonServicosActionPerformed
        if (user.getAdm() == 1) {
            MainColab tColab = new MainColab(user);
            tColab.setSize(1000, 570);
            tColab.setLocation(0, 0);
            jPanelContent.removeAll();
            jPanelContent.add(tColab, BorderLayout.CENTER);
            jPanelContent.revalidate();
            jPanelContent.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "Somente adminstradores podem acessar a parte de Colaboradores!", "Acesso Negado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonServicosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlunos;
    private javax.swing.JButton jButtonServicos;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelLogoUser;
    private javax.swing.JLabel jLabelRodape;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanelContent;
    // End of variables declaration//GEN-END:variables
}
