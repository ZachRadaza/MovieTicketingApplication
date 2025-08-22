package guiComponents.specifics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import guiComponents.MainFrame;
import guiComponents.resources.RoundedBorderPanel;

//search bar button, round
public class SearchBarButton extends RoundedBorderPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String filePath;
	private int widthPhoto;
	private JTextField textField;
	
	public SearchBarButton(int radius, int width, JTextField textField){
		super(radius);
		this.filePath = "resources/photos/searchIcon.png";
		this.widthPhoto = 25;
		this.textField = textField;
		
		this.addMouseListener(this);
		this.setBackground(MainFrame.colorLightMid);
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, width)); //width on both since it is square
		this.setMaximumSize(new Dimension(width, width));
		
		
		this.add(createIcon());

	}
	
	public SearchBarButton(int radius, Color color, int thickness, int width, JTextField textField){
		super(radius, color, thickness, false);
		this.filePath = "resources/photos/searchIcon.png";
		this.widthPhoto = 25;
		this.textField = textField;
		
		this.addMouseListener(this);
		this.setBackground(MainFrame.colorLightMid);
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(width, width)); //width on both since it is square
		this.setMaximumSize(new Dimension(width, width));
		
		this.add(createIcon());
	}
	
	private JLabel createIcon(){
		JLabel labelIcon = new JLabel();
		int imageHeight = widthPhoto;
		labelIcon.setIcon(new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(widthPhoto - 10, imageHeight - 10, Image.SCALE_DEFAULT)));
		labelIcon.setOpaque(false);
		labelIcon.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//labelIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		//labelIcon.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		return labelIcon;
	}
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.setBackground(MainFrame.colorDarkMid);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		this.setBackground(MainFrame.colorLightMid);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		MainFrame.openPageSearch(textField.getText());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}