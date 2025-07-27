package guiComponents.resources;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

//JPanel with rounded edges based on radius given
public class RoundedPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int radius;
	
	public RoundedPanel(int radius){
		this.radius = radius;
		
		this.setOpaque(false);
	}
	
	//getters
	public int getRadius(){
		return radius;
	}
	
	//setters
	public void setRadius(int r){
		radius = r;
	}
	
	//methods
	@Override
    protected void paintComponent(Graphics g) {
        // Enable anti-aliasing for smooth curves
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set background color and draw rounded rectangle
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2.dispose();
        super.paintComponent(g);  // Paint children
    }
}