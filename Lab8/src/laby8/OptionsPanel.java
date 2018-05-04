package laby8;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsPanel extends JPanel implements ActionListener {
	JButton setEmptyTextButton;
	JButton setOriginalTextButton;
	JButton checkText;
	Window window;
	String whichButton="";
	
	
	
	

	public OptionsPanel(Window window) {
		
		super();
		this.window=window;
		
		setEmptyTextButton=new JButton("Set text with gaps");
		setOriginalTextButton=new JButton("Set original text");
		checkText=new JButton("Check text");
		setLayout(new GridLayout(3, 1));
		add(setEmptyTextButton);
		add(setOriginalTextButton);
		add(checkText);
		setOriginalTextButton.addActionListener(this);
		setEmptyTextButton.addActionListener(this);
		checkText.addActionListener(this);
		
		}
	
	public OptionsPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public OptionsPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public OptionsPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==setOriginalTextButton) {
			whichButton=window.textComponent.original;
			window.textComponent.setText();
			
			
		
		}
		if(e.getSource()==setEmptyTextButton) {
			whichButton=window.textComponent.empty;
			window.menu.changeToEmptyText();
			window.textComponent.setText();
			
		
		}
		if(e.getSource()==checkText) {
			try {
				window.textComponent.checkAllText();
			} catch ( ErrorExceptions e1) {
				for(int i=0; i<e1.message.size();i++) {
					window.textComponent.changeLog.append(e1.message.get(i)+"\n");
				}
				
				//e1.printStackTrace();
			}
		
		}
		
	}

}
