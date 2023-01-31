package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener{
	Choice ccustomer;
	JTextField tfroom,tfname,tfcheckin,tfdeposite,tfpending;
	JButton check,update,back;
	
	public UpdateCheck() {
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel text=new JLabel("Update Status");
		text.setFont(new Font("Tahoma",Font.PLAIN,20));
		text.setForeground(Color.black);
		text.setBounds(100,20,200,30);
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
		lblroom.setBounds(30,120,150,20);
		add(lblroom);
		tfroom=new JTextField();
		tfroom.setBounds(180,120,150,25);	
		add(tfroom);
		
		JLabel lblname=new JLabel("Name");
		lblname.setBounds(30,160,150,20);
		add(lblname);
		
		tfname=new JTextField();
		tfname.setBounds(180,160,150,25);	
		add(tfname);
		
		JLabel lblchenkim=new JLabel("Checkin Time");
		lblchenkim.setBounds(30,200,150,20);
		add(lblchenkim);
		
		tfcheckin=new JTextField();
		tfcheckin.setBounds(180,200,150,25);	
		add(tfcheckin);
		
		JLabel lbldeposite=new JLabel("Amount Paid");
		lbldeposite.setBounds(30,240,150,20);
		add(lbldeposite);
		
		tfdeposite=new JTextField();
		tfdeposite.setBounds(180,240,150,25);	
		add(tfdeposite);
		
		JLabel lblpending=new JLabel("Pending Amount");
		lblpending.setBounds(30,280,150,20);
		add(lblpending);
		
		tfpending=new JTextField();
		tfpending.setBounds(180,280,150,25);	
		add(tfpending);
		
		check=new JButton("Check");
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		check.setBounds(20,350,100,25);
		check.addActionListener(this);
		add(check);
		update=new JButton("Update");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		update.setBounds(150,350,100,25);
		add(update);
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(280,350,100,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		JLabel image=new JLabel(i1);
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
				  tfname.setText(rs.getString("name"));
				  tfcheckin.setText(rs.getString("date"));
				  tfdeposite.setText(rs.getString("deposite"));
				  }
			  ResultSet rs2=con.s.executeQuery("select *from room where roomno='"+tfroom.getText()+"' ");
			  while(rs2.next()) {
				  String price=rs2.getString("price");
				  int amountPaid=Integer.parseInt(price)-Integer.parseInt(tfdeposite.getText());
				  tfpending.setText("" +amountPaid);
			  }
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
				
			
			
		}else if(ae.getSource()==update) {
			String number=ccustomer.getSelectedItem();
			String room =tfroom.getText();
			String name=tfname.getText();
			String checkin=tfcheckin.getText();
			String deposite=tfdeposite.getText();
			try {
				Conn c=new Conn();
				c.s.executeUpdate("update customer set room='"+room+"',name='"+name+"',date='"+checkin+"',deposite='"+deposite+"'where number='"+number+"'");
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
		new UpdateCheck();

	}

}
