package Hotel.Management.System;

import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class AddCustomer extends JFrame implements ActionListener {
	JComboBox comboid,combogender;
	JTextField tfidno,tfname,tfcountry,tfdeposite;
	Choice croom;
	JLabel checkintime;
	JButton add,back;
	AddCustomer(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel text=new JLabel("New Customer Form");
		text.setBounds(100,20,300,40);
		text.setFont(new Font("Raleway",Font.BOLD,20));
		add(text);
		
		JLabel lblid=new JLabel("Id");
		lblid.setBounds(30,60,120,30);
		lblid.setFont(new Font("Raleway",Font.BOLD,18));
		add(lblid);
	    String idoption[]= {"Aadher card","Passport","Pancard","Driving Licence","Voting id"};
	    comboid=new JComboBox(idoption);
	    comboid.setBounds(180,60,120,30);
	    comboid.setBackground(Color.WHITE);
	    add(comboid);
	    
	    JLabel lblno=new JLabel("Number");
		lblno.setBounds(30,100,120,30);
		lblno.setFont(new Font("Raleway",Font.BOLD,18));
		add(lblno);
		tfidno=new JTextField();
		tfidno.setBounds(180,100,120,30);
		tfidno.setBackground(Color.white);
		add(tfidno);
	    
		JLabel lblname=new JLabel("Name");
	    lblname.setBounds(30,140,120,30);
		lblname.setFont(new Font("Raleway",Font.BOLD,18));
		add(lblname);
		tfname=new JTextField();
		tfname.setBounds(180,140,120,30);
		tfname.setBackground(Color.white);
		add(tfname);
		
		JLabel lblgender=new JLabel("Gender");
	    lblgender.setBounds(30,180,120,30);
		lblgender.setFont(new Font("Raleway",Font.BOLD,18));
		add(lblgender);
		String genderoption[]= {"Male","Female","Other"};
		combogender=new JComboBox(genderoption);
		combogender.setBounds(180,180,120,30);
		combogender.setBackground(Color.WHITE);
		add(combogender);
		
		JLabel lblcountry=new JLabel("Country");
		lblcountry.setBounds(30,220,120,30);
		lblcountry.setFont(new Font("Raleway",Font.BOLD,18));
		add(lblcountry);
		tfcountry=new JTextField();
		tfcountry.setBounds(180,220,120,30);
		tfcountry.setBackground(Color.white);
		add(tfcountry);
		
		JLabel lblroom=new JLabel("Allocated room ");
		lblroom.setBounds(30,260,150,30);
		lblroom.setFont(new Font("Raleway",Font.BOLD,16));
		add(lblroom);
		
		croom =new Choice();
		croom.setBounds(180,262,120,30);
		add(croom);
		try {
			Conn c=new Conn();
			String query="select *from room where availability='AVAILABLE'";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next()) {
				croom.add(rs.getString("roomno"));
			}
			}catch(Exception e) {
			e.printStackTrace();
		}
		JLabel lbltime=new JLabel("Check Time");
		lbltime.setBounds(30,300,150,30);
		lbltime.setFont(new Font("Raleway",Font.BOLD,16));
		add(lbltime);
		Date date=new Date();
		
		checkintime =new JLabel(""+date);
		checkintime.setBounds(180,300,180,30);
		checkintime.setFont(new Font("Raleway",Font.ITALIC,13));
		add(checkintime);
		
		JLabel lbldeposit=new JLabel("Deposite");
		lbldeposit.setBounds(30,340,120,30);
		lbldeposit.setFont(new Font("Raleway",Font.BOLD,18));
		add(lbldeposit);
		tfdeposite=new JTextField();
		tfdeposite.setBounds(180,340,120,30);
		tfdeposite.setBackground(Color.white);
		add(tfdeposite);
		
		add=new JButton("ADD Customer");
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.addActionListener(this);
		add.setBounds(50,400,120,30);
		add(add);
		
		back=new JButton("BACK");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(200,400,120,30);
		back.addActionListener(this);
		add(back);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i2=i1.getImage().getScaledInstance(400, 400,Image.SCALE_DEFAULT );
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(200,20,800,500);
		add(image);
		setBounds(450,200,900,600);
		setVisible(true);
		}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==add) {
			String id=(String) comboid.getSelectedItem();
			String number=tfidno.getText();
			String name=tfname.getText();
			String gender=(String)  combogender.getSelectedItem();
			String country=tfcountry.getText();
			String room=croom.getSelectedItem();
			String date=checkintime.getText();
			String deposite=tfdeposite.getText();
			try {
				
				String query="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+date+"','"+deposite+"')";
				String query2="update room set availability='occupied' where roomno='"+room+"'";
				Conn conn=new Conn();
				conn.s.executeUpdate(query);
				conn.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null,"New Customer added succesfully" );
				setVisible(false);
				new Reception();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}else if (ae.getSource()==back){
			setVisible(false);
			
			new Reception();
			
		}
		
		
	}
	

	public static void main(String[] args) {
		new AddCustomer();

	}


	

}
