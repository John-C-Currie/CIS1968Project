import java.util.ArrayList;

public class Selection  // class to find all nearby trees at a specific point on the map
{
    private static double xCoor, yCoor;

    private static double WPP = Conversion.convertWidthPerPixel("PhilaCnty1854.png");
    private static double HPP = Conversion.convertHeightPerPixel("PhilaCnty1854.png");
    
    public static void setCordinates(int x, int y)
    {
        xCoor = Conversion.widthToLong(x, WPP);
        yCoor = Conversion.heightToLat(y, HPP);
    }

    public static void main(String args[])
    {
        
    }
}