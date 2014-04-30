package launcher.ui;

import javax.swing.JLabel;

import launcher.net.DownloadStatus;



public class DownloadStatusLabel extends JLabel{

	public void setStatus(DownloadStatus status) {
		String label = "";
		
		
		switch(status){
		case WAITINGFORHASH: label = "Connecting to a Master Node";	break;
		case SEEDING: label = "Files are up to date, seeding";	break;
		case LEECHING: label = "Downloading files";	break;
		case FINISHED: label = "Files are up to date";	break;
		case CONNECTIONISSUE: label = "Connection error";	break;
		default: label = "Attempting to connect";	break;
						
		
		}
		
		this.setText(label);
		
	}

	
	
	
}
