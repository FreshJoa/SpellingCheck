package laby8;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.text.StyledEditorKit;

import com.sun.glass.ui.Menu;

public class StyleMenu extends JMenu {

	Window window;
	public StyleMenu(Window window) {
		super();
		this.window=window;
		
			setText("Style");

			Action action = new StyledEditorKit.BoldAction();
			action.putValue(Action.NAME, "Bold");
			add(action);

			action = new StyledEditorKit.ItalicAction();
			action.putValue(Action.NAME, "Italic");
			add(action);

			action = new StyledEditorKit.UnderlineAction();
			action.putValue(Action.NAME, "Underline");
			add(action);

			addSeparator();

			add(new StyledEditorKit.FontSizeAction("12", 12));
			add(new StyledEditorKit.FontSizeAction("14", 14));
			add(new StyledEditorKit.FontSizeAction("18", 18));

			

			addSeparator();

			add(new StyledEditorKit.ForegroundAction("Red", Color.red));
			add(new StyledEditorKit.ForegroundAction("Green", Color.green));
			add(new StyledEditorKit.ForegroundAction("Blue", Color.blue));
			add(new StyledEditorKit.ForegroundAction("Black", Color.black));

			
		
	}

}
