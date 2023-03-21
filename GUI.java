import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
public class GUI extends JFrame
{
    private JFrame frame;
    private JLabel label;
    private Container contentPane;

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

    public GUI(String fileName)
    {
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        frame = new JFrame("Philly Tree Map");
        label = new JLabel("");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        contentPane.add(label, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(getScreenWidth(), getScreenHeight());
        label.setIcon(new ImageIcon(fileName));
        frame.getContentPane().add(label);
        
        JScrollPane scrollPane = new JScrollPane(label);
        scrollPane.setPreferredSize(new Dimension(getScreenWidth(), getScreenHeight()));
        frame.getContentPane().add(scrollPane);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            private int zoomLevel = 100;

            @Override
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                if (notches < 0) {
                    zoomLevel += 10;
                } else if (zoomLevel >= 50) {
                    zoomLevel -= 10;
                }
                ImageIcon imgIcon = new ImageIcon(fileName);
                Image img = imgIcon.getImage();
                Image newImg = img.getScaledInstance(zoomLevel, zoomLevel, java.awt.Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(newImg));
                label.setPreferredSize(new Dimension(zoomLevel, zoomLevel));
                //frame.getContentPane().add(label);
                frame.pack();
                frame.repaint();
            }
        };

        label.addMouseWheelListener(mouseAdapter);
        pack();
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI("PhilaCnty1854.png");
    }
}
