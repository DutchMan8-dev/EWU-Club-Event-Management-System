
package ewu.event.system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ManageEvents extends javax.swing.JFrame {

    /**
     * Creates new form ManageEvents
     */
    public ManageEvents() {
 setContentPane(new BackgroundPanel());
initComponents();

    setSize(818, 808);
    setLocationRelativeTo(null);
    setResizable(false);

    loadEvents();   }

    private void loadEvents() {

    DefaultTableModel model =
            (DefaultTableModel) tblEvents.getModel();

    model.setRowCount(0);

    String sql = "SELECT * FROM events";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            Object[] row = {
                rs.getInt("event_id"),
                rs.getString("event_name"),
                rs.getString("club_name"),
                rs.getDate("event_date"),
                rs.getString("venue"),
                rs.getInt("capacity")
            };

            model.addRow(row);
        }

        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {

        JOptionPane.showMessageDialog(
                this,
                "Error loading events: " + e.getMessage()
        );
    }
}
   private void clearFields() {

    txtEventname.setText("");
    txtClubname.setText("");
    txtEventdate.setText("");
    txtvenue.setText("");
    txtcapacity.setText("");

    tblEvents.clearSelection();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEventName = new javax.swing.JTextField();
        txtClubName = new javax.swing.JTextField();
        txtEventDate = new javax.swing.JTextField();
        txtVenue = new javax.swing.JTextField();
        txtCapacity = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        txtEventname = new javax.swing.JTextField();
        txtClubname = new javax.swing.JTextField();
        txtEventdate = new javax.swing.JTextField();
        txtvenue = new javax.swing.JTextField();
        txtcapacity = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANAGE EVENTS");

        txtEventName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEventName.setForeground(new java.awt.Color(69, 73, 74));
        txtEventName.setText("Event Name:");

        txtClubName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtClubName.setForeground(new java.awt.Color(69, 73, 74));
        txtClubName.setText("Club Name:");

        txtEventDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtEventDate.setForeground(new java.awt.Color(69, 73, 74));
        txtEventDate.setText("Event Date:");

        txtVenue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtVenue.setForeground(new java.awt.Color(69, 73, 74));
        txtVenue.setText("Venue:");

        txtCapacity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCapacity.setForeground(new java.awt.Color(69, 73, 74));
        txtCapacity.setText("Capacity:");

        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Event Name", "Club Name", "Date", "Venue", "Capacity"
            }
        ));
        tblEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEventsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEvents);

        txtEventname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtClubname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtEventdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtvenue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtcapacity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(btnAdd)
                        .addGap(152, 152, 152)
                        .addComponent(btnDelete)
                        .addGap(30, 30, 30)
                        .addComponent(btnClear)
                        .addGap(29, 29, 29)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClubName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEventDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEventname)
                            .addComponent(txtClubname)
                            .addComponent(txtEventdate)
                            .addComponent(txtvenue)
                            .addComponent(txtcapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdate)
                                    .addComponent(jLabel1))
                                .addGap(198, 198, 198))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEventname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClubName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClubname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEventDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEventdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnBack)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
String eventName = txtEventname.getText().trim();
String clubName = txtClubname.getText().trim();
String eventDate = txtEventdate.getText().trim();
String venue = txtvenue.getText().trim();
String capacityText = txtcapacity.getText().trim();
if (eventName.isEmpty()
        || clubName.isEmpty()
        || eventDate.isEmpty()
        || venue.isEmpty()
        || capacityText.isEmpty()) {

    JOptionPane.showMessageDialog(
            this,
            "Please fill in all fields."
    );

    return;
}

try {

    int capacity = Integer.parseInt(capacityText);
    if (capacity <= 0) {
    JOptionPane.showMessageDialog(
            this,
            "Capacity must be greater than 0."
    );
    return;
}

    String sql =
            "INSERT INTO events "
            + "(event_name, club_name, event_date, venue, capacity) "
            + "VALUES (?, ?, ?, ?, ?)";

    Connection con = DBConnection.getConnection();

    PreparedStatement pst = con.prepareStatement(sql);

    pst.setString(1, eventName);
    pst.setString(2, clubName);
    pst.setDate(3, Date.valueOf(eventDate));
    pst.setString(4, venue);
    pst.setInt(5, capacity);

    pst.executeUpdate();

    JOptionPane.showMessageDialog(
            this,
            "Event Added Successfully!"
    );

    pst.close();
    con.close();

    clearFields();
    loadEvents();

} catch (NumberFormatException e) {

    JOptionPane.showMessageDialog(
            this,
            "Capacity must be a number."
    );

} catch (IllegalArgumentException e) {

    JOptionPane.showMessageDialog(
            this,
            "Date must be YYYY-MM-DD."
    );

} catch (Exception e) {

    JOptionPane.showMessageDialog(
            this,
            "Error: " + e.getMessage()
    );
}    }//GEN-LAST:event_btnAddActionPerformed

    private void tblEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEventsMouseClicked
int row = tblEvents.getSelectedRow();

    if (row != -1) {

        txtEventname.setText(
                tblEvents.getValueAt(row, 1).toString()
        );

        txtClubname.setText(
                tblEvents.getValueAt(row, 2).toString()
        );

        txtEventdate.setText(
                tblEvents.getValueAt(row, 3).toString()
        );

        txtvenue.setText(
                tblEvents.getValueAt(row, 4).toString()
        );

        txtcapacity.setText(
                tblEvents.getValueAt(row, 5).toString()
        );
}    }//GEN-LAST:event_tblEventsMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
int row = tblEvents.getSelectedRow();

if (row == -1) {

    JOptionPane.showMessageDialog(
            this,
            "Please select an event first."
    );

    return;
}

try {

    int eventId =
            Integer.parseInt(
                    tblEvents.getValueAt(row, 0).toString()
            );

    String eventName =
        txtEventname.getText().trim();

String clubName =
        txtClubname.getText().trim();

String eventDate =
        txtEventdate.getText().trim();

String venue =
        txtvenue.getText().trim();

int capacity =
        Integer.parseInt(
                txtcapacity.getText().trim()
        );
if (capacity <= 0) {
    JOptionPane.showMessageDialog(
            this,
            "Capacity must be greater than 0."
    );
    return;
}

    String sql =
            "UPDATE events SET "
            + "event_name=?, "
            + "club_name=?, "
            + "event_date=?, "
            + "venue=?, "
            + "capacity=? "
            + "WHERE event_id=?";

    Connection con = DBConnection.getConnection();

    PreparedStatement pst = con.prepareStatement(sql);

    pst.setString(1, eventName);
    pst.setString(2, clubName);
    pst.setDate(3, Date.valueOf(eventDate));
    pst.setString(4, venue);
    pst.setInt(5, capacity);
    pst.setInt(6, eventId);

    pst.executeUpdate();

    JOptionPane.showMessageDialog(
            this,
            "Event Updated Successfully!"
    );

    pst.close();
    con.close();

    clearFields();
    loadEvents();

} catch (java.sql.SQLIntegrityConstraintViolationException e) {

    JOptionPane.showMessageDialog(
            this,
            "Cannot delete this event because students are registered for it."
    );

} catch (Exception e) {

    JOptionPane.showMessageDialog(
            this,
            "Error: " + e.getMessage()
    );

    e.printStackTrace();
}    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
int row = tblEvents.getSelectedRow();

if (row == -1) {

    JOptionPane.showMessageDialog(
            this,
            "Please select an event first."
    );

    return;
}

int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete this event?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
);

if (confirm != JOptionPane.YES_OPTION) {
    return;
}

try {

    int eventId =
            Integer.parseInt(
                    tblEvents.getValueAt(row, 0).toString()
            );

    String sql =
            "DELETE FROM events WHERE event_id=?";

    Connection con = DBConnection.getConnection();

    PreparedStatement pst = con.prepareStatement(sql);

    pst.setInt(1, eventId);

    pst.executeUpdate();

    JOptionPane.showMessageDialog(
            this,
            "Event Deleted Successfully!"
    );

    pst.close();
    con.close();

    clearFields();
    loadEvents();

} catch (Exception e) {

    JOptionPane.showMessageDialog(
            this,
            "Error: " + e.getMessage()
    );
}    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
clearFields();    }//GEN-LAST:event_btnClearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
AdminDashboard admin = new AdminDashboard();
admin.setLocationRelativeTo(null);
admin.setVisible(true);

this.dispose();    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(ManageEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageEvents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageEvents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEvents;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtClubName;
    private javax.swing.JTextField txtClubname;
    private javax.swing.JTextField txtEventDate;
    private javax.swing.JTextField txtEventName;
    private javax.swing.JTextField txtEventdate;
    private javax.swing.JTextField txtEventname;
    private javax.swing.JTextField txtVenue;
    private javax.swing.JTextField txtcapacity;
    private javax.swing.JTextField txtvenue;
    // End of variables declaration//GEN-END:variables
}
