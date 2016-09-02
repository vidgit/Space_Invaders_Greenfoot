import greenfoot.*;

/**
 * Generates asteroids
 * asteroids are obstacles which will not attack the player instead they will create path hinderence
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{   private int imgnumber;
    private int hit=10;
    int dx=0;
    int dy=1;
    
    public Asteroid(){
        imgnumber=Greenfoot.getRandomNumber(12)+1;
        setImage("a"+imgnumber+".png");
    }
    
    public int gethit()
    {return hit;}
    public void sethit(int d)
    {hit-=d;
    }
    public void act() 
    {
        
        int i=1;
        if(imgnumber>=144)
        {imgnumber=1;
        }
        else
        imgnumber++;
        i=1+imgnumber/12;
        setImage("a"+i+".png");
        move();
    }    
    
    public void move()
    {   setLocation(getX(), getY()+dy);
        checkWalls();
    }
    
    private void checkWalls()
    {
        if (getY() == getWorld().getHeight()-1) 
        {
            
            getWorld().removeObject(this);
        
        }
       
    }
}
