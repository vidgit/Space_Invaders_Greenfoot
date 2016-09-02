import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Wave2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wave2 extends Actor
{
    Enemyship1[] enemyship;
    int count=6;
    boolean next;
    public Wave2(int c,boolean nex)
    {
        setImage(new GreenfootImage(" ",1,new Color(0,0,0,0),new Color(0,0,0,0)));
        count=c;
        enemyship=new Enemyship1[c];
        next=nex;
    }

    /**
     * Act - do whatever the Wave2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
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
    }  

}
