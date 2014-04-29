package launcher.ui;

import javax.swing.JLabel;

import com.WeaverStatus;

public class WeaverStatusLabel extends JLabel{

	public void setStatus(WeaverStatus status) {
		String label = "";
		
		
		switch(status){
		case WAITINGFORHASH: label = "Connecting to a Master Node";	break;
		case SEEDING: label = "Files are up to date, seeding";	break;
		case LEECHING: label = "Downloading files";	break;
		case NOTHING: label = "Files are up to date";	break;
		default: label = "UNKNOWN STATUS";	break;
						
		
		}
		
		this.setText(label);
		
	}

	
	
	
}
