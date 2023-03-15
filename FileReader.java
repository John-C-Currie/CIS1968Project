import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReader 
{
    public void lines(String filename)
    {
        try
        {
            Scanner scan = new Scanner(new File(filename));
            while (scan.hasNextLine())
            {
                scan.useDelimiter(",");
                String line = scan.next();
                System.out.println(line);
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
