package adminHomePage;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import bloodDetails.BloodDetails;
import donorDetails.DonorDetails;
import mainPage.MainPage;
import seekerDetails.SeekerDetails;


@SuppressWarnings("serial")
public class AdminPage extends JFrame{
	static JLabel heading;
	
	static JButton btn1, btn2, btn3;
	Container c;
	//Font font = new Font("Times New Roman", Font.BOLD,24);
	
	public void contents() {
		setTitle("ADMIN HOME PAGE");
		setBounds(450,100,400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		c = getContentPane();
		c.setBackground(MainPage.backGroundColor);
		c.setLayout(null);

		
		heading = new JLabel("Admin Home Page");
		heading.setBounds(70,50,260,50);
		heading.setFont(new Font("Times New Roman", Font.BOLD,30));
		add(heading);
		
		createOptions(c);		
		setVisible(true);
	}
	

	void createOptions(Container c) {
				
		btn1 = new JButton("Donor Details");
		btn1.setBounds(90,150,200,50);
		MainPage.buttonProperties(btn1);
//		btn1.setFont(font);
//		btn1.setBackground(Color.black);
//		btn1.setForeground(Color.white);
//		btn1.setFocusPainted(false);
//		btn1.setOpaque(true);
		c.add(btn1);
		
		btn2 = new JButton("Seeker Details");
		btn2.setBounds(90,220,200,50);
		MainPage.buttonProperties(btn2);
//		btn2.setFont(font);
//		btn2.setBackground(Color.black);
//		btn2.setForeground(Color.white);
//		btn2.setFocusPainted(false);
//		btn2.setOpaque(true);
		c.add(btn2);
		
		btn3 = new JButton("Blood Details");
		btn3.setBounds(90,290,200,50);
		MainPage.buttonProperties(btn3);
//		btn3.setFont(font);
//		btn3.setBackground(Color.black);
//		btn3.setForeground(Color.white);
//		btn3.setFocusPainted(false);
//		btn3.setOpaque(true);
		c.add(btn3);
		
		btn1.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DonorDetails donorPage = new DonorDetails();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					SeekerDetails seekerPage = new SeekerDetails();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BloodDetails bloodDetailsPage = new BloodDetails();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
		
	}
	public AdminPage() {
		// TODO Auto-generated constructor stub
		contents();
	}

//	public static void main(String[] args) {
//		try {
//			AdminPage page = new AdminPage();
//			page.contents();
//			
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//	}


}
