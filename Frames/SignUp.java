package Frames;

import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import Entities.*;

public class SignUp extends JFrame implements ActionListener {
    JLabel namelbl, passlbl, imagelbl, titleLbl, contactlbl, addresslbl, varsitylbl, doblbl, gNamelbl, gContactlbl,
            genderlbl, bloodlbl, userIconLbl;
    JTextField nameField, contactField, addressField, varsityField, dobfld, gNameField, gContactField;
    JPasswordField passwordField;
    JButton registerBtn, backBtn, eyeBtn;
    Color mycolor1, lblcolor1;
    Font mfont1, mfont2, mfont3;
    ImageIcon img3,showIcon, hideIcon;
    JRadioButton r1, r2;
    JComboBox combo;
    JPanel leftPanel, rightPanel;
    ButtonGroup genderGroup;

    public SignUp() {
        super("Sign up");
        this.setSize(800, 600);
        this.setIconImage(new ImageIcon("./Images/icon.png").getImage());
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        mycolor1 = new Color(245, 249, 255);
        lblcolor1 = new Color(0, 0, 255);

        mfont1 = new Font("Roboto", Font.BOLD, 13);
        mfont2 = new Font("Roboto", Font.BOLD, 28);
        mfont3 = new Font("Roboto", Font.BOLD, 12);
        leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(0, 0, 400, 600);
        img3 = new ImageIcon("./Images/signUp.png");
        imagelbl = new JLabel(img3);
        imagelbl.setBounds(0, 0, 400, 600);
        leftPanel.add(imagelbl);

        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(400, 0, 400, 600);
        rightPanel.setBackground(mycolor1);

        titleLbl = new JLabel("Sign up now!");
        titleLbl.setBounds(100, 10, 250, 40);
        titleLbl.setFont(mfont2);
        titleLbl.setForeground(new Color(65, 96, 193));
        rightPanel.add(titleLbl);

        namelbl = new JLabel("Name:");
        namelbl.setBounds(30, 60, 100, 30);
        namelbl.setFont(mfont1);
        rightPanel.add(namelbl);

        nameField = new JTextField();
        nameField.setBounds(150, 60, 200, 30);
		nameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        nameField.setFont(mfont1);
        rightPanel.add(nameField);

        doblbl = new JLabel("DOB:");
        doblbl.setBounds(30, 100, 100, 30);
        doblbl.setFont(mfont1);
        rightPanel.add(doblbl);

        dobfld = new JTextField();
        dobfld.setBounds(150, 100, 200, 30);
		dobfld.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        dobfld.setFont(mfont1);
        rightPanel.add(dobfld);

        genderlbl = new JLabel("Gender:");
        genderlbl.setBounds(30, 140, 100, 30);
        genderlbl.setFont(mfont1);
        rightPanel.add(genderlbl);

        r1 = new JRadioButton("Male");
        r1.setBounds(150, 140, 70, 30);
        r1.setBackground(mycolor1);
        rightPanel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(230, 140, 100, 30);
        r2.setBackground(mycolor1);
        rightPanel.add(r2);

        genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        bloodlbl = new JLabel("Blood group:");
        bloodlbl.setBounds(30, 180, 100, 30);
        bloodlbl.setFont(mfont1);
        rightPanel.add(bloodlbl);

        String items[] = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        combo = new JComboBox(items);
        combo.setBounds(150, 180, 200, 30);
        rightPanel.add(combo);

        contactlbl = new JLabel("Contact:");
        contactlbl.setBounds(30, 220, 100, 30);
        contactlbl.setFont(mfont1);
        rightPanel.add(contactlbl);

        contactField = new JTextField();
        contactField.setBounds(150, 220, 200, 30);
		contactField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        contactField.setFont(mfont1);
        rightPanel.add(contactField);

        addresslbl = new JLabel("Address:");
        addresslbl.setBounds(30, 260, 100, 30);
        addresslbl.setFont(mfont1);
        rightPanel.add(addresslbl);

        addressField = new JTextField();
        addressField.setBounds(150, 260, 200, 30);
		addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        addressField.setFont(mfont1);
        rightPanel.add(addressField);

        varsitylbl = new JLabel("Institution:");
        varsitylbl.setBounds(30, 300, 100, 30);
        varsitylbl.setFont(mfont1);
        rightPanel.add(varsitylbl);

        varsityField = new JTextField();
        varsityField.setBounds(150, 300, 200, 30);
		varsityField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        varsityField.setFont(mfont1);
        rightPanel.add(varsityField);

        passlbl = new JLabel("Password:");
        passlbl.setBounds(30, 340, 100, 30);
        passlbl.setFont(mfont1);
        rightPanel.add(passlbl);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 340, 200, 30);
		passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        passwordField.setFont(mfont1);
        passwordField.setEchoChar('*');
        rightPanel.add(passwordField);
		
		
		showIcon = new ImageIcon("./Images/icon3.png");
		hideIcon = new ImageIcon("./Images/icon2.png");

		
		eyeBtn = new JButton(hideIcon);
		eyeBtn.setBounds(360, 340, 20, 30);
		eyeBtn.setFocusable(false);
		eyeBtn.setBorder(null);
		eyeBtn.setBackground(Color.GRAY);
		eyeBtn.addActionListener(this);
		rightPanel.add(eyeBtn);

        gNamelbl = new JLabel("Guardian Name:");
        gNamelbl.setBounds(30, 380, 120, 30);
        gNamelbl.setFont(mfont1);
        rightPanel.add(gNamelbl);

        gNameField = new JTextField();
        gNameField.setBounds(150, 380, 200, 30);
		gNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        gNameField.setFont(mfont1);
        rightPanel.add(gNameField);

        gContactlbl = new JLabel("Guardian Contact:");
        gContactlbl.setBounds(30, 420, 130, 30);
        gContactlbl.setFont(mfont1);
        rightPanel.add(gContactlbl);
        
        gContactField = new JTextField();
        gContactField.setBounds(150, 420, 200, 30);
		gContactField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        gContactField.setFont(mfont1);
        rightPanel.add(gContactField);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(50, 480, 130, 40);
        registerBtn.setBackground(new Color(46, 186, 136));
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFont(mfont1);
        registerBtn.addActionListener(this);
        rightPanel.add(registerBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 480, 130, 40);
        backBtn.setBackground(new Color(244, 114, 118));
        backBtn.setForeground(Color.WHITE);
        backBtn.setFont(mfont1);
        backBtn.addActionListener(this);
        rightPanel.add(backBtn);

        this.setResizable(true);
        this.add(leftPanel);
        this.add(rightPanel);
    }

    public void actionPerformed(ActionEvent ae) {
        String uname = nameField.getText();
		String upass =passwordField.getText();
        String contact = contactField.getText();
        String address = addressField.getText();
        String varsity = varsityField.getText();
        String dob = dobfld.getText();
        String gname = gNameField.getText();
        String gcontact = gContactField.getText();
		String blood = (String )combo.getSelectedItem();
        String gender  = " ";
        if (r1.isSelected()){
	      gender= "Male";
	     }
		else if (r2.isSelected()) 
		{ 
		gender =" Female"; 
		}
		
        if (ae.getSource() == backBtn) {
            this.setVisible(false);
            new SignIn().setVisible(true);
        } else if (ae.getSource() == registerBtn) {
            if(uname.isEmpty()|| upass.isEmpty() || contact.isEmpty() || address.isEmpty() 
				|| varsity.isEmpty() || dob.isEmpty()|| blood.isEmpty()
                || gender.isEmpty() || gname.isEmpty() || gcontact.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill up all!");
            }
            else
            {
                Data d1 = new Data(uname, upass, dob, gender, blood, contact, address, varsity, gname, gcontact);
                d1.addLoginData();
				d1.addFullRegData();
                JOptionPane.showMessageDialog(null, "Registration is successfull");
                this.setVisible(false);
                new SignIn().setVisible(true);
            }
        }
		if (passwordField.getEchoChar() == '\u0000')
		{
        	passwordField.setEchoChar('*');
        	eyeBtn.setIcon(hideIcon);
    	}
		else {
        	passwordField.setEchoChar('\u0000');
       		eyeBtn.setIcon(showIcon);
    	}
    }


}
