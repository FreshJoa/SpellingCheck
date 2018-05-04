package laby8;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Menu extends JMenu implements ActionListener {
	Window window;
	JMenuItem readFile;
	JMenuItem saveFile;
	
	
	String[] reader = null;
	String newline = "\n";

	ArrayList<String> originalText = new ArrayList<String>();
	ArrayList<String> emptyText = new ArrayList<String>();
	ArrayList<String> changeText;
	

	public Menu(Window window) {
		this.window = window;
		setText("Menu");

		readFile = new JMenuItem("Read file");
		saveFile = new JMenuItem("Save file");


		readFile.addActionListener(this);
		saveFile.addActionListener(this);
		
		this.add(readFile);
		this.add(saveFile);
	}

	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if (object == readFile) {
			readFile();
			
		} else if (object == saveFile) {
			
			try {
				window.textComponent.saveFile();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} 

	}

	public void readFile() {
		JFileChooser chooser = new JFileChooser();
		String line = "";
		BufferedReader bfr = null;
		int i = 0;

		int returnVal = chooser.showDialog(null, "Choose");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File fr = chooser.getSelectedFile();
			try {
				bfr = new BufferedReader(new FileReader(fr));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// ODCZYT KOLEJNYCH LINII Z PLIKU:
			try {
				while ((line = bfr.readLine()) != null) {
					originalText.add(line);

					
					System.out.println(line);
					
					i++;

				}
			} catch (IOException e) {
				System.out.println("BLAD ODCZYTU Z PLIKU!");
				System.exit(2);
			}
			

			System.out.println(originalText);
			changeToEmptyText();

		}

	}

	
	public void changeToEmptyText() {
		emptyText = new ArrayList<>();
		String ii = "";
		for (int i = 0; i < originalText.size(); i++) {

			ii = originalText.get(i).replace("ą", "?").replace("ż", "?").replace("u", "?").replace("ó", "?")
					.replace("rz", "?").replace("ch", "?").replace("h", "?");

			emptyText.add(ii);

			System.out.println(emptyText.get(i));
		}

	}
	
	public void stringTokenizer() {
		
	}

	public Menu(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	public Menu(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public Menu(String s, boolean b) {
		super(s, b);
		// TODO Auto-generated constructor stub
	}

}
