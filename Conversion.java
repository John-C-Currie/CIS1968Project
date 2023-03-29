import java.awt.Image;

import javax.swing.ImageIcon;

public class Conversion 
{
    static final double pNorth = 40.13800000;
    static final double pSouth = 39.86500000;
    static final double pEast = -74.94800000;
    static final double pWest = -75.28500000;
    static double pWidth = pEast-pWest;
    static double pHeight = pNorth-pSouth;
    
    static final double longFromPoint = (1.0/69.0)/2.0;
    static final double latFromPoint = (1.0/54.6)/2.0;

    public static String getImageSize(String fileName)
    {
        ImageIcon imgIcon = new ImageIcon(fileName);
        Image img = imgIcon.getImage();
        int imgWidth = img.getWidth(null);
        int imgHeight = img.getHeight(null);
        return imgWidth + "x" + imgHeight;
    }

    public static double convertWidthPerPixel(String fileName)
    {
        String dim = getImageSize(fileName);
        double width = pWidth/Integer.parseInt(dim.substring(dim.indexOf("x")+1, dim.length()));
        return width;
    }

    public static double convertHeightPerPixel(String fileName)
    {
        String dim = getImageSize(fileName);
        double height = pHeight/Integer.parseInt(dim.substring(0, dim.indexOf("x")));
        return height;
    }

    public static void main(String[] args) 
    {
        String x = getImageSize("PhilaCnty1854.png");
        System.out.println(x);
        System.out.println(convertWidthPerPixel("PhilaCnty1854.png"));
        System.out.println(convertHeightPerPixel("PhilaCnty1854.png"));
        System.out.println(longFromPoint);
        
    }
}
