package laby8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.concurrent.SynchronousQueue;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import sun.swing.MenuItemLayoutHelper;

public class TextComponent extends JPanel {
	JTextPane textPane;
	AbstractDocument doc;
	JTextArea changeLog;
	
	Window window;
	JSplitPane splitPane;
	JPanel statusPanel;
	Menu menu;
	
	OptionsPanel optionsPanel;
	public static final String empty = "Empty";
	public static final String original = "Original";
	boolean check = true;

	String[] changeStrings = null;
	String[] originalStrings = null;

	public TextComponent(Window window, Menu menu, OptionsPanel optionsPanel) {
		super();
		this.optionsPanel = optionsPanel;
		this.window = window;
		this.menu = menu;
		
		setLayout(new BorderLayout());
		
		textPane = new JTextPane();

		StyledDocument styledDoc = textPane.getStyledDocument();

		doc = (AbstractDocument) styledDoc;

		statusPanel = new JPanel();

		

		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(new Dimension(900, 500));

		// Create the text area for the status log and configure it.
		changeLog = new JTextArea(5, 30);
		// changeLog.setEditable(false);//powoduje, że obszar tekstu jest nieedytowalny.
		// Nadal można go wybrać, a użytkownik może kopiować z niego dane, ale
		// użytkownik nie może bezpośrednio zmieniać zawartości obszaru tekstowego.
		JScrollPane scrollPaneForLog = new JScrollPane(changeLog);

		// Create a split pane for the change log and the text area.
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, scrollPaneForLog);// wyświetla dwa komponenty,
																							// jeden obok drugiego lub
																							// jeden na drugim.
		splitPane.setOneTouchExpandable(true);// tylko jedno okienko jest do edytowanie/pisania


	}

	public void setText() {

		SimpleAttributeSet attributes;// Tworzy nowy zestaw atrybutów.
		attributes = new SimpleAttributeSet();

		StyleConstants.setForeground(attributes, Color.red);

		try {
			for (int i = 0; i < menu.originalText.size(); i++) {
				
				 if(optionsPanel.whichButton==original) 
				  {
					  doc.insertString(doc.getLength(), menu.originalText.get(i) , attributes);
				  
				  } if(optionsPanel.whichButton==empty) {
				  
				 
				doc.insertString(doc.getLength(), menu.emptyText.get(i) , attributes);
				
			}
			}
		} catch (BadLocationException ble) {
			System.err.println("Couldn't insert initial text.");
		}
	}

	public void saveFile() {
		JFileChooser chooser = new JFileChooser();
		;
		BufferedWriter bw = null;

		int returnVal = chooser.showDialog(null, "Choose");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File fw = chooser.getSelectedFile();

			try {
				bw = new BufferedWriter(new FileWriter(fw));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {

				bw.write(textPane.getText());
				bw.close();

			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	public void checkAllText() throws ErrorExceptions {


		ArrayList<String> mistakes=new ArrayList<>();
		
		  changeStrings = textPane.getText().split("\\s");
		  String longOriginal="";
		  
		 
		  for (int i = 0; i < menu.originalText.size(); i++) {
		  longOriginal+=menu.originalText.get(i);
		  
		 
		  
		  } 
		  System.out.println(longOriginal);
		  originalStrings=longOriginal.split("\\s");
		  System.out.println(originalStrings.length);
		  
		 
		 System.out.println(changeStrings.length);
		 
		 
		 for (int i = 1; i < originalStrings.length; i++) {
			 System.out.println(originalStrings[i] +" "+changeStrings[i]);
				if (!(originalStrings[i].equalsIgnoreCase(changeStrings[i]))) {
					
					System.out.println(i);
					System.out.println(originalStrings[i]);
					System.out.println(changeStrings[i]);
					mistakes.add(changeStrings[i]);
					
				
				}

			}
			if(mistakes.size()==0) {
				
			}
			else {
				throw new ErrorExceptions(mistakes);
			}
		 
	}

}
