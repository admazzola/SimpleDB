package launcher;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import launcher.ui.ConsoleTab;
import launcher.ui.LauncherTabPanel;
import launcher.ui.SidebarPanel;

//https://github.com/meiskam/mcLauncher2/blob/master/src/main/java/net/minecraft/launcher/GameLauncher.java#L269


public class LauncherPanel extends JPanel{

	
	 
	private final LauncherTabPanel tabPanel;
	 private final SidebarPanel sidebar;
	 
	public LauncherPanel(){
		this.setSize(675, 525);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//this.setLayout(new MigLayout() );q
		
		//this.setBorder(BorderFactory.createTitledBorder("test"));
		
		 sidebar = new SidebarPanel();
		
		 tabPanel = new LauncherTabPanel();
		 
		 createInterface();
	}
	
	
	 protected void createInterface() {
		    tabPanel.getBlog().setPage(SharedData.URL_BLOG);

		    setLayout(new MigLayout());

		    add(tabPanel, "north, h 460!, w 100%");
		    add(sidebar, "south, h 60!, w 100%");
		  }
	 
	 public LauncherTabPanel getTabPanel() {
		    return tabPanel;
		  }
	 
	
	 
	 
	 public SidebarPanel getSidebar() {
		    return sidebar;
		  }
	 
	 
	 protected void launchGame() {
		 //from button
		 
	 }
	
}
