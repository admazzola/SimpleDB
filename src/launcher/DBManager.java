package launcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DBManager {

	
	
	
	public static void storeRecord(Record newRecord) {
		try
		{
			
			
			
		    String filename= "db.txt";
		    String path = SharedData.getDefaultDirectory()  + filename;
		    
		    new File(SharedData.getDefaultDirectory()).mkdir();
		    
		    
		    try {
		    	 
			      File file = new File(path);
		 
			      if (file.createNewFile()){
			        System.out.println("File is created!");
			      }else{
			        System.out.println("File already exists.");
			      }
		 
		    	} catch (IOException e) {
			      e.printStackTrace();
			}
		    
		    		    		    
		    FileWriter fw = new FileWriter(path,true); //the true will append the new data
		  
		    fw.write(newRecord.getData() + System.getProperty("line.separator"));//appends the string to the file
		    
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
		
		
	}

	public static void importFile(File file) {
		
		
		 Scanner scan;
		try {
			scan = new Scanner(file);
		
		
		 String line;
		 
		 Launcher.println("Started import.");
		    
		 while (scan.hasNextLine()) 
		  {
			 line = scan.nextLine();
			 
			 storeRecord( new Record(line) );
		  }
		 
		 Launcher.println("Completed import.");
		 
		 scan.close();
		 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
