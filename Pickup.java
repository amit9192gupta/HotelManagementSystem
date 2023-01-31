package Hotel.Management.System;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import net.proteanit.sql.*;


public class Pickup extends JFrame implements ActionListener{
	JTable table;
	JButton back,submit;
	JComboBox bed_type;
	JCheckBox available;
	Choice cars;
	Pickup(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel text=new JLabel("Pickup Service");
		text.setFont(new Font("Tohoma",Font.PLAIN,20));
		text.setBounds(400,40,250,30);
		add(text);
	
		
		JLabel lblcars=new JLabel("Type of car");
		lblcars.setBounds(50,100,100,20);
		add(lblcars);
		cars =new Choice();
		cars.setBounds(180,100,150,25);
		add(cars);
		try {
			Conn c=new Conn();
			 ResultSet rs=c.s.executeQuery("select * from driver ");
			while(rs.next()) {
				cars.add(rs.getString("model"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		JLabel l1=new JLabel("      name");
		l1.setBounds(30,180,150,30);
		add(l1);
		JLabel l2=new JLabel("    Age   ");
		l2.setBounds(200,180,150,30);
		add(l2);
		JLabel l3=new JLabel("  Gender ");
		l3.setBounds(350,180,150,30);
		add(l3);
        
		JLabel l4=new JLabel(" Company        ");
		l4.setBounds(450,180,150,30);
		add(l4);
		JLabel l5=new JLabel("Model       ");
		l5.setBounds(600,180,100,30);
		add(l5);
		JLabel l6=new JLabel("Availability   ");
		l6.setBounds(730,180,150,30);
		add(l6);
		JLabel l7=new JLabel("       Location     ");
		l7.setBounds(850,180,100,30);
		add(l7);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		submit.setBounds(200,500,100,30);
		add(submit);
		back=new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBounds(500,500,100,30);
		add(back);
		
		table=new JTable();
		table.setBounds(0,205,1000,360);
		add(table);
		try {
			Conn c=new Conn();
			ResultSet rs= c.s.executeQuery("select * from driver");
			table.setModel(DbUtils.resultSetToTableModel(rs));	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		setBounds(400,220,1100,650);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			try {
				String query="select *from driver where model='"+cars.getSelectedItem()+ "'";
				Conn con=new Conn();
				ResultSet rs;
					rs=  con.s.executeQuery(query);
					
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e) {
			e.printStackTrace();
		}
		}else if(ae.getSource()==back) {
			new Reception();
			setVisible(false);
		}
		
	}


	public static void main(String[] args) {
		new Pickup();
		

	}

	
}
