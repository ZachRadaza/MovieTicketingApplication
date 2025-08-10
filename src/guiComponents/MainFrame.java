package guiComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import guiComponents.pages.PageHome;
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
	private static Frame frame;
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
		panelTop.setBorder(null);
		fillPanelTop();
		panelBackground.add(panelTop, BorderLayout.NORTH);
		
		panelMain = new JPanel();
		panelMain.setOpaque(false);
		panelMain.setBorder(BorderFactory.createEmptyBorder(-10, 0, 0, 0));
		panelBackground.add(panelMain, BorderLayout.CENTER);
		
		panelMain.add(new PageHome(house));
		
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
	
	public static Frame getFrame(){
		return frame;
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
		int thickness = 1;
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, thickness, 0, MainFrame.colorDarkMid));
		
		JPanel panelLogo = createPanelLogo();
		searchBar = new SearchBar();
		
		panel.add(panelLogo);
		panel.add(searchBar);
		
		return panel;
	}
	
	public JPanel createPanelLogo(){
		JPanel panelLogo = new JPanel();
		panelLogo.setOpaque(false);
		panelLogo.setLayout(new BoxLayout(panelLogo, BoxLayout.X_AXIS));
		panelLogo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		JLabel labelIcon = new JLabel();
		int imageWidth = 50;
		int imageHeight = 50;
		labelIcon.setIcon(new ImageIcon(new ImageIcon("resources/photos/Zandango.png").getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT)));
		labelIcon.setOpaque(false);
		labelIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel labelName = new JLabel("Zandango".toUpperCase());
		Font font = MainFrame.fontHeader.deriveFont(40f);
		labelName.setFont(font);
		labelName.setOpaque(false);
		labelName.setForeground(MainFrame.colorLightMid);
		
		panelLogo.add(labelIcon);
		panelLogo.add(labelName);
		
		return panelLogo;
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