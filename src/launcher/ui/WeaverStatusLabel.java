package launcher.ui;

import javax.swing.JLabel;

import com.WeaverStatus;

public class WeaverStatusLabel extends JLabel{

	public void setStatus(WeaverStatus status) {
		String label = "";
		
		
		switch(status){
		case WAITINGFORHASH: label = "Connecting to a Master Node...";	break;
		case SEEDING: label = "Files are up to date. Uploading to others...";	break;
		case LEECHING: label = "Downloading files...";	break;
		default: label = "UNKNOWN STATUS";	break;
						
		
		}
		
		this.setText(label);
		
	}

	
	
	
}
