package launcher;

import java.io.File;
import java.net.URI;

public class SharedData {
	

	public static String VERSION = "0.1";
	
	

	
	public static String getDefaultDirectory()
	{

		String OS = System.getProperty("os.name").toUpperCase();

		String answer = System.getProperty("user.home");

		if (OS.contains("WIN")) {
			answer = System.getenv("APPDATA");
		}
		else if (OS.contains("MAC")) {
			answer = System.getProperty("user.home") + "/Library/Application "
					+ "Support";
		}
		else if (OS.contains("NUX")) {
			answer = System.getProperty("user.home");
		}

		//answer += "\\" + AppName + "\\";

		return answer + "\\" + "SimpleDB" + "\\";
	}
	
	
	public static OS getOS()
	{
		String osname = System.getProperty("os.name").toUpperCase();

		if (osname.contains("WIN")) {
			return OS.WINDOWS;
		}
		else if (osname.contains("MAC")) {
			return OS.MAC;
		}
		else if (osname.contains("NUX")) {
			return OS.LINUX;
		}
		
		return OS.LINUX;
	}
	
	public enum OS{
		WINDOWS("win"),MAC("mac"),LINUX("nux");

		
		private String name;

		OS(String name){
			this.name=name;
		}
		
		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}
	}
	
	
}
