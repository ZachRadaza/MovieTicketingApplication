package guiComponents.pages.home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;

import guiComponents.MainFrame;
import guiComponents.resources.ImageScaler;
import guiComponents.resources.RoundedBorderPanel;
import guiComponents.specifics.TimeButton;
import logic.movies.Movie;
import logic.theater.TheaterRoom;

//the panel with poster, title, description, and time buttons
public class HomeMoviePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//data fields
	private String filePathPoster; //file path to poster of movie
	private TheaterRoom theaterRoom; //holds theater house, all the information needed for this panel
	private TimeButton[] timeButtons; //button to book movie on a specific time
	
	//gui components
	private RoundedBorderPanel panelMain; //add and remove things here

	public HomeMoviePanel(TheaterRoom theaterRoom){
		this.theaterRoom = theaterRoom;
		this.filePathPoster = theaterRoom.getMovie().getPoster();
		initializeTimeButtons();
		initializePanel();
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	//initializing methods
	private void initializeTimeButtons(){
		timeButtons = new TimeButton[theaterRoom.getShowingSize()];
		
		for(int i = 0; i < timeButtons.length; i++){
			timeButtons[i] = new TimeButton(35, theaterRoom.getMovies(i));
		}
	}
	
	//initialized this panel
	private void initializePanel(){
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panelMain = new RoundedBorderPanel(50, MainFrame.colorDarkMid, 1, false);
		panelMain.setOpaque(false);
		panelMain.setLayout(new BorderLayout());
		panelMain.setBackground(MainFrame.colorDark);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		panelCenter.add(createDescriptionPanel());
		panelCenter.add(createTimePanel());
		
		panelMain.add(createPosterPanel(), BorderLayout.WEST);
		panelMain.add(panelCenter, BorderLayout.CENTER);
		
		this.add(panelMain);
	}
	
	private JLayeredPane createPosterPanel(){
		JLayeredPane panel = new JLayeredPane(); //needed for the borders
		panel.setOpaque(false);
		panel.setLayout(new OverlayLayout(panel));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		int photoHeight = 300;
		//panel with photo
		JPanel panelPoster = new JPanel();
		panelPoster.setOpaque(false);
		panelPoster.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelPoster.setAlignmentY(Component.CENTER_ALIGNMENT);
	    JLabel labelIcon = ImageScaler.scaledImageJLabel(filePathPoster, photoHeight, photoHeight);
	    labelIcon.setBorder(BorderFactory.createEmptyBorder(7, 0, 0, 0)); //border at the top because setAlightment is always broken
	    labelIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelIcon.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelPoster.add(labelIcon);
	    
	    //panel with round border
	    int rad = 50;
	    int thickness = 15;
	    RoundedBorderPanel roundedBorder = new RoundedBorderPanel(rad, MainFrame.colorDark, thickness, true);
	    roundedBorder.setOpaque(false);
	    roundedBorder.setAlignmentX(Component.CENTER_ALIGNMENT);
	    roundedBorder.setAlignmentY(Component.CENTER_ALIGNMENT);
	    
	    int posterWidth = panelPoster.getPreferredSize().width;
	    int posterHeight = panelPoster.getPreferredSize().height;
	    int div = 40;
	    Dimension dim = new Dimension(posterWidth + (posterWidth / div) , posterHeight + (posterHeight / div));
	    roundedBorder.setPreferredSize(dim);
		
		panel.add(panelPoster, Integer.valueOf(1)); //under
		panel.add(roundedBorder, Integer.valueOf(2)); //above
		
		return panel;
	}
	
	private JPanel createDescriptionPanel(){
		JPanel panel = new JPanel();
		Movie movie = theaterRoom.getMovie();
		
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//movie title
		JPanel title = new JPanel();
		title.setOpaque(false);
		JLabel titleText = new JLabel(movie.getTitle().toUpperCase());
		Font fontTitle = MainFrame.fontHeader.deriveFont(35f);
		titleText.setFont(fontTitle);
		titleText.setOpaque(false);
		titleText.setForeground(MainFrame.colorLight);
		titleText.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.add(titleText);
		
		//movie desc
		JTextArea text = new JTextArea(movie.getDescription());
		text.setOpaque(false);
		text.setForeground(MainFrame.colorLight);
		text.setPreferredSize(new Dimension(300, 100));
		text.setEnabled(false);
		Font fontText = MainFrame.fontText.deriveFont(15f);
		title.setFont(fontText);
		
		//movie rating
		int width = 60;
		Color color = MainFrame.colorLightMid;
		int thickness = 1;
		RoundedBorderPanel rating = new RoundedBorderPanel(width, color, thickness, true);
		rating.setOpaque(false);
		rating.setBackground(MainFrame.colorDark);
		Dimension dim = new Dimension(width, 25);
		rating.setPreferredSize(dim);
		rating.setMaximumSize(dim);
		//JLabel ratingText = new JLabel(movie.getRating());
		JLabel ratingText = new JLabel("PG-13");
		ratingText.setOpaque(false);
		ratingText.setForeground(color);
		Font fontRating = MainFrame.fontSubHeader.deriveFont(10f);
		ratingText.setFont(fontRating);
		rating.add(ratingText);
		
		panel.add(title);
		panel.add(text);
		panel.add(rating);
		
		
		return panel;
	}
	
	private JPanel createTimePanel(){
		JPanel panelMain = new JPanel();
		
		panelMain.setOpaque(false);
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		
		JPanel panelAvail = new JPanel();
		panelAvail.setOpaque(false);
		panelAvail.setBorder(BorderFactory.createEmptyBorder());
		panelAvail.setAlignmentX(RIGHT_ALIGNMENT);
		JLabel label = new JLabel("Available Times:");
		label.setOpaque(false);
		label.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5));
		label.setForeground(MainFrame.colorLight);
		Font font = MainFrame.fontSubHeader.deriveFont(16f);
		label.setFont(font);
		panelAvail.add(label);
		
		JPanel panel = new JPanel();
		
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5); // Padding
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		
		int x = 0;
		for(int i = 0; i < timeButtons.length; i++){
			if(i % 6 == 0) x = 0;
			gbc.gridx = x;
			gbc.gridy = (i / 6);
			panel.add(timeButtons[i], gbc);
			x++;
		}
		
		
		panelMain.add(panelAvail);
		panelMain.add(panel);
		return panelMain;
	}
	
}