package guiComponents.resources;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

//JPanel with rounded edges based on radius given
public class RoundedBorderPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int radius;
	private int thickness;
	private Color color;
	
	public RoundedBorderPanel(int radius){
		this.radius = radius;
		this.color = Color.BLACK;
		this.thickness = 2;
		
		this.setOpaque(false);
	}
	
	public RoundedBorderPanel(int radius, Color color, int thickness){
		this.radius = radius;
		this.color = color;
		this.thickness = thickness;
		
		this.setOpaque(false);
	}
	
	//getters
	public int getRadius(){
		return radius;
	}
	
	public int getThickness(){
		return thickness;
	}
	
	public Color getColor(){
		return color;
	}
	
	//setters
	public void setRadius(int r){
		radius = r;
		setVisible(true);
		revalidate();
		repaint();
	}
	
	public void setThickness(int t){
		thickness = t;
		setVisible(true);
		revalidate();
		repaint();
	}
	
	public void setColor(Color c){
		color = c;
		setVisible(true);
		revalidate();
		repaint();
	}
	
	//methods
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	    Graphics2D g2 = (Graphics2D) g.create();
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	    // Optional: Draw background with rounded corners
	    g2.setColor(getBackground());
	    g2.fillRoundRect(
	        thickness / 2, thickness / 2,
	        getWidth() - thickness, getHeight() - thickness,
	        radius, radius
	    );

	    // Draw border
	    g2.setColor(color);
	    g2.setStroke(new BasicStroke(thickness));
	    g2.drawRoundRect(
	        thickness / 2, thickness / 2,
	        getWidth() - thickness, getHeight() - thickness,
	        radius, radius
	    );

	    g2.dispose();
    }
}