package Frames;

import Entities.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class BookingForm extends JFrame implements ActionListener {
    String userName, facilitiesStr;
    JPanel panel;
    JLabel title, roomLabel, facilitiesLabel;
    JRadioButton singleRoom, doubleRoom;
    JCheckBox wifiBox, acBox, fridgeBox;
    JButton bookNowBtn, backBtn;
    ButtonGroup roomGroup;
    Color color1, color2;
    Font font1, font2;
    boolean isUpdateMode = false;

    public BookingForm(String userName) {
        this(userName, false);
    }

    public BookingForm(String userName, boolean updateMode) {
        super(updateMode ? "Update Booking" : "Add Booking");
        this.userName = userName;
        this.isUpdateMode =  updateMode;
        this.setSize(800, 600);
        this.setIconImage(new ImageIcon("./Images/icon.png").getImage());
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        color1 = new Color(7, 39, 90);
        color2 = new Color(210, 237, 255);

        font1 = new Font("Roboto", Font.BOLD, 20);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color2);
        panel.setSize(800, 600);

        title = new JLabel("Room Booking");
        title.setBounds(280, 20, 250, 50);
        title.setFont(new Font("Roboto", Font.BOLD, 32));
        title.setForeground(color1);
        panel.add(title);

        roomLabel = new JLabel("Choose Room Type");
        roomLabel.setBounds(290, 80, 180, 25);
        roomLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        panel.add(roomLabel);

        singleRoom = new JRadioButton("Single Room");
        singleRoom.setBounds(360, 120, 120, 25);
        singleRoom.setFont(new Font("Roboto", Font.PLAIN, 15));
        singleRoom.setBackground(color2);
        singleRoom.setFocusPainted(false);
        doubleRoom = new JRadioButton("Double Room");
        doubleRoom.setBounds(360, 150, 120, 25);
        doubleRoom.setFont(new Font("Roboto", Font.PLAIN, 15));
        doubleRoom.setBackground(color2);
        doubleRoom.setFocusPainted(false);

        roomGroup = new ButtonGroup();
        roomGroup.add(singleRoom);
        singleRoom.setBackground(color2);
        roomGroup.add(doubleRoom);
        panel.add(singleRoom);
        panel.add(doubleRoom);

        facilitiesLabel = new JLabel("Facilities (choose any)");
        facilitiesLabel.setBounds(290, 190, 200, 25);
        facilitiesLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        panel.add(facilitiesLabel);

        wifiBox = new JCheckBox("Wi-Fi");
        wifiBox.setBounds(360, 220, 100, 25);
        wifiBox.setFont(new Font("Roboto", Font.PLAIN, 15));
        wifiBox.setBackground(color2);
        acBox = new JCheckBox("AC");
        acBox.setBounds(360, 250, 100, 25);
        acBox.setFont(new Font("Roboto", Font.PLAIN, 15));
        acBox.setBackground(color2);
        fridgeBox = new JCheckBox("Fridge");
        fridgeBox.setBounds(360, 280, 100, 25);
        fridgeBox.setFont(new Font("Roboto", Font.PLAIN, 15));
        fridgeBox.setBackground(color2);

        panel.add(wifiBox);
        panel.add(acBox);
        panel.add(fridgeBox);

        if (isUpdateMode) {
            loadExistingBooking();
        }

        bookNowBtn = new JButton(updateMode ? "Update" : "Book Now");
        bookNowBtn.setBounds(250, 340, 150, 40);
        bookNowBtn.setBackground(new Color(46, 186, 136));
        bookNowBtn.setFont(new Font("Roboto", Font.BOLD, 15));
        bookNowBtn.setForeground(Color.WHITE);
        bookNowBtn.addActionListener(this);
        panel.add(bookNowBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(420, 340, 150, 40);
        backBtn.setBackground(new Color(244, 114, 118));
        backBtn.setFont(new Font("Roboto", Font.BOLD, 15));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        this.add(panel);
        this.setResizable(false);
    }

    public void loadExistingBooking() {
        try {
            File f1 = new File("Booking.txt");
            Scanner sc = new Scanner(f1);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(";");
                if (parts.length > 2) {
                    if (parts[1].equals("Single Room")) {
                        singleRoom.setSelected(true);
                    } else if (parts[1].equals("Double Room")) {
                        doubleRoom.setSelected(true);
                    }
                }

                String facilities = parts[2];
                if (parts.length > 2) {
                    if (facilities.contains("Wi-Fi"))
                        wifiBox.setSelected(true);
                    if (facilities.contains("AC"))
                        acBox.setSelected(true);
                    if (facilities.contains("Fridge"))
                        fridgeBox.setSelected(true);
                }

                break;
            }
            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bookNowBtn) {
            String roomType = "";
            if (singleRoom.isSelected()) {
                roomType = "Single Room";
            } else if (doubleRoom.isSelected()) {
                roomType = "Double Room";
            } else {
                JOptionPane.showMessageDialog(this, "Please select a room type");
                return;
            }

            ArrayList<String> facilities = new ArrayList<>();

            if (wifiBox.isSelected()) {
                facilities.add("Wi-Fi");
            }
            if (acBox.isSelected()) {
                facilities.add("AC");
            }
            if (fridgeBox.isSelected()) {
                facilities.add("Fridge");
            }

            facilitiesStr = String.join(", ", facilities).trim();

            String bookingDetails = userName + ";" + roomType + ";" + facilitiesStr;

            if (isUpdateMode == true) {
                updateBooking ub = new updateBooking(bookingDetails, userName);
                JOptionPane.showMessageDialog(this, "Booking Update Successfully");
            } else {
                saveBooking sb = new saveBooking(bookingDetails);
                sb.saveBookingInfo();
                JOptionPane.showMessageDialog(this, "Booking Successful!");
            }

            this.setVisible(false);
            new Homepage(userName).setVisible(true);

        } else if (ae.getSource() == backBtn) {
            this.setVisible(false);
            new Homepage(userName).setVisible(true);
        }
        
    }
}