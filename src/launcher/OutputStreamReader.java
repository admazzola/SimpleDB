package launcher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import launcher.ui.ConsoleTab;

public class OutputStreamReader implements Runnable{

	ConsoleTab consoleTab;
	PipedOutputStream stream;
	public OutputStreamReader(ConsoleTab consoleTab, PipedOutputStream stream) {
		this.consoleTab=consoleTab;
		this.stream=stream;
	}


	@Override
	public void run() {
		
		try{
		PipedInputStream pis = new PipedInputStream(stream );
		BufferedReader reader = new BufferedReader( new InputStreamReader(pis) );
        String line = null;
		   while (true ) {
			   line = reader.readLine();
			   consoleTab.append(line);
		   }
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
