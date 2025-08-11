package guiComponents.pages;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import guiComponents.MainFrame;
import guiComponents.resources.RoundedBorderPanel;
import guiComponents.specifics.SeatButton;
import logic.movies.Movie;
import logic.seats.Seat;

public class PageSeats extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//logic
	private Movie movie;
	
	//gui
	private JPanel panelTop;
	private JPanel panelCenter;
	private JPanel panelBottom;
	private SeatButton[] seatButton;
	private JPanel panelSeat;
	
	public PageSeats(Movie movie){
		this.movie = movie;
		
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		initializePanelTop();
		initializePanelCenter();
		initializePanelBottom();
		
		this.add(panelTop, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelBottom, BorderLayout.SOUTH);
		
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
		roundedBorderPanel.add(label);
		panelScreen.add(roundedBorderPanel);
		
		JPanel labelCont = new JPanel();
		labelCont.setOpaque(false);
		labelCont.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelCont.setAlignmentY(Component.CENTER_ALIGNMENT);
		labelCont.add(label);
		roundedBorderPanel.add(labelCont);
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
}