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
		
		notepad.textArea.setText("");
		notepad.Window.setTitle("New");
		fileName = null ;
		fileAddress = null ;
		
	}
	
	public void open () {
		
		FileDialog fd = new FileDialog(notepad.Window,"Open",FileDialog.LOAD );
	      fd.setVisible(true);
	      
	      if(fd.getFile()!= null) {
	    	  
	    	  fileName = fd.getFile();
	    	  fileAddress = fd.getDirectory();
	    	  notepad.Window.setTitle(fileName);
	    	  
	    	  try {
	    		 
	    		  BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName)) ; 
	    	  notepad.textArea.setText("");
	    	  
	    	  String line = null ;
	    	  
	    	  while ( (line = br.readLine())!= null) {
	    		  
	    		  notepad.textArea.append(line + "\n");
	    		   
	    	  }
	    	  br.close();
	    	  }catch(Exception e) {
	    		  
	    		  System.out.println("File not opened");
	    	  } 
	      }
	       
	}
	
	 public void Save () {
		 
		 if (fileName == null) {
			 SaveAs();
			 
		 }else {
			 
			 try {
				 FileWriter fw = new FileWriter(fileAddress + fileName);
		    	  fw.write(notepad.textArea.getText());
		    	  notepad.Window.setTitle(fileName);
		    	  fw.close();
				 
			 }catch (Exception e) {
				 
				 System.out.println("Somethingis wrong");
				 
			 }
		 }
   	  
     }
     
     public void SaveAs() {
   	  
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
