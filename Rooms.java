package Hotel.Management.System;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	Rooms(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(510,10,600,600);
		add(image);
		JLabel l1=new JLabel("   Room number  |");
		l1.setBounds(3,19,100,30);
		add(l1);
		JLabel l2=new JLabel("    Availibility         |");
		l2.setBounds(103,19,100,30);
		add(l2);
		JLabel l3=new JLabel("       Status            |");
		l3.setBounds(204,19,100,30);
		add(l3);
        
		JLabel l4=new JLabel("        Price             |");
		l4.setBounds(305,19,101,30);
		add(l4);
		JLabel l5=new JLabel("       Bed Type      |");
		l5.setBounds(406,19,100,30);
		add(l5);
		
		table=new JTable();
		table.setBounds(0,40,500,400);
		add(table);
		try {
			Conn c=new Conn();
			ResultSet rs= c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));	
		}catch (Exception e) {
			e.printStackTrace();
		}
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBounds(200,500,100,30);
		add(back);
		
		
		
		
		setBounds(400,220,1100,650);
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
		new Rooms();
		

	}

	
}
