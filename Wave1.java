import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class Wave1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wave1 extends Actor
{
    Enemyship[] enemyship=new Enemyship[18];
    int count;
    int next;
    boolean wv3;
    public Wave1(int c,int nex,boolean wv)
    {
        setImage(new GreenfootImage(" ",1,new Color(0,0,0,0),new Color(0,0,0,0)));
        wv3=wv;
        next=nex;
        count=c;
        enemyship=new Enemyship[c];
    }
    /**
     * Act - do whatever the Wave1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        if(count<=0)
        {   World myWorld=getWorld();
            BackDrop bd=(BackDrop)myWorld;
            bd.addWave2(next,wv3);
            getWorld().removeObject(this);
        }
    }    
}
