package Hotel.Management.System;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
	JTable table;
	JButton back,Back;
	Department(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		
		JLabel l1=new JLabel("Department   |");
		l1.setBounds(172,18,100,30);
		add(l1);
		JLabel l2=new JLabel("Budget");
		l2.setBounds(370,10,100,30);
		add(l2);
	
		
		
		table=new JTable();
		table.setBounds(0,40,500,100);
		add(table);
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBounds(80,420,100,30);
		add(back);
		try {
			Conn c=new Conn();
			ResultSet rs= c.s.executeQuery("select * from department");
			table.setModel(DbUtils.resultSetToTableModel(rs));	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	
		
		
		
		
		setBounds(400,220,700,500);
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
		new Department();

	}

}
