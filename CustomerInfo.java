package Hotel.Management.System;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
	JTable table;
	JButton back,Back;
	CustomerInfo(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
		JLabel l1=new JLabel("Id");
		l1.setBounds(10,20,100,30);
		add(l1);
		JLabel l2=new JLabel("Number");
		l2.setBounds(140,20,100,30);
		add(l2);
		JLabel l3=new JLabel("Name");
		l3.setBounds(300,20,100,30);
		add(l3);
		JLabel l4=new JLabel("Gender");
		l4.setBounds(450,20,100,30);
		add(l4);
		JLabel l5=new JLabel("City");
		l5.setBounds(560,20,100,30);
		add(l5);
		JLabel l6=new JLabel("Room");
		l6.setBounds(670,20,100,30);
		add(l6);
		JLabel l7=new JLabel("Date");
		l7.setBounds(770,20,100,30);
		add(l7);
		JLabel l8=new JLabel("Deposite");
		l8.setBounds(900,20,100,30);
		add(l8);
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBounds(300,400,100,30);
		add(back);
		
	
		
		
		table=new JTable();
		table.setBounds(0,50,1000,650);
		add(table);
		
		try {
			Conn c=new Conn();
			ResultSet rs= c.s.executeQuery("select * from customer");
			table.setModel(DbUtils.resultSetToTableModel(rs));	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	
		
		
		
		
		setBounds(500,220,1000,650);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back) {
			new Reception();
			setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		new CustomerInfo();

	}

}


