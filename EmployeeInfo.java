package Hotel.Management.System;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{
	JTable table;
	JButton back,Back;
	EmployeeInfo(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
		JLabel l1=new JLabel("Name");
		l1.setBounds(10,20,100,30);
		add(l1);
		JLabel l2=new JLabel("Age");
		l2.setBounds(140,20,100,30);
		add(l2);
		JLabel l3=new JLabel("Gender");
		l3.setBounds(300,20,100,30);
		add(l3);
		JLabel l4=new JLabel("Job");
		l4.setBounds(450,20,100,30);
		add(l4);
		JLabel l5=new JLabel("Salary");
		l5.setBounds(560,20,100,30);
		add(l5);
		JLabel l6=new JLabel("Phone");
		l6.setBounds(670,20,100,30);
		add(l6);
		JLabel l7=new JLabel("Mail");
		l7.setBounds(770,20,100,30);
		add(l7);
		JLabel l8=new JLabel("Aadhar");
		l8.setBounds(900,20,100,30);
		add(l8);
		
	
		
		
		table=new JTable();
		table.setBounds(0,50,1000,650);
		add(table);
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBounds(450,600,100,30);
		add(back);
		try {
			Conn c=new Conn();
			ResultSet rs= c.s.executeQuery("select * from employee");
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
		new EmployeeInfo();

	}

}

