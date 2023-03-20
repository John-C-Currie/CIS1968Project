import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;
public class GUI extends JFrame
{

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Philly Tree Map");
        JLabel label = new JLabel("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(getScreenWidth(), getScreenHeight());
        label.setIcon(new ImageIcon("PhilaCnty1854.png"));
        Dimension size = label.getPreferredSize();
        label.setBounds(0,0,size.width, getScreenHeight());
        frame.getContentPane().add(label);
        frame.setVisible(true);
    }
}
