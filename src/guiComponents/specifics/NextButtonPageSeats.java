package guiComponents.specifics;

import java.awt.event.MouseEvent;

import guiComponents.MainFrame;
import guiComponents.pages.PageSeats;

public class NextButtonPageSeats extends NextButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PageSeats pageSeats;
	
	public NextButtonPageSeats(PageSeats pageSeats){
		this.pageSeats = pageSeats;
		
		this.setLabel("select seats".toUpperCase());
		this.setColor(MainFrame.colorDarkMid);
		this.setBackground(MainFrame.colorDarkMid);
		
	}
	
	public void refresh(){
		this.setBackground(MainFrame.colorDarkMid);
		if(pageSeats.getNumberOfTickets() > 0) this.setBackground(MainFrame.colorLightMid);
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setColor(MainFrame.colorDarkMid);
		if(pageSeats.getNumberOfTickets() > 0) this.setColor(MainFrame.colorLightMid);
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		this.setBackground(MainFrame.colorDarkMid);
		if(pageSeats.getNumberOfTickets() > 0)MainFrame.openPageCheckout(pageSeats);
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.setBackground(MainFrame.colorDarkMid);
		if(pageSeats.getNumberOfTickets() > 0) this.setBackground(MainFrame.colorLightMid);
		
	}
	
}