package Frames;

import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;

import Entities.bookingCounter;

public class Homepage extends JFrame implements ActionListener{
    String userName;
    JLabel user, HostelName, choose, BookingCounterLbl;
    JPanel topPanel, bottomPanel;
    JButton logOutBtn, editBtn, addBookingBtn, deleteBookingBtn, updateBookingBtn, showDetailsBtn;
    ImageIcon logOutIcon, addBookingIcon, deleteIcon, updateBookingIcon, showDetailsIcon;
    Color color1, color2;

    public Homepage(String userName) {
        super("User Dashboard");
        this.userName = userName;
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon("./Images/icon.png").getImage());

        color1 = new Color(7, 39, 90);
        color2 = new Color(210, 237, 255);
        
        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(0,0,800, 80);
        topPanel.setBackground(color1);

        HostelName = new JLabel("XYZ Hostel Dashboard");
        HostelName.setBounds(30, 10, 300, 50);
        HostelName.setForeground(Color.WHITE);
        HostelName.setFont(new Font("Roboto", Font.BOLD, 25));
        topPanel.add(HostelName);
        
        logOutIcon = new ImageIcon("./Images/logOutIcon.png");
        logOutBtn = new JButton(" Log Out", logOutIcon);
        logOutBtn.setBounds(630, 20, 130, 40);
        logOutBtn.setFont(new Font("Roboto", Font.BOLD, 15));
        logOutBtn.setForeground(color2);
        logOutBtn.setOpaque(false);
        logOutBtn.setBorderPainted(false);
        logOutBtn.setContentAreaFilled(false);
        logOutBtn.setFocusPainted(false);
        logOutBtn.addActionListener(this);
        topPanel.add(logOutBtn);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(null);
        bottomPanel.setBounds(0, 200, 400, 500);
        bottomPanel.setBackground(new Color(245, 249, 255));

        user = new JLabel("Welcome, " + userName);
        user.setBounds(30, 90, 300, 50);
        user.setFont(new Font("Roboto", Font.BOLD, 20));
        user.setBackground(Color.RED);
        user.setForeground(color1);
        bottomPanel.add(user);
        
        bookingCounter bkc = new bookingCounter();
        int bookingCnt = bkc.countLine();
        BookingCounterLbl = new JLabel("Booked Rooms: " + bookingCnt);
        BookingCounterLbl.setLayout(null);
        BookingCounterLbl.setOpaque(true);
        BookingCounterLbl.setBounds(620, 100, 150, 40);
        BookingCounterLbl.setHorizontalAlignment(SwingConstants.CENTER);
        BookingCounterLbl.setForeground(Color.WHITE);
        BookingCounterLbl.setBackground(new Color(253, 156, 63));
        BookingCounterLbl.setFont(new Font("Roboto", Font.BOLD, 15));
        bottomPanel.add(BookingCounterLbl);

        choose = new JLabel("Choose any option");
        choose.setBounds(300, 170, 300, 50);
        choose.setFont(new Font("Roboto", Font.BOLD, 20));
        choose.setForeground(color1);
        bottomPanel.add(choose);

        addBookingIcon = new ImageIcon("./Images/addIcon.png");
        addBookingBtn = new JButton("New Booking", addBookingIcon);
        addBookingBtn.setLayout(null);
        addBookingBtn.setBounds(150, 250, 220, 60);
        addBookingBtn.setForeground(color2);
        addBookingBtn.setBackground(color1);
        addBookingBtn.setFocusPainted(false);
        addBookingBtn.setFont(new Font("Roboto", Font.BOLD, 18));
        addBookingBtn.addActionListener(this);
        bottomPanel.add(addBookingBtn);        

        deleteIcon = new ImageIcon("./Images/deleteIcon.png");
        deleteBookingBtn = new JButton("Delete Booking", deleteIcon);
        deleteBookingBtn.setLayout(null);
        deleteBookingBtn.setBounds(150, 350, 220, 60);
        deleteBookingBtn.setForeground(color2);
        deleteBookingBtn.setBackground(color1);
        deleteBookingBtn.setFocusPainted(false);
        deleteBookingBtn.setFont(new Font("Roboto", Font.BOLD, 18));
        deleteBookingBtn.addActionListener(this);
        bottomPanel.add(deleteBookingBtn);

        updateBookingIcon = new ImageIcon("./Images/updatedBookingIcon.png");
        updateBookingBtn = new JButton("Update Booking", updateBookingIcon);
        updateBookingBtn.setLayout(null);
        updateBookingBtn.setBounds(450, 250, 220, 60);
        updateBookingBtn.setForeground(color2);
        updateBookingBtn.setBackground(color1);
        updateBookingBtn.setFocusPainted(false);
        updateBookingBtn.setFont(new Font("Roboto", Font.BOLD, 18));
        updateBookingBtn.addActionListener(this);
        bottomPanel.add(updateBookingBtn);

        showDetailsIcon = new ImageIcon("./Images/detailsIcon.png");
        showDetailsBtn = new JButton("Booking Details", showDetailsIcon);
        showDetailsBtn.setLayout(null);
        showDetailsBtn.setBounds(450, 350, 220, 60);
        showDetailsBtn.setForeground(color2);
        showDetailsBtn.setBackground(color1);
        showDetailsBtn.setFocusPainted(false);
        showDetailsBtn.setFont(new Font("Roboto", Font.BOLD, 18));
        showDetailsBtn.addActionListener(this);
        bottomPanel.add(showDetailsBtn);


        this.add(topPanel);
        this.add(bottomPanel);
        this.setResizable(false);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == logOutBtn)
        {
            this.setVisible(false);
            new SignIn().setVisible(true);
        }
        else if(ae.getSource() == addBookingBtn)
        {
            this.setVisible(false);
            new BookingForm(userName).setVisible(true);
        }
        else if(ae.getSource() == updateBookingBtn)
        {
            this.setVisible(false);
            new BookingForm(userName, true).setVisible(true);
        }
        else if(ae.getSource() == deleteBookingBtn)
        {
            this.setVisible(false);
            new DeleteBooking(userName).setVisible(true);
        }
        else if(ae.getSource() == showDetailsBtn)
        {
            this.setVisible(false);
            new showBooking(userName).setVisible(true);
        }
    }

            
}
