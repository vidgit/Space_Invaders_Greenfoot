import greenfoot.*;
import java.awt.*;

/**
 * Stores hitpoints of the ship
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{   int health;
   Bar bOut;
    Bar bIn;
    
    public int gethealth()
    {   health=bIn.getValue();
        return bIn.getValue();
    }
    
    public void sethealth(int x)
    {
        health-=x;
        bIn.setValue(-x);
        
    }
    
    public Health()
    {
        health=100;
        bOut=new Bar(104,24,Color.WHITE);
        bIn=new Bar(100,20,Color.GREEN);
        
        
    }
    
    /**
     * Act - do whatever the CoolDownBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void update() 
    {   
        bIn.update(0);
        if(health!=0)
        bOut.updateLocation(104);
        else
        bOut.getImage().setTransparency(0);
        bIn.updateLocation(bIn.getValue());
    }   
    
}
