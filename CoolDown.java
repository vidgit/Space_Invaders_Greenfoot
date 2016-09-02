import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class CoolDownBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoolDown extends Actor
{   private int cooldown;
    Bar bOut;
    Bar bIn;
    
    public int getcooldown()
    {   cooldown=bIn.getValue();
        return bIn.getValue();
    }
    
    public void setcooldown()
    {
        cooldown=0;
        bIn.setValue(-100);
        
    }
    
    public CoolDown()
    {
        cooldown=100;
        bOut=new Bar(104,12,Color.WHITE);
        bIn=new Bar(100,10,Color.BLUE);
        
        
    }
    
    /**
     * Act - do whatever the CoolDownBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void update() 
    {   
        bIn.update(2);
        bOut.updateLocation(104);
        bIn.updateLocation(bIn.getValue());
    }   
    
    
    
}
