import greenfoot.*;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private int imgnumber;
    // Generates the explosion animation
    public Explosion(){
        imgnumber=1;
        setImage("e"+imgnumber+".png");
        Greenfoot.playSound("Explosion.wav");
    }

    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(imgnumber>=100)
            getWorld().removeObject(this);
        else
        {imgnumber+=2;
            int i=1+imgnumber/5;
            setImage("e"+i+".png");
        }  
    }
}

