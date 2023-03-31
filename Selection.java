import java.util.ArrayList;

public class Selection  // class to find all nearby trees at a specific point on the map
{
    private double xCoor, yCoor;

    private double WPP = Conversion.convertWidthPerPixel("PhilaCnty1854.png");
    private double HPP = Conversion.convertHeightPerPixel("PhilaCnty1854.png");
    
    public Selection(int x, int y)
    {
        this.xCoor = Conversion.widthToLong(x, WPP);
        this.yCoor = Conversion.heightToLat(y, HPP);
    }

    public String toString()
    {
        return "X: " + this.xCoor + "\t Y: " + this.yCoor;
    }

    public static void main(String args[])
    {
        
    }
}