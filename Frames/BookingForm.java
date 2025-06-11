package Frames;

import Entities.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;

public class BookingForm extends JFrame implements ActionListener
{
    String userName;
    JPanel panel;
    JRadioButton singleRoom, doubleRoom;
    JCheckBox wifiBox, acBox, fridgeBox;
    JButton bookNowBtn, backBtn;
    ButtonGroup roomGroup;
    Color color1, color2;
    Font font1, font2;

    public BookingForm(String userName)
    {
        super("Add Booking");
        this.userName = userName;
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

        JLabel title = new JLabel("Room Booking");
        title.setBounds(280, 20, 250, 50);
        title.setFont(new Font("Roboto", Font.BOLD, 32));
        title.setForeground(color1);
        panel.add(title);

        JLabel roomLabel = new JLabel("Choose Room Type");
        roomLabel.setBounds(30, 50, 150, 25);
        panel.add(roomLabel);

        singleRoom = new JRadioButton("Single Room");
        singleRoom.setBounds(180, 50, 120, 25);
        singleRoom.setBackground(color2);
        doubleRoom = new JRadioButton("Double Room");
        doubleRoom.setBounds(180, 80, 120, 25);
        doubleRoom.setBackground(color2);

        roomGroup = new ButtonGroup();
        roomGroup.add(singleRoom);
        singleRoom.setBackground(color2);
        roomGroup.add(doubleRoom);
        panel.add(singleRoom);
        panel.add(doubleRoom);

        JLabel facilitiesLabel = new JLabel("Facilities (choose any)");
        facilitiesLabel.setBounds(30, 120, 150, 25);
        panel.add(facilitiesLabel);

        wifiBox = new JCheckBox("Wi-Fi");
        wifiBox.setBounds(180, 120, 100, 25);
        wifiBox.setBackground(color2);
        acBox = new JCheckBox("AC");
        acBox.setBounds(180, 150, 100, 25);
        acBox.setBackground(color2);
        fridgeBox = new JCheckBox("Fridge");
        fridgeBox.setBounds(180, 180, 100, 25);
        fridgeBox.setBackground(color2);

        panel.add(wifiBox);
        panel.add(acBox);
        panel.add(fridgeBox);

        bookNowBtn = new JButton("Book Now!");
        bookNowBtn.setBounds(70, 230, 100, 30);
        bookNowBtn.addActionListener(this);
        panel.add(bookNowBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(210, 230, 100, 30);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == bookNowBtn)
        {
            String roomType = "";
            if(singleRoom.isSelected())
            {
                roomType = "Single Room";
            }
            else if(doubleRoom.isSelected())
            {
                roomType = "Double Room";
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please select a room type");
                return;
            }
            
            ArrayList<String> facilities = new ArrayList<>();
            
            if(wifiBox.isSelected())
            {
                facilities.add("Wi-Fi");
            }
            if(acBox.isSelected())
            {
                facilities.add("AC");
            }
            if(fridgeBox.isSelected())
            {
                facilities.add("Fridge");
            }
            
            String facilitiesStr = String.join(", ", facilities);
            
            String bookingData = userName + ";" + roomType + ";" + facilitiesStr;

            saveBooking sb = new saveBooking(bookingData);
            sb.saveBookingInfo();

            JOptionPane.showMessageDialog(this, "Booking Successful!");
            this.setVisible(false);
            new Homepage(userName).setVisible(true);

        }
        else if(ae.getSource() == backBtn)
        {
            this.setVisible(false);
            new Homepage(userName).setVisible(true);
        }
    }
    
}