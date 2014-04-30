package launcher;

import java.util.ArrayList;
import java.util.List;

public class CustomLogger {

	
	
	List<String> lines = new ArrayList<String>();
	public synchronized void log(String line) {
		lines.add(line);
		
	}

	public synchronized void update() {
		
		for(String line : lines){
			Launcher.out.println(line);
		}
		lines.clear();
		
	}

}
