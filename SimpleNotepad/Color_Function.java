package SimpleNotepad;

import java.awt.Color;

public class Color_Function {

	Notepad notepad ;
	
	
	public  Color_Function(Notepad notepad) {
		
		this.notepad = notepad ;
		
	}
	
	public  void changeColor(String color) {
		
		switch(color) {
		
		case "White" : 
			notepad.Window.getContentPane().setBackground(Color.white);
			
			notepad.textArea.setBackground(Color.white);
			
			notepad.textArea.setForeground(Color.black);
			
			break ; 
		
		case "Black" : 
			notepad.Window.getContentPane().setBackground(Color.black);
			
			notepad.textArea.setBackground(Color.black);
			
			notepad.textArea.setForeground(Color.white);
			
			break ; 
			
			
		case "Blue" : 
			notepad.Window.getContentPane().setBackground(Color.blue);
			
			notepad.textArea.setBackground(Color.BLUE);
			
			notepad.textArea.setForeground(Color.white);
			
			break ; 
		
		
		}
		
		
		
		
	}
}
