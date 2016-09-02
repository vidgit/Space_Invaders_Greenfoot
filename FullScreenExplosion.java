import greenfoot.*;
import java.awt.Color;
import java.util.List;

/**
 * Write a description of class FullScreenExplosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FullScreenExplosion extends Actor
{private int time=20;
    private boolean kill=false;
    public FullScreenExplosion(boolean b)
    {
        GreenfootImage img=new GreenfootImage(600,600);
        img.setColor(Color.WHITE);
        img.fill();
        setImage(img);
        kill=b;
        Greenfoot.playSound("Explosion2.wav");
    }

    /**
     * Act - do whatever the FullScreenExplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   time--;
        if(time%2==0)
            getImage().setTransparency(0);
        else
            getImage().setTransparency(255);
        if(time==0)
        { 
            if(kill)
            {
                World myWorld=getWorld();
                BackDrop bd=(BackDrop)myWorld;
                BackDrop.death++;
                getWorld().removeObject(bd.ab);
                bd.setDead();
            }
            else            
            {
                World myWorld=getWorld();
                BackDrop bd=(BackDrop)myWorld;
                
                List l=getObjectsInRange(600, Enemyship1.class);
                List k=getObjectsInRange(600, EShip2.class);
                List j=getObjectsInRange(600, Enemyship.class);
                List z=getObjectsInRange(600, EnemyBullets.class);
                getWorld().removeObjects(z);
                int a=l.size();
                int b=k.size();
                int c=j.size();
                getWorld().removeObjects(l);
                //BackDrop.counte1-=a;
                getWorld().removeObjects(k);
                //BackDrop.counte2-=b;
                getWorld().removeObjects(j);
                //BackDrop.counte4-=c;
                //getWorld().removeObject(bd.ab);
                if(j.size()!=0)
                bd.w1.count=0;
                if(l.size()!=0)
                bd.w2.count=0; 
                if(k.size()!=0)
                bd.w3.count=0;
                for(int i=0;i<a+b+c;i++)
                {
                    getWorld().addObject(new Explosion(),
                    Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(530)+70);
                }
                getWorld().removeObject(this);
                
                
                
                
            }
        }

    }    
}
