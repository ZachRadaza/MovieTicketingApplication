package guiComponents.specifics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import guiComponents.MainFrame;
import guiComponents.resources.HintTextField;
import guiComponents.resources.RoundedBorderPanel;

public class SearchBar extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RoundedBorderPanel searchPanel;
	private HintTextField textField;
	
	public SearchBar(){		
		this.setOpaque(true);
		this.setBackground(MainFrame.colorDark);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		int radius = 50; //of rounded panel
		initializeSearchPanel(radius);
		
		this.add(searchPanel);
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	//getters
	public String getText(){
		return textField.getText();
	}
	
	//setters
	public void setInTextField(String t){
		textField.setText(t);
	}
	
	public void setHintText(String t){
		//textField.setHint(t);
		textField.revalidate();
		textField.repaint();
	}
	
	//methods
	//initializes and fills search panel, panel with the rounded edges
	private void initializeSearchPanel(int radius){
		int thickness = 1;
		searchPanel = new RoundedBorderPanel(radius, MainFrame.colorDarkMid, thickness);
		searchPanel.setBackground(MainFrame.colorDark);
		searchPanel.setPreferredSize(new Dimension(400, 50));
		searchPanel.setOpaque(false);
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		
		initializeTextField();
		JPanel button = initializeButton();
		
		searchPanel.add(textField);
		searchPanel.add(button);
		
		searchPanel.setVisible(true);
		searchPanel.revalidate();
		searchPanel.repaint();
	}
	
	private void initializeTextField(){
		int columns = 30;
		String hintText = "    Search for Movie";
		textField = new HintTextField(hintText, columns);
		
		textField.addActionListener(e -> {
		    String input = textField.getText();
		    search(input);
		});
		
		float fontSize = 20f;
		Font font = MainFrame.fontText.deriveFont(fontSize);
		textField.setFont(font);
		textField.setForeground(MainFrame.colorLight);
		textField.setOpaque(false);
		textField.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
	}
	
	//placed in parent panel so it will uniformly fit into the search bar, as it doesnt without it
	private JPanel initializeButton(){
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		int width = 40;
		int radiusButton = width; //same to make it round
		SearchBarButton button = new SearchBarButton(radiusButton, MainFrame.colorLightMid, 0, width, textField);
		
		panel.add(button);
		return panel;
	}
	
	public static void search(String text){
		System.out.println("Text texted: " + text);
	}
}