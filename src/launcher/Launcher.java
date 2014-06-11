package launcher;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.net.UnknownHostException;

public class Launcher {

	
	static Launcher launcher;

	static LauncherFrame launcherFrame;
	static LauncherPanel launcherPanel;
	
	
	public static PipedOutputStream pos = new PipedOutputStream();
	public static PrintStream out;

	public static void main(String args[]) {
		  try {
			UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		out = new PrintStream(pos,true);
		
		//System.setOut(ps);
		
		
		launcher = new Launcher();

		try {
			launcher.initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}



	private void initialize() throws UnknownHostException {

		
		LauncherFrame frame = new LauncherFrame();
		frame.setTitle("Simple DB " + SharedData.VERSION);
		frame.setSize(725, 525);
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
		
		
		URL imgURL = getClass().getResource("/launcher/assets/icon64.png");
		ImageIcon ii = new ImageIcon(imgURL); //Toolkit.getDefaultToolkit().getImage(ii)
		frame.setIconImage(ii.getImage()); 
		

		launcherPanel = new LauncherPanel();
		launcherPanel.getSidebar().setAlignmentY(Component.BOTTOM_ALIGNMENT);
		launcherPanel.getSidebar().setAlignmentX(Component.CENTER_ALIGNMENT);
		setLookAndFeel();

		frame.getContentPane().add(launcherPanel);

		// frame.pack();
		frame.setVisible(true);

		

	

		while (true) {
			update();
		}
	}

	
	private void update() {

		
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
				UIManager.setLookAndFeel(UIManager
						.getCrossPlatformLookAndFeelClassName());
			} catch (Exception f) {
				f.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public static LauncherPanel getPanel() {
		return launcherPanel;

	}

	public static void println(String s) {
		System.out.println(s);
		getPanel().getTabPanel().getConsole().print(s);
	}



	static CustomLogger customLogger = new CustomLogger();
	public static CustomLogger getLogger() {		
		return customLogger;
	}
	
	
}
