import java.awt.*;
import java.applet.*;
import java.net.*;
import java.awt.event.*;
public class Fourteen extends Applet implements ActionListener
{
    public void init() {
      String link = "bookbin";
      Button b = new Button(link);
      b.addActionListener(this);
      add(b);
   }
   public void actionPerformed(ActionEvent ae) {
      Button src = (Button)ae.getSource();
      String link = "https://www."+src.getLabel()+".com";
      
      try {
         AppletContext a = getAppletContext();
         URL u = new URL(link);
         a.showDocument(u,"_self");
      } catch (MalformedURLException e){
         System.out.println(e.getMessage());
      }
   }
}

/*

 */