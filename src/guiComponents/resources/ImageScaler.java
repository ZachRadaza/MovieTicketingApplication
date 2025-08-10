package guiComponents.resources;

import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageScaler {
    public static Image getScaledImage(Image srcImg, int maxWidth, int maxHeight) {
        int srcWidth = srcImg.getWidth(null);
        int srcHeight = srcImg.getHeight(null);

        // Calculate scale factor
        double widthRatio = (double) maxWidth / srcWidth;
        double heightRatio = (double) maxHeight / srcHeight;
        double scale = Math.min(widthRatio, heightRatio); // Keep smaller ratio to avoid overflow

        // New dimensions
        int newWidth = (int) (srcWidth * scale);
        int newHeight = (int) (srcHeight * scale);

        return srcImg.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    }
    
    public static JLabel scaledImageJLabel(String filePath, int maxWidth, int maxHeight){
	    ImageIcon originalIcon = new ImageIcon(filePath);
	    Image scaledImg = ImageScaler.getScaledImage(originalIcon.getImage(), maxWidth, maxHeight);
	    JLabel labelIcon = new JLabel(new ImageIcon(scaledImg));
	    labelIcon.setBorder(BorderFactory.createEmptyBorder());
	    
	    return labelIcon;
    }
}