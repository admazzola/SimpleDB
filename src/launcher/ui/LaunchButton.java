package launcher.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class LaunchButton extends JButton{
	
	public LaunchButton(){
		this.setText("Launch");
		this.setVisible(false);
		this.setBackground(Color.DARK_GRAY);
		this.setForeground(Color.WHITE);
		this.setMnemonic(KeyEvent.VK_ENTER);
		
		
		 
			
			
	}
	
	
	

}
