package Frames;

import Entities.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;

public class DeleteBooking extends JFrame implements ActionListener{
    String userName;
    JPanel panel;
    JTextField bookingNumberFld;
    JButton deleteBtn, backBtn;
    JLabel lbl1, lbl2;
    Color color1, color2;
    Font font1, font2;

    public DeleteBooking(String userName) {
        super("Delete Booking");
        this.userName = userName;
        this.setSize(800, 600);
        this.setIconImage(new ImageIcon("./Images/icon.png").getImage());
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        color1 = new Color(7, 39, 90);
        color2 = new Color(210, 237, 255);

        font1 = new Font("Roboto", Font.BOLD, 24);
        font2 = new Font("Roboto", Font.BOLD, 16);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color2);
        panel.setSize(800, 600);

        lbl1 = new JLabel("Delete Room Booking");
        lbl1.setBounds(265, 20, 250, 50);
        lbl1.setFont(font1);
        panel.add(lbl1);

        lbl2 = new JLabel("Enter booking Number: ");
        lbl2.setBounds(180, 130, 250, 50);
        lbl2.setFont(font2);
        panel.add(lbl2);

        bookingNumberFld = new JTextField();
        bookingNumberFld.setBounds(390, 130, 200, 40);
        bookingNumberFld.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        panel.add(bookingNumberFld);

        deleteBtn = new JButton("Delete Booking");
        deleteBtn.setBounds(220, 250, 160, 50);
        deleteBtn.setBackground(new Color(244, 114, 118));
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.setFont(font2);
        deleteBtn.addActionListener(this);
        panel.add(deleteBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(410, 250, 160, 50);
        backBtn.setBackground(color1);
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(font2);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deleteBtn) {

        }
        if (ae.getSource() == backBtn) {
            this.setVisible(false);
            new Homepage(userName).setVisible(true);
        }
    }

}