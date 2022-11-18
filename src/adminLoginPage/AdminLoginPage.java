package adminLoginPage;

import javax.swing.*;

import adminHomePage.AdminPage;
import mainPage.MainPage;

import java.awt.*;  
import java.awt.event.*;


@SuppressWarnings("serial")
class CreateLoginPage extends JFrame{
	
	static JLabel heading, userName, password;
	static JTextField userNameText;
	static JPasswordField passwordText;
	static JButton btn;
	Container c;
	
	Font textFont = new Font("Times New Roman", Font.BOLD,20);
	
	CreateLoginPage(){
		
		setTitle("ADMIN LOGIN PAGE");
		setBounds(450,150,400,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
//		getContentPane().setBackground(new Color(255, 135, 135));
		
		c = getContentPane();
		c.setBackground(MainPage.backGroundColor);
		c.setLayout(null);

		
		heading = new JLabel("Admin Login");
		heading.setBounds(100,50,200,50);
		heading.setFont(new Font("Times New Roman", Font.BOLD,30));
		add(heading);
		
		createFields(c);
		
		setVisible(true);
		
		formValidation();
	}


	void createFields(Container c) {
		
		userName = new JLabel("Username  : ");
		userName.setBounds(80,160,110,27);
		userName.setFont(textFont);
		c.add(userName);
		
		userNameText = new JTextField();
		userNameText.setBounds(200,160,110,25);
		userNameText.setFont(textFont);
		c.add(userNameText);
		
		password = new JLabel("Passowrd  : ");
		password.setBounds(80,200,110,27);
		password.setFont(textFont);
		c.add(password);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(200, 200, 110, 25);
		passwordText.setFont(textFont);
		c.add(passwordText);
		
		btn = new JButton("Submit");
		btn.setBounds(140,300,100,40);
		btn.setBackground(Color.black);
		btn.setForeground(Color.white);
		btn.setOpaque(true);
		btn.setFont(textFont);
		c.add(btn);
		
	}
	
	
	
	void formValidation() {
		JFrame frame = new JFrame();
	    frame.setSize(200, 200);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(false);		
		
			
		btn.addActionListener(new ActionListener() {	
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				int flag = 1;
				String username = userNameText.getText();
				String password = String.valueOf(passwordText.getPassword());
			
				if(username.equals("") && password.equals("1")) {
						AdminPage page = new AdminPage();
						//page.setVisible(true);
						dispose();
				}
				else {
					if(username.equals(null) && flag == 1 ) {
						JOptionPane.showMessageDialog(frame, "Please Enter User Name!");
						userNameText.setBackground(Color.yellow);
						flag = 0;
					}
					else if(password.equals(null) && flag == 1 ) {
						JOptionPane.showMessageDialog(frame, "Please Enter Password!");
						passwordText.setBackground(Color.yellow);
						flag = 0;
					}
					else {
						JOptionPane.showMessageDialog(frame, "Invalid Username or Password!");
						flag = 0;
					}
				}
			}
		});
	}
	
}

public class AdminLoginPage{
	
	@SuppressWarnings("unused")
	public AdminLoginPage() {
		CreateLoginPage form = new CreateLoginPage();
	}
	public static void main(String[] args) {
		new AdminLoginPage();
	}

}
