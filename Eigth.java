import java.awt.*;
import javax.swing.*;

public class Eigth extends JPanel
{
    
    public void paintComponent(Graphics g)
    {
        g.drawString("Hello I am in London!!",50,100);
        
    }
    public static void main(String args[])
    {
        Label l1,l2;
        JFrame frame = new JFrame("Where I am");
        l1=new Label("Thsi is a Label Example");
        l2 = new Label("And I am Writing Some Text you have to seee 0_0");
        l1.setBounds(50,100,100,30);
        l2.setBounds(50,140,500,30);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Eigth panel = new Eigth();
        frame.add(l1);
        frame.add(l2);
        frame.add(panel);
        frame.setSize(500,300);
        frame.setVisible(true);
    }
}