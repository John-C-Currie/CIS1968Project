import java.awt.Image;

import javax.swing.ImageIcon;

public class Conversion 
{
    //Philadelphia boundaries in decimal degrees
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

    public static double convertWidthPerPixel(String fileName) //returns the number of decimal degrees per pixel in the width of the given image
    {
        String dim = getImageSize(fileName);
        double width = pWidth/Integer.parseInt(dim.substring(dim.indexOf("x")+1, dim.length()));
        return width;
    }

    public static double convertHeightPerPixel(String fileName)//returns the number of decimal degrees per pixel in the height of given image
    {
        String dim = getImageSize(fileName);
        double height = pHeight/Integer.parseInt(dim.substring(0, dim.indexOf("x")));
        return height;
    }
    
    public static double widthToLat(int width, double WPP)
    {
        return pWest + (width * WPP);
    }

    public static double heightToLong(int height, double HPP)
    {
        return pNorth - (height * HPP);
    }
    public static void main(String[] args) 
    {
        String x = getImageSize("PhilaCnty1854.png");
        System.out.println(x);
        System.out.println(convertWidthPerPixel("PhilaCnty1854.png"));
        System.out.println(convertHeightPerPixel("PhilaCnty1854.png"));
        System.out.println(longFromPoint);
        
        // example pixel at (250, 250)
        System.out.println("Lat: " + heightToLong(250, convertHeightPerPixel("PhilaCnty1854.png")));
        System.out.println("Long: " + widthToLat(250, convertWidthPerPixel("PhilaCnty1854.png")));
    }
}
