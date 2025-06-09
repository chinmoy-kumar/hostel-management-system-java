package Frames;

import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;

public class Homepage extends JFrame implements ActionListener{
    JLabel user, HostelName;
    JPanel topPanel, bottomPanel;
    JButton logOutBtn, editBtn;
    ImageIcon logOutIcon, editProfileIcon;
    Color color1, color2;

    public Homepage(String userName) {
        super("User Dashboard");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

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
        
        editProfileIcon = new ImageIcon("./Images/editProfileIcon.png");
        editBtn = new JButton("Edit Profile", editProfileIcon);
        editBtn.setLayout(null);
        editBtn.setBounds(630, 100, 130, 40);
        editBtn.setForeground(color2);
        editBtn.setBackground(color1);
        editBtn.setFont(new Font("Roboto", Font.BOLD, 13));
        editBtn.setFocusPainted(false);
        bottomPanel.add(editBtn);

        this.add(topPanel);
        this.add(bottomPanel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == logOutBtn)
        {
            this.setVisible(false);
            new SignIn().setVisible(true);
        }
    }

            
}
