package Frames;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

import Entities.updateBooking;

public class showBooking extends JFrame implements ActionListener {
    String userName, line;
    JPanel panel;
    JTextArea bookingShowWindow;
    JScrollPane scrollPane;
    File bookingFile;
    StringBuilder userBookings;
    String[] bookingDetails;
    JButton backBtn;

    public showBooking(String userName) {
        super("Show Details");
        this.userName = userName;
        this.setSize(800, 600);
        this.setIconImage(new ImageIcon("./Images/icon.png").getImage());
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        bookingShowWindow = new JTextArea();
        bookingShowWindow.setEditable(false);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);

        scrollPane = new JScrollPane(bookingShowWindow);
        scrollPane.setBounds(20, 20, 740, 400);
        panel.add(scrollPane);

        loadUserBookings();

        backBtn = new JButton("Back");
        backBtn.setLayout(null);
        backBtn.setBounds(330, 470, 150, 40);
        backBtn.setBackground(new Color(7, 39, 90));
        backBtn.setFont(new Font("Roboto", Font.BOLD, 18));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        panel.setVisible(true);
        this.add(panel);
        this.setResizable(false);
    }

    public void loadUserBookings() {
        bookingFile = new File("./Data/Booking.txt");

        boolean flag = true;
        if (bookingFile.exists() && bookingFile.canRead()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(bookingFile))) {
                int lineNum = 1;
                userBookings = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    if (line.contains(":")) {
                        bookingDetails = line.split(":");
                    }
                    else
                    {
                        bookingDetails = null;
                    }

                    if (bookingDetails != null && bookingDetails.length >= 1) {
                        String[] bookingInfo = bookingDetails[1].split(";");

                        if (bookingInfo.length > 0 && bookingInfo[0].equals(userName)) {
                            userBookings.append(bookingDetails[0]).append(": ").append(bookingDetails[1]+ " ").append("\n");
                            lineNum++;
                        }
                    }
                }
                if (userBookings.length() > 0) {
                    bookingShowWindow.setText(userBookings.toString());
                } else {
                    bookingShowWindow.setText("No Booking Found!");
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            bookingShowWindow.setText("No Booking Found!");
            flag = false;
            
        }
        

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backBtn) {
            this.setVisible(false);
            new Homepage(userName).setVisible(true);
        }
    }

}
