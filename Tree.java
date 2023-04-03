public class Tree 
{
    private double xcor, ycor;
    private String treeType;
    private double DBH;

    public double getXcor()
    {
        return this.xcor;
    }
    
    public double getYcor()
    {
        return this.ycor;
    }

    public String getTreeType()
    {
        return this.treeType;
    }

    public double getDBH()
    {
        return this.DBH;
    }

    public void setXcor(double x)
    {
        this.xcor = x;
    }

    public void setYcor(double y)
    {
        this.ycor = y;
    }

    public void setTreeType(String type)
    {
        this.treeType = type;
    }

    public void setDBH(double DBH)
    {
        this.DBH = DBH;
    }
    public Tree(double y, double x, String type)
    {
        setYcor(y);
        setXcor(x);
        setTreeType(type);
    }

    public Tree(double x, double y)
    {
        this(x,y,"");
    }

    public String toString()
    {
        return "X-Cordinate: " + getXcor() + " Y-Cordinate: " + getYcor() + " Type: " + getTreeType();
    }
}
