package launcher.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import launcher.Launcher;
import launcher.SharedData;

public class FileClient implements Runnable{

/**
 * @param args the command line arguments
 */
	String serveraddress;
	int serverport;
public FileClient(String serveraddress, int serverport) throws IOException {
	this.serveraddress=serveraddress;
	this.serverport=serverport;
	}


@Override
public void run() {
	
	try{
	 Socket socket = null;
	    
	    
	   
	    InputStream is = null;
	    FileOutputStream fos = null;
	    BufferedOutputStream bos = null;
	    int bufferSize = 0;
	    
	    
	 
	    socket = new Socket(serveraddress, serverport);
	    Launcher.getLogger().log("fileclient connected on "+serveraddress +":"+serverport);
	   
	     BufferedReader textin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    PrintWriter textout = new PrintWriter(socket.getOutputStream() , true);	    
	    
	    textout.println(Launcher.getCheckSum());
	    Launcher.getLogger().log("sent checksum "+Launcher.getCheckSum()+" at "+System.currentTimeMillis());
	    textout.println(SharedData.getOS().getName());
	    
	    String serverResponse = textin.readLine();
	    
	    if(serverResponse.startsWith("sending")){
	    	
	    	setStatus(DownloadStatus.LEECHING);
	    	
	    	String length = textin.readLine();
	    	int fileLength = Integer.parseInt(length);
	    	int numPackets = 1;
	   
	    try {
	        is = socket.getInputStream();
	        bufferSize = socket.getReceiveBufferSize();
	        numPackets = fileLength / bufferSize;
	        Launcher.getLogger().log("Buffer size: " + bufferSize);
	    } catch (IOException ex) {
	    	Launcher.getLogger().log("Can't get socket input stream. ");
	    }

	    try {
	        fos = new FileOutputStream(SharedData.PATH_TO_CLIENT_JAR + "sandsofosiris.jar");
	        bos = new BufferedOutputStream(fos);

	    } catch (FileNotFoundException ex) {
	    	Launcher.getLogger().log("File not found. ");
	    }

	    byte[] bytes = new byte[bufferSize];

	    int count;

	    while (is!=null && (count = is.read(bytes)) > 0) {
	        bos.write(bytes, 0, count);
	        
	        progress+=(1f / numPackets*0.5f);
	        Launcher.getLogger().log("got packet of size"+count);
	    }

	    bos.flush();
	    bos.close();
	    is.close();
	    
	    }
	    
	    setStatus(DownloadStatus.FINISHED);
	   
	    
	    textin.close();
	    textout.close();
	    socket.close();
	    
	    
	}catch(Exception x){
		x.printStackTrace();
		setStatus(DownloadStatus.CONNECTIONISSUE);
	}
	
	
	
}





public boolean isFinished() {
	return currentStatus==DownloadStatus.FINISHED;
}

public boolean isErrored() {
	return currentStatus==DownloadStatus.CONNECTIONISSUE;
}

public boolean isDownloading() {
	return currentStatus==DownloadStatus.LEECHING;
}


float progress = 0;

public float getProgress() {
	
	return progress;
}

DownloadStatus currentStatus = DownloadStatus.INITIALIZING;
public DownloadStatus getStatus() {	
	return currentStatus;
}

private void setStatus(DownloadStatus status){
	currentStatus = status;
}




}