package guiComponents;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//private final Color bgColor = Color.WHITE;

	public Frame(){
		
		this.setTitle("AMC Studios");
		this.setSize(new Dimension(1080, 720));
		this.setLocationRelativeTo(null);

		this.setMinimumSize(new Dimension(500, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		
		ImageIcon image = new ImageIcon(""); //popcorn or smth
		this.setIconImage(image.getImage());
		
		this.setVisible(true);
	}
}