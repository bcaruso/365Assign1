/*
*	URLSuggesterGUI CLASS - CSC 365 - Assignment 1
*
*	Author: Brandon Caruso
*   Sets up GUI and Handles events.
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class URLSuggesterGUI {

	// GUI Components
		
	public static JFrame frame;
	public static JPanel content;
	public static JLabel instructions;
	public static JTextField urlBox;
	public static JButton submit;
	public static JLabel suggestedURL;

	public URLSuggesterGUI(){
	
	}

	public void createGUI(){
	
		// Create Main Window
		frame = new JFrame("URL Suggester");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		content = new JPanel();
		content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		frame.add(content);
		// Create and Add components
		
		instructions= new JLabel("Enter in a valid URL:");
		instructions.setAlignmentX(Component.LEFT_ALIGNMENT);
		content.add(instructions);
		
		urlBox= new JTextField("http://www.example.com");
		urlBox.setColumns(30);
		urlBox.setAlignmentX(Component.LEFT_ALIGNMENT);
		urlBox.setMaximumSize(urlBox.getPreferredSize());
		content.add(urlBox);
		
		submit= new JButton("Submit");
		submit.setAlignmentX(Component.LEFT_ALIGNMENT);
		submit.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				submitClicked(e);
			}
		});
		
		content.add(submit);
		
		suggestedURL = new JLabel("Suggested URL: ");
		suggestedURL.setAlignmentX(Component.LEFT_ALIGNMENT);
		content.add(suggestedURL);
		
		
		//Display Window
		frame.pack();
		frame.setVisible(true);
	}
	
	// Action Methods
		
	public static void submitClicked(ActionEvent e){
		suggestedURL.setText("Suggested URL: Submit Clicked");
	}
	
}