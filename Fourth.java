import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.text.SimpleDateFormat;  
import java.util.Date;   
public class Fourth extends Applet implements Runnable
{
    Thread t1;
    private int h,m,s,y,mm,d;
    private String str,tmd,day;
    public void init()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss:yyyy:MM:dd");  
        Date date = new Date();  
        String tmd = formatter.format(date);
        String stm[] = tmd.split(":");
        System.out.println(tmd);
        Font f = new Font("Calibri",Font.BOLD,50);
        setFont(f);
        str= Integer.parseInt(stm[0])+":"+Integer.parseInt(stm[1])+":"+Integer.parseInt(stm[2]);
        y=Integer.parseInt(stm[3]);
        mm=Integer.parseInt(stm[4]);
        d=Integer.parseInt(stm[5]);
        s=Integer.parseInt(stm[2]);
        m=Integer.parseInt(stm[1]);
        h=Integer.parseInt(stm[0]);  
        day=d+"-"+mm+"-"+y;
        
        t1= new Thread(this,"T1");
        t1.start();
    }
    public void update()
    {
        str= h+":"+m+":"+s;
        s++;
        if(s==60)
        {
            s=0;
            m++;
        }else
        if(m==60)
        {
            h++;
            m=0;
        }else
        if((h==24)&&(mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==12))
        {
            h=0;
            d++;
            if(d==31)
            {
                d=1;
                mm++;
            }
            
        }
        else
        if((h==24)&&(mm==2||mm==4||mm==6||mm==9||mm==11))
        {
            h=0;
            d++;
            if(d==30)
            {
                d=1;
                m++;
            }
            else
            
            if(((y%100!=0 && y%4==0) || (y%400==0))&& (mm==2)&&(d==29))
            {
                d=1;
                m++;
            }
            else if((m==2)&&(d==28))
            {
                d=1;
                m++;
            }
        }
        if(m==12)
        {
            y++;
            m=0;
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
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    }
    public void paint(Graphics g)
    {
        g.drawString("Time::",10,100);
        g.drawString(str,140,100);
        g.drawString("Date::",10,170);
        g.drawString(day,140,170);
    }
}

/*
 <html>
 <head>
 <titel>
 Question 3
 </titel>
 </head>
 <body>
 <applet code = "Fourth.class" width="500" height="250">
 <param name="name" value="Hello world">
 </applet>
 </body>
 </html>
 */