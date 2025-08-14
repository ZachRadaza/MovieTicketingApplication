package guiComponents.pages;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;

import guiComponents.MainFrame;
import guiComponents.resources.ImageScaler;
import guiComponents.resources.RoundedBorderPanel;
import guiComponents.specifics.BackButtonPageSeats;
import guiComponents.specifics.SeatButton;
import logic.TimeConverter;
import logic.movies.Movie;
import logic.seats.Seat;

public class PageSeats extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//logic
	private Movie movie;
	private int index; //index of when in the calendar it would be, plus x
	
	//gui
	private JPanel panelMain;
	private JScrollPane panelMainCont;
	private JPanel panelTop;
	private JPanel panelCenter;
	private JPanel panelBottom;
	private SeatButton[] seatButton;
	private JPanel panelSeat;
	
	public PageSeats(Movie movie, int index){
		this.movie = movie;
		this.index = index;
		
		this.setOpaque(false);
		
		panelMain = new JPanel();
		panelMain.setLayout(new BorderLayout());
		panelMain.setBackground(MainFrame.colorDark);
		panelMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		initializePanelTop();
		initializePanelCenter();
		initializePanelBottom();
		
		panelMain.add(panelTop, BorderLayout.NORTH);
		panelMain.add(panelCenter, BorderLayout.CENTER);
		panelMain.add(panelBottom, BorderLayout.SOUTH);
		
		panelMainCont = new JScrollPane(panelMain);
		
		panelMainCont.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		panelMainCont.setOpaque(false);
		panelMainCont.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    panelMainCont.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
	    	@Override
	        protected void configureScrollBarColors() {
	            this.thumbColor = MainFrame.colorDarkMid; // scroll thumb
	            this.trackColor = MainFrame.colorDark; // track background
	        }
	    });
	    panelMainCont.getVerticalScrollBar().setUnitIncrement(10);
	    Dimension dim = MainFrame.getFrame().getSize();
	    dim.height = 550;
		panelMainCont.setPreferredSize(dim);
		
		this.add(panelMainCont);
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	//getters
	public Movie getMovie(){
		return movie;
	}
	
	public Seat getSeat(int i){
		return seatButton[i].getSeat();
	}
	
	//initializing methods
	private void initializePanelTop(){
		panelTop = new JPanel();
		
		panelTop.setOpaque(false);
		panelTop.setLayout(new BorderLayout());
		panelTop.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, MainFrame.colorDarkMid));
		
		//center stuff
		JPanel panelCenter = new JPanel();
		panelCenter.setOpaque(false);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		panel.add(createPosterPanel());
		panel.add(createTitlePanel());
		
		panelCenter.add(panel);
		
		//back button stuff
		JPanel panelBack = new JPanel();
		panelBack.setOpaque(false);
		BackButtonPageSeats backButton = new BackButtonPageSeats(this);
		panelBack.add(backButton);
		
		panelTop.add(panelCenter, BorderLayout.CENTER);
		panelTop.add(panelBack, BorderLayout.WEST);
		
		panelTop.setVisible(true);
		panelTop.revalidate();
		panelTop.repaint();
	}
	
	private JLayeredPane createPosterPanel(){
		JLayeredPane panel = new JLayeredPane(); //needed for the borders
		panel.setOpaque(false);
		panel.setLayout(new OverlayLayout(panel));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);

		int photoHeight = 100;
		//panel with photo
		JPanel panelPoster = new JPanel();
		panelPoster.setOpaque(false);
		panelPoster.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelPoster.setAlignmentY(Component.CENTER_ALIGNMENT);
	    JLabel labelIcon = ImageScaler.scaledImageJLabel(movie.getPoster(), photoHeight, photoHeight);
	    labelIcon.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0)); //border at the top because setAlightment is always broken
	    labelIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelIcon.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelPoster.add(labelIcon);
	    
	    //panel with round border
	    int rad = 20;
	    int thickness = 10;
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
	
	private JPanel createTitlePanel(){
		JPanel panel = new JPanel();
		
		panel.setOpaque(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		int panelBorder = 5;
		panel.setBorder(BorderFactory.createEmptyBorder(panelBorder, panelBorder, panelBorder, panelBorder));
		
		//title panel
		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		titlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JLabel title = new JLabel(movie.getTitle().toUpperCase());
		title.setForeground(MainFrame.colorLightMid);
		title.setOpaque(false);
		Font fontTitle = MainFrame.fontHeader.deriveFont(20f);
		title.setFont(fontTitle);
		title.setHorizontalAlignment(SwingConstants.LEFT);
		titlePanel.add(title);
		titlePanel.setMaximumSize(titlePanel.getPreferredSize());
		
		//else label
		//date
		JPanel elsePanel = new JPanel();
		elsePanel.setOpaque(false);
		//elsePanel.setBorder(BorderFactory.createEmptyBorder(5,  0,  5,  0));
		elsePanel.setLayout(new BoxLayout(elsePanel, BoxLayout.Y_AXIS));
		elsePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		LocalDate dateDate = LocalDate.now().plusDays(index);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd");
		JLabel date = new JLabel(dateDate.format(formatter) + " at " + TimeConverter.converterToString(movie.getTime()));
		date.setOpaque(false);
		date.setForeground(MainFrame.colorLight);
		Font fontDate = MainFrame.fontSubHeader.deriveFont(15f);
		date.setFont(fontDate);
		elsePanel.add(date);
		
		//movie type
		JLabel movieType = new JLabel(movie.getRating());
		movieType.setOpaque(false);
		movieType.setForeground(MainFrame.colorLight);
		movieType.setFont(fontDate);
		elsePanel.add(movieType);
		
		panel.add(titlePanel);
		panel.add(elsePanel);
		
		return panel;
	}
	
	private void initializePanelCenter(){
		panelCenter = new JPanel();
		
		panelCenter.setOpaque(false);
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		panelCenter.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelCenter.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		//screen
		JPanel panelScreen = new JPanel();
		panelScreen.setOpaque(false);
		panelScreen.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
		
		RoundedBorderPanel roundedBorderPanel = new RoundedBorderPanel(30, MainFrame.colorDarkMid, 1, false);
		roundedBorderPanel.setBackground(MainFrame.colorDarkMid);
		Dimension dim = new Dimension(500, 25);
		roundedBorderPanel.setPreferredSize(dim);
		roundedBorderPanel.setMaximumSize(dim);
		
		JLabel label = new JLabel("Screen".toUpperCase());
		label.setOpaque(false);
		label.setForeground(MainFrame.colorLight);
		Font font = MainFrame.fontText.deriveFont(15f);
		label.setFont(font);
		//label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setBorder(BorderFactory.createEmptyBorder(-3, 0, 0, 0));
		roundedBorderPanel.add(label);
		panelScreen.add(roundedBorderPanel);
		
		initializePanelSeat();
		
		panelCenter.add(panelScreen);
		panelCenter.add(panelSeat);
		
	}

	private void initializePanelSeat(){
		panelSeat = new JPanel();
		
		panelSeat.setOpaque(false);
		panelSeat.setLayout(new BoxLayout(panelSeat, BoxLayout.Y_AXIS));
		panelSeat.setPreferredSize(new Dimension(950, 400));
		
		initializeSeatButton();
		
		char currentLetter = ' ';
		for(int i = 0; i < seatButton.length; i++){
			currentLetter = seatButton[i].getNumber().charAt(0);
			
			//make a panel with the seats in a row
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			
			while(currentLetter == seatButton[i].getNumber().charAt(0)){
				seatButton[i].setAlignmentY(Component.TOP_ALIGNMENT); // for horizontal rows
				panel.add(seatButton[i]);
				i++;
				
				if(i >= seatButton.length) break;
			}
			i--;
			
			JPanel panelCont = new JPanel();
			panelCont.setOpaque(false);
			panelCont.setPreferredSize(panel.getPreferredSize());
			panelCont.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelCont.add(panel);
			
			panelSeat.add(panelCont);
			
		}
		
	}
	
	private void initializeSeatButton(){
		seatButton = new SeatButton[movie.getSeatsSize()];
		
		for(int i = 0; i < seatButton.length; i++){
			seatButton[i] = new SeatButton(movie.getSeats(i));
		}
	}
	
	private void initializePanelBottom(){
		panelBottom = new JPanel();
		
	}
	//for when back button is pressed
	public void cancelBooking(){
		for(int i = 0; i < seatButton.length; i++){
			seatButton[i].unBook();
		}
	}
}