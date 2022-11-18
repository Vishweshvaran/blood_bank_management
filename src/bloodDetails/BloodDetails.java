package bloodDetails;

import java.awt.Color;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import DAO.DAOController;
import mainPage.MainPage;


@SuppressWarnings("serial")
public class BloodDetails extends JFrame{
	static JLabel heading;
	static JButton btn;
	
	public void contentPane() throws SQLException {
		JFrame f=new JFrame("BLOOD DETAILS PAGE");
		f.setBounds(450,150,500,700);
		
		ArrayList<ArrayList<String>> res = new DAOController().seekerDetails();

	    String data[][]= new String[res.size()][res.get(0).size()];
	    
	    for(int i = 0; i < res.size(); i++) {
	    	for(int j = 0; j < res.get(i).size(); j++) {
	    		data[i][j] = res.get(i).get(j);
	    	}
	    }
	        
	    String column[]={"FNAME" ,"LNAME", "GENDER", "CITY", "EMAIL", "PH.NO", "BLOOD"};   
	    
	    JTable table = new JTable(data,column);    
	    
	    table.setRowHeight(35);
	    table.setBounds(100,100,500,700);       
	    //table.setBackground(new Color(255, 135, 135));
	    table.setBackground(MainPage.backGroundColor);
	    
	    JTableHeader tableHeader = table.getTableHeader();
	    tableHeader.setBackground(Color.black);
	    tableHeader.setForeground(Color.white);
	    Font headerFont = new Font("Verdana", Font.BOLD, 14);
	    tableHeader.setFont(headerFont);

	    table.setFont(new Font("Times New Roman", Font.BOLD,15));
	    
	    JScrollPane sp=new JScrollPane(table);    
	    
	    f.add(sp);      
	    f.setSize(600,400);    
	    f.setVisible(true); 
	}
	
	public BloodDetails() throws SQLException{
		contentPane();
	}
//	public static void main(String[] args) {
//		try {
//			BloodDetails bloodDetailsPage = new BloodDetails();
//			bloodDetailsPage.contentPane();
//			
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//
//	}

}
