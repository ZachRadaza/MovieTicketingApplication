package guiComponents.specifics;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import guiComponents.MainFrame;
import guiComponents.pages.PageHome;

public class DateButton extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int index;
	private LocalDate date;
	private PageHome pageHome;
	
	public DateButton(int i, PageHome pageHome){
		this.index = i;
		date = LocalDate.now().plusDays(index);
		this.pageHome = pageHome;
		
		this.addMouseListener(this);
		this.setOpaque(true);
		this.setBackground(MainFrame.colorDark);
		this.setBorder(BorderFactory.createLineBorder(MainFrame.colorDarkMid, 1));
		this.add(createDateString());
		
	}
	
	private JPanel createDateString(){
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		JLabel label = new JLabel(date.format(DateTimeFormatter.ofPattern("MM / dd")));
		Font font = MainFrame.fontSubHeader.deriveFont(15f);
		label.setFont(font);
		label.setForeground(MainFrame.colorLight);
		
		panel.add(label);
		
		return panel;
	}
	
	public void pressedBG(){
		this.setBackground(MainFrame.colorDarkMid);
	}
	
	public void unPress(){
		this.setBackground(MainFrame.colorDark);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setBorder(BorderFactory.createLineBorder(MainFrame.colorLightMid, 1));
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setBorder(BorderFactory.createLineBorder(MainFrame.colorDarkMid, 1));
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		pressedBG();
		this.pageHome.setDatesContainer(index);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
}