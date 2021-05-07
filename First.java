import java.applet.*;  
import java.awt.*; 
import java.net.*; 
import java.awt.event.*;
public class First extends Applet implements Runnable,ActionListener{  
  private String disp;
  private int x,y;
  private boolean flag;
  Thread t;
  Image back;
  AudioClip au;
  private Button b1,b2,b3;
  private AppletContext ctx;
  public void init()
  {
      Font f=new Font("Arial",Font.BOLD,25);   
      ctx=this.getAppletContext();
        setFont(f);    
      disp= "Question 1 Playing Music";
      flag=true;
      setSize(900,900);
      back = getImage(getCodeBase(),"image.jpeg");
      x=150;
      y=100;
      try
      {
          URL url = new URL(this.getCodeBase(),"song.wav");
          au = ctx.getAudioClip(url);
          System.out.println(url);
        }catch(Exception e)
        {
            System.out.println("Error>>>"+e);
            
        }
      b1 = new Button("Play");
      b2 = new Button("Repeat");
      b3 = new Button("Stop");
      add(b1);
      add(b2);
      add(b3);
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      t = new Thread(this,"My Thread");
      t.start();
    }
    public void actionPerformed(ActionEvent ae)
    {  
        Button b = (Button) ae.getSource();
        if(b==b1)
        {
            au.play();
            System.out.println("Playing song!!!");
        }
            else if(b==b2)
            {
            au.loop();
            System.out.println("Repeating song!!!");
        }
            else
            {
            au.stop();
            System.out.println("Stoping song!!!");
        }
    }
    public void update()
    {
        if(flag)
        {
            disp="";
            flag=false;
        }else
        {
            disp= "Question 1 Playing Music";
            flag=true;
        }
    }
    
    public void run()
    {
        while(true)
        {
            repaint();
            update();
            try
            {
                Thread.sleep(1000);
            }catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    public void paint(Graphics g)
    {
        g.drawImage(back,0,0,this);
        g.drawString(disp,x,y);
    }
}  