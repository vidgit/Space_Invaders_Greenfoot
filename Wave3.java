import greenfoot.*;
import java.awt.Color;
import java.util.List;

/**
 * Write a description of class Wave3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wave3 extends Actor
{
    Wave1 w1;
    Wave2 w2;
    EShip2 e;
    int count=3;
    int prev_count=3;
    public Wave3()
    {   setImage(new GreenfootImage(" ",1,new Color(0,0,0,0),new Color(0,0,0,0)));
        
        e=new EShip2();
    }
    
    public void act()
    {
        World myWorld=getWorld();
        BackDrop bd=(BackDrop)myWorld;
        if(count>0)
        {
            if(count<prev_count)
            {
                prev_count=count;
                e=new EShip2();
                getWorld().addObject(e,Greenfoot.getRandomNumber(600),100);
            }
            
        }
        else if(count<=0&&bd.w1.count<=0&&bd.w2.count<=0)
        {
            
            List l=bd.getObjects(Enemyship1.class);
            bd.removeObjects(l);
            bd.afterburn();
            getWorld().removeObject(this);
            
        }
    }
}
