package ewu.event.system;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
    public class ViewEvents extends javax.swing.JFrame {
    
   
   
    public ViewEvents() {

    setContentPane(new BackgroundPanel());

    initComponents();

    setTitle("Available Events");
    setSize(900, 600);
    setLocationRelativeTo(null);
    setResizable(false);

    loadEvents();
}

    private void loadEvents() {

        DefaultTableModel model =
            (DefaultTableModel) tblEvents.getModel();

    model.setColumnIdentifiers(new Object[]{
        "ID",
        "Event Name",
        "Club Name",
        "Date",
        "Venue",
        "Capacity"
    });

    model.setRowCount(0);

        String sql =
                "SELECT * FROM events";

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

                model.addRow(
                        new Object[]{
                            rs.getInt("event_id"),
                            rs.getString("event_name"),
                            rs.getString("club_name"),
                            rs.getDate("event_date"),
                            rs.getString("venue"),
                            rs.getInt("capacity")
                        }
                );
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error loading events: "
                    + e.getMessage()
            );
        }
    }
private boolean isEventFull(Connection con, int eventId) throws Exception {

    String sql =
            "SELECT e.capacity, COUNT(r.registration_id) AS registered_count "
            + "FROM events e "
            + "LEFT JOIN registrations r "
            + "ON e.event_id = r.event_id "
            + "AND r.status='Registered' "
            + "WHERE e.event_id=? "
            + "GROUP BY e.event_id, e.capacity";

    PreparedStatement pst = con.prepareStatement(sql);

    pst.setInt(1, eventId);

    ResultSet rs = pst.executeQuery();

    boolean full = false;

    if (rs.next()) {

        int capacity = rs.getInt("capacity");
        int registered = rs.getInt("registered_count");

        full = registered >= capacity;
    }

    rs.close();
    pst.close();

    return full;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        btnRegister = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AVAILABLE EVENTS");

        tblEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Event Name", "Club Name", "Date", "Venue", "Capacity", "null"
            }
        ));
        jScrollPane1.setViewportView(tblEvents);
        if (tblEvents.getColumnModel().getColumnCount() > 0) {
            tblEvents.getColumnModel().getColumn(6).setResizable(false);
        }

        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegister.setText("REGISTER");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
                        .addGap(252, 252, 252)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnRegister)
                        .addGap(139, 139, 139)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(249, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        registerEvent();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        StudentDashboard student = new StudentDashboard();

student.setLocationRelativeTo(null);
student.setVisible(true);

this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void registerEvent() {

        int row =
                tblEvents.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select an event first."
            );

            return;
        }

        int eventId =
                Integer.parseInt(
                        tblEvents
                            .getValueAt(row, 0)
                            .toString()
                );

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

            // CHECK IF STUDENT ALREADY REGISTERED
String checkSql =
        "SELECT registration_id, status "
        + "FROM registrations "
        + "WHERE user_id=? AND event_id=? "
        + "ORDER BY registration_id DESC "
        + "LIMIT 1";

PreparedStatement check =
        con.prepareStatement(checkSql);

check.setInt(1, Session.userId);
check.setInt(2, eventId);

ResultSet rs =
        check.executeQuery();

if (rs.next()) {

    int registrationId =
            rs.getInt("registration_id");

    String status =
            rs.getString("status");

    // STILL REGISTERED
    if (status.equalsIgnoreCase("Registered")) {

        JOptionPane.showMessageDialog(
                this,
                "You are already registered for this event."
        );

        rs.close();
        check.close();
        con.close();

        return;
    }

    // PREVIOUSLY CANCELLED
    if (status.equalsIgnoreCase("Cancelled")) {

        rs.close();
        check.close();
        if (isEventFull(con, eventId)) {

    JOptionPane.showMessageDialog(
            this,
            "This event is already full."
    );

    con.close();
    return;
}

        String reactivateSql =
                "UPDATE registrations "
                + "SET status='Registered', registration_date=? "
                + "WHERE registration_id=? "
                + "AND user_id=?";

        PreparedStatement reactivate =
                con.prepareStatement(reactivateSql);

        reactivate.setDate(
                1,
                new Date(System.currentTimeMillis())
        );

        reactivate.setInt(2, registrationId);
        reactivate.setInt(3, Session.userId);

        reactivate.executeUpdate();

        reactivate.close();
        con.close();

        JOptionPane.showMessageDialog(
                this,
                "Registration Successful!"
        );

        return;
    }
}

rs.close();
check.close();
// CHECK CAPACITY FOR NEW REGISTRATION
if (isEventFull(con, eventId)) {

    JOptionPane.showMessageDialog(
            this,
            "This event is already full."
    );

    con.close();
    return;
}


// INSERT NEW REGISTRATION
String sql =
        "INSERT INTO registrations "
        + "(user_id, event_id, registration_date, status) "
        + "VALUES (?, ?, ?, ?)";

PreparedStatement pst =
        con.prepareStatement(sql);

pst.setInt(1, Session.userId);
pst.setInt(2, eventId);

pst.setDate(
        3,
        new Date(System.currentTimeMillis())
);

pst.setString(
        4,
        "Registered"
);

pst.executeUpdate();

JOptionPane.showMessageDialog(
        this,
        "Registration Successful!"
);

pst.close();
con.close();


        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );
        }
    }
     public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {

            new ViewEvents().setVisible(true);

        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEvents;
    // End of variables declaration//GEN-END:variables

    }