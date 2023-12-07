package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.RegistroServicoController;
import corp.healthware.model.dao.DAOexception;
import corp.healthware.model.entity.RegistroServico;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

public class MostrarRegistroServicoFrame extends javax.swing.JPanel {

    private int cod_s;
    private String data;
    private String hora;
    
    public MostrarRegistroServicoFrame(RegistroServico r) {
        initComponents();
        jPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanelMain.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanelEnd.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        jPanelObs.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        
        cod_s = r.getCod_s();
        data = r.getData();
        hora = r.getHora();
        jLabelCodigo.setText("Código do serviço: " + r.getCod_s());
        jLabelNome.setText("Nome do Cliente: : " + r.getNome_cliente());;
        jLabelHora.setText("Preço: " + r.getHora());
        jLabelData.setText("Responsável: " + r.getData());

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalvar1 = new javax.swing.JButton();
        jPanelCentral = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonVerServicos = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonNovoRegistro = new javax.swing.JButton();
        jPanelMain = new javax.swing.JPanel();
        jLabelCodigo = new javax.swing.JLabel();
        jPanelObs = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jPanelEnd = new javax.swing.JPanel();
        jLabelHora = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();

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
        jLabelTitulo.setText("Serviço");

        jButtonVerServicos.setBackground(new java.awt.Color(212, 81, 93));
        jButtonVerServicos.setFont(new java.awt.Font("Rosario", 1, 24)); // NOI18N
        jButtonVerServicos.setForeground(new java.awt.Color(239, 239, 239));
        jButtonVerServicos.setText("Ver Serviços");
        jButtonVerServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerServicosActionPerformed(evt);
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

        jButtonNovoRegistro.setBackground(new java.awt.Color(212, 81, 93));
        jButtonNovoRegistro.setFont(new java.awt.Font("Rosario", 1, 24)); // NOI18N
        jButtonNovoRegistro.setForeground(new java.awt.Color(239, 239, 239));
        jButtonNovoRegistro.setText("Novo Registro");
        jButtonNovoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoRegistroActionPerformed(evt);
            }
        });

        jPanelMain.setBackground(new java.awt.Color(239, 239, 239));

        jLabelCodigo.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelCodigo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelCodigo.setText("Código do serviço:");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabelCodigo)
                .addGap(48, 48, 48))
        );

        jPanelObs.setBackground(new java.awt.Color(239, 239, 239));

        jLabelNome.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(41, 41, 41));
        jLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelNome.setText("Nome do Cliente:");

        javax.swing.GroupLayout jPanelObsLayout = new javax.swing.GroupLayout(jPanelObs);
        jPanelObs.setLayout(jPanelObsLayout);
        jPanelObsLayout.setHorizontalGroup(
            jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelObsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelObsLayout.setVerticalGroup(
            jPanelObsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelObsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanelEnd.setBackground(new java.awt.Color(239, 239, 239));

        jLabelHora.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelHora.setForeground(new java.awt.Color(41, 41, 41));
        jLabelHora.setText("Hora:");

        jLabelData.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 20)); // NOI18N
        jLabelData.setForeground(new java.awt.Color(41, 41, 41));
        jLabelData.setText("Data:");

        javax.swing.GroupLayout jPanelEndLayout = new javax.swing.GroupLayout(jPanelEnd);
        jPanelEnd.setLayout(jPanelEndLayout);
        jPanelEndLayout.setHorizontalGroup(
            jPanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEndLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanelEndLayout.setVerticalGroup(
            jPanelEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEndLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabelData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelHora)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButtonNovoRegistro)
                .addGap(18, 18, 18)
                .addComponent(jButtonVerServicos)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanelObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonVerServicos)
                        .addComponent(jButtonEditar)
                        .addComponent(jButtonNovoRegistro)))
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

    private void jButtonVerServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerServicosActionPerformed
        RegistroServicoCentralFrame main = new RegistroServicoCentralFrame();
        main.setSize(1000, 570);
        main.setLocation(0, 0);
        removeAll();
        add(main, BorderLayout.CENTER);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonVerServicosActionPerformed

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvar1ActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        AlunosCentralFrame central = new AlunosCentralFrame();
        central.setSize(820, 570);
        central.setLocation(0, 0);
        removeAll();
        add(central, BorderLayout.CENTER);
        revalidate();
        repaint();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonNovoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoRegistroActionPerformed
        // TODO add your handling code here:
        NovoRegistroServicoFrame novoRegistro = new NovoRegistroServicoFrame(cod_s);
        novoRegistro.setSize(820, 570);
        novoRegistro.setLocation(0, 0);
        removeAll();
        add(novoRegistro, BorderLayout.CENTER);
        revalidate();
        repaint();        
    }//GEN-LAST:event_jButtonNovoRegistroActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        RegistroServicoController regCtrl = new RegistroServicoController();
        EditarRegistroServicoFrame edRegistro;
        try {
            edRegistro = new EditarRegistroServicoFrame(regCtrl.findOne(cod_s));
            edRegistro.setSize(820, 570);
            edRegistro.setLocation(0, 0);
            removeAll();
            add(edRegistro, BorderLayout.CENTER);
            revalidate();
            repaint();
        } catch (DAOexception ex) {
            Logger.getLogger(AlunosCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlunosCentralFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonNovoRegistro;
    private javax.swing.JButton jButtonSalvar1;
    private javax.swing.JButton jButtonVerServicos;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelEnd;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelObs;
    // End of variables declaration//GEN-END:variables
}
