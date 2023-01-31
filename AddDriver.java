package Hotel.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener {
	JButton ADD,cancel;
	JRadioButton rbm,rbf;
	JTextField tfname,tfprice,tfage,tfcompany,tfmodel,tflocation;
	JComboBox<String> avaliblecombo;
	AddDriver(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel heading=new JLabel("ADD Drivers");
		heading.setFont(new Font("Tahoma",Font.BOLD,18));
		heading.setBounds(150,20,200,20);
		add(heading);
		
		JLabel lblname=new JLabel("name");
		lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblname.setBounds(80,60,120,30);
		add(lblname);
		
		tfname=new JTextField();
		tfname.setBounds(180,60,150,30);
		add(tfname);
		
		JLabel lblage=new JLabel("Age");
		lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblage.setBounds(80,120,120,30);
		add(lblage);
		
		tfage=new JTextField();
		tfage.setBounds(180,120,150,30);
		add(tfage);
		
		JLabel lblgender=new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblgender.setBounds(80,180,120,30);
		add(lblgender);
		
		rbm=new JRadioButton("Male");
		rbm.setBackground(Color.WHITE);
		rbm.setBounds(180,180,60,30);
		add(rbm);
		rbf=new JRadioButton("Female");
		rbf.setBackground(Color.WHITE);
		rbf.setBounds(236,180,120,30);
		add(rbf);
		ButtonGroup bd=new ButtonGroup();
		bd.add(rbf);
		bd.add(rbm);
		
		
		
		JLabel lblcompany=new JLabel("Car company");
		lblcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblcompany.setBounds(80,230,120,30);
		add(lblcompany);
		
		tfcompany=new JTextField();
		tfcompany.setBounds(180,230,150,30);
		add(tfcompany);
		
		JLabel lbltype=new JLabel("Car model");
		lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbltype.setBounds(80,280,120,30);
		add(lbltype);
		tfmodel=new JTextField();
		tfmodel.setBounds(180,280,150,30);
		add(tfmodel);
		
		JLabel lblavailable=new JLabel("Availibility");
		lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblavailable.setBounds(80,330,120,30);
		add(lblavailable);
		String avloption[]= {"AVAILABLE","Busy"};
		avaliblecombo=new JComboBox<String>(avloption);
		avaliblecombo.setBackground(Color.white);
		avaliblecombo.setBounds(180,330,120,30);
		add(avaliblecombo);
		
		JLabel lbllocation=new JLabel("Location");
		lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbllocation.setBounds(80,380,120,30);
		add(lbllocation);
		tflocation=new JTextField();
		tflocation.setBounds(180,380,150,30);
		add(tflocation);
		
		
		
		ADD=new JButton("ADD Driver");
		ADD.setBackground(Color.black);
		ADD.setForeground(Color.white);
		ADD.setBounds(120,440,100,30);
		ADD.addActionListener(this);
		add(ADD);
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
	    cancel.setForeground(Color.white);
	    cancel.setBounds(260,440,100,30);
	    cancel.addActionListener(this);
		add(cancel);
	
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		 Image i2=i1.getImage().getScaledInstance(450, 350,Image.SCALE_DEFAULT);
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel image=new JLabel(i3);
		 image.setBounds(380,20,500,400);
		 add(image);
		
		setBounds(400,250,980,550);
		setVisible(true);
		
		
	}	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ADD ) {
			String name=tfname.getText();
			String age=tfage.getText();
			String gender=null;
			 if(rbm.isSelected()) {
				 gender="Male";
			 }else if (rbf.isSelected()){
				 gender="female";
			 }
			String company=tfcompany.getText();
			String model=tfmodel.getText();
			String available= (String) avaliblecombo.getSelectedItem();
			String location=tflocation.getText();
			try {
				Conn c=new Conn();
				String query="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"new driver added");
				setVisible(false);
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}else if(ae.getSource()==cancel) {
			setVisible(false);
		}
	}
		
	
	
	public static void main(String[] args) {
	new AddDriver();
	

	}

}
