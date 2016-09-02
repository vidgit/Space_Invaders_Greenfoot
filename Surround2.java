import greenfoot.*;

/**
 * Generates the backfire effect
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Surround2 extends Actor
{int i=5;
    /**
     * Act - do whatever the Surround2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      fade();
    }    

    public void fade(){
        i--;
        if(i==0){
            
            getWorld().removeObject(this);
            
        }
        
    }}