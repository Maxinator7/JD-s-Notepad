package SimpleNotepad;

import java.awt.Font;

public class Format_Function {

	Notepad notepad ;
	Font arial, comicSansMS , timesNewRoman ;
	
	String selectedFont ;
	public Format_Function (Notepad notepad) {
		
		this.notepad = notepad ;
	}
	
	public void wordWrap() {
		
		if( notepad.wordWrapon == false ) {
			notepad.wordWrapon = true ;
			notepad.textArea.setLineWrap(true);
			notepad.textArea.setWrapStyleWord(true);
			notepad.iWrap.setText("Word Wrap on");
		}else if ( notepad.wordWrapon == true) {
			
			notepad.wordWrapon = false ;
			notepad.textArea.setLineWrap(false);
			notepad.textArea.setWrapStyleWord(false);
			notepad.iWrap.setText("Word Wrap off");
		}
	}
	
	public void createFont(int fontsize) {
		
		arial = new Font ("Arial", Font.PLAIN, fontsize);
		
		comicSansMS = new Font ("comic Sans MS",Font.PLAIN, fontsize);
		
		timesNewRoman = new Font ("Times New Roman", Font.PLAIN, fontsize);
		
		setFont(selectedFont);
		
	}
	
	
	public void setFont(String font) {
		
		selectedFont = font ;
		
		switch (selectedFont) {
		
		case "Arial" :
		
		notepad.textArea.setFont(arial);
		break;
		
		case "Comic Sans MS" :
			
			notepad.textArea.setFont(comicSansMS);
			break;
			
		case "Times New Roman" :
			
			notepad.textArea.setFont(timesNewRoman);
			break;
		
		}
	}
}
