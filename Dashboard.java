package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
	JMenuItem addemployee,AddRoom,addDriver;
	Dashboard(){
		setBounds(0,0,1930,1100);
		setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2=i1.getImage().getScaledInstance(1930,1100,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel Dash=new JLabel(i3);
		Dash.setBounds(0,0,1930,1000);
		add(Dash);
		
		JLabel Welcome=new JLabel("THE TAJ GROUP WELCOMES YOU");
		Welcome.setBounds(550,120,1200,50);
		Welcome.setForeground(Color.WHITE);
		Welcome.setFont(new Font("Tahoma",Font.PLAIN,52));
		Dash.add(Welcome);
		
		JMenuBar mb=new JMenuBar();
		mb.setBounds(0,0,1930,30);
		Dash.add(mb);
		
		
		JMenu hotel=new JMenu("HOTEL MANAGEMENT");
		hotel.setForeground(Color.RED);
		mb.add(hotel);
		JMenuItem reception=new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		
		JMenu admin=new JMenu("ADMIN");
		admin.setForeground(Color.RED);
		mb.add(admin);
		 addemployee=new JMenuItem("ADD Employee");
		addemployee.addActionListener(this);
		admin.add(addemployee);
	     AddRoom=new JMenuItem("ADD ROOM");
	     AddRoom.addActionListener(this);
		admin.add(AddRoom);
		addDriver=new JMenuItem("ADD DRIVER");
		addDriver.addActionListener(this);
		admin.add(addDriver);
		
		setVisible(true);
		
	}
public void actionPerformed(ActionEvent ae) {
	if(ae.getActionCommand().equals("ADD Employee")) {
		new AddEmployee();
		
	}else if(ae.getActionCommand().equals("ADD ROOM")) {
		new AddRooms();
	}else if(ae.getActionCommand().equals("ADD DRIVER")) {
		new AddDriver();
	}else if(ae.getActionCommand().equals("RECEPTION")) {
		new Reception();
	}
	
}
	public static void main(String[] args) {
		new Dashboard();

	}

}
