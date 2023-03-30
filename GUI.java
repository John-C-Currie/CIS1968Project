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
    private JTextField textField;
    private JPanel panel;

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
        contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        frame = new JFrame("Philly Tree Map");
        label = new JLabel("");
        panel = new JPanel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        textField = new JTextField("Mouse Location");
        textField.setEditable(true);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setText("Mouse Location");
        textField.setSize(100,100);

        panel.add(textField);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
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

            public void mouseClicked(java.awt.event.MouseEvent e) 
            {
                setMouseX(e.getX());
                setMouseY(e.getY());
            }        
        };

        label.addMouseListener(mouseAdapter);
        pack();
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI("PhilaCnty1854.png");
    }
}
