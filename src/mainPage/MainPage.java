package mainPage;

import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import adminLoginPage.AdminLoginPage;
import donorRegistration.DonorRegistration;
import seekerRegistration.SeekerRegistration;


@SuppressWarnings("serial")
public class MainPage extends JFrame{
	
	
	static JLabel heading;
	
	static JButton btn1, btn2, btn3;
	Container c;
	static Font font = new Font("Times New Roman", Font.BOLD,16);
	public static Color backGroundColor = new Color(255, 135, 135);
	
	public static void buttonProperties(JButton button) {
		button.setFont(font);
		button.setBackground(Color.black);
		button.setForeground(Color.white);
		button.setFocusPainted(false);
		button.setOpaque(true);
	}
	
	public void contents() {
		setTitle("LIFE STREAM");
		setBounds(450,100,400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		c = getContentPane();
		c.setBackground(backGroundColor);
		c.setLayout(null);

		
		heading = new JLabel("LIFE STREAM");
		heading.setBounds(100,50,260,50);
		heading.setFont(new Font("Times New Roman", Font.BOLD,30));
		add(heading);
		
		createOptions(c);		
		setVisible(true);
	}
	

	void createOptions(Container c) {
				
		btn1 = new JButton("DONOR REGISTRATION");
		btn1.setBounds(70,150,250,50);
		buttonProperties(btn1);
		c.add(btn1);

		
		btn2 = new JButton("SEEKER REGISTRATION");
		btn2.setBounds(70,220,250,50);
		buttonProperties(btn2);
		c.add(btn2);

		
		btn3 = new JButton("LOGIN AS ADMIN");
		btn3.setBounds(70,290,250,50);
		buttonProperties(btn3);
		c.add(btn3);

		
		btn1.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DonorRegistration donorRegistration = new DonorRegistration();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				SeekerRegistration seekerRegistration = new SeekerRegistration();
				dispose();	
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminLoginPage adminLoginPage = new AdminLoginPage();
				dispose();
			}
		});
		
	}
	
	public MainPage(){
		contents();
	}


}
