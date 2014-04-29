package launcher.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.Box.Filler;

import net.miginfocom.swing.MigLayout;
import launcher.SharedData;

public class SidebarPanel extends JPanel
{

  //private final LoginContainerForm loginForm;
  //private final ProfileSelection profileSelection;
  //private final StatusPanelForm serverStatus;
	
	private final LaunchButton launchButton;
	private final WeaverStatusLabel statusLabel;
	private final JProgressBar progressBar;
	
  public SidebarPanel()
  {
 

    int border = 4;
    setBorder(new EmptyBorder(border, border, border, border));

    progressBar = new JProgressBar();
    launchButton = new LaunchButton();
    statusLabel = new WeaverStatusLabel();
    
    
    
	
    launchButton.addActionListener(new ActionListener() {
		 
        public void actionPerformed(ActionEvent e)
        {
            //Execute when button is pressed
            System.out.println("Launching");
           
            
           
				launch();
		
            
        }

		
    });     
	
    //loginForm = new LoginContainerForm();
    //profileSelection = new ProfileSelection();
    //serverStatus = new StatusPanelForm();

  
    
    createInterface();
  }
  
  private void launch() {
	   try {
		   Process proc = Runtime.getRuntime().exec("java -jar " + SharedData.PATH_TO_CLIENT_JAR);
		} catch (Exception e) {			
			e.printStackTrace();
		}finally{
			System.exit(0);			
		}
	   
	 
	  
}
  
  
  
  

  protected void createInterface() {
    setLayout(new MigLayout());
    //add(profileSelection);
    //add(serverStatus);
    
    add(statusLabel, "west");
   // add(new Panel());
    add(launchButton, "east");
    
    statusLabel.setVisible(true);
    
    progressBar.setVisible(false);
    progressBar.setMinimum(0);
    progressBar.setMaximum(100);
    add(progressBar, "center");
   
    
    //add(new Filler(new Dimension(0, 0), new Dimension(32767, 10), new Dimension(32767, 10)), BorderLayout.SOUTH);

   
   // add(loginForm);
  }
  
  public LaunchButton getLaunchButton(){
	  return launchButton;
  }
  
  public WeaverStatusLabel getStatusLabel(){
	  return statusLabel;
  }

public void setReadyToLaunch() {
	getLaunchButton().setVisible(true);
}
  
public JProgressBar getProgressBar() {
    return progressBar;
  }

  //public LoginContainerForm getLoginForm() {
  //  return loginForm;
  //}

}