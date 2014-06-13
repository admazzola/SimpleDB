package launcher.ui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import launcher.DBManager;
import launcher.Launcher;
import launcher.Record;
import launcher.SharedData;
import net.miginfocom.swing.MigLayout;

public class ImportPanel extends JPanel  
{
	
	JButton openFolderButton;
	
	JButton importButton;
	
	  public ImportPanel()
	  {
		  
		  openFolderButton = new JButton("Open Folder");		  
		
		  importButton = new JButton("Import File");

		  createInterface();
	  }
	
	protected void createInterface() {
	    setLayout(new MigLayout());
	    	  
	    openFolderButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
               try {
				openFolder(SharedData.getDefaultDirectory()+"/"+"SimpleDB");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            }
        });      
		
	    add(openFolderButton, "west, h 40!, w 160!, pad 20 20 20 20");
	    
	    
	    importButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
               selectFile();
            }
        });      
		
	    add(importButton, "west, h 40!, w 160!, pad 20 20 20 20");
	}

	protected void selectFile() {
		
		JFileChooser chooser = new JFileChooser();
	   
	    int returnVal = chooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       DBManager.importFile( chooser.getSelectedFile() );	       
	    }
		
	}

	protected void openFolder(String path) throws Exception {
		File myfile = new File(path);
		String abspath = myfile.getAbsolutePath();
		File dir = new File(abspath.substring(0, abspath.lastIndexOf(File.separator)));
		if (Desktop.isDesktopSupported()) {
		    Desktop.getDesktop().open(dir);
		}
		
	}


	

	
}
