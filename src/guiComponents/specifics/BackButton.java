package guiComponents.specifics;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import guiComponents.MainFrame;
import guiComponents.resources.RoundedBorderPanel;

public class BackButton extends RoundedBorderPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BackButton(){
		super(25, MainFrame.colorDarkMid, 1, false);
		
		this.setBackground(MainFrame.colorDark);
		this.add(createJPanel());
		this.addMouseListener(this);
		
		Dimension dim = this.getPreferredSize();
		dim.width = 50;
		this.setPreferredSize(dim);
		this.setMaximumSize(dim);
		
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	private JPanel createJPanel(){
		JPanel panel = new JPanel();
		
		panel.setOpaque(false);
		
		JLabel label = new JLabel("<");
		label.setForeground(MainFrame.colorLightMid);
		label.setFont(MainFrame.fontText.deriveFont(15f));
		
		panel.add(label);
		return panel;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setColor(MainFrame.colorLight);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setColor(MainFrame.colorDarkMid);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		this.setBackground(MainFrame.colorDarkMid);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.setBackground(MainFrame.colorDark);
		
	}
}