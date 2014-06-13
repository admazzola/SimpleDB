package launcher.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import launcher.DBManager;
import launcher.Launcher;
import launcher.Record;
import net.miginfocom.swing.MigLayout;

public class InputPanel extends JPanel  
{
	JTextField nameField;
	JTextField keyField;
	JTextField dataField;
	JTextField timestampField;
	
	JButton submitButton;
	
	JTextField searchField;
	
	JButton searchButton;
	
	  public InputPanel()
	  {
		  
		  nameField = new JTextField(20);
		  keyField = new JTextField(20);
		  dataField = new JTextField(20);
		  timestampField = new JTextField(20);
		  
		  submitButton = new JButton("Submit");

		  createInterface();
	  }
	
	protected void createInterface() {
	    setLayout(new MigLayout());
	    	   
	    
	    submitButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
               submitNewRecord();
            }
        });      
			    
	    add(nameField , "pad 10");
	    add(keyField , "pad 10");
	    add(dataField , "pad 10");
	    add(timestampField, "pad 10");
	    add(submitButton, "south, h 40!, w 160!, pad 20 20 20 20");
	}

	protected void submitNewRecord() {
		if(nameField.getText().length() > 0){
		
		Record newRecord = new Record(nameField.getText(),keyField.getText(),dataField.getText(),timestampField.getText());
		
		nameField.setText("");
		keyField.setText("");
		dataField.setText("");
		timestampField.setText("");
		
		DBManager.storeRecord(newRecord);
		
		Launcher.println("Saved record " + newRecord.getData());
		
		}
	}

	
}
