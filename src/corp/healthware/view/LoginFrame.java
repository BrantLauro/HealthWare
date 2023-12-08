
package corp.healthware.view;

import com.formdev.flatlaf.FlatClientProperties;
import corp.healthware.controller.ColaboradorController;
import corp.healthware.model.dao.DAOexception;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class LoginFrame extends javax.swing.JFrame {
    
    private boolean typed = false;

    public LoginFrame() {
        initComponents();
        jPanelLogin.putClientProperty( FlatClientProperties.STYLE, "arc: 15" );
        jTextFieldUsuario.putClientProperty( FlatClientProperties.STYLE, "arc: 9" );
        jPasswordField.putClientProperty( FlatClientProperties.STYLE, "arc: 9" );
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContent = new javax.swing.JPanel();
        jPanelLogin = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jPanelContent.setBackground(new java.awt.Color(239, 239, 239));
        jPanelContent.setPreferredSize(new java.awt.Dimension(1000, 570));
        jPanelContent.setLayout(null);

        jPanelLogin.setBackground(new java.awt.Color(223, 223, 223));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo70px.png"))); // NOI18N

        jLabelTitulo.setFont(new java.awt.Font("Rosario", 1, 50)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(41, 41, 41));
        jLabelTitulo.setText("HEALTHWARE");

        jLabelUsuario.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(41, 41, 41));
        jLabelUsuario.setText("Usuário");

        jTextFieldUsuario.setBackground(new java.awt.Color(239, 239, 239));
        jTextFieldUsuario.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jTextFieldUsuario.setForeground(new java.awt.Color(139, 137, 137));
        jTextFieldUsuario.setText("adm@studioceciliabrant.com");
        jTextFieldUsuario.setToolTipText("");
        jTextFieldUsuario.setCaretColor(new java.awt.Color(0, 0, 0));
        jTextFieldUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldUsuarioMouseClicked(evt);
            }
        });
        jTextFieldUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioKeyPressed(evt);
            }
        });

        jLabelSenha.setFont(new java.awt.Font("Rosario", 1, 14)); // NOI18N
        jLabelSenha.setForeground(new java.awt.Color(41, 41, 41));
        jLabelSenha.setText("Senha");

        jPasswordField.setBackground(new java.awt.Color(239, 239, 239));
        jPasswordField.setFont(new java.awt.Font("TT Hoves Pro Trial", 0, 12)); // NOI18N
        jPasswordField.setForeground(new java.awt.Color(139, 137, 137));
        jPasswordField.setText("************");
        jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldFocusGained(evt);
            }
        });

        jButtonLogin.setBackground(new java.awt.Color(212, 81, 93));
        jButtonLogin.setFont(new java.awt.Font("Rosario", 1, 26)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(239, 239, 239));
        jButtonLogin.setText("LOGIN");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabelLogo)
                        .addGap(69, 69, 69)
                        .addComponent(jLabelTitulo))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldUsuario)
                            .addGroup(jPanelLoginLayout.createSequentialGroup()
                                .addComponent(jLabelSenha)
                                .addGap(337, 337, 337))
                            .addComponent(jLabelUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLogo)
                    .addComponent(jLabelTitulo))
                .addGap(80, 80, 80)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        jPanelContent.add(jPanelLogin);
        jPanelLogin.setBounds(160, 30, 678, 500);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tela_incial_desfoque.png"))); // NOI18N
        jPanelContent.add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 1010, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        String email = jTextFieldUsuario.getText();
        String senha = jPasswordField.getText();
        ColaboradorController colabCtrl = new ColaboradorController();
        try {
            if(colabCtrl.login(email, senha)){
                MainFrame main = new MainFrame(colabCtrl.findOne(colabCtrl.getCod_cLogin(email, senha)));
                main.setSize(1000, 570);
                main.setLocation(0, 0);
                jPanelContent.removeAll();
                jPanelContent.add(main, BorderLayout.CENTER);
                jPanelContent.revalidate();
                jPanelContent.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Email ou Senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DAOexception ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jTextFieldUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioMouseClicked
       if(typed == false) {
            jTextFieldUsuario.setForeground(new Color(41, 41, 41));
            jTextFieldUsuario.setText("");
            typed = true;   
       }
    }//GEN-LAST:event_jTextFieldUsuarioMouseClicked

    private void jTextFieldUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioKeyPressed
        if(typed == false) {
            jTextFieldUsuario.setForeground(new Color(41, 41, 41));
            jTextFieldUsuario.setText("");
            typed = true;   
       }
    }//GEN-LAST:event_jTextFieldUsuarioKeyPressed

    private void jPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldFocusGained
        if(jPasswordField.getText().equals("************")) {
            jPasswordField.setForeground(new Color(41, 41, 41));
            jPasswordField.setText("");
        }
    }//GEN-LAST:event_jPasswordFieldFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
