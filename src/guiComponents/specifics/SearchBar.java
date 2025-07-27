package guiComponents.specifics;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import guiComponents.MainFrame;
import guiComponents.resources.HintTextField;
import guiComponents.resources.RoundedPanel;

public class SearchBar extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RoundedPanel searchPanel;
	private HintTextField textField;
	
	public SearchBar(){		
		this.setOpaque(false);
		
		int radius = 2; //of rounded panel
		initializeSearchPanel(radius);
		
		this.add(searchPanel);
		
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
	//initializes and fills search panel
	private void initializeSearchPanel(int radius){
		searchPanel = new RoundedPanel(radius);
		int thickness = 2;
		searchPanel.setBorder(BorderFactory.createLineBorder(MainFrame.colorDarkMid, thickness));
		searchPanel.setOpaque(false);
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		
		initializeTextField();
		
		SearchBarButton button = new SearchBarButton();
		
		searchPanel.add(textField);
		searchPanel.add(button);
	}
	
	private void initializeTextField(){
		int columns = 50;
		String hintText = "Search for Movie";
		textField = new HintTextField(hintText, columns);
		
		float fontSize = 15f;
		Font font = MainFrame.fontText.deriveFont(fontSize);
		textField.setFont(font);
		textField.setForeground(MainFrame.colorLight);
		textField.setBackground(MainFrame.colorDark);
		textField.setBorder(BorderFactory.createEmptyBorder());
	}
}