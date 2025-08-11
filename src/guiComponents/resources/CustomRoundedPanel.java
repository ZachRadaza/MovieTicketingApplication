package guiComponents.resources;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;

public class CustomRoundedPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int topLeftRadius;
    private int topRightRadius;
    private int bottomRightRadius;
    private int bottomLeftRadius;
    private int thickness;
    private Color borderColor;

    public CustomRoundedPanel(int tl, int tr, int br, int bl, Color borderColor, int thickness) {
        this.topLeftRadius = tl;
        this.topRightRadius = tr;
        this.bottomRightRadius = br;
        this.bottomLeftRadius = bl;
        this.borderColor = borderColor;
        this.thickness = thickness;
        setOpaque(false);
    }
    
    public CustomRoundedPanel(int top, int bottom, Color borderColor, int thickness) {
        this.topLeftRadius = top;
        this.topRightRadius = top;
        this.bottomRightRadius = bottom;
        this.bottomLeftRadius = bottom;
        this.borderColor = borderColor;
        this.thickness = thickness;
        setOpaque(false);
    }
    
	//getters
	public int getRadiusTL(){
		return topLeftRadius;
	}
	
	public int getRadiusTR(){
		return topRightRadius;
	}
	
	public int getRadiusBL(){
		return bottomLeftRadius;
	}
	
	public int getRadiusBR(){
		return bottomRightRadius;
	}
	
	public int getThickness(){
		return thickness;
	}
	
	public Color getColor(){
		return this.borderColor;
	}
	
	//setters
	public void setRadiusTL(int r){
		topLeftRadius = r;
		setVisible(true);
		revalidate();
		repaint();
	}
	
	public void setRadiusTR(int r){
		topRightRadius = r;
		setVisible(true);
		revalidate();
		repaint();
	}
	
	public void setRadiusBL(int r){
		bottomLeftRadius = r;
		setVisible(true);
		revalidate();
		repaint();
	}
	
	public void setRadiusBR(int r){
		bottomRightRadius = r;
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
		this.borderColor = c;
		setVisible(true);
		revalidate();
		repaint();
	}
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape shape = createRoundedShape(w, h);

        // Fill background
        g2.setColor(getBackground());
        g2.fill(shape);

        // Draw border
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(borderColor);
        g2.draw(shape);

        g2.dispose();
    }
    
    private Shape createRoundedShape(int w, int h) {
        int t = thickness / 2;

        GeneralPath path = new GeneralPath();
        path.moveTo(t + topLeftRadius, t);

        // Top edge to top-right corner
        path.lineTo(w - topRightRadius - t, t);
        path.quadTo(w - t, t, w - t, t + topRightRadius);

        // Right edge to bottom-right corner
        path.lineTo(w - t, h - bottomRightRadius - t);
        path.quadTo(w - t, h - t, w - bottomRightRadius - t, h - t);

        // Bottom edge to bottom-left corner
        path.lineTo(t + bottomLeftRadius, h - t);
        path.quadTo(t, h - t, t, h - bottomLeftRadius - t);

        // Left edge to top-left corner
        path.lineTo(t, t + topLeftRadius);
        path.quadTo(t, t, t + topLeftRadius, t);

        path.closePath();
        return path;
    }
    
}