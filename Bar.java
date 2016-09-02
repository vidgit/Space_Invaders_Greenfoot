import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Bar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bar extends Actor
{   GreenfootImage image;
    private int value;
    private int maxlength;
    public Bar(int width,int height, Color color)
    {   maxlength=width;
        GreenfootImage img=new GreenfootImage(width,height);
        img.setColor(color);
        img.fill();
        image=img;
        value=maxlength;
        setImage(image);

    }
    public int getValue()
    {
        return value;
    }

    public void setValue(int x)
    {
        update(x);
    }

    /**
     * Act - do whatever the Bar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void update(int x)
    {if(value+x<=0)
            value=0;
        else if(value+x>=maxlength)
            value=maxlength;
        else
            value+=x;
    }

    public void updateLocation(int l)
    {
        if(l==0)
        l++;
        GreenfootImage img2=new GreenfootImage(l,image.getHeight());
        img2.setColor(image.getColor());
        img2.fill();
        image=img2;
        setImage(image);
    }
}
