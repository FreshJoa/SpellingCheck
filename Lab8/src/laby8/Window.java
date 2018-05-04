package laby8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

import com.sun.java.swing.plaf.windows.resources.windows;

import javafx.scene.layout.Border;



public class Window extends JFrame {
	public static JFrame windowStatic=new Window();
	//ErrorExceptions error;
	Menu menu;
	JMenuBar menuBar;
	TextComponent textComponent;
	OptionsPanel optionsPanel;
	StyleMenu styleMenu;
	
	
	public Window() throws HeadlessException {
		styleMenu=new StyleMenu(this);
		menu=new Menu(this);
		
		
		optionsPanel=new OptionsPanel(this);
		textComponent=new TextComponent(this, menu, optionsPanel);
		
		
		menuBar = new JMenuBar();
		menuBar.add(menu);
		menuBar.add(styleMenu);
		this.setJMenuBar(menuBar);
		setLayout(new BorderLayout());
		add(optionsPanel, BorderLayout.LINE_START);
		
		getContentPane().add(textComponent.splitPane, BorderLayout.CENTER);
		
		//getContentPane().add(textComponent.statusPane, BorderLayout.PAGE_END);
		add(textComponent.statusPanel, BorderLayout.LINE_END);
		
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Text Editor");
		this.pack();
		
	}


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() { 
			@Override
			public void run() {
				new Window().setVisible(true);
				
				
			}
		});

	}

}
