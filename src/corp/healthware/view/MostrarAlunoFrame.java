package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.AlunoController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.Aluno;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class MostrarAlunoFrame extends javax.swing.JPanel {

    private int cod_a;
    
    public MostrarAlunoFrame(Aluno a) {
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanelMain.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanelEnd.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanelObs.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        
        cod_a = a.getCod_a();
        jLabelTitulo.setText(a.getNome_a());
        jLabelStatus.setText("Status: " + a.getStatusNome());
        jLabelData.setText("Data de Nascimento: " + formatarDataShow(a.getData_nasc_a()));
        jLabelMod.setText("Modalidade: " + a.getNomeModalidade());
        jLabelHorario.setText("Horário: " + a.getHorario().substring(0, 5));
        jLabelTel.setText("Telefone: " + a.getTel_a());
        jLabelVencimento.setText("Vencimento: " + a.getDia_pag());
        jLabelEndereco.setText("Endereco: " + a.getEndereco());
        jLabelObj.setText("Objetivo: " + a.getObj());
        jLabelObs.setText("Observações: " + a.getObs());

    }

    private String formatarDataShow(String data) {
        return data.substring(8) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4);
    }

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
        jLabelData = new javax.swing.JLabel();
        jLabelMod = new javax.swing.JLabel();
        jLabelTel = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelVencimento = new javax.swing.JLabel();
        jLabelHorario = new javax.swing.JLabel();
        jPanelObs = new javax.swing.JPanel();
        jLabelObj = new javax.swing.JLabel();
        jLabelObs = new javax.swing.JLabel();
        jPanelEnd = new javax.swing.JPanel();
        jLabelEndereco = new javax.swing.JLabel();

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

        jLabelData.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(41, 41, 41));
        jLabelData.setText("jLabel3");

        jLabelMod.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelMod.setForeground(new java.awt.Color(41, 41, 41));
        jLabelMod.setText("jLabel3");

        jLabelTel.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelTel.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTel.setText("jLabel3");

        jLabelStatus.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(41, 41, 41));
        jLabelStatus.setText("jLabel3");

        jLabelVencimento.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelVencimento.setForeground(new java.awt.Color(41, 41, 41));
        jLabelVencimento.setText("jLabel3");

        jLabelHorario.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelHorario.setForeground(new java.awt.Color(41, 41, 41));
        jLabelHorario.setText("jLabel3");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMod, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelData)
                    .addComponent(jLabelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMod)
                    .addComponent(jLabelVencimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTel)
                    .addComponent(jLabelHorario))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanelObs.setBackground(new java.awt.Color(239, 239, 239));

        jLabelObj.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelObj.setForeground(new java.awt.Color(41, 41, 41));
        jLabelObj.setText("jLabel3");

        jLabelObs.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelObs.setForeground(new java.awt.Color(41, 41, 41));
        jLabelObs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelObs.setText("jLabel3");

        javax.swing.GroupLayout jPanelObsLayout = new javax.swing.GroupLayout(jPanelObs);
        jPanelObs.setLayout(jPanelObsLayout);
        jPanelObsLayout.setHorizontalGroup(
            jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelObsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelObs, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObj, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanelObsLayout.setVerticalGroup(
            jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelObsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelObj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelObs, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelEnd.setBackground(new java.awt.Color(239, 239, 239));

        jLabelEndereco.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelEndereco.setForeground(new java.awt.Color(41, 41, 41));
        jLabelEndereco.setText("jLabel3");

        javax.swing.GroupLayout jPanelEndLayout = new javax.swing.GroupLayout(jPanelEnd);
        jPanelEnd.setLayout(jPanelEndLayout);
        jPanelEndLayout.setHorizontalGroup(
            jPanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEndLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanelEndLayout.setVerticalGroup(
            jPanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEndLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
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
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
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
                .addGap(27, 27, 27)
                .addComponent(jPanelObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonVerAulas)
                        .addComponent(jButtonEditar)
                        .addComponent(jButtonNovaAula)))
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

        MostrarAulasFrame main = new MostrarAulasFrame(cod_a);
        main.setSize(1000, 570);
        main.setLocation(0, 0);
        removeAll();
        add(main, BorderLayout.CENTER);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonVerAulasActionPerformed

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvar1ActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        AlunoController alunoCtrl = new AlunoController();
        EditarAlunoFrame edAluno;
        try {
            edAluno = new EditarAlunoFrame(alunoCtrl.findOne(cod_a));
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
        NovaAulaFrame novaAula = new NovaAulaFrame(cod_a);
        novaAula.setSize(820, 570);
        novaAula.setLocation(0, 0);
        removeAll();
        add(novaAula, BorderLayout.CENTER);
        revalidate();
        repaint();        
    }//GEN-LAST:event_jButtonNovaAulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonNovaAula;
    private javax.swing.JButton jButtonSalvar1;
    private javax.swing.JButton jButtonVerAulas;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelMod;
    private javax.swing.JLabel jLabelObj;
    private javax.swing.JLabel jLabelObs;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelVencimento;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelEnd;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelObs;
    // End of variables declaration//GEN-END:variables
}
