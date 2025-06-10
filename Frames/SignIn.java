package Frames;

import Entities.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;

public class SignIn extends JFrame implements MouseListener, ActionListener {
	JLabel namelbl, passlbl, imagelbl, titleLbl, subTitleLbl, signUplbl, messageLbl, userIconLbl;
	JTextField namefld;
	JPasswordField passfld;
	JButton signInbtn, exitbtn, signUpbtn, eyeBtn;
	Color mycolor, lblcolor;
	Font myfont1, myfont2, myfont3, myfont4;
	ImageIcon img1, img2, img3, showIcon, hideIcon, userIcon;
	JPanel leftPanel, rightPanel;
	boolean isPasswordVisible = false;

	public SignIn() {
		super("XYZ Hostel");
		this.setSize(800, 600);
		this.setIconImage(new ImageIcon("./Images/icon.png").getImage());
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		mycolor = new Color(245, 249, 255);
		lblcolor = new Color(0, 0, 255);

		myfont1 = new Font("Roboto", Font.BOLD, 15);
		myfont2 = new Font("Roboto", Font.PLAIN, 15);
		myfont3 = new Font("Roboto", Font.PLAIN, 18);
		myfont4 = new Font("Roboto", Font.BOLD, 42);

		leftPanel = new JPanel();
		leftPanel.setLayout(null);
		leftPanel.setBounds(0, 0, 400, 600);
		ImageIcon img2 = new ImageIcon("./Images/signIn.png");
		imagelbl = new JLabel(img2);
		imagelbl.setBounds(0, 0, 400, 600);
		leftPanel.add(imagelbl);

		rightPanel = new JPanel();
		rightPanel.setLayout(null);
		rightPanel.setBounds(400, 0, 400, 600);
		rightPanel.setBackground(mycolor);

		titleLbl = new JLabel("XYZ Hostel");
		titleLbl.setBounds(80, 40, 300, 50);
		titleLbl.setFont(myfont4);
		titleLbl.setForeground(new Color(65, 96, 193));
		rightPanel.add(titleLbl);

		subTitleLbl = new JLabel("Login to your account");
		subTitleLbl.setBounds(110, 100, 300, 30);
		subTitleLbl.setFont(myfont3);
		subTitleLbl.setForeground(Color.BLACK);
		rightPanel.add(subTitleLbl);

		namelbl = new JLabel("Username: ");
		namelbl.setBounds(60, 140, 120, 40);
		namelbl.setForeground(new Color(65, 96, 193));
		namelbl.setFont(myfont1);
		rightPanel.add(namelbl);

		namefld = new JTextField();
		namefld.setBounds(60, 180, 250, 30);
		namefld.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		namefld.setFont(myfont1);
		rightPanel.add(namefld);

		passlbl = new JLabel("Password: ");
		passlbl.setBounds(60, 210, 150, 50);
		passlbl.setForeground(new Color(65, 96, 193));
		passlbl.setFont(myfont1);
		rightPanel.add(passlbl);

		passfld = new JPasswordField();
		passfld.setBounds(60, 250, 250, 30);
		passfld.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		passfld.setEchoChar('*');
		passfld.setFont(myfont1);
		rightPanel.add(passfld);

		userIcon = new ImageIcon("./Images/userIcon.png");
		showIcon = new ImageIcon("./Images/icon3.png");
		hideIcon = new ImageIcon("./Images/icon2.png");

		userIconLbl = new JLabel(userIcon);
		userIconLbl.setBounds(330, 180, 26, 26);
		rightPanel.add(userIconLbl);

		eyeBtn = new JButton(hideIcon);
		eyeBtn.setBounds(330, 250, 30, 30);
		eyeBtn.setFocusable(false);
		eyeBtn.setBorder(null);
		eyeBtn.setBackground(Color.GRAY);
		eyeBtn.addActionListener(this);
		rightPanel.add(eyeBtn);

		signInbtn = new JButton("Sign in");
		signInbtn.setBounds(60, 320, 120, 40);
		signInbtn.setBackground(new Color(58, 122, 204));
		signInbtn.setFont(myfont1);
		signInbtn.setForeground(Color.WHITE);
		signInbtn.addMouseListener(this);
		signInbtn.addActionListener(this);
		rightPanel.add(signInbtn);

		exitbtn = new JButton("Exit");
		exitbtn.setBounds(230, 320, 120, 40);
		exitbtn.setFont(myfont1);
		exitbtn.setBackground(new Color(244, 114, 118));
		exitbtn.setForeground(Color.WHITE);
		exitbtn.addMouseListener(this);
		exitbtn.addActionListener(this);
		rightPanel.add(exitbtn);

		signUplbl = new JLabel("Don't have an account? Sign up now! ");
		signUplbl.setBounds(80, 380, 350, 40);
		signUplbl.setFont(myfont2);
		signUplbl.setForeground(Color.GRAY);
		rightPanel.add(signUplbl);

		signUpbtn = new JButton("Sign up");
		signUpbtn.setBounds(60, 430, 290, 40);
		signUpbtn.setFont(myfont1);
		signUpbtn.setForeground(Color.WHITE);
		signUpbtn.setBackground(new Color(46, 186, 136));
		signUpbtn.addMouseListener(this);
		signUpbtn.addActionListener(this);
		rightPanel.add(signUpbtn);

		messageLbl = new JLabel("");
		messageLbl.setBounds(100, 220, 300, 30);
		messageLbl.setForeground(Color.RED);
		rightPanel.add(messageLbl);

		this.setResizable(false);
		this.add(leftPanel);
		this.add(rightPanel);

	}

	public void mouseClicked(MouseEvent me) {
	}

	public void mousePressed(MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {
		if (me.getSource() == signInbtn) {
			signInbtn.setBackground(new Color(59, 100, 190));
			signInbtn.setForeground(Color.WHITE);
		} else if (me.getSource() == signUpbtn) {
			signUpbtn.setBackground(new Color(31, 139, 78));
			signUpbtn.setForeground(Color.WHITE);
		} else if (me.getSource() == exitbtn) {
			exitbtn.setBackground(new Color(189, 60, 57));
			exitbtn.setForeground(Color.WHITE);
		}
	}

	public void mouseExited(MouseEvent me) {
		if (me.getSource() == signInbtn) {
			signInbtn.setBackground(new Color(58, 122, 204));
			signInbtn.setForeground(Color.WHITE);
		} 
		else if (me.getSource() == signUpbtn) {
			signUpbtn.setBackground(new Color(46, 186, 136));
			signUpbtn.setForeground(Color.WHITE);
		} 
		else if (me.getSource() == exitbtn) {
			exitbtn.setBackground(new Color(244, 114, 118));
			exitbtn.setForeground(Color.WHITE);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		String uname = namefld.getText();
		String upass = passfld.getText();

		if (ae.getSource() == signInbtn) {

			if (uname.equals("") || upass.equals("")) {

				JOptionPane.showMessageDialog(this, "Please enter username and password");
			} 
			else {
				Data d1 = new Data();
				if (d1.getData(uname, upass) == true) {
					this.setVisible(false);
					Homepage h1 = new Homepage(uname);
					h1.setVisible(true);
				} 
				else {
					JOptionPane.showMessageDialog(this, "Invalid username or password");
				}
			}
		} 
		else if (ae.getSource() == signUpbtn) {
			this.setVisible(false);
			SignUp r1 = new SignUp();
			r1.setVisible(false);
		} 
		else if (ae.getSource() == exitbtn) {
			this.setVisible(false);
		} 
		if (passfld.getEchoChar() == '\u0000')
		{
        	passfld.setEchoChar('*');
        	eyeBtn.setIcon(hideIcon);
    	}
		else {
        	passfld.setEchoChar('\u0000');
       		eyeBtn.setIcon(showIcon);
    	}

	}

}
