package SimpleNotepad;

public class Edit_Function {

	Notepad notepad ;
	
	public Edit_Function (Notepad notepad) {
		
		this.notepad = notepad ;
	}
	
	public void Undo() {
		
		notepad.um.undo();   // calling UM func in Main class TextArea 
	}
	
	public void redo () {
		
		notepad.um.redo();    // calling UM func in Main class TextArea 
		 
	}
}
