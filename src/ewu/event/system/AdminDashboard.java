package ewu.event.system;

public class AdminDashboard extends javax.swing.JFrame {

    public AdminDashboard() {
        setContentPane(new BackgroundPanel());
initComponents();
        setSize(900, 600);
    setLocationRelativeTo(null);
    setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnManageEvents = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();
        btnChangePassword = new javax.swing.JButton();
        btnResetRequests = new javax.swing.JButton();
        btnViewRegistrations = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMIN DASHBOARD");

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnManageEvents.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageEvents.setText("MANAGE EVENTS");
        btnManageEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEventsActionPerformed(evt);
            }
        });

        btnManageUsers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageUsers.setText("MANAGE USERS");
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });

        btnChangePassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChangePassword.setText("CHANGE PASSWORD");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        btnResetRequests.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnResetRequests.setText("RESET REQUESTS");
        btnResetRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetRequestsActionPerformed(evt);
            }
        });

        btnViewRegistrations.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewRegistrations.setText("VIEW REGISTRATIONS");
        btnViewRegistrations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRegistrationsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnManageUsers)
                                    .addComponent(btnManageEvents)))
                            .addComponent(btnChangePassword)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnLogout))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnResetRequests))
                            .addComponent(btnViewRegistrations))))
                .addContainerGap(458, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(btnManageEvents)
                .addGap(18, 18, 18)
                .addComponent(btnManageUsers)
                .addGap(18, 18, 18)
                .addComponent(btnChangePassword)
                .addGap(37, 37, 37)
                .addComponent(btnViewRegistrations)
                .addGap(27, 27, 27)
                .addComponent(btnResetRequests)
                .addGap(32, 32, 32)
                .addComponent(btnLogout)
                .addContainerGap(337, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEventsActionPerformed
        ManageEvents manage = new ManageEvents();
    manage.setVisible(true);
    manage.setLocationRelativeTo(null);

    this.dispose();
    }//GEN-LAST:event_btnManageEventsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
       LoginForm login = new LoginForm();
    login.setVisible(true);
    login.setLocationRelativeTo(null);

    this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed
         ManageUsers manageUsers = new ManageUsers();
    manageUsers.setLocationRelativeTo(null);
    manageUsers.setVisible(true);

    this.dispose();
    }//GEN-LAST:event_btnManageUsersActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        ChangePassword change =
        new ChangePassword();

change.setLocationRelativeTo(null);
change.setVisible(true);

this.dispose();
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnResetRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetRequestsActionPerformed
        ResetRequests requests =
        new ResetRequests();

        requests.setLocationRelativeTo(null);
        requests.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnResetRequestsActionPerformed

    private void btnViewRegistrationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRegistrationsActionPerformed
        new ViewRegistrations().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnViewRegistrationsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageEvents;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JButton btnResetRequests;
    private javax.swing.JButton btnViewRegistrations;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
