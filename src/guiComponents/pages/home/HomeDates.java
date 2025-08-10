package guiComponents.pages.home;

import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import guiComponents.MainFrame;
import logic.theater.TheaterHouse;
import logic.theater.TheaterRoom;

//panel with all the Home Movie Panels in the given date
public class HomeDates extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//logic components
	private int date; //starts at 0, + the number of days from the start date, practically its index
	private TheaterHouse theaterHouse; //based on date on which we use
	
	//gui components
	private JPanel panelMain;
	private JPanel[] panelTheater; //holds the movies for the specific theater
	private HomeMoviePanel[] homeMoviePanel;
	
	public HomeDates(TheaterHouse theaterHouse, int date){
		this.setOpaque(false);
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.theaterHouse = theaterHouse;
		this.date = date;
		
		initializePanelMain();
		this.add(panelMain);
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	private void initializePanelMain(){
		panelMain = new JPanel();
		panelMain.setOpaque(false);
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
		panelMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		initializePanelTheater();
		
		for(int i = 0; i < panelTheater.length; i++){
			panelMain.add(panelTheater[i]);
		}
	}
	
	private void initializePanelTheater(){
		panelTheater = new JPanel[3]; //regular, 3d, imax
		initializeHomeMoviePanel();
		
		String[] title = {"Imax Showings", "3D Showings", "Standard Showings"};
		for(int i = 0; i < panelTheater.length; i++){
			panelTheater[i] = new JPanel();
			
			panelTheater[i].setOpaque(false);
			panelTheater[i].setLayout(new BoxLayout(panelTheater[i], BoxLayout.Y_AXIS));
			
			JLabel label = new JLabel(title[i].toUpperCase());
			label.setForeground(MainFrame.colorDarkMid);
			label.setHorizontalAlignment(SwingConstants.LEFT);
			Font font = MainFrame.fontSubHeader.deriveFont(20f);
			label.setFont(font);
			JPanel titlePanel = new JPanel();
			titlePanel.setOpaque(false);
			titlePanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			titlePanel.add(label);
			
			panelTheater[i].add(titlePanel);
			panelTheater[i].add(homeMoviePanel[i]);
			
			if(i == panelTheater.length - 1) panelTheater[i].add(homeMoviePanel[i+1]); //for both regular movies are there
		}
	}
	
	private void initializeHomeMoviePanel(){
		int size = 4; //2 regulars, 1 3d, 1 imax
		homeMoviePanel = new HomeMoviePanel[size];
		TheaterRoom[] rooms = {theaterHouse.getImax().getRoom(date), theaterHouse.get3D().getRoom(date), theaterHouse.getRegular1().getRoom(date), theaterHouse.getRegular2().getRoom(date)};
		
		for(int i = 0; i < homeMoviePanel.length; i++){
			homeMoviePanel[i] = new HomeMoviePanel(rooms[i]);
		}
	}
}