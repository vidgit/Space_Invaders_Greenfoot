import greenfoot.*;

/**
 * Write a description of class invader3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class invader3 extends Actor
{
     GreenfootImage img;
    int e;
    public invader3()
    {img=new GreenfootImage("sii5.gif");
        img.scale(img.getHeight()*4,img.getWidth()*4);
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
       img=new GreenfootImage("sii6.gif");
       else
       img=new GreenfootImage("sii5.gif");
       if(e==40)
       e=0;
       img.scale(img.getHeight()*4,img.getWidth()*4);
       setImage(img);
    }    
}
