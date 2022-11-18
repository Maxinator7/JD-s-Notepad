package SimpleNotepad ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Notepad implements ActionListener {
	
  
	JFrame Window ;
	
	
	// Text Area 
	JTextArea textArea ;
	
	JScrollPane scrollPane ;
	boolean wordWrapon = false ; 
	
	// Top Menu bar Components  
	JMenuBar  menuBar ;
	
	JMenu menuFile,menuEdit,menuFormat,menuColor ;
	
	// File Menu
	JMenuItem iNew,iOpen,  iSave,iSaveAs, iExit ;
	
	// Edit Menu
	JMenuItem iUndo, iRedo ;
	
	
	// Format Menu 
	JMenuItem iWrap, iFontArial, iFontCSMS,iFontTNR, iFontSize8 , iFontSize12 , iFontSize16 , iFontSize20 ,iFontSize24 ,iFontSize28;
	JMenu menuFont, menuFontSize ;
	
	File_Function file = new File_Function(this);  
	
	Format_Function format = new Format_Function(this);
	
	// Color MEnu
	
	JMenuItem iColor1, iColor2, iColor3 ;
	
	Color_Function color = new Color_Function(this);
	
	Edit_Function Edit = new Edit_Function(this);
	
	UndoManager um = new UndoManager();

	//==============================================================================
	
	
	public static void main(String[] args) {
		
		 new Notepad();
	}
	
	//=====================================================================
	
	public Notepad () {    // Notepad Constructor to initialize its attributes and other properties 
		
		createwindow();
		
		Window.setVisible(true);   // Setting Visibility of Window to true 
		
		createtextarea();
		
		createmenubar();
		
		createfilemenu();
		
		createFormatMenu();
		
		
		createEditMenu () ;
		
		createColorMenu();
		
		
		format.selectedFont = "Arial";
		
		format.createFont(16);
		
		format.wordWrap();
		
		color.changeColor("White");
	}
	
	//============================================================================
	
	public void createwindow() {
		
		Window = new JFrame("JD'S Notepad");
		
		Window.setSize(800,600);
		
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // For CLose symbol on Top and closing the application 
	}
	
	
	public void createtextarea() {
		
		
		textArea = new JTextArea();
		
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
				
				
			
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		Window.add(scrollPane);
		
	}
	
	public void createmenubar () {
		
		menuBar = new JMenuBar();
		
		Window.setJMenuBar(menuBar);
		
		menuFile = new JMenu ("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu ("Edit");
		menuBar.add(menuEdit);
		
		
		menuFormat = new JMenu ("Format");
		menuBar.add(menuFormat);
		
		
		menuColor = new JMenu ("Color");
		menuBar.add(menuColor);
		
		
	}
	
	public void createfilemenu() {
		
		iNew = new JMenuItem ("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem ("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem ("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem ("SaveAs");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem ("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
		
	}
	
	public void createEditMenu () {
		
		iUndo = new JMenuItem ("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		
		
		iRedo = new JMenuItem ("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
		
	}

	
	
public void createFormatMenu() {
	
	iWrap = new JMenuItem("Word Wrap: off");
	iWrap.addActionListener(this);
	iWrap.setActionCommand("Word Wrap");
	menuFormat.add(iWrap);
	
	menuFont = new JMenu("Font");
	menuFormat.add(menuFont);
	
	menuFontSize = new JMenu("Font Size");
	menuFormat.add(menuFontSize); 
	
	// adding sub menu item -> i.e Fontmenu
	iFontArial = new JMenuItem("Arial");
	iFontArial.addActionListener(this);
	iFontArial.setActionCommand("Arial");
	menuFont.add(iFontArial);
	
	
	iFontCSMS = new JMenuItem("Comic Sans MS");
	iFontCSMS.addActionListener(this);
	iFontCSMS.setActionCommand("Comic Sans MS");
	menuFont.add(iFontCSMS);
	
	iFontTNR = new JMenuItem("Times New Roman");
	iFontTNR.addActionListener(this);
	iFontTNR.setActionCommand("Times New Roman");
	menuFont.add(iFontTNR);
	
	iFontSize8 = new JMenuItem("8");
	iFontSize8.addActionListener(this);
	iFontSize8.setActionCommand("Size 8");
	menuFontSize.add(iFontSize8);
	
	iFontSize12 = new JMenuItem("12");
	iFontSize12.addActionListener(this);
	iFontSize12.setActionCommand("Size 12");
	menuFontSize.add(iFontSize12);
	
	iFontSize16 = new JMenuItem("16");
	iFontSize16.addActionListener(this);
	iFontSize16.setActionCommand("Size 16");
	menuFontSize.add(iFontSize16);
	
	iFontSize20 = new JMenuItem("20");
	iFontSize20.addActionListener(this);
	iFontSize20.setActionCommand("Size 20");
	menuFontSize.add(iFontSize20);
	
	iFontSize24 = new JMenuItem("24");
	iFontSize24.addActionListener(this);
	iFontSize24.setActionCommand("Size 24");
	menuFontSize.add(iFontSize24);
	
	iFontSize28 = new JMenuItem("28");
	iFontSize28.addActionListener(this);
	iFontSize28.setActionCommand("Size 28");
	menuFontSize.add(iFontSize28);
		
	
}

public void createColorMenu() {
	
	iColor1 = new JMenuItem("White");
	iColor1.addActionListener(this);
	iColor1.setActionCommand("White");
	menuColor.add(iColor1);
	
	
	iColor2 = new JMenuItem("Black");
	iColor2.addActionListener(this);
	iColor2.setActionCommand("Black");
	menuColor.add(iColor2); 
	
	iColor3 = new JMenuItem("Blue");
	iColor3.addActionListener(this);
	iColor3.setActionCommand("Blue");
	menuColor.add(iColor3);
}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String command = e.getActionCommand() ;
		
		switch (command) {
		
		case "New" : file.newFile(); break ;
		
		case "Open" : file.open(); break ;
		
		case "Save" : file.Save(); break ;
		
		case "SaveAs" : file.SaveAs(); break ;
		
		case "Exit" : file.Exit(); break ;
		
		case "Undo" : Edit.Undo();break;
		
		case "Redo" : Edit.redo(); break;
 		
		case "Word Wrap" : format.wordWrap(); break ;
		
		case "Arial" : format.setFont(command); break ;
		
		case "Comic Sans MS" : format.setFont(command);break ;
		
		case "Times New Roman" : format.setFont(command); break ;
		
		case "Size 8" : format.createFont(8); break ;
		
		case "Size 12" : format.createFont(12); break ;
		
		case "Size 16" : format.createFont(16); break ;
		 
		case "Size 20" : format.createFont(20); break ;
		
		case "Size 24" : format.createFont(24); break ;
		
		case "Size 28" : format.createFont(28); break ;
		 
		case "White" :  color.changeColor(command); break ;
		
		case "Black" :  color.changeColor(command); break ;
		
		case "Blue" :  color.changeColor(command); break ;
	
		}
		
	}

}
