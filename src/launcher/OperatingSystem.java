package launcher;

import java.net.URI;

public class OperatingSystem {
	
	public static void openLink(URI link){
		try{
			Class<?> desktopClass = Class.forName("java.awt.Desktop");
			Object o = desktopClass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
			
		}catch(Exception e){
			Launcher.println("failed to open link "+ link.toString());
			
		}
		
		
	}
	
	
	
}
