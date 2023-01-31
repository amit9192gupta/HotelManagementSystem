package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
	JButton newCustomer,rooms,department,allemployee,managerinfo,customerinfo,searchroom,update,roomstatus,pickup,Checkout,logout;
	Reception(){
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		 newCustomer=new JButton("New Customer form");
		newCustomer.setBackground(Color.black);
		newCustomer.setForeground(Color.white);
		newCustomer.setFont(new Font("Tahoma",Font.PLAIN,14));
		newCustomer.setBounds(10,40,200,30);
		newCustomer.addActionListener(this);
		add(newCustomer);
		
		rooms=new JButton("Rooms");
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		rooms.setFont(new Font("Tahoma",Font.PLAIN,14));
		rooms.addActionListener(this);
		rooms.setBounds(10,85,200,30);
		add(rooms);
		
		 department=new JButton("Department");
		department.setBackground(Color.black);
		department.setForeground(Color.white);
		department.setFont(new Font("Tahoma",Font.PLAIN,14));
		department.setBounds(10,140,200,30);
		department.addActionListener(this);
		add(department);
		
		allemployee=new JButton("All Employee");
		allemployee.setBackground(Color.black);
		allemployee.setForeground(Color.white);
		allemployee.setFont(new Font("Tahoma",Font.PLAIN,14));
		allemployee.setBounds(10,195,200,30);
		allemployee.addActionListener(this);
		add(allemployee);
		
		customerinfo=new JButton("Customer Info");
		customerinfo.setBackground(Color.black);
		customerinfo.setForeground(Color.white);
		customerinfo.setFont(new Font("Tahoma",Font.PLAIN,14));
		customerinfo.setBounds(10,240,200,30);
		customerinfo.addActionListener(this);
		add( customerinfo);
		
		managerinfo=new JButton("Manager Info");
		managerinfo.setBackground(Color.black);
		managerinfo.setForeground(Color.white);
		managerinfo.setFont(new Font("Tahoma",Font.PLAIN,14));
		managerinfo.setBounds(10,295,200,30);
		managerinfo.addActionListener(this);
		add(managerinfo);
		
		Checkout=new JButton("Check out");
		Checkout.setBackground(Color.black);
		Checkout.setForeground(Color.white);
        Checkout.setFont(new Font("Tahoma",Font.PLAIN,14));
		Checkout.setBounds(10,350,200,30);
		Checkout.addActionListener(this);
		add(Checkout);

		 update=new JButton("Update status");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.setFont(new Font("Tahoma",Font.PLAIN,14));
		update.setBounds(10,405,200,30);
		update.addActionListener(this);
		add(update);
		
		roomstatus=new JButton("Update Room Status");
		roomstatus.setBackground(Color.black);
		roomstatus.setForeground(Color.white);
		roomstatus.setFont(new Font("Tahoma",Font.PLAIN,14));
		roomstatus.setBounds(10,460,200,30);
		roomstatus.addActionListener(this);
		add( roomstatus);

		 pickup=new JButton("Pickup");
		 pickup.setBackground(Color.black);
		pickup.setForeground(Color.white);
		 pickup.setFont(new Font("Tahoma",Font.PLAIN,14));
		pickup.setBounds(10,515,200,30);
		pickup.addActionListener(this);
		add(pickup);
		
		searchroom=new JButton("Search Room");
		searchroom.setBackground(Color.black);
		searchroom.setForeground(Color.white);
		 searchroom.setFont(new Font("Tahoma",Font.PLAIN,14));
		 searchroom.setBounds(10,570,200,30);
		 searchroom.addActionListener(this);
		add( searchroom);

		 logout=new JButton("Logout");
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		logout.setFont(new Font("Tahoma",Font.PLAIN,14));
		logout.setBounds(10,615,200,30);
		logout.addActionListener(this);
		add( logout);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(280,80,500,500);
		add(image);

		


		
		
		setBounds(450,200,900,700);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== newCustomer) {
			setVisible(false);
			new AddCustomer();
			
		}else if(ae.getSource()==rooms) {
			new Rooms();
			setVisible(false);
		}else if(ae.getSource()==department) {
			new Department();
			setVisible(false);
		}else if(ae.getSource()==allemployee) {
			new EmployeeInfo();
			setVisible(false);
		}
		else if(ae.getSource()==managerinfo) {
			new ManagerInfo();
			setVisible(false);
		}else if(ae.getSource()==customerinfo) {
			new CustomerInfo();
			setVisible(false);
		}else if(ae.getSource()==searchroom) {
			new SearchRoom();
			setVisible(false);
		}else if(ae.getSource()==update) {
			new UpdateCheck();
			setVisible(false);
		}else if(ae.getSource()==roomstatus) {
			new UpdateRoom();
			setVisible(false);
		}else if(ae.getSource()==pickup) {
			new Pickup();
			setVisible(false);
		}
		else if(ae.getSource()==Checkout) {
			new Checkout();
			setVisible(false);
		}else if (ae.getSource()==logout) {
			setVisible(false);
			System.exit(0);
		}
	}
	

	public static void main(String[] args) {
	new Reception();

	}



}
