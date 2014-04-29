package launcher;

import java.net.URI;

public class SharedData {
	public static final String URL_BLOG = "http://www.starflask.com/launcher/updates";
	public static final String URL_HASH = "http://www.starflask.com/hash";
	public static final String PATH_TO_CLIENT_JAR = getDefaultDirectory() +"\\" +"Sands of Osiris" +"\\";
	public static final String PATH_TO_SERVER_JAR = getDefaultDirectory() +"\\" +"SandsLauncher" +"\\" ;
	
	public static final String FILENAME = "sandsofosiris.jar";
	public static String VERSION = "0.10";
	
	
	private static String getDefaultDirectory() {
		
		return System.getenv("AppData");
	}
	
	
}
