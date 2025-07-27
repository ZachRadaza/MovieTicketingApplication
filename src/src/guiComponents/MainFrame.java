package guiComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import guiComponents.resources.Frame;
import guiComponents.specifics.SearchBar;
import logic.theater.TheaterHouse;

//main frame, will be used for everything
public class MainFrame{
	
	//final things
	public static final Color colorDark = new Color(12, 24, 33);
	public static final Color colorDarkMid = new Color(50, 74, 95);
	public static final Color colorLightMid = new Color(121, 173, 220);
	public static final Color colorLight = new Color(250, 250, 250);
	
	public static final Font fontHeader = initializeFont("/fonts/EncodeSansSemiCondensed-ExtraBold.ttf");
	public static final Font fontSubHeader = initializeFont("/fonts/EncodeSansSemiCondensed-Medium.ttf");
	public static final Font fontText = initializeFont("/fonts/Afacad-Regular.ttf");
	
	//fields
	private Frame frame;
	private JPanel panelBackground; //background panel
	private JPanel panelMain; //panel to add things on
	private JPanel panelTop; //panel holding panels on top
	private SearchBar searchBar; //panel with search bar
	
	private TheaterHouse house; //theater house with all info
	
	
	public MainFrame(TheaterHouse house){
		this.house = house;
		
		frame = new Frame();
		frame.setVisible(true);
		
		panelBackground = new JPanel();
		panelBackground.setBackground(colorDark);
		panelBackground.setLayout(new BorderLayout());
		frame.add(panelBackground);
		
		panelTop = new JPanel();
		fillPanelTop();
		panelBackground.add(panelTop, BorderLayout.NORTH);
		
		panelMain = new JPanel();
		panelMain.setOpaque(false);
		panelMain.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panelBackground.add(panelMain, BorderLayout.CENTER);
		
		panelMain.setVisible(true);
		panelMain.revalidate();
		panelMain.repaint();
		
	}
	
	//getters
	public JPanel getPanelBackground(){
		return panelBackground;
	}
	
	public JPanel getPanelMain(){
		return panelMain;
	}
	
	//methods
	private void fillPanelTop(){
		panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));
		panelTop.setOpaque(false);
		
		panelTop.add(createBlueTab());
		panelTop.add(createSearchTab());
		
		panelTop.setVisible(true);
		panelTop.revalidate();
		panelTop.repaint();
	}
	//creates blue tab on top
	private JPanel createBlueTab(){
		JPanel panel = new JPanel();
		panel.setBackground(colorLightMid);
		
		//holds all text
		JPanel box = new JPanel();
		box.setOpaque(false);
		box.setLayout(new BoxLayout(box, BoxLayout.X_AXIS));
		
		JLabel[] labels = new JLabel[3];
		String[] texts = {"inspired by Fandango", "FILM TICKETING PROJECT".toUpperCase(), "Zachary Juls Radaza"};
		Font[] fonts = {fontHeader.deriveFont(15f), fontHeader.deriveFont(20f), fontHeader.deriveFont(15f),};
		float[] fontSize = {15f, 20f, 15f};
		
		for(int i = 0; i < labels.length; i++){
			labels[i] = new JLabel(texts[i]);
			labels[i].setForeground(colorLight);
			labels[i].setHorizontalAlignment(SwingConstants.CENTER);
			
			labels[i].setFont(fonts[i]);
			labels[i].setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
			box.add(labels[i]);
		}
		
		panel.add(box);
		return panel;
	}
	
	private JPanel createSearchTab(){
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setAlignmentX(SwingConstants.CENTER);
		int thickness = 2;
		panel.setBorder(BorderFactory.createLineBorder(MainFrame.colorDarkMid, thickness));
		
		//TODO
		JPanel panelLogo = new JPanel();
		panelLogo.setOpaque(false);
		
		searchBar = new SearchBar();
		
		panel.add(panelLogo);
		panel.add(searchBar);
		return panel;
	}
	
	public static Font initializeFont(String filePath){
		try {
			// Load font from classpath
			Font font;
	        InputStream fontStream = MainFrame.class.getResourceAsStream(filePath);
	        if (fontStream == null) {
	        	throw new RuntimeException("Font file not found!");
	        }

	        font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(24f);
	        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
	        
	        return font;
		} catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }    
	}
	
}