package Frames;

import Entities.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;

public class DeleteBooking extends JFrame{
    String userName;
    JPanel panel;
    JTextField bookingNumberFld;
    JButton deleteBtn, backBtn;
    JLabel lbl;
    Color color1, color2;
    Font font1;

    public DeleteBooking(String userName)
    {
        super("Delete Booking");
        this.userName = userName;
        this.setSize(400, 200);
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

        lbl = new JLabel("Enter Booking Number to Delete: ");
        bookingNumberFld = new JTextField();
        bookingNumberFld.setBounds(280, 20, 250, 50);
        this
    }
}