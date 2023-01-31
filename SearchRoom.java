package Hotel.Management.System;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import net.proteanit.sql.*;


public class SearchRoom extends JFrame implements ActionListener{
	JTable table;
	JButton back,submit;
	JComboBox bed_type;
	JCheckBox available;
	SearchRoom(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel text=new JLabel("Search for Room");
		text.setFont(new Font("Tohoma",Font.PLAIN,20));
		text.setBounds(400,40,250,30);
		add(text);
		
		JLabel lblbed=new JLabel("Bed Type");
		lblbed.setBounds(50,100,100,20);
		add(lblbed);
		bed_type=new JComboBox(new String[]{"Single bed","Double bed"});
		bed_type.setBounds(160,100,120,20);
		bed_type.setBackground(Color.white);
		add(bed_type);
		
		available=new JCheckBox("Only display available");
		available.setBounds(650,100,150,25);
		available.setBackground(Color.WHITE);
		add(available);
		
		JLabel l1=new JLabel("   Room number          |");
		l1.setBounds(79,180,150,30);
		add(l1);
		JLabel l2=new JLabel("    Availibility          |");
		l2.setBounds(300,180,150,30);
		add(l2);
		JLabel l3=new JLabel("  Cleaning  Status      |");
		l3.setBounds(482,180,150,30);
		add(l3);
        
		JLabel l4=new JLabel("        Price              |");
		l4.setBounds(702,180,150,30);
		add(l4);
		JLabel l5=new JLabel("       Bed Type        |");
		l5.setBounds(901,180,100,30);
		add(l5);
		
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
		table.setBounds(0,200,1000,360);
		add(table);
		try {
			Conn c=new Conn();
			ResultSet rs= c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		setBounds(400,220,1100,650);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==submit) {
			try {
				String query="select *from room where bed_type='"+bed_type.getSelectedItem()+ "'";
				String query2="select *from room where availability='AVAILABLE' AND bed_type='"+bed_type.getSelectedItem()+"'"; 
				Conn con=new Conn();
				ResultSet rs;
				if(available.isSelected()) {
					rs=  con.s.executeQuery(query2);
					
				}else {
					rs=con.s.executeQuery(query);
					
				}
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
		new SearchRoom();
		

	}

	
}
