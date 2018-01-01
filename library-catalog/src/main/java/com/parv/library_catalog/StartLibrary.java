package com.parv.library_catalog;


	


	/**
	 * [LibraryCatalog.java]
	 * Author : Parvathi Krishnan
	 * Description:This program allows the user to store elements of a books entrysuch as title isbn# author genre and resType in a well displayed user interface.The software can add new, search, browse, sort(alphabetically),edit and delete entries is the user wishes to do so.
	 * Date: May 14, 2015
	 */

	//Importing Java Statements
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.*;
	import java.util.Scanner;
	import javax.swing.border.BevelBorder;

	//Open Public Class with ActionListener
	public class StartLibrary extends JFrame implements ActionListener { 
	  //Declare GUI components(JPanel,JButton,JTextField,JLabel,JComboBox)
	  JPanel interactPanel = new JPanel();    
	  JButton newButton = new JButton("  NEW ");
	  JButton searchButton = new JButton("SEARCH");
	  JLabel totalCounterLabel = new JLabel ("                                Total Entries:");
	  JTextField totalCounterTF = new JTextField(2);
	  
	  JPanel actionPanel = new JPanel();
	  
	  JPanel newPanel = new JPanel();
	  
	  JPanel infoPanel = new JPanel();
	  
	  JPanel isbnPanel = new JPanel();
	  JLabel isbnLabel = new JLabel("ISBN:   " ); 
	  JTextField isbnTF = new JTextField(20);
	  
	  JPanel titlePanel = new JPanel();
	  JLabel titleLabel = new JLabel("Title:   " ); 
	  JTextField titleTF = new JTextField(20);
	  
	  JPanel authorPanel = new JPanel();
	  JLabel authorLabel = new JLabel("Author:" ); 
	  JTextField authorTF = new JTextField(20);
	  
	  JPanel genrePanel = new JPanel();
	  JLabel genreLabel = new JLabel("Genre: " ); 
	  JComboBox genreCB = new JComboBox();
	  
	  JPanel resTypePanel = new JPanel();
	  JLabel resTypeLabel = new JLabel("Res.Type:" );
	  JComboBox resTypeCB = new JComboBox();
	  
	  JPanel saveExitPanel = new JPanel();
	  JButton saveButton = new JButton("SAVE");
	  JButton exitButton = new JButton("EXIT");
	  
	  JPanel searchPanel = new JPanel();
	  
	  JPanel findInfoPanel = new JPanel();
	  
	  JPanel info2Panel = new JPanel();
	  
	  JPanel isbn2Panel = new JPanel();
	  JLabel isbn2Label = new JLabel("ISBN:   " );
	  JTextField isbn2TF = new JTextField(20);
	  
	  JPanel title2Panel = new JPanel();
	  JLabel title2Label = new JLabel("Title:   " ); 
	  JTextField title2TF = new JTextField(20);
	  
	  JPanel author2Panel = new JPanel();
	  JLabel author2Label = new JLabel("Author:" );
	  JTextField author2TF = new JTextField(20);
	  
	  JPanel genre2Panel = new JPanel();
	  JLabel genre2Label = new JLabel("Genre: " ); 
	  JComboBox genre2CB = new JComboBox();
	  
	  JPanel resType2Panel = new JPanel();
	  JLabel resType2Label = new JLabel("Res.Type:" );
	  JComboBox resType2CB = new JComboBox();
	  
	  JPanel findPanel = new JPanel();
	  JLabel searchByLabel = new JLabel("Search By:" ); 
	  JComboBox searchByCB = new JComboBox();
	  JLabel searchTextLabel = new JLabel("Search Text:" ); 
	  JTextField searchTextTF = new JTextField(10);
	  JButton findButton = new JButton("FIND");
	  
	  JPanel editBrowsePanel = new JPanel();
	  JButton exit2Button = new JButton("EXIT");
	  JButton editButton = new JButton("EDIT");
	  JButton deleteButton = new JButton("DELETE");
	  
	  JPanel tabPanel = new JPanel();
	  JButton tabLButton = new JButton("<<");
	  JButton tabRButton = new JButton(">>");
	  
	  JPanel introPanel = new JPanel();
	  
	  JPanel instructionPanel = new JPanel();
	  JLabel instructionLabel = new JLabel("<html>Welcome to LibraryCatalog2015<br>Program Description:<br>This version of LibraryCatalog will allow for you to efficiently add and store books from your personal library onto an online database<br>\n<br>Remember!:<br>Entries will sorted alphabetically once you save so make sure your entries are in the proper format<br>EX.<br>author(lastnamefirstname)<br>HAPPY READING!!!</html> ", SwingConstants.CENTER);
	  
	  //Empty Components to fill space
	  JLabel blankspace = new JLabel("                                                  ");
	  JLabel blankspace2 = new JLabel("                                          ");
	  JLabel blankspace3 = new JLabel("                                          ");
	  //Declaring global 2D array,Book Entries
	  String[][] books = new String[100][5];
	  //Declaring entry number counter
	  int totalCounter = 0;
	  //Declaring variable used for sorting
	  int currentPosition=0;
	  //Open Constructer 
	  public StartLibrary() { 
	    //Call method user to read txt file
	    loadFile();
	    //Displaying totalCounter in interface
	    totalCounterTF.setText(String.valueOf(totalCounter));
	    //Setting JFrame appearance 
	    setTitle("Library Catalog");
	    setSize(590,380);
	    setResizable(false);
	    //Create Layouts for JPanels ad JFrame
	    FlowLayout layout1 = new FlowLayout();
	    GridLayout layout2 = new GridLayout();
	    BoxLayout layout3 = new BoxLayout(saveExitPanel,BoxLayout.Y_AXIS);
	    BoxLayout layout4 = new BoxLayout(editBrowsePanel,BoxLayout.Y_AXIS);
	    //setting JFrame layout
	    setLayout(layout1);
	    //setting Panel Dimensions for Aesthetics
	    interactPanel.setPreferredSize(new Dimension(590,55));
	    actionPanel.setPreferredSize(new Dimension(590,340));
	    instructionPanel.setPreferredSize(new Dimension(570,250));
	    resTypePanel.setPreferredSize(new Dimension(395,30));
	    genrePanel.setPreferredSize(new Dimension(395,30));
	    titlePanel.setPreferredSize(new Dimension(395,30));
	    authorPanel.setPreferredSize(new Dimension(395,30));
	    isbnPanel.setPreferredSize(new Dimension(395,30));
	    resType2Panel.setPreferredSize(new Dimension(395,30));
	    genre2Panel.setPreferredSize(new Dimension(395,30));
	    title2Panel.setPreferredSize(new Dimension(395,30));
	    author2Panel.setPreferredSize(new Dimension(395,30));
	    isbn2Panel.setPreferredSize(new Dimension(395,30));
	    newPanel.setPreferredSize(new Dimension(590,340));
	    searchPanel.setPreferredSize(new Dimension(590,340));
	    infoPanel.setPreferredSize(new Dimension(400,320));
	    info2Panel.setPreferredSize(new Dimension(400,270));
	    saveExitPanel.setPreferredSize(new Dimension(105,338));
	    editBrowsePanel.setPreferredSize(new Dimension(120,338));
	    findPanel.setPreferredSize(new Dimension(400,65));
	    findInfoPanel.setPreferredSize(new Dimension(400,340));
	    //Adding ActionListener to each JButton
	    newButton.addActionListener(this);
	    searchButton.addActionListener(this);
	    saveButton.addActionListener(this);
	    exitButton.addActionListener(this);
	    exit2Button.addActionListener(this);
	    findButton.addActionListener(this);
	    editButton.addActionListener(this);
	    deleteButton.addActionListener(this);
	    tabLButton.addActionListener(this);
	    tabRButton.addActionListener(this);
	    //Constructing GUI(setting layouts to JPanels,borders,spacing,components,visibility,editability)
	    instructionPanel.setLayout(layout2);
	    instructionPanel.add(instructionLabel);
	    instructionPanel.setVisible(true);
	    
	    isbnPanel.setLayout(layout1);                            
	    isbnPanel.add(isbnLabel);
	    isbnPanel.add(isbnTF);
	    
	    titlePanel.setLayout(layout1);                            
	    titlePanel.add(titleLabel);
	    titlePanel.add(titleTF);
	    
	    authorPanel.setLayout(layout1);                            
	    authorPanel.add(authorLabel);
	    authorPanel.add(authorTF);
	    
	    genreCB.addItem("Select");
	    genreCB.addItem("Romance");
	    genreCB.addItem("Horror");
	    genreCB.addItem("Adventure");
	    genreCB.addItem("NonFiction");
	    genreCB.addItem("Poetry");
	    genreCB.addItem("Other");
	    
	    genrePanel.setLayout(layout1);
	    genrePanel.add(genreLabel);
	    genrePanel.add(genreCB);
	    genrePanel.add(blankspace2);
	    
	    resTypeCB.addItem("Select");
	    resTypeCB.addItem("EBook");
	    resTypeCB.addItem("Print-Book");
	    resTypeCB.addItem("Audio-Book");
	    resTypeCB.addItem("DVD(Movies&TV)");
	    resTypeCB.addItem("CD(Sound&Music)");
	    resTypeCB.addItem("Article(Newspapers&Magazines)");
	    resTypeCB.addItem("Other");
	    
	     resTypePanel.setLayout(layout1);
	    resTypePanel.add(resTypeLabel);
	    resTypePanel.add(resTypeCB);
	    
	    infoPanel.setLayout(layout1);
	    infoPanel.add(isbnPanel);
	    infoPanel.add(titlePanel);
	    infoPanel.add(authorPanel);
	    infoPanel.add(genrePanel);
	    infoPanel.add(resTypePanel);
	    
	    saveExitPanel.setLayout(layout3);
	    saveExitPanel.add(saveButton);
	    saveExitPanel.add(Box.createVerticalStrut(60));
	    saveExitPanel.add(exitButton);
	    
	    newPanel.setLayout(layout1);
	    newPanel.add(infoPanel);  
	    newPanel.add(saveExitPanel);
	    newPanel.setVisible(false);
	    
	    isbn2Panel.setLayout(layout1);                            
	    isbn2Panel.add(isbn2Label);
	    isbn2Panel.add(isbn2TF);
	    
	    title2Panel.setLayout(layout1);                            
	    title2Panel.add(title2Label);
	    title2Panel.add(title2TF);
	    
	    author2Panel.setLayout(layout1);                            
	    author2Panel.add(author2Label);
	    author2Panel.add(author2TF);
	    
	    genre2CB.addItem("Select");
	    genre2CB.addItem("Romance");
	    genre2CB.addItem("Horror");
	    genre2CB.addItem("Adventure");
	    genre2CB.addItem("NonFiction");
	    genre2CB.addItem("Poetry");
	    genre2CB.addItem("Other");
	   
	     genre2Panel.setLayout(layout1);
	    genre2Panel.add(genre2Label);
	    genre2Panel.add(genre2CB);
	    genre2Panel.add(blankspace3);
	    
	    resType2CB.addItem("Select");
	    resType2CB.addItem("EBook");
	    resType2CB.addItem("Print-Book");
	    resType2CB.addItem("Audio-Book");
	    resType2CB.addItem("DVD(Movies&TV)");
	    resType2CB.addItem("CD(Sound&Music)");
	    resType2CB.addItem("Article(Newspapers&Magazines)");
	    resType2CB.addItem("Other");
	    
	     resType2Panel.setLayout(layout1);
	    resType2Panel.add(resType2Label);
	    resType2Panel.add(resType2CB);
	    
	     isbn2TF.setEditable(false);
	    title2TF.setEditable(false);
	    author2TF.setEditable(false);
	    genre2CB.setEditable(false);
	    resType2CB.setEditable(false);
	    
	    info2Panel.setLayout(layout1);
	    info2Panel.add(isbn2Panel);
	    info2Panel.add(title2Panel);
	    info2Panel.add(author2Panel);
	    info2Panel.add(genre2Panel);
	    info2Panel.add(resType2Panel);
	    
	    tabPanel.setLayout(layout1);
	    tabPanel.add(tabLButton);
	    tabPanel.add(tabRButton);
	   
	    editBrowsePanel.setLayout( new FlowLayout(FlowLayout.CENTER, 20, 20) );
	    editBrowsePanel.add(editButton);
	    editBrowsePanel.add(deleteButton);
	    editBrowsePanel.add(exit2Button);
	    editBrowsePanel.add(tabPanel);
	    
	    searchByCB.addItem("Select");
	    searchByCB.addItem("Author");
	    searchByCB.addItem("Title");
	    searchByCB.addItem("Genre");
	    searchByCB.addItem("Res.Type");
	    searchByCB.addItem("ISBN #");
	    
	    findPanel.setLayout(layout1);
	    findPanel.add(searchByLabel);
	    findPanel.add(searchByCB);
	    findPanel.add(searchTextLabel);
	    findPanel.add(searchTextTF);
	    findPanel.add(findButton);
	    
	    findInfoPanel.setLayout(layout1);
	    findInfoPanel.add(findPanel);
	    findInfoPanel.add(info2Panel);
	    
	    searchPanel.setLayout(layout1);
	    searchPanel.add(findInfoPanel);
	    searchPanel.add(editBrowsePanel);
	    searchPanel.setVisible(false);
	    
	    interactPanel.setLayout(layout1);
	    interactPanel.add(newButton);
	    interactPanel.add(blankspace);
	    interactPanel.add(searchButton);
	    interactPanel.add(totalCounterLabel);
	    interactPanel.add(totalCounterTF);
	    
	    actionPanel.setLayout(layout1);
	    actionPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
	    actionPanel.add(instructionPanel);
	    actionPanel.add(newPanel);
	    actionPanel.add(searchPanel);
	    //Ading Panels to JFrame 
	    add(interactPanel);
	    add(actionPanel);
	    
	    setVisible(true);
	    //Calling Method that adds WindowsListener to JFrame( so txt file can be saved when user terminates program)
	    addWindowsListener();
	    
	  }
	  // ActionListener: This method runs when an event occurs
	  
	  public void actionPerformed(ActionEvent event) {
	    //Read Command selected
	    String command = event.getActionCommand();
	    //Condition for each Button entered
	    //If user selects NEW, open newPanel
	    if (command.equals("  NEW ")) {                 
	      System.out.println("new button pressed");
	      searchButton.setEnabled(false);//settingVsisbility
	      instructionPanel.setVisible(false);
	      searchPanel.setVisible(false);
	      newPanel.setVisible(true);
	    }
	    //If user selects SAVE add new row to array
	    else if (command.equals("SAVE")) {  
	      //calling valid entry menthod
	      if(checkValid()){
	        //calling saving entry method
	        saveNewEntry();
	        JOptionPane.showMessageDialog(this, "Entry has been saved");
	        System.out.println("save button pressed");
	        //setting counter text
	        totalCounterTF.setText(String.valueOf(totalCounter));
	        //clearing JTextFields
	        titleTF.setText("");
	        isbnTF.setText("");
	        authorTF.setText("");
	        genreCB.setSelectedIndex(0);
	        resTypeCB.setSelectedIndex(0);
	      }
	      else{
	        //Output error message if there is a blank textField
	        JOptionPane.showMessageDialog(this,"Please complete all entries before saving",
	                                      "Error",
	                                      JOptionPane.ERROR_MESSAGE);  
	      }
	    }
	    //If user selects Search open searchPanel
	    else if (command.equals("SEARCH")) {                
	      System.out.println("search button pressed");
	      //Disable selected buttons
	      editButton.setEnabled(false);
	      deleteButton.setEnabled(false);
	      newButton.setEnabled(false);
	      instructionPanel.setVisible(false);
	      newPanel.setVisible(false);
	      searchPanel.setVisible(true);
	    }
	    //If user selects find
	    else if (command.equals("FIND")) {
	      if(totalCounter>0){
	        //determin what to search by and return respective column number
	        int colNum=0;
	        if(searchByCB.getSelectedItem().equals("ISBN #")){
	          colNum = 0;
	        }else if(searchByCB.getSelectedItem().equals("Title")){
	          colNum = 1;
	        }else if(searchByCB.getSelectedItem().equals("Author")){
	          colNum = 2;
	        }else if(searchByCB.getSelectedItem().equals("Genre")){
	          colNum = 3;
	        }else if(searchByCB.getSelectedItem().equals("Res.Type")){
	          colNum = 4;
	        }
	        //setting current position from sorting method
	        currentPosition = sortByColumn(colNum,removeWhiteSpace(searchTextTF.getText()));
	        System.out.println("find button pressed");
	        displayEntry(currentPosition);
	        
	      }else{
	        //output warning message is entries = 0
	        JOptionPane.showMessageDialog(this,"No entries to search from",
	                                      "Error",
	                                      JOptionPane.WARNING_MESSAGE);
	      }
	    }
	    //Tabs allow user to browse through alphabetically sorted list by using current position
	    else if (command.equals(">>")) {  
	      System.out.println("next button pressed");
	      currentPosition++;
	      if( currentPosition>=totalCounter){
	        //if gone out of bounds then return to first entry 
	        currentPosition=0;
	      }//calling method that displays current position array information
	      displayEntry(currentPosition);
	    }//Same as tab right
	    else if (command.equals("<<")) {  
	      System.out.println("previous button pressed");
	      currentPosition--;
	      if( currentPosition<0){
	        currentPosition=totalCounter-1;
	      }
	      displayEntry(currentPosition);
	    }//when edit is selected, user will be able to edit JTextFields and save changes
	    else if (command.equals("EDIT")) {  
	      System.out.println("edit button pressed");
	      editButton.setText(" SAVE");
	      deleteButton.setEnabled(false);
	      isbn2TF.setEditable(true);
	      title2TF.setEditable(true);
	      author2TF.setEditable(true);
	      genre2CB.setEditable(true);
	      resType2CB.setEditable(true);
	      
	    }//when user selects delete current position will be shifted to delete entry
	    else if (command.equals("DELETE")) {
	      //if user confirms deletion
	      if (JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this entry?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION)
	      {
	        System.out.println("delete button pressed");
	        //calling delete and display methods
	        deleteEntry(currentPosition);
	        displayEntry(currentPosition);
	        JOptionPane.showMessageDialog(this, "Entry has been deleted");
	      }
	    }//if second save button is pressed (edit button) 
	    else if (command.equals(" SAVE")) {  
	      //call method to edit entry and output confirmation message
	      editEntry(currentPosition);
	      JOptionPane.showMessageDialog(this, "Edit has been saved");
	      System.out.println("save button pressed");
	      editButton.setText("EDIT");
	      //enable certain buttons to continue
	      deleteButton.setEnabled(true);
	      isbn2TF.setEditable(false);
	      title2TF.setEditable(false);
	      author2TF.setEditable(false);
	      genre2CB.setEditable(false);
	      resType2CB.setEditable(false);
	      
	    }//whenever exit is selected the program will return to the main instruction page
	    else if (command.equals("EXIT")) {                 
	      System.out.println("exit button pressed"); 
	      newButton.setEnabled(true);
	      searchButton.setEnabled(true);
	      instructionPanel.setVisible(true);
	      newPanel.setVisible(false);
	      searchPanel.setVisible(false);
	      
	    }
	  }
	  public void saveNewEntry(){
	    String isbn =removeWhiteSpace(isbnTF.getText());
	    String title = removeWhiteSpace(titleTF.getText());
	    String author = removeWhiteSpace(authorTF.getText());
	    String genre = genreCB.getSelectedItem().toString();
	    String resType = resTypeCB.getSelectedItem().toString();
	    books[totalCounter]=new String[]{isbn,title,author,genre,resType};
	    totalCounter++;
	    
	  }
	  public int sortByColumn(int colNum,String text){
	    String[] placeHolder = new String[5];
	    for( int i = 0; i < totalCounter-1; i++ ){
	      for(int j = 0; j <totalCounter-i-1; j++ ){
	        if((books[j][colNum].compareToIgnoreCase(books[j+1][colNum]))>0){
	          placeHolder = books[j+1];
	          books[j+1] = books[j];
	          books[j] = placeHolder;
	        }
	      }
	    }
	    int position=-1;
	    for(int k=0; k<totalCounter; k++){
	      
	      if(books[k][colNum].indexOf(text)==0){
	        position= k;
	        break;
	      }
	    }if(position==-1){
	      JOptionPane.showMessageDialog(this,"No Matches.. Sorry","WARNING"
	                                      ,JOptionPane.WARNING_MESSAGE);
	       position=0;
	    }
	    return position;
	  }
	  public void displayEntry(int position){
	    isbn2TF.setText(books[position][0]);
	    title2TF.setText(books[position][1]);
	    author2TF.setText(books[position][2]);
	    genre2CB.setSelectedItem(books[position][3]);
	    resType2CB.setSelectedItem(books[position][4]);
	    totalCounterTF.setText(String.valueOf(totalCounter));
	    editButton.setEnabled(true);
	    deleteButton.setEnabled(true);
	    repaint();
	  }
	  public void editEntry(int position){
	    String isbn = removeWhiteSpace(isbn2TF.getText());
	    String title = removeWhiteSpace(title2TF.getText());
	    String author = removeWhiteSpace(author2TF.getText());
	    String genre = genre2CB.getSelectedItem().toString();
	    String resType = resType2CB.getSelectedItem().toString();
	    books[position]= new String[]{isbn,title,author,genre,resType};
	    
	  }
	  public boolean checkValid(){
	    String isbn = isbnTF.getText();
	    String title = titleTF.getText();
	    String author = authorTF.getText();
	    String genre = genreCB.getSelectedItem().toString();
	    String resType = resTypeCB.getSelectedItem().toString();
	    if((isbn==null)||(title==null)||(author==null)||(genre.equals("Select"))||(resType.equals("Select"))){
	      return false;
	    }else{
	      return true;
	    }
	  }
	  public void deleteEntry(int position){
	    for (int i = position; i<totalCounter;i++){
	      books[i]=books[i+1];
	    }
	    totalCounter--;
	  }
	  public void loadFile(){
	    
	    try{
	      
	      File myFile = new File("LibraryCatalog.txt");
	      Scanner input = new Scanner(myFile);
	      totalCounter=0;
	      while (input.hasNext()) { 
	        String isbn=input.next();
	        String title=input.next();
	        String author=input.next();
	        String genre=input.next();
	        String resType=input.next();
	        books[totalCounter] = new String[]{isbn,title,author,genre,resType};
	        totalCounter++;
	        
	      }
	      
	      
	      
	      totalCounterTF.setText(String.valueOf(totalCounter));
	      repaint();
	      
	      
	      input.close();
	      
	      totalCounterTF.setText(String.valueOf(totalCounter));
	    }catch(Exception e){
	    }
	  }
	  public void saveFile(){
	    
	    try{
	      File myFile = new File("LibraryCatalog.txt");
	      if(totalCounter>0){
	      PrintWriter output = new PrintWriter(myFile); 
	      for(int i=0;i<totalCounter;i++){
	        for(int j=0;j<5;j++){
	          output.println(books[i][j]);
	        }
	      }
	      output.close(); 
	       }
	      else{
	      if(myFile.exists()){
	      myFile.delete();
	       } 
	      }
	    }
	    catch(Exception e){
	      
	    }
	    
	    
	  }
	  public String removeWhiteSpace(String text){
	    String newText = text.replaceAll("\\s+","");
	    return newText;
	  }
	  public void addWindowsListener(){
	    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    this.addWindowListener(new WindowAdapter() {
	      @Override
	      public void windowClosing(WindowEvent event) {
	        exitProcedure();
	      }
	    });
	  }
	  
	  public void exitProcedure() {
	    saveFile();
	    this.dispose();
	    System.exit(0);
	  }
	  public static void main(String[] args) throws Exception{   
	    StartLibrary frame1 = new StartLibrary();     
	  } 
	}
	
