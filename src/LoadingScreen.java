import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import mainPage.MainPage;


@SuppressWarnings("serial")
class UModule extends JFrame{
}

@SuppressWarnings("serial")
class UserModule extends Canvas{
}

@SuppressWarnings("serial")
public class LoadingScreen extends UserModule {
	String imgPath = "C:\\Users\\91978\\Desktop\\blood_logo.gif";
	
	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage(imgPath);
		g.drawImage(img, 0, 10, this);
	}
	
	public static void main(String[] args) {
		
		LoadingScreen loadingPage = new LoadingScreen();
		JFrame frame = new JFrame("LifeStream");
		JButton button = new JButton("Get In ");
		button.setBounds(300,430,280,50);
		button.setFont(new Font("",Font.BOLD,48));
		button.setBackground(new Color(237,237,235));
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setForeground(new Color(200,0,0));
		frame.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				MainPage mainPage = new MainPage();
				frame.dispose();
			}
		});
		frame.add(loadingPage);
		//frame.setSize(820,600);
		frame.setBounds(400,100,820,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		
		frame.setVisible(true);
	}
}

