package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.*;

public class UpdateRoom extends JFrame implements ActionListener{
	Choice ccustomer;
	JTextField tfroom,tfavailable,tfstatus;
	JButton check,update,back;
	
	public UpdateRoom() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text=new JLabel("Update Room Status");
		text.setFont(new Font("Tahoma",Font.PLAIN,25));
		text.setForeground(Color.black);
		text.setBounds(30,20,250,30);
		add(text);
		
		JLabel lblid=new JLabel("Customer id");
		lblid.setBounds(30,80,150,20);
		add(lblid);
		
		ccustomer =new Choice();
		ccustomer.setBounds(180,80,150,25);
		add(ccustomer);
		try {
			Conn c=new Conn();
			 ResultSet rs=c.s.executeQuery("select * from customer ");
			while(rs.next()) {
				ccustomer.add(rs.getString("number"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		JLabel lblroom=new JLabel("Room no");
		lblroom.setBounds(30,130,150,20);
		add(lblroom);
		tfroom=new JTextField();
		tfroom.setBounds(180,130,150,25);	
		add(tfroom);
		
		JLabel lblavailable=new JLabel("Availibility");
		lblavailable.setBounds(30,180,150,20);
		add(lblavailable);
		
		tfavailable=new JTextField();
		tfavailable.setBounds(180,180,150,25);	
		add(tfavailable);
		
		JLabel lblclean=new JLabel("Cleaning Status");
		lblclean.setBounds(30,230,150,20);
		add(lblclean);
		
		tfstatus=new JTextField();
		tfstatus.setBounds(180,230,150,25);	
		add(tfstatus);
		
		
		check=new JButton("Check");
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.setBounds(20,300,100,25);
		check.addActionListener(this);
		add(check);
		update=new JButton("Update");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		update.setBounds(150,300,100,25);
		add(update);
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(280,300,100,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
		Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(300,20,800,400);
		add(image);

		setBounds(350,220,1000,500);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==check) {
			String id=ccustomer.getSelectedItem();
			String query="select * from customer where number='"+id+"'";
			try {
				Conn con=new Conn();
			  ResultSet rs=con.s.executeQuery(query);
			  while(rs.next()) {
				  tfroom.setText(rs.getString("room"));
			  
				  
				  }
			  ResultSet rs2=con.s.executeQuery("select *from room where roomno='"+tfroom.getText()+"' ");
			  while(rs2.next()) {
				 tfavailable.setText(rs2.getString("availability"));
				 tfstatus.setText(rs2.getString("cleaning_status"));
				 
			  }
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
				
			
			
		}else if(ae.getSource()==update) {
			String number=ccustomer.getSelectedItem();
			String room =tfroom.getText();
			String available=tfavailable.getText();
			String status=tfstatus.getText();
			try {
				Conn c=new Conn();
				c.s.executeUpdate("update room set availability='"+available+"',cleaning_Status='"+status+"'where roomno ='"+room+"'");  ;
				JOptionPane.showConfirmDialog(null, "Data Updated successfully");
				setVisible(false);
				
				new Reception();
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(ae.getSource()==back) {
			new   Reception();
			setVisible(false);
		}
		
		
	}


	public static void main(String[] args) {
		new UpdateRoom();

	}

}
