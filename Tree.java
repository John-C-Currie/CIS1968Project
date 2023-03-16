public class Tree 
{
    double xcor, ycor;
    String treeType;
    double DBH;
 
    public Tree(double x, double y, String type, double DBH)
    {
        this.xcor = x;
        this.ycor = y;
        this.treeType = type;
        this.DBH = DBH;
    }

    public Tree(double x, double y)
    {
        this(x,y,"",0);
    }
}
