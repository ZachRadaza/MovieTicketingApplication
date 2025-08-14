package guiComponents.specifics;

import java.awt.event.MouseEvent;

import guiComponents.MainFrame;
import guiComponents.pages.PageSeats;

public class BackButtonPageSeats extends BackButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PageSeats pageSeats;
	
	public BackButtonPageSeats(PageSeats pageSeats){
		this.pageSeats = pageSeats;
	
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		this.setBackground(MainFrame.colorDarkMid);
		pageSeats.cancelBooking();
		MainFrame.openPageHome();
	}
}