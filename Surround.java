import greenfoot.*;

/**
 * Generates Backfire Effect
 * 
 * @author  
 * @version (a version number or a date)
 */
public class Surround extends Actor
{
    int i=5;

    /**
     * Act - do whatever the Surround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {fade();
    }    

    public void fade(){
        i--;
        if(i==0){
            getWorld().addObject(new Surround2(),getX(),getY());
            getWorld().removeObject(this);
            
        }
        
    }
}
