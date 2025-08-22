package guiComponents.specifics;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import guiComponents.MainFrame;
import guiComponents.resources.RoundedBorderPanel;

public class NextButton extends RoundedBorderPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel label;
	
	public NextButton(){
		super(25, MainFrame.colorLightMid, 1, false);
		this.setBackground(MainFrame.colorLightMid);
		this.addMouseListener(this);
		
		initializeLabel();
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(null);
		panel.add(label);
		
		this.add(panel);
		
		Dimension dim = this.getPreferredSize();
		dim.width = 200;
		this.setPreferredSize(dim);
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	private void initializeLabel(){
		label = new JLabel("Next".toUpperCase());
		label.setForeground(MainFrame.colorLight);
		label.setFont(MainFrame.fontHeader.deriveFont(15f));
	}
	
	public void setLabel(String s){
		label.setText(s);
		label.setVisible(true);
		label.revalidate();
		label.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setColor(MainFrame.colorLight);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setColor(MainFrame.colorLightMid);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		this.setBackground(MainFrame.colorDarkMid);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.setBackground(MainFrame.colorLightMid);
		
	}
}