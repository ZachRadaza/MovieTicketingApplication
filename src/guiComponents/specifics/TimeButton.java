package guiComponents.specifics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import guiComponents.MainFrame;
import guiComponents.resources.RoundedBorderPanel;
import logic.TimeConverter;
import logic.movies.Movie;

//button for Home Movie Panel, has the times for a specific movie, brings them to book movie
public class TimeButton extends RoundedBorderPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//data fields
	private Movie movie; //pointer to movie being used
	private int index;
	
	public TimeButton(int height, Movie movie, int index){
		super(height/2, MainFrame.colorLightMid, 1, false);
		this.movie = movie;
		this.index = index;
		this.addMouseListener(this);
		
		initializePanel(height);
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	private void initializePanel(int height){
		this.setOpaque(false);
		this.setBackground(MainFrame.colorLightMid);
		int width = height * 2;
		this.setPreferredSize(new Dimension(width, height));
		
		String time = TimeConverter.converterToString(movie.getTime());
		JLabel label = new JLabel(time);
		label.setOpaque(false);
		label.setForeground(MainFrame.colorLight);
		Font font = MainFrame.fontText.deriveFont(16f);
		label.setFont(font);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.add(label);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setColor(MainFrame.colorLight);
		this.setBackground(MainFrame.colorDarkMid);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setColor(MainFrame.colorLightMid);
		this.setBackground(MainFrame.colorLightMid);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.setColor(MainFrame.colorLight);
		this.setBackground(MainFrame.colorDark);
		MainFrame.openPageSeats(movie, index);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.setColor(MainFrame.colorLight);
		this.setBackground(MainFrame.colorLightMid);
	}
}