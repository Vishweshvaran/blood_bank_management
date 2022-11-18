package seekerRegistration;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.DAOController;
import mainPage.MainPage;

@SuppressWarnings("serial")
public class SeekerRegistration extends JFrame {
	// references
	Label heading, fn, ln, gender, address, city, mail, phn,bloodgroup;// fnl,lnl,phl,eml,gl,ctl;
	TextField fnt, lnt, emt, pht;
	Checkbox m, f;
	CheckboxGroup gen;
	Choice ct,blg;
	Button sub;

	public SeekerRegistration() {
		// Frame Layout
		setLayout(null);
		setBounds(100, 200, 600, 600); // ( setSize + setLocation )
		setBackground(new Color(255, 135, 135));
		setVisible(true);
		setResizable(false);
		setTitle("Seeker Registration Form");

		setFont(new Font("", Font.CENTER_BASELINE, 14));

		// JFrame
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(false);

		// heading
		heading = new Label("SEEKER REGISTRATION FORM");
		heading.setBounds(100, 40, 300, 50);// (x,y,width,height)
		heading.setFont(new Font("", Font.BOLD, 18));
		add(heading);
		// fn ln label
		fn = new Label("First Name :");
		fn.setBounds(100, 100, 100, 20);
		add(fn);
		ln = new Label("Last Name  :");
		ln.setBounds(100, 150, 100, 20);
		add(ln);
		// fn ln text field
		fnt = new TextField();
		fnt.setBounds(250, 100, 150, 20);
		add(fnt);

		lnt = new TextField();
		lnt.setBounds(250, 150, 150, 20);
		add(lnt);

		// gen label and text
		gender = new Label("Gender       :");
		gender.setBounds(100, 200, 100, 20);
		add(gender);

		gen = new CheckboxGroup();

		m = new Checkbox("Male", gen, false);
		m.setBounds(250, 200, 50, 25);
		add(m);
		f = new Checkbox("Female", gen, false);
		f.setBounds(300, 200, 70, 25);
		add(f);

		// city Label
		city = new Label("City              :");
		city.setBounds(100, 250, 100, 20);
		add(city);
		
		// city Choices
		ct = new Choice();
		ct.add("select");
		ct.add("Tirupur");
		ct.add("Coimbatore");
		ct.add("Salem");
		ct.add("Karur");
		ct.add("Trichy");
		ct.setBounds(250, 250, 150, 20);
		add(ct);

		// email
		mail = new Label("E-Mail         :");
		mail.setBounds(100, 300, 100, 20);
		add(mail);
		emt = new TextField();
		emt.setBounds(250, 300, 150, 20);
		add(emt);

		// phone number
		phn = new Label("Phone         :");
		phn.setBounds(100, 350, 100, 20);
		add(phn);
		pht = new TextField();
		pht.setBounds(250, 350, 150, 20);
		add(pht);
		
		// Blood Group Label   
		bloodgroup = new Label("Blood Group       :");
		bloodgroup.setBounds(100, 400, 100, 20);
		add(bloodgroup);
					
		// Blood Group Choices
		blg = new Choice();
		blg.add("select");
		blg.add("O+ve");
		blg.add("Ab+ve");
		blg.add("Ab-ve");
		blg.add("B+ve");
		blg.add("B-ve");
		blg.setBounds(250, 400, 150, 20);
	    add(blg);

		// button
		sub = new Button("Submit");
		sub.setBounds(200, 450, 100, 20);
		sub.setBackground(new Color(255, 255, 255));
		add(sub);


		// Event Handling
		sub.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				// first name validation
				int flag1 = 1;
				boolean submissionFlag = false;
				String fnpat = "^[a-zA-Z]{1,30}$";
				Pattern fnpatt = Pattern.compile(fnpat);
				Matcher fnmat = fnpatt.matcher(fnt.getText());
				if (fnt.getText().equals("") && flag1 == 1) {
					JOptionPane.showMessageDialog(frame, "Please Enter Your First Name !");
					// fnl.setText("First name Required!");
					fnt.setBackground(new Color(239, 159, 159));
					flag1 = 0;
				} else if (!fnmat.matches() && flag1 == 1) {
					JOptionPane.showMessageDialog(frame, "Invalid First Name");
					// fnl.setText("Invalid First Name!");
					fnt.setBackground(new Color(239, 159, 159));
					flag1 = 0;
				} else if (flag1 == 1) {
					// fnl.setText(null);
					fnt.setBackground(Color.white);
					flag1 = 1;
				}

				// last name validation

				Matcher lnmat = fnpatt.matcher(lnt.getText());
				if (lnt.getText().equals("") && flag1 == 1) {
					JOptionPane.showMessageDialog(frame, "Enter Your Last Name ! ");
					// lnl.setText("Last name Required!");
					lnt.setBackground(new Color(239, 159, 159));
					flag1 = 0;
				} else if (!lnmat.matches() && flag1 == 1) {
					JOptionPane.showMessageDialog(frame, "Invalid Last Name !");
					// lnl.setText("Invalid Last Name!");
					lnt.setBackground(new Color(239, 159, 159));
					flag1 = 0;
				} else if (flag1 == 1) {
					// lnl.setText(null);
					lnt.setBackground(Color.white);
					flag1 = 1;
				}

				// gender validation
				if (flag1 == 1) {
					if ((m.getState() == false) && (f.getState() == false)) {
						JOptionPane.showMessageDialog(frame, "Select a gender !");
						flag1 = 0;
					}
				}

				// City Validation
				if ((ct.getSelectedItem().equals("select")) && flag1 == 1) {
					JOptionPane.showMessageDialog(frame, "Select a city !");
					flag1 = 0;
				} else if (flag1 == 0) {
					flag1 = 0;
				}

				// email validation
				String empat = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
				Pattern empatt = Pattern.compile(empat);
				Matcher emat = empatt.matcher(emt.getText());
				if (emt.getText().equals("") && flag1 == 1) {
					JOptionPane.showMessageDialog(frame, "Enter Your Email ID !");
					// eml.setText("Email Required!");
					emt.setBackground(new Color(239, 159, 159));
				}
				if (!emat.matches() && flag1 == 1) {
					// eml.setText("Invalid E-Mail!");
					emt.setBackground(new Color(239, 159, 159));
					flag1 = 0;
				} else if (flag1 == 1) {
					// eml.setText(null);
					emt.setBackground(Color.white);
					flag1 = 1;
				}

				// phone validation
				String phnpat = "[987][0-9]{9}$";
				Pattern phpatt = Pattern.compile(phnpat);
				Matcher phmat = phpatt.matcher(pht.getText());
				if (pht.getText().equals("") && flag1 == 1) {
					JOptionPane.showMessageDialog(frame, "Phone Number Required !");
					// phl.setText("Phone No Required!");
					pht.setBackground(new Color(239, 159, 159));
					flag1 = 0;
				}
				if (!phmat.matches() && flag1 == 1) {
					JOptionPane.showMessageDialog(frame, "Invalid Phone Number !");
					// phl.setText("Invalid Phone number!");
					pht.setBackground(new Color(239, 159, 159));
					flag1 = 0;
				} else {
					// phl.setText(null);
					pht.setBackground(Color.white);
					submissionFlag = true;
					flag1 = 1;
				}

				//Blood Group Validation
				if ((blg.getSelectedItem().equals("select")) && flag1 == 1) {
					JOptionPane.showMessageDialog(frame, "Select your Blood Group !");
					flag1 = 0;
				} else if (flag1 == 0) {
					flag1 = 0;
				}
				
				if(fnmat.matches() && lnmat.matches() && ((m.getState() == true) || (f.getState() == true)) &&  !ct.getSelectedItem().equals("select") && emat.matches() &&  phmat.matches() &&  !blg.getSelectedItem().equals("select")) {
					try {		
						DAOController obj = new DAOController();
						String gender = f.getState() ? "female" : "male";
						obj.donorRegistration(fnt.getText(), lnt.getText(), gender, ct.getSelectedItem(), emt.getText(), pht.getText(), blg.getSelectedItem());
						JOptionPane.showMessageDialog(frame, "Data Submitted Successfully!");
						MainPage mainPage = new MainPage();
						dispose();						
					}catch(Exception exp) {
						System.out.println(exp);					
					}
				}
			}
		});

		// close button
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

//	public static void main(String[] args) {
//		new SeekerRegistration();
//	}

}
