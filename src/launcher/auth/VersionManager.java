package launcher.auth;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import com.Weaver;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.orb.WeaverOrb;

import launcher.Http;
import launcher.Launcher;
import launcher.OperatingSystem;
import launcher.SharedData;


public class VersionManager {

	public VersionManager(){
		
			if(hasCurrentVersion()){
			Launcher.setGameUpToDate();
			//start seeding
			
			
			
		}else{
			//start leeching
			/*1. ask permission to overwrite old jar
			 * 2. find peeps who have the file
			 * 3. get it from them in tiny packets
			 */
			
			
			
		}
		
		
		
	}

	private boolean hasCurrentVersion() {
		String currentHash = null;
		String gameJarHash = null;
		
	
		try {	
			gameJarHash = getGameJarHash();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			currentHash = Http.performGet(new URL(SharedData.URL_HASH));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		if(gameJarHash!=null && currentHash!=null){
			if(currentHash.startsWith(gameJarHash) && gameJarHash.length() >= 40){
				return true;				
			}
		}		

		return false;
	}
	
	
	
	
	protected String getGameJarHash() throws Exception{		
		File file = new File(SharedData.PATH_TO_CLIENT_JAR);		
		HashCode hc = Files.hash(file, Hashing.sha1());
		return hc.toString();
	}
	
	
	
}
