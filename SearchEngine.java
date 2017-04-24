package SearchEngine;
import javax.swing.*;//imports needed for code
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class SearchEngine extends JFrame implements ActionListener   // The class and the implementation of the JFrame and ActionListener
	{
	

	   JButton Cars;// These buttons run the code when clicked
	   JButton Games;
	   JButton Colours;
	   JButton Close; 
	   JTextField searchstring;
	
	   
	   
	   // constructor
	  SearchEngine(String title)
	   {
		  	
		   super(title); // sets JFrame 
		   setSize(450,200);
		   setLayout(new FlowLayout());
		   
		  
		   // Pop Up Message Dialog
		   JOptionPane.showMessageDialog(null, "Search either a car, a video game or a colour! Click the button relevant to your search preferences and search through our files to see if we have what you're looking for! (CAPS Sesitive)");

		   	// Sets text fields and buttons
		   searchstring = new JTextField(25);
		   add(searchstring);
		   
		   Cars = new JButton("Search for a car");
		   add(Cars);
		   setVisible(true);
		   Cars.addActionListener(this);
		   
		   Games = new JButton("Search for a game");
		   add(Games);
		   setVisible(true);
		   Games.addActionListener(this);
		   
		   Colours = new JButton("Search for a colour");
		   add(Colours);
		   setVisible(true);
		   Colours.addActionListener(this);
		   
		   Close =  new JButton("Close");
		   add(Close);
		   setVisible(true);
		   Close.addActionListener(new CloseListener());
		}
	  
	  private class CloseListener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {  
		        System.exit(0);
		    }
		}

        public void actionPerformed(ActionEvent e) //action implementation
        {
        // if statements to complete the buttons processes
        	if (e.getSource().equals(Cars))
        	{	
        		if (searchstring.getText().equals(""))
        		{
        			JOptionPane.showMessageDialog(this ,"text not entered" );
        		}					
        		else if(searchstring.getText().length()>40)
        		{
        			JOptionPane.showMessageDialog(this ,"Too many characters entered" );
        		}
        		
        		else
        		{
        			try {
        				File file = new File("Cars.txt");		// Scanner scans the file
						Scanner fileScanner = new Scanner(file);
					
						String word;
						String key = searchstring.getText();
						
						
						
						while ((word=fileScanner.nextLine())!=null) // while loops goes through all lines of the file
						{
							if (word.contains(key))
							{
								JOptionPane.showMessageDialog(this, word);
							
							
							}
							
							
							
						}
						
					}
        			catch (HeadlessException | IOException e1) 
        			{
						e1.printStackTrace();
					}
        			
        		}
        	} /// Repeated for each button
        	
        	if (e.getSource().equals(Games))
        	{	
        		if (searchstring.getText().equals(""))
        		{
        			JOptionPane.showMessageDialog(this ,"text not entered" );
        		}				
        		else if(searchstring.getText().length()>40)
        		{
        			JOptionPane.showMessageDialog(this ,"Too many characters entered" );
        		}
        		
        		else
        		{
        			try {
        				File games = new File("games.txt");
						Scanner gamesScanner = new Scanner(games);
					
						String word;
						String key = searchstring.getText();
						while((word=gamesScanner.nextLine())!=null)
						{
							if(word.contains(key))
							{
								JOptionPane.showMessageDialog(this, word);
								
							}
							
						}
						
					}
        			catch (HeadlessException | IOException e1) 
        			{
					
						e1.printStackTrace();
					}
        		}
        	}
        	
        	if (e.getSource().equals(Colours))
        	{	
        		if (searchstring.getText().equals(""))
        		{
        			JOptionPane.showMessageDialog(this ,"text not entered" );
        		}					
        		else if(searchstring.getText().length()>40)
        		{
        			JOptionPane.showMessageDialog(this ,"Too many characters entered" );
        		}
        		
        		else
        		{
        			try {
        				File colours = new File("Colours.txt");
						Scanner coloursScanner = new Scanner(colours);
					
						String word;
						String key = searchstring.getText();
						
						
						while((word=coloursScanner.nextLine())!=null)
						{
							if(word.contains(key)) 
							{
								JOptionPane.showMessageDialog(this, word); 
							}
							}
							
						}
					
					
        			catch (HeadlessException | IOException e1) 
        			{
					
						e1.printStackTrace();
					}
        			
        		} /// end of program
        	}
        	
        }		
	}

