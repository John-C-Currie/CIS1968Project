import javax.swing.*;
import java.awt.Toolkit;
public class GUI extends JFrame
{
    
    public GUI()
    {
        super();
    }

    public GUI(String Title)
    {
        super(Title);
    }

    public static int getScreenHeight()
    {
        return Toolkit.getDefaultToolkit().getScreenSize().height;
    }

    public static int getScreenWidth()
    {
        return Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    public static int[] getScreenSize()
    {
        int[] screenSize = new int[]{getScreenWidth(), getScreenHeight()};  
        return screenSize;
    }

    public void createContainer()
    {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        this.add(container);
    }
    public static void main(String[] args) {
        GUI frame = new GUI("Philly Tree Map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(getScreenWidth(), getScreenHeight());
        JButton button = new JButton("Press");
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}
