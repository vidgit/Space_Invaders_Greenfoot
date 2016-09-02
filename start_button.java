import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class start_button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class start_button extends Actor
{   
    GreenfootImage img;
    int i;
    int up,down;
    public start_button(String txt)
    {   i=254;
        
        img=new GreenfootImage(txt,40,Color.white,new Color(0,0,0,0));
        setImage(img);
        down=1;
        up=0;
    }
    public void act() 
    {  if(up==0&&down==1)
        i-=2;
        else
        i+=2;
        if(i==254)
        {
            down=1;
            up=0;
        }
        if(i==2)
        {
            down=0;
            up=1;
        }
       img.setTransparency(i);
    }    
}
