import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;


public class Map extends BufferedImage
{
    private BufferedImage map;

    public Map(int width, int height, int imageType)
    {
        super(width, height, imageType);
    }

    public BufferedImage getMap()
    {
        return this.map;
    }

    public void setMap(BufferedImage map)
    {
        this.map = map;
    }

    public void loadMap(String filename)
    {
        try
        {
            map = ImageIO.read(new File(filename));
        }
        catch (IOException e)
        {
            System.out.println("ERROR: File Not Found");
            e.printStackTrace();
        }
    }
}
