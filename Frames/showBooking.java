package Frames;

import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import Entities.*;

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

    }

    public void loadUserBookings() {
        bookingFile = new File("./Booking.txt");
        if (bookingFile.exists() && bookingFile.canRead()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(bookingFile))) {
                userBookings = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    bookingDetails = line.split(";");
                    if (bookingDetails.length >= 3 && bookingDetails[0].equals(userName)) {
                        userBookings.append("Room: ").append(bookingDetails[1]).append("| Facilities: ")
                                .append(bookingDetails[2]).append("\n");
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
        }

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == backBtn)
        {
            this.setVisible(false);
            new Homepage(userName).setVisible(true);
        }
    }

}
