import java.applet.*;  
import java.awt.*;  
import java.awt.event.*;  
public class EventApplet extends Applet implements ActionListener{  
Button b;  
TextField tf;  
String st;
public void init(){  
tf=new TextField();  
tf.setBounds(30,40,150,20);  
b=new Button("Click");  
b.setBounds(80,150,60,50);  
st="Welcome";
add(b);add(tf);   
b.addActionListener(this); 
setLayout(null);  
}  
  
 public void actionPerformed(ActionEvent e){ 
    String s = tf.getText();
    st= "Welcome 0_0"+s;
    repaint();
 }  
 public void paint(Graphics g)
 {
     g.drawString(st,50,100);
    }
}  
/*
 <html>  
<body>  
<applet code="EventApplet.class" width="300" height="300">  
</applet>  
</body>  
</html>  
 */