package launcher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	
	
}
