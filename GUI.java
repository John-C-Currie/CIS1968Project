import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
public class GUI extends JFrame
{

    private int mouseX, mouseY;
    //private static ArrayList<Tree> trees = new ArrayList<Tree>();

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

    public GUI(String fileName, String csvFileName) //takes the name of the image file and the name of the csv file as parameters, and displays the image file with the amount of trees in the area of the image that the user clicks on
    {
        FileReader read = new FileReader();
        read.lines(csvFileName);

        Container contentPane = getContentPane();
            contentPane.setLayout(new BorderLayout());
        
        JFrame frame = new JFrame("Philly Tree Map");
        
        JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

        JLabel imgLabel = new JLabel("");
            Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
            imgLabel.setBorder(border);
            ImageIcon imgIcon = new ImageIcon(fileName);
            Image img = imgIcon.getImage();
            imgLabel.setIcon(imgIcon);
        
        JLabel textLabel = new JLabel("Click on the map to display the amount of trees in that area.");
            textLabel.setHorizontalAlignment(JLabel.CENTER);
            textLabel.setVerticalAlignment(JLabel.CENTER);
            textLabel.setMinimumSize(new Dimension(621, 50));
            textLabel.setMaximumSize(new Dimension(621, 50));
            textLabel.setPreferredSize(new Dimension(621, 50));

        JPanel textPanel = new JPanel();
            textPanel.add(textLabel, BorderLayout.NORTH);
            textPanel.setPreferredSize(new Dimension(621, 50));
            textPanel.setMinimumSize(new Dimension(621, 50));
            textPanel.setMaximumSize(new Dimension(621, 50));

        JPanel imgPanel = new JPanel();
            imgPanel.add(imgLabel, BorderLayout.CENTER);
            imgPanel.setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            imgPanel.setMinimumSize(new Dimension(img.getWidth(null), img.getHeight(null)));
            imgPanel.setMaximumSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        
            textLabel.setPreferredSize(new Dimension(500, 50));
            textLabel.setMinimumSize(new Dimension(500, 50));
            textLabel.setMaximumSize(new Dimension(500, 50));
        
        mainPanel.add(imgPanel, BorderLayout.CENTER);
        mainPanel.add(textPanel, BorderLayout.NORTH);
            
            
        frame.setVisible(true);
        frame.add(textLabel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(getScreenWidth(), getScreenHeight());
        
        
        frame.getContentPane().add(imgPanel);

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
                setMouseX(e.getX());
                setMouseY(e.getY());
                frame.setTitle("Mouse Location: " + getMouseX() + ", " + getMouseY());

                Selection.setCordinates(getMouseX(), getMouseY());
                int near = Selection.getNearbyTrees(getMouseX(), getMouseY(), Selection.trees);
                if(near > 0)
                textLabel.setText("<html>Click on the map to display the amount of trees in that area.<br>" + "<center>There are " + near + " trees in a square mile from this point.</center>");
                else
                textLabel.setText("<html>Click on the map to display the amount of trees in that area.<br>" + "<center>There are no recorded trees in this area at this time.</center>");
            }        
        };

        imgLabel.addMouseListener(mouseAdapter);
        pack();
        
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        GUI gui = new GUI("PhilaCnty1854.png", "tree2022.csv");
    }
}
