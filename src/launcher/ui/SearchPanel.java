package launcher.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import launcher.DBManager;
import launcher.Launcher;
import launcher.Record;
import launcher.SharedData;
import net.miginfocom.swing.MigLayout;

public class SearchPanel extends JPanel  
{
	
	JTextField searchField;
	
	JButton searchButton;
	
	  public SearchPanel()
	  {
		  
		  searchField = new JTextField(20);
		  
		  
		
		  searchButton = new JButton("Search");

		  createInterface();
	  }
	
	protected void createInterface() {
	    setLayout(new MigLayout());
	    	  
	    add(searchField, "pad 10");
	    
	    searchButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
               search();
            }
        });      
		
	    add(searchButton, "south, h 40!, w 160!, pad 20 20 20 20");
	}

	protected void search() {
		//scanner on file
		if(searchField.getText().length() > 0){
			String query = searchField.getText();
			
			Launcher.println("Searching query: "+ query);
			
			 String filename= "db.txt";
			    String path = SharedData.getDefaultDirectory()  + filename;
			
			
			 Scanner scan;
			try {
				scan = new Scanner(new File(path));
			
			
			 String s;
			 //int indexfound=-1;
			    
			 while (scan.hasNextLine()) 
			  {
			    s = scan.nextLine();
			    if(s.indexOf(query)>-1){
			        //indexfound++; 
			    	
			    	Launcher.println("Found match: "+s);
			    	
			    	Launcher.getPanel().getTabPanel().setSelectedIndex(1);
			    }
			  }
			 
			 scan.close();
			 Launcher.println("Completed search.");
			 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	

	
}
