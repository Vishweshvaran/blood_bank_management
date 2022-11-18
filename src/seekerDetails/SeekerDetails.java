package seekerDetails;

import java.awt.Color;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import DAO.DAOController;

@SuppressWarnings("serial")
public class SeekerDetails extends JFrame{

static JLabel heading;
	
	public void contentPane() throws SQLException {
		
		JFrame f=new JFrame("SEEKER DETAILS PAGE");
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
	    table.setBackground(new Color(255, 135, 135));
	    
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
	
	public SeekerDetails() throws SQLException {
		contentPane();
	}
	
//	public static void main(String[] args) {
//		try {
//			SeekerDetails donorPage = new SeekerDetails();
//			
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//
//	}

}
