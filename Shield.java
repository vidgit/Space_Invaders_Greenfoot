import greenfoot.*;
import java.awt.Color;
import java.util.List;

/**
 * Write a description of class Nuke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Actor
{   Bar in;
    Bar out;
    int time=0;
    int dx=5;
    public Shield()
    {//new Color(0,204,255)
        in=new Bar(15,40,new Color(0,204,255));
        out=new Bar(19,44,Color.white);
    }

    /**
     * Act - do whatever the Nuke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(BackDrop.pause==true)
        {   time++;
            checkWall();
            setDamage();
            setLocation(getX()+dx,getY());
            in.setLocation(getX()+dx,getY());
            out.setLocation(getX()+dx,getY());
            if(time==413)
            {
                getWorld().removeObject(this.in);
                getWorld().removeObject(this.out);
                getWorld().removeObject(this);
            } 
        }
    }

    public void checkWall()
    {
        if(getX()<10||getX()>getWorld().getWidth()-10)
            dx*=-1;
    }
    
    public void setDamage()
    {
        List l=getIntersectingObjects(EnemyBullets.class);
        getWorld().removeObjects(l);
    }
}
