package Hotel.Management.System;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
  HotelManagementSystem() {
//		setSize(1366,565);
//		setLocation(300,150);   /combination is know as set bounds
	  setBounds(300,150,1366,565);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image=new JLabel(i1);
		add(image);
		setLayout(null);
		image.setBounds(0,0,1366,565);
		//JLable is use to write text on the frame but it can also be use to add image 
		JLabel text=new JLabel("Hotel Management System");
		text.setForeground(Color.WHITE);
		text.setBounds(10, 450, 900, 60);
		text.setFont(new Font("serif",Font.PLAIN,50));
		
		image.add(text);
		
		JButton next=new JButton("Next->");
		next.setForeground(Color.CYAN);
		next.setBackground(Color.BLACK);
		next.addActionListener(this);
		
		
		next.setFont(new Font("serif",Font.HANGING_BASELINE,30));
		next.setBounds(910,450,170 ,50 );
		image.add(next);
		
		
		
		
		setVisible(true);
		
		while(true) {
			text.setVisible(false);
			try {
			Thread.sleep(300);	
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	setVisible(false);
	new Login();
		
	}
	
	
	
	public static void main(String[] args) {
		new HotelManagementSystem();

	}





}
