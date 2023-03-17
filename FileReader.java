import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileReader 
{
    private ArrayList<Tree> trees = new ArrayList<Tree>();

    public void lines(String filename)
    {
        trees.add(null);
        try
        {
            Scanner scan = new Scanner(new File(filename));
            scan.nextLine();
            while (scan.hasNextLine())
            {
                //scan.useDelimiter(",");
                String line = scan.nextLine();
                String [] data = line.split(",");
                trees.add(new Tree(Double.parseDouble(data[6]), Double.parseDouble(data[7]), data[3]));
            }
            scan.close();
        }

        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: File Not Found");
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        FileReader read = new FileReader();
        read.lines("tree2021.csv");
    }
}
