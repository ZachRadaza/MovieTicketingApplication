package guiComponents.specifics;

import java.awt.event.MouseEvent;

import guiComponents.MainFrame;

public class NextButtonPageCheckout extends NextButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NextButtonPageCheckout(){
		this.setLabel("Checkout".toUpperCase());
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		this.setBackground(MainFrame.colorDarkMid);
		
		MainFrame.openPageHome();
	}
}