import java.util.ArrayList;

public class Selection  // class to find all nearby trees at a specific point on the map
{
    private static double xCoor, yCoor;
    static ArrayList<Tree> trees = FileReader.getList();
    private static double WPP = Conversion.convertWidthPerPixel("PhilaCnty1854.png");
    private static double HPP = Conversion.convertHeightPerPixel("PhilaCnty1854.png");
    
    public static void setCordinates(int x, int y) //this is public so that it can be used in the GUI class
    {
        xCoor = Conversion.widthToLat(x, WPP);
        yCoor = Conversion.heightToLong(y, HPP);
    }

    public static int getNearbyTrees(int x, int y, ArrayList<Tree> trees)
    {
        setCordinates(x, y);
        int count = 0;
        for (int i = 1; i < trees.size(); i++)
        {
            Tree tree = FileReader.getList().get(i);
            if (Math.abs(tree.getXcor() - xCoor) < Conversion.latFromPoint && 
                Math.abs(tree.getYcor() - yCoor) < Conversion.longFromPoint)
            {
                count++;
            }
            
        }
        return count;
    }

    public static void main(String args[])
    {
        FileReader read = new FileReader();
        read.lines("tree2022.csv");
        System.out.println(getNearbyTrees(274, 291, trees));
    }
}