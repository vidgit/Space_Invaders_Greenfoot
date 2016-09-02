import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    GreenfootImage img;
    int i;
    int flag;
    Color color;
    String txt;
    int max;
    public Title(String t,int m, Color c)
    {   txt=t;
        color=c;
        img=new GreenfootImage(txt,10,color,new Color(0,0,0,0));
        setImage(img);
        flag=1;
        max=m;
        i=m-80;
    }

    public void act() 
    {  img=new GreenfootImage(txt,i,color,new Color(0,0,0,0));
        setImage(img);
       // if(i%10==0)
        //    changeColor();
        
        if(i!=max)
        i++;
    }    

    public void changeColor()
    {flag*=-1;
        if(flag==-1)
            img=new GreenfootImage("SPACE INVADERS",80,new Color(0,204,255,255),new Color(0,0,0,0));
        else
            img=new GreenfootImage("SPACE INVADERS",80,Color.white,new Color(0,0,0,0));
        setImage(img);  

    }
}