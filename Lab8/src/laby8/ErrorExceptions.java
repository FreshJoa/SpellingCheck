package laby8;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ErrorExceptions extends Exception {
	ArrayList<String> message=new ArrayList<>();
	
	public ErrorExceptions(ArrayList<String> mess) {
		
		message.addAll(mess);
		//super();
		JOptionPane.showMessageDialog (null,
			    "You made a mistake.",
			    "Mistake!!",
			    JOptionPane.WARNING_MESSAGE);
	
		
	}
	
	
	

	

}
