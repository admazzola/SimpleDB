package launcher.ui;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent.EventType;

import net.miginfocom.swing.MigLayout;
import launcher.Launcher;
import launcher.OperatingSystem;


public class MainTab extends JScrollPane{

	InputPanel input = new InputPanel();
	SearchPanel search = new SearchPanel();
	ImportPanel aux = new ImportPanel();
	JPanel body = new JPanel();
		
	public MainTab(){
		
		body.setLayout(new MigLayout());
		
		setViewportView(body);
		
		 
		body.add(input, "north, h 110!, w 100%");
		body.add(aux, "south, h 150!, w 100%");
		body.add(search, "south, h 100!, w 100%");
		
		
	}
	

}
