package launcher;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.ProcessBuilder.Redirect;

public class GameLauncher implements Runnable{

	@Override
	public void run() {
		 try {
			 
			 
			 //    Runtime.getRuntime().exec(new String[]{"java -jar " + SharedData.PATH_TO_CLIENT_JAR + "sandsofosiris.jar"}) ;
			   ProcessBuilder pb = new ProcessBuilder("java", "-Xms"+SharedData.GameMegabyteSizeInit+"m", "-jar", SharedData.PATH_TO_CLIENT_JAR + "sandsofosiris.jar");
			   pb.redirectOutput(Redirect.PIPE);
			   pb.redirectError(Redirect.PIPE);
			   Process p = pb.start();
			   
			   
			   
			  // BufferedOutputStream stream = (BufferedOutputStream) p.getOutputStream();
			   InputStream err = p.getInputStream();  
	            InputStreamReader isr = new InputStreamReader(err);  
	            BufferedReader br = new BufferedReader(isr);  
	            String line = "";  
	            while (! line.toLowerCase().startsWith("init"))   
	            {  
	            	if(br.ready()){
	            	line = br.readLine();
	            	Launcher.getLogger().log(line);
	            	}
	            } 
			  

		   } catch (Exception e) {			
				e.printStackTrace();
			}finally{
				try {
					Thread.sleep(1000);  //wait 5 seconds and close
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);			
			}
		
	}

}
