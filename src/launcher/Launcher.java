package launcher;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import launcher.net.FileClient;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Launcher {

	static Launcher launcher;
	
	static LauncherFrame launcherFrame;
	static LauncherPanel launcherPanel;
	
	
	public static void main(String args[]){
		launcher = new Launcher();	
		
		try{
		launcher.initialize();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	private FileClient fileClient;
	 
	 
	private void initialize() throws UnknownHostException {
		
		new File(SharedData.PATH_TO_CLIENT_JAR).mkdir();
				
		LauncherFrame frame = new LauncherFrame();
		frame.setTitle("Sands Launcher " + SharedData.VERSION);
        frame.setSize(725,525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
              System.exit(0);
            }
        });
        
        
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());
        
        
		launcherPanel = new LauncherPanel();
		launcherPanel.getSidebar().setAlignmentY(Component.BOTTOM_ALIGNMENT);
		launcherPanel.getSidebar().setAlignmentX(Component.CENTER_ALIGNMENT);
		setLookAndFeel();
		
		frame.getContentPane().add(launcherPanel);
		
		//frame.pack();
        frame.setVisible(true);
        
        
        
        
        try {
			fileClient = new FileClient("192.168.62.187",2232);
			
			new Thread(fileClient).start();
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
       // versionManager = new VersionManager();
        
		//pass in where the file should be located (where it WILL be located for masters)
       /* weaver = new Weaver( new NodeInfo[]{new NodeInfo("107.170.122.137",2232)} , 2242 );
                
        WeaverOrb orb = new WeaverOrb( SharedData.PATH_TO_CLIENT_JAR + "sandsofosiris.jar", weaver );
		orb.start();		 
		      
		//pass in addresses of the master nodes		
		weaver.registerOrb(orb);
		weaver.start();
		*/
		
		while(true){
			update();
		}
	}
	
	
	
	public static String getCheckSum() {
		try{
		File file = new File(  SharedData.PATH_TO_CLIENT_JAR + "sandsofosiris.jar" );		
		HashCode hc = Files.hash(file, Hashing.sha1());
		return hc.toString();
		}catch(Exception e){
			return "nofilefound";
		}
	}


	boolean readyToLaunch = false;
	private void update() {
		
		if(!readyToLaunch){
			if(fileClient!=null && !fileClient.isFinished()){
				readyToLaunch = true;
				getPanel().getSidebar().setReadyToLaunch();  
				getPanel().getSidebar().getProgressBar().setVisible(false);
			}else{
					getPanel().getSidebar().getProgressBar().setVisible(true);
					getPanel().getSidebar().getProgressBar().setValue((int) (fileClient.getProgress() * 100) );
					System.out.println("setting progress to " + fileClient.getProgress() * 100);
			}
		}
		
		getPanel().getSidebar().getStatusLabel().setStatus(fileClient.getStatus());
		
		 try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}


	
	
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
			} catch (Exception f) {			
				f.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

	public static LauncherPanel getPanel(){
		return launcherPanel;	
		
	}

	public static void println(String s) {
		System.out.println(s);
		getPanel().getTabPanel().getConsole().print(s);
	}

	public static void setGameUpToDate() {
		
		Launcher.getPanel().getSidebar().getLaunchButton().setVisible(true);
		
	}
	
	
	
}
