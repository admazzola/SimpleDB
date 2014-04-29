package launcher.ui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTabbedPane;


public class LauncherTabPanel extends JTabbedPane
{

  private final WebsiteTab blog;
  private final ConsoleTab console;
 // private CrashReportTab crashReportTab;

  public LauncherTabPanel()
  {
    super(1);
    
    

    blog = new WebsiteTab();
    console = new ConsoleTab();

    createInterface();
  }

  protected void createInterface() {
    addTab("Update Notes", blog);
    addTab("Development Console", console);
    //addTab("Profile Editor", new ProfileListTab());
    //addTab("Local Version Editor (NYI)", new VersionListTab());
  }

  

  public WebsiteTab getBlog() {
    return blog;
  }

  public ConsoleTab getConsole() {
    return console;
  }

  public void showConsole() {
    setSelectedComponent(console);
  }

  /*public void setCrashReport(CrashReportTab newTab) {
    if (crashReportTab != null) removeTab(crashReportTab);
    crashReportTab = newTab;
    addTab("Crash Report", crashReportTab);
    setSelectedComponent(newTab);
  }*/

  protected void removeTab(Component tab) {
    for (int i = 0; i < getTabCount(); i++)
      if (getTabComponentAt(i) == tab) {
        removeTabAt(i);
        break;
      }
  }
}