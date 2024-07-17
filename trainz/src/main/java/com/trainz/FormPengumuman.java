package com.trainz;

import javax.swing.*;
import java.sql.*;

public class FormPengumuman extends javax.swing.JFrame {

    private JLabel lblPengumuman;
    private MainMenu parentClass;

    public FormPengumuman() {
        initComponents();
    }

    public FormPengumuman(MainMenu parentClass, String message) {
        this.parentClass = parentClass;
        initComponents();
        lblPengumuman.setText(message);
    }

    public FormPengumuman(String message) {
        initComponents();
        lblPengumuman.setText(message);

    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblPengumuman = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 500));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon("C:\\BelajarJAVAFX\\trainz\\src\\main\\java\\Logo\\arrow (1).png"));
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblPengumuman.setHorizontalAlignment(SwingConstants.CENTER);
        lblPengumuman.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        lblPengumuman.setText("Pengumuman");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(0, 428, Short.MAX_VALUE))
                        .addComponent(lblPengumuman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addGap(18, 18, 18)
                                .addComponent(lblPengumuman)
                                .addGap(0, 430, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        parentClass.setVisible(true);
    }

    private String fetchAnnouncementMessage(String nim) {
        String sql = "SELECT message FROM announcements WHERE nim = ?";
        try {
            java.sql.Connection conn = (Connection) connDB.configDB();
            java.sql.PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nim);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("message");
            }
        } catch (SQLException e) {
            System.err.println("Error saat mengambil pengumuman: " + e.getMessage());
        }
        return "Pengumuman tidak ditemukan.";
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPengumuman().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
}
