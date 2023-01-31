package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener {
	JButton ADD,cancel;
	JTextField tfroom,tfprice;
	JComboBox avaliblecombo,cleancombo,typecombo;
	AddRooms(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel heading=new JLabel("ADD ROOMS");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,20,200,20);
		add(heading);
		
		JLabel lblroomno=new JLabel("Room no");
		lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblroomno.setBounds(80,60,120,30);
		add(lblroomno);
		
		tfroom=new JTextField();
		tfroom.setBounds(180,60,150,30);
		add(tfroom);
		
		JLabel lblavailable=new JLabel("Availibilty");
		lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblavailable.setBounds(80,120,120,30);
		add(lblavailable);
		String avloption[]= {"AVAILABLE","NOT AVAILABLE"};
		avaliblecombo=new JComboBox(avloption);
		avaliblecombo.setBackground(Color.white);
		avaliblecombo.setBounds(180,120,120,30);
		add(avaliblecombo);
		
		JLabel lblclean=new JLabel("Clean");
		lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblclean.setBounds(80,170,120,30);
		add(lblclean);
		String cleanoption[]= {"DIRTY","Cleaned"};
		cleancombo=new JComboBox(cleanoption);
		cleancombo.setBackground(Color.white);
		cleancombo.setBounds(180,170,120,30);
		add(cleancombo);
		
		JLabel lblprice=new JLabel("Price");
		lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblprice.setBounds(80,220,120,30);
		add(lblprice);
		
		tfprice=new JTextField();
		tfprice.setBounds(180,220,150,30);
		add(tfprice);
		
		JLabel lbltype=new JLabel("Bed Type");
		lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbltype.setBounds(80,270,120,30);
		add(lbltype);
		String typeoption[]= {"Single bed","Double bed"};
		typecombo=new JComboBox(typeoption);
	
		typecombo.setBackground(Color.white);
		typecombo.setBounds(180,270,120,30);
		add(typecombo);
		
		ADD=new JButton("ADD Room");
		ADD.setBackground(Color.black);
		ADD.setForeground(Color.white);
		ADD.setBounds(120,333,100,30);
		ADD.addActionListener(this);
		add(ADD);
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
	    cancel.setForeground(Color.white);
	    cancel.setBounds(260,333,100,30);
	    cancel.addActionListener(this);
		add(cancel);
		
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		 JLabel image=new JLabel(i1);
		 image.setBounds(380,20,500,400);
		 add(image);
		 
		
		
		
		setBounds(420,250,940,470);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ADD) {
			String roomno=tfroom.getText();
			String availability=(String) avaliblecombo.getSelectedItem();
			String cleaning_status=(String) cleancombo.getSelectedItem();
			String price=tfprice.getText();
			String bed_type=(String) typecombo.getSelectedItem();
			try {
				Conn c=new Conn();
				String query="insert into room values('"+roomno+"','"+availability+"','"+cleaning_status+"','"+price+"','"+bed_type+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"new room added");
				setVisible(false);
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(ae.getSource()==cancel) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
	new AddRooms();
		

	}


}
