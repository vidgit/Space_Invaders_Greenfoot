import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Pause here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pause extends Actor
{   GreenfootImage img;
    int i=0;
    public Pause()
    {
        img=new GreenfootImage("Paused",80,Color.white,new Color(0,0,0,0));
        img.setTransparency(1);
        setImage(img);
    }

    /**
     * Act - do whatever the Pause wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   if(i++%10==0)
        {
            if(Greenfoot.isKeyDown("shift"))
                if(BackDrop.pause==true)
                {
                    BackDrop.pause=false;
                    img.setTransparency(255);
                    setImage(img);
                }
                else
                {
                    BackDrop.pause=true;
                    img.setTransparency(0);
                    setImage(img);
            }
        }
    }    
}
