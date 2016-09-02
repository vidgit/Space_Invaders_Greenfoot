import greenfoot.*;

/**
 * Write a description of class invader2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class invader2 extends Actor
{
     GreenfootImage img;
    int e;
    public invader2()
    {img=new GreenfootImage("sii3.gif");
        img.scale(img.getHeight()*5,img.getWidth()*5);
        setImage(img);
        e=1;
        
    }
    /**
     * Act - do whatever the invader wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       e++;
       if(e<20)
       img=new GreenfootImage("sii4.gif");
       else
       img=new GreenfootImage("sii3.gif");
       if(e==40)
       e=0;
       img.scale(img.getHeight()*5,img.getWidth()*5);
       setImage(img);
    }    
}
