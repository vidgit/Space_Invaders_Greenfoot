import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class TextDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextDisplay extends Actor
{
    GreenfootImage img;
    public TextDisplay(String txt,int size)
    {
        img=new GreenfootImage(txt,size,Color.white,new Color(0,0,0,0));
        setImage(img);
    }
    /**
     * Act - do whatever the TextDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
    }    
}
