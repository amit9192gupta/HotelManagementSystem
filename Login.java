package Hotel.Management.System;


import java.awt.*;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class Login extends JFrame implements ActionListener{
	JTextField username;
	JPasswordField password;
	JButton login,cancel;
	Login(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel user=new JLabel("Username");
		user.setBounds(40,20,100,30);
		add(user);
		username=new JTextField();
		username.setBounds(110,20,130,30);
		add(username);
		
		JLabel pass=new JLabel("Password");
		pass.setBounds(40,60,100,30);
		add(pass);
	    password=new JPasswordField();
		password.setBounds(110,60,130,30);
		add(password);
		
		login=new JButton("Login");
		login.setBounds(45,120,80,25);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(150,120,80,25);
		cancel.setBackground(Color.BLACK);
	    cancel.setForeground(Color.WHITE);
	    cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(370,10,250,220);
		add(image);
		setBounds(500,200,600,300);
		setVisible(true);
	}

		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == login) {
				String user=username.getText();
				@SuppressWarnings("deprecation")
				String pass=password.getText();
				try {
					Conn c=new Conn();
					String query="select *from login where username='"+user+"' and password='"+pass+"'";
					ResultSet rs=c.s.executeQuery(query);
					if(rs.next()) {
						setVisible(false);
						new Dashboard();
						
					}else {
					
						JOptionPane.showMessageDialog(null, "invalid username or password","Failed",JOptionPane.WARNING_MESSAGE);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(ae.getSource() == cancel) {
			setVisible(false);
			}
	}
	

	public static void main(String[] args) {
	new	Login();
			
		

	}


	

}
