package launcher;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import launcher.net.FileServer;
import launcher.net.FileUploader;


public class Server {
	
	private FileServer fileServer;


	public static void main(String[] args) {
		try{
		new Server();		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public Server() throws UnknownHostException{
		
		System.out.println("starting server v"+SharedData.VERSION);
			
		//new File(SharedData.PATH_TO_SERVER_JAR).mkdir();
		
		
		//107.170.122.137
		//put my external IP here, plus the external forwarded port
		try {
			fileServer = new FileServer(2232);
			new Thread(fileServer).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	  
		
      /*  weaver = new Weaver( new NodeInfo[]{new NodeInfo("107.170.122.137",2232)} , 2232 );
        
        WeaverOrb orb = new WeaverOrb( SharedData.getSelfJarPath() + "sandsofosiris.jar", weaver );
		orb.start();		 
		      
		//pass in addresses of the master nodes		
		weaver.registerOrb(orb);
		weaver.start();
		*/
		
	}
	
	public static String getCheckSum() {
		try{
		File file = new File(  SharedData.getSelfJarPath() + "sandsofosiris.jar" );		
		HashCode hc = Files.hash(file, Hashing.sha1());
		return hc.toString();
		}catch(Exception e){
			System.err.println("no file found to upload!!!");
			return "none";
		}
	}

}
