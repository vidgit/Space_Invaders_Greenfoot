import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Wave4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wave4 extends Actor
{
   Help[] help;
    int count=6;
    boolean next;
    private int time;
    int index;
    int X;
    public Wave4(int c,boolean nex)
    {
        setImage(new GreenfootImage(" ",1,new Color(0,0,0,0),new Color(0,0,0,0)));
        count=c;
        help=new Help[c];
        next=nex;
        time=0;
        index=0;
        X=100;
    }

    /**
     * Act - do whatever the Wave2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        time++;
        if(count<=0)
        {
            if(next)
            {
                World myWorld=getWorld();
                BackDrop bd=(BackDrop)myWorld;
                bd.addWave3();
            }
            getWorld().removeObject(this);
        }
        else
        {
            if(time%100==0&&index<count)
            {   if(X==100)
                X=500;
                else
                X=100;
                help[index]=new Help();
                getWorld().addObject(help[index++],X,100);
            }
            
        }
    }  
 
}
