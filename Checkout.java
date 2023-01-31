package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
	Choice customer;
	JLabel lblroomnumber,lblcheckouttime,lblcheckintime;
	JButton checkout,back;
public Checkout() {
	setBounds(300,200,800,400);
	setLayout(null);
	getContentPane().setBackground(Color.white);
	JLabel  text=new JLabel("Check Out ");
	text.setBounds(100,20,300,30);
	text.setForeground(Color.RED);
	text.setFont(new Font("Tohoma",Font.PLAIN,20));
    add(text);
    
    JLabel lblid=new JLabel("Customer id ");
    lblid.setBounds(30,80,100,30);
    add(lblid);
	customer =new Choice();
	customer.setBounds(150,80,150,25);
	add(customer);

	ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
	Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i2);
	JLabel image=new JLabel (i3);
	image.setBounds(304,80,20,20);
	add(image);
	
	 JLabel lblroom=new JLabel("Room Number");
	 lblroom.setBounds(30,130,100,30);
	 add(lblroom);
	 
	 lblroomnumber=new JLabel();
	 lblroomnumber.setBounds(150,130,100,30);
	 add(lblroomnumber);
	
	 JLabel lblcheckin=new JLabel("Checkin Time");
	 lblcheckin.setBounds(30,180,100,30);
	 add(lblcheckin);
	 
	 lblcheckintime=new JLabel();
	 lblcheckintime.setBounds(150,180,150,30);
	 add(lblcheckintime);
	 
	 JLabel lblcheckout=new JLabel("Checkout Time");
	 lblcheckout.setBounds(30,230,100,30);
	 add(lblcheckout);
	 
	 Date date=new Date();
	 lblcheckouttime=new JLabel(""+date);
	 lblcheckouttime.setBounds(150,230,150,30);
	 add(lblcheckouttime);
	 
	 checkout =new JButton("Check Out");
	 checkout.setBackground(Color.black);
	 checkout.setForeground(Color.white);
	 checkout.setBounds(30,280,120,30);
	 checkout.addActionListener(this);
	 add(checkout);
	 
	 back =new JButton("Back");
	 back.setBackground(Color.black);
	 back.setForeground(Color.white);
	 back.setBounds(180,280,120,30);
	 back.addActionListener(this);
	 add(back);
	 
		try {
			Conn c=new Conn();
			 ResultSet rs=c.s.executeQuery("select * from customer ");
			while(rs.next()) {
				customer.add(rs.getString("number"));
				lblroomnumber.setText(rs.getString("room"));
				lblcheckintime.setText(rs.getString("date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	 
	 ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		Image i5=i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel image2=new JLabel (i6);
		image2.setBounds(354,50,400,300);
		add(image2);
	
	
	
	setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==checkout) {
		String query="delete from customer  where number='"+customer.getSelectedItem()+"' ";
		String query2="update room set availability='Available' where roomno='"+lblroomnumber.getText()+"'";
		try {
			Conn c=new Conn();
			c.s.executeUpdate(query);
			c.s.executeUpdate(query2);
			
			JOptionPane.showMessageDialog(null,"Checkout done");
			setVisible(false);
			new Reception();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}else if(ae.getSource()==back) {
		setVisible(false);
		new Reception();
	}
}
	public static void main(String[] args) {
		new Checkout();

	}

}
