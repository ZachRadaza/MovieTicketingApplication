package guiComponents.specifics;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import guiComponents.MainFrame;
import guiComponents.resources.CustomRoundedPanel;
import logic.seats.Seat;

public class SeatButton extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//logic
	private Seat seat;
	private String seatNumber;
	private boolean originallyTaken; //so you cant unbooked
	
	//gui
	private CustomRoundedPanel roundPanel;
	
	public SeatButton(Seat seat){
		this.seat = seat;
		this.seatNumber = seat.getName();
		this.originallyTaken = seat.getTaken();
		
		this.addMouseListener(this);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(1, 0, 0, 1));
		
		roundPanel = new CustomRoundedPanel(8, 5, MainFrame.colorLightMid, 2);
		roundPanel.setBackground(MainFrame.colorLightMid);
		Dimension dim = new Dimension(20, 20);
		roundPanel.setPreferredSize(dim);
		roundPanel.setMaximumSize(dim);
		
		if(originallyTaken) {
			roundPanel.setBackground(MainFrame.colorDarkMid);
			roundPanel.setColor(MainFrame.colorDarkMid);
			this.removeMouseListener(this);
		}
		
		roundPanel.add(createSeatNumberPanel());
		this.setPreferredSize(new Dimension(dim.width + 5, dim.height + 5));
		this.setMaximumSize(this.getPreferredSize());
		this.add(roundPanel);
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	private JPanel createSeatNumberPanel(){
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JLabel label = new JLabel(seatNumber);
		label.setOpaque(false);
		label.setForeground(MainFrame.colorLight);
		Font font = MainFrame.fontText.deriveFont(10f);
		label.setFont(font);
		panel.add(label);
		
		return panel;
	}

	public Seat getSeat(){
		return seat;
	}
	
	public String getNumber(){
		return seatNumber;
	}
	
	//for when they cancel the booking or press back
	public void unBook(){
		if(originallyTaken) return;
		
		roundPanel.setBackground(MainFrame.colorLightMid);
		seat.setTaken(false);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		roundPanel.setColor(MainFrame.colorLight);
		if(seat.getTaken()) roundPanel.setColor(MainFrame.colorLight);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		roundPanel.setColor(MainFrame.colorLightMid);
		if(seat.getTaken()) roundPanel.setColor(MainFrame.colorLight);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(!seat.getTaken()){
			roundPanel.setBackground(MainFrame.colorDarkMid);
			seat.setTaken(true);
		} else {
			roundPanel.setBackground(MainFrame.colorLightMid);
			seat.setTaken(false);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}