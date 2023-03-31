import java.util.ArrayList;

public class Selection  // class to find all nearby trees at a specific point on the map
{
    private static double xCoor, yCoor;
    static ArrayList<Tree> trees = FileReader.getList();
    private static double WPP = Conversion.convertWidthPerPixel("PhilaCnty1854.png");
    private static double HPP = Conversion.convertHeightPerPixel("PhilaCnty1854.png");
    
    public static void setCordinates(int x, int y)
    {
        xCoor = Conversion.widthToLong(x, WPP);
        yCoor = Conversion.heightToLat(y, HPP);
    }

    public static int getNearbyTrees(int x, int y)
    {
        setCordinates(x, y);
        int count = 0;
        System.out.println("This shouldn't be 0: " + trees.size());
        for (int i = 1; i < trees.size(); i++)
        {
            Tree tree = FileReader.getList().get(i);
            if (Math.abs(tree.getXcor() - xCoor) < Conversion.longFromPoint && 
                Math.abs(tree.getYcor() - yCoor) < Conversion.latFromPoint)
            {
                count++;
            }
            
        }
        return count;
    }

    public static void main(String args[])
    {
        FileReader read = new FileReader();
        read.lines("tree2021.csv");
        System.out.println(getNearbyTrees(274, 291));
    }
}