package SimpleNotepad;

public class Edit_Function {

	Notepad notepad ;
	
	public Edit_Function (Notepad notepad) {
		
		this.notepad = notepad ;
	}
	
	public void Undo() {
		
		notepad.um.undo();
	}
	
	public void redo () {
		
		notepad.um.redo();
		 
	}
}
