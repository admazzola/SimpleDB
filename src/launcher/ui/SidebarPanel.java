package launcher.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.Box.Filler;

import net.miginfocom.swing.MigLayout;
import launcher.GameLauncher;
import launcher.Launcher;
import launcher.SharedData;

public class SidebarPanel extends JPanel  
{

  //private final LoginContainerForm loginForm;
  //private final ProfileSelection profileSelection;
  //private final StatusPanelForm serverStatus;
	
	private final LaunchButton launchButton;
	private final DownloadStatusLabel statusLabel;
	private final JProgressBar progressBar;
	private final JComboBox memoryOptions;
	
	
	String[] memoryStrings = { "", "512m", "1024m", "2048m" };
	
  public SidebarPanel()
  {
 

	  

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
	 
	  memoryOptions = new JComboBox(memoryStrings);
	  memoryOptions.setSelectedIndex(0);
	  
	  memoryOptions.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	JComboBox cb = (JComboBox)e.getSource();
	            String memChoice = (String)cb.getSelectedItem();
	        	
	        	setMemoryOption(memChoice);
	        }

			
	    });    
		
		
    int border = 4;
    setBorder(new EmptyBorder(border, border, border, border));

    progressBar = new JProgressBar();
    launchButton = new LaunchButton();
    statusLabel = new DownloadStatusLabel();
    
   
    
	
    launchButton.addActionListener(new ActionListener() {
		 
        public void actionPerformed(ActionEvent e)
        {
            //Execute when button is pressed
          
           Launcher.getLogger().log("Launching");
            
           Launcher.getPanel().getTabPanel().getConsole().clear();
           
            new Thread(new GameLauncher()).start();
				
           Launcher.getPanel().getTabPanel().setSelectedIndex(1);
            
        }

		
    });     
	
    //loginForm = new LoginContainerForm();
    //profileSelection = new ProfileSelection();
    //serverStatus = new StatusPanelForm();

  
    
    createInterface();
  }
  

  
  
  
  
String lastMemChoice = "";
  protected void setMemoryOption(String memChoice) {
	  System.out.println("chose "+memChoice );
	  lastMemChoice = memChoice;
}
  
  
  public String getLaunchMemory(){
	  if(lastMemChoice.equals("")){
		  return lastMemChoice;
	  }else{
		  return "-Xms"+lastMemChoice;
	  }
	  
	  
  }







protected void createInterface() {
    setLayout(new MigLayout());
    //add(profileSelection);
    //add(serverStatus);
    
    add(statusLabel, "dock west,gapx 20 0");    
    
    
    
   // add(new Panel());
    add(launchButton, "dock east,gapx 120 0");
    
   
    
    statusLabel.setVisible(true);
    
    
    progressBar.setVisible(false);
    progressBar.setMinimum(0);
    progressBar.setMaximum(100);
    add(progressBar, "dock west,gapx 50 50,width 300");
   
    launchButton.setVisible(false);
    progressBar.setVisible(false);
    //add(new Filler(new Dimension(0, 0), new Dimension(32767, 10), new Dimension(32767, 10)), BorderLayout.SOUTH);

   
   // add(loginForm);
  }
  
  public LaunchButton getLaunchButton(){
	  return launchButton;
  }
  
  public DownloadStatusLabel getStatusLabel(){
	  return statusLabel;
  }

public void setReadyToLaunch() {
	getLaunchButton().setVisible(true);
	 progressBar.setVisible(false);
}

public void setReadyToLaunchOffline() {
	if(!Launcher.getCheckSum().equals(Launcher.CHECKSUM_FAIL_MESSAGE))
	getLaunchButton().setText("Launch Offline");
	getLaunchButton().setVisible(true);
	 progressBar.setVisible(false);
}
  
public JProgressBar getProgressBar() {
    return progressBar;
  }

  //public LoginContainerForm getLoginForm() {
  //  return loginForm;
  //}

}