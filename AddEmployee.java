package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{
	JTextField tfname,tfage,tfSalary,tfPhone,tfMail,tfaadhar;
	JLabel lblname,age,lblgender,lbljob,lblSalary,lblPhone,lblMail,lblaadhar;
	JRadioButton rbm,rbf;
	JComboBox cbjob;
	JButton submit;
	public AddEmployee() {
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		 lblname=new JLabel("Name");
		 lblname.setBounds(60,30,120,30);
		 lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblname);
		 
		  tfname=new JTextField();
		 tfname.setBounds(180,30,120,30);
		 add(tfname);
		 
		 age=new JLabel("AGE");
		 age.setBounds(60,70,120,30);
		 age.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(age);
		 
		  tfage=new JTextField();
		 tfage.setBounds(180,70,120,30);
		 add(tfage);
		 
		 lblgender=new JLabel("GENDER");
		 lblgender.setBounds(60,110,120,30);
		 lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblgender);
		 
		 rbm=new JRadioButton("Male");
		 rbm.setBounds(180, 110, 70, 30);
		 rbm.setFont(new Font("Tahoma",Font.PLAIN,14));
		 rbm.setBackground(Color.WHITE);
		 add(rbm);
		
		 rbf=new JRadioButton("female");
		 rbf.setFont(new Font("Tahoma",Font.PLAIN,14));
		 rbf.setBackground(Color.WHITE);
		 rbf.setBounds(180, 140, 70, 30);
		 add(rbf);
		 ButtonGroup bg=new ButtonGroup();
		 bg.add(rbf);
		 bg.add(rbm);
		 
		 lbljob=new JLabel("Job");
		 lbljob.setBounds(60,180,120,30);
		 lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lbljob);
		 String str[]= {"Frontend Desk Clerks ","Porters","housekeeping","Kitchen Staff","Room Service","Chefs","Waiter","Manager","Accountant"};
		 cbjob=new JComboBox(str) ;
		 cbjob.setBounds(180,180,150,30);
		 add(cbjob);
		 
		 lblSalary=new JLabel("Salary");
		 lblSalary.setBounds(60,240,120,30);
		 lblSalary.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblSalary);
		 
		 tfSalary=new JTextField();
		 tfSalary.setBounds(180,240,120,30);
		 add(tfSalary);
		 
		 lblPhone=new JLabel("Phone");
		 lblPhone.setBounds(60,280,120,30);
		 lblPhone.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblPhone);
		 
		  tfPhone=new JTextField();
		 tfPhone.setBounds(180,280,120,30);
		 add(tfPhone);
		 
		 lblMail=new JLabel("Email");
		 lblMail.setBounds(60,320,120,30);
		 lblMail.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblMail);
		 
		 tfMail=new JTextField();
		 tfMail.setBounds(180,320,120,30);
		 add(tfMail);
	
		 lblaadhar=new JLabel("Aadhar no");
		 lblaadhar.setBounds(60,360,120,30);
		 lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblaadhar);
	
		 tfaadhar=new JTextField();
		 tfaadhar.setBounds(180,360,120,30);
		 add(tfaadhar);
		 
		 submit=new JButton("SUBMIT");
		 submit.setBackground(Color.black);
		 submit.setForeground(Color.WHITE);
		 submit.setBounds(90,420,100,30);
		 submit.addActionListener(this);
		 add(submit);
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		 Image i2=i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel image=new JLabel(i3);
		 
		 image.setBounds(360,50,480,380);
		 add(image);

		
		setBounds(450,280,850,540);
		setVisible(true);
	}
 public void actionPerformed(ActionEvent ae) {
	 String name=tfname.getText();
	 String age=tfage.getText();
	 String salary=tfSalary.getText();
	 String phone=tfPhone.getText();
	 String email=tfMail.getText();
	 String aadhar=tfaadhar.getText();
	 String gender=null;
	 if(rbm.isSelected()) {
		 gender="Male";
	 }else if (rbf.isSelected()){
		 gender="female";
	 }
	 String job=(String) cbjob.getSelectedItem();
	 try {
		 Conn c=new Conn();
		 String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
		 c.s.executeUpdate(query);
		 JOptionPane.showMessageDialog(null,"Employee added succesfully" );
		 setVisible(false);
	 }catch(Exception e) {
		 e.printStackTrace();
		 
	 }
	 
	 
	 
 }
	public static void main(String[] args) {
		new AddEmployee();
			
		
	}
}

