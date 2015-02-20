/*
*	URLSuggesterGUI CLASS - CSC 365 - Assignment 1
*
*	Author: Brandon Caruso
*   Sets up GUI and Handles events.
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.net.URISyntaxException;
import java.net.*;
import java.io.IOException;


public class URLSuggesterGUI {

	// GUI Components
		
	private JFrame frame;
	private JPanel content;
	private JLabel instructions;
	private JTextField urlBox;
	private  JButton submit;
	private  JLabel suggestedURLHeader;
	private  JLabel suggestedURL;

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
		urlBox.setColumns(35);
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
		
		suggestedURLHeader = new JLabel("Suggested URL:");
		suggestedURLHeader.setAlignmentX(Component.LEFT_ALIGNMENT);
		content.add(suggestedURLHeader);
		
		suggestedURL = new JLabel(" ");
		suggestedURL.setAlignmentX(Component.LEFT_ALIGNMENT);
		content.add(suggestedURL);
		
		//Display Window
		frame.pack();
		frame.setVisible(true);
	}
	
	// Action Methods
		
	public void submitClicked(ActionEvent e){
		try{
			submit.setEnabled(false);
			frame.getRootPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
			Histogram h = HistogramSimilarity.findMostSimilar(urlBox.getText(), URLSuggester.urlHistograms);
			frame.getRootPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			submit.setEnabled(true);
			String hURL = h.getURL().toString();
			System.out.println(hURL);
			suggestedURL.setForeground(Color.black);
			suggestedURL.setText(hURL);
			
		}catch(URISyntaxException|IOException ex){
			frame.getRootPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			submit.setEnabled(true);
			ex.printStackTrace();
			suggestedURL.setForeground(Color.red);
			suggestedURL.setText("Please input a valid URL.");
			
		}
	}
	
}