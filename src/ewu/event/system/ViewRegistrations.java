
 
package ewu.event.system;

/**
 *
 * @author HP
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ViewRegistrations extends javax.swing.JFrame {

    /**
     * Creates new form ViewRegistrations
     */
 public ViewRegistrations() {

    setContentPane(new BackgroundPanel());

    initComponents();

    setTitle("View Event Registrations");
    setSize(900, 600);
    setLocationRelativeTo(null);
    setResizable(false);

    loadEventsIntoCombo();
    loadRegistrationsForSelectedEvent();
}
   private void loadEventsIntoCombo() {

    cmbEvents.removeAllItems();

    String sql =
            "SELECT event_id, event_name FROM events ORDER BY event_id";

    try {

        Connection con =
                DBConnection.getConnection();

        if (con == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database connection failed."
            );

            return;
        }

        PreparedStatement pst =
                con.prepareStatement(sql);

        ResultSet rs =
                pst.executeQuery();

        while (rs.next()) {

            int eventId =
                    rs.getInt("event_id");

            String eventName =
                    rs.getString("event_name");

            cmbEvents.addItem(
                    eventId + " - " + eventName
            );
        }

        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Error loading events: " + e.getMessage()
        );

        e.printStackTrace();
    }
}
private void loadRegistrationsForSelectedEvent() {

    Object selected = cmbEvents.getSelectedItem();

    if (selected == null) {
        return;
    }

    int eventId;

    try {
        String selectedText = selected.toString();
        eventId = Integer.parseInt(
                selectedText.substring(0, selectedText.indexOf(" - "))
        );
    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Invalid event selection."
        );

        return;
    }

    DefaultTableModel model =
            (DefaultTableModel) tblRegistrations.getModel();

    model.setRowCount(0);

    String registrationSql =
            "SELECT r.registration_id, " +
            "u.student_id, u.name, u.email, " +
            "r.registration_date, r.status " +
            "FROM registrations r " +
            "JOIN users u ON r.user_id = u.user_id " +
            "WHERE r.event_id = ? " +
            "ORDER BY r.registration_id";

    String capacitySql =
            "SELECT e.capacity, " +
            "SUM(CASE WHEN r.status = 'Registered' THEN 1 ELSE 0 END) " +
            "AS registered_count " +
            "FROM events e " +
            "LEFT JOIN registrations r " +
            "ON e.event_id = r.event_id " +
            "WHERE e.event_id = ? " +
            "GROUP BY e.event_id, e.capacity";

    try {

        Connection con =
                DBConnection.getConnection();

        if (con == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database connection failed."
            );

            return;
        }

        // LOAD STUDENTS
        PreparedStatement pst =
                con.prepareStatement(registrationSql);

        pst.setInt(1, eventId);

        ResultSet rs =
                pst.executeQuery();

        while (rs.next()) {

            model.addRow(new Object[]{
                rs.getInt("registration_id"),
                rs.getString("student_id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getDate("registration_date"),
                rs.getString("status")
            });
        }

        rs.close();
        pst.close();

        // LOAD CAPACITY
        PreparedStatement capacityPst =
                con.prepareStatement(capacitySql);

        capacityPst.setInt(1, eventId);

        ResultSet capacityRs =
                capacityPst.executeQuery();

        if (capacityRs.next()) {

            int capacity =
                    capacityRs.getInt("capacity");

            int registered =
                    capacityRs.getInt("registered_count");

            lblCapacity.setText(
                    "Registered: "
                    + registered
                    + " / "
                    + capacity
            );
        }

        capacityRs.close();
        capacityPst.close();
        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Error loading registrations: "
                + e.getMessage()
        );

        e.printStackTrace();
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbEvents = new javax.swing.JComboBox<>();
        lblCapacity = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistrations = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("VIEW EVENT REGISTRATIONS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Event:");

        cmbEvents.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cmbEvents.setForeground(new java.awt.Color(255, 255, 255));
        cmbEvents.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEventsActionPerformed(evt);
            }
        });

        lblCapacity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCapacity.setForeground(new java.awt.Color(255, 255, 255));
        lblCapacity.setText("Registered: 0 / 0");

        tblRegistrations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Registration ID ", "Student ID ", "Student Name ", "Email", "Registration Date ", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblRegistrations);
        if (tblRegistrations.getColumnModel().getColumnCount() > 0) {
            tblRegistrations.getColumnModel().getColumn(5).setResizable(false);
        }

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(69, 73, 74));
        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(69, 73, 74));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCapacity)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(cmbEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btnRefresh)
                        .addGap(42, 42, 42)
                        .addComponent(btnBack)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblTitle)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(lblCapacity)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnBack))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEventsActionPerformed
       loadRegistrationsForSelectedEvent();
    }//GEN-LAST:event_cmbEventsActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
       loadEventsIntoCombo();
loadRegistrationsForSelectedEvent();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       AdminDashboard admin =
        new AdminDashboard();

admin.setLocationRelativeTo(null);
admin.setVisible(true);

this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(ViewRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRegistrations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cmbEvents;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCapacity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblRegistrations;
    // End of variables declaration//GEN-END:variables
}
