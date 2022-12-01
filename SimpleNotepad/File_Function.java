package SimpleNotepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class File_Function {

	Notepad notepad ;
	
	String fileName ;
	
	String fileAddress ;
	
	
	public File_Function(Notepad notepad) {
		
		this.notepad = notepad ;
	}
	
	public void newFile() {
		
		notepad.textArea.setText(""); // setting TexArea to blank 
		notepad.Window.setTitle("New"); // setting Title to NEW 
		fileName = null ;
		fileAddress = null ;
		
	}
	
	// to open saved Text files 
	public void open () {
		
		// FileDialog func is used to load files in Application window 
		FileDialog fd = new FileDialog(notepad.Window,"Open",FileDialog.LOAD );
	      fd.setVisible(true);
	      
	      if(fd.getFile()!= null) {
	    	  
	    	  fileName = fd.getFile();
	    	  fileAddress = fd.getDirectory();
	    	  notepad.Window.setTitle(fileName);
	    	  
	    	  try {
	    		 // Reading text file with files address and file name as parameters 
	    		  BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName)) ; 
	    	  notepad.textArea.setText("");
	    	  
	    	  String line = null ;   // String to store files text 
	    	  
	    	  while ( (line = br.readLine())!= null) {
	    		  
	    		  notepad.textArea.append(line + "\n");   // appending text in String line and changing line 
	    		   
	    	  }
	    	  br.close();
	    	  }catch(Exception e) {
	    		  
	    		  System.out.println("File not opened");    //  error message in console in case of invalid file name or file address  
	    	  } 
	      }
	       
	}
	
	 public void Save () {
		 
		 if (fileName == null) {    // calling saveAs func in case of new File 
			 SaveAs();
			 
		 }else {
			  // writing text or saving text in existing file with name & address  
			 try {
				 FileWriter fw = new FileWriter(fileAddress + fileName);
		    	  fw.write(notepad.textArea.getText());
		    	  notepad.Window.setTitle(fileName);
		    	  fw.close();
				 
			 }catch (Exception e) {
				 
				 System.out.println("Something is wrong");
				 
			 }
		 }
   	  
     }
     
	 // Func to save new File or existing file with new Name 
     public void SaveAs() {
   	  
    	 // FileDialog-save meth to save new file 
   	  FileDialog fd = new FileDialog(notepad.Window,"SaveAs", FileDialog.SAVE); 
      fd.setVisible(true);
      
      if  (fd.getFile()!= null){
    	  fileName = fd.getFile();
    	  fileAddress = fd.getDirectory();
    	  notepad.Window.setTitle(fileName);
    	  
      }
      try {
    	  FileWriter fw = new FileWriter(fileAddress + fileName);
    	  fw.write(notepad.textArea.getText());
    	  fw.close();
    	  
      }catch (Exception  e) {
    	  
    	  System.out.println("Something is wrong");
      }
     
     }
     
     
     public void Exit() {
    	 System.exit(0);
     }
}
