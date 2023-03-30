import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
public class GUI extends JFrame
{

    private int mouseX, mouseY;

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

    public int getMouseX()
    {
        return mouseX;
    }

    public int getMouseY()
    {
        return mouseY;
    }

    public void setMouseX(int mouseX)
    {
        this.mouseX = mouseX;
    }

    public void setMouseY(int mouseY)
    {
        this.mouseY = mouseY;
    }

    public GUI(String fileName) //takes the name of the image file as a parameter, creates a JFrame with the image as a JLabel
    {
        Container contentPane = getContentPane();
            contentPane.setLayout(new BorderLayout());
        
        JFrame frame = new JFrame("Philly Tree Map");
        
        JLabel imgLabel = new JLabel("");
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            imgLabel.setBorder(border);
            ImageIcon imgIcon = new ImageIcon(fileName);
            Image img = imgIcon.getImage();
            //ImageIcon imgIconScaled = new ImageIcon(img.getScaledInstance(img.getWidth(null), img.getHeight(null), Image.SCALE_SMOOTH));
            //imgLabel.setHorizontalAlignment(JLabel.CENTER);
            //imgLabel.setVerticalAlignment(JLabel.CENTER);
            //imgLabel.setMinimumSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            //imgLabel.setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            //imgLabel.setMaximumSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            imgLabel.setIcon(imgIcon);
        
        JPanel imgPanel = new JPanel();
            imgPanel.add(imgLabel);
            imgPanel.setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            imgPanel.setMinimumSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            imgPanel.setMaximumSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            
            
            
        frame.setVisible(true);
        contentPane.add(imgPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(getScreenWidth(), getScreenHeight());
        
        
        frame.getContentPane().add(imgPanel);
        
        //JScrollPane scrollPane = new JScrollPane(label);
        //scrollPane.setPreferredSize(new Dimension(getScreenWidth(), getScreenHeight()));
        //frame.getContentPane().add(scrollPane);

        MouseAdapter mouseAdapter = new MouseAdapter() {
           // private int zoomLevel = 100;

            @Override
            /* 
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
            */
            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                //int panelXLoc = imgPanel.getLocation().x;
                //int panelYLoc = imgPanel.getLocation().y;
                
                setMouseX(e.getX());
                setMouseY(e.getY());
                frame.setTitle("Mouse Location: " + getMouseX() + ", " + getMouseY());
            }        
        };

        imgLabel.addMouseListener(mouseAdapter);
        pack();
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI("PhilaCnty1854.png");
    }
}
