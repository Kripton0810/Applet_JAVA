import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Fifth extends Applet
{
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.drawRoundRect(100,50,200,80,20,20);
        
        g.setColor(Color.green);
        g.fillOval(100,230,200,200);
        g.setColor(Color.yellow);
        g.fillRect(140,290,100,100);
    }
}


/*
 <html>
 <head>
 <titel>
 Question 5
 </titel>
 </head>
 <body>
 <applet code = "Fifth.class" width="500" height="500">
 <param name="name" value="Hello world">
 </applet>
 </body>
 </html>
 */