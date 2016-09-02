import greenfoot.*;

/**
 * Write a description of class Enemyship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemyship extends SmoothMover
{
    private int Damage=10;
    private int hit=10;
    public double exactX;
    public double exactY;
    private Vector move = new Vector();
    public Ship user = new Ship();
    private GreenfootImage img;
    private int dx=2;

    public Enemyship()
    {
        img=new GreenfootImage("bgbattleship.png");
        img.scale(50,50);
        img.rotate(90);
        setImage(img);
    }

    public double getExactX(double exactX)
    { 
        this.exactX = exactX;
        return exactX;
    }

    public double getExactY(double exactY)
    {
        this.exactY = exactY;
        return exactY;
    }

    /**
     * Act - do whatever the Enemyship1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        if(BackDrop.pause==true)
        {
            setLocation(getX()+dx,getY());
            atEdge();
            if ( Greenfoot.getRandomNumber(1000)<4)
            {
                getWorld().addObject(new EnemyBullets( new Vector(this.getRotation()-90, 10.0), this.getRotation()-90), this.getX() , this.getY() + 40);
            }
            if (atBottom())
            {
                World myWorld=getWorld();
                BackDrop bd=(BackDrop)myWorld;
                bd.w1.count--;
                getWorld().removeObject(this);
                
            }
            else if(gethit()==0)
            {
                getWorld().removeObject(this);
            }
        }
    }

    public int gethit()
    {
        return hit;
    }

    public void sethit(int d)
    {
        hit-=d;
    }

    private void atEdge()
    {
        if (getX() == 0 || getX() == getWorld().getWidth()-1) 
        {
            dx = -dx;
            for(int i=50;i>0;i--)
            {
                setLocation(getX(),getY()+1);
            }
        }

    }

    private boolean atBottom()
    {
        if (getY() == getWorld().getHeight()-1) 
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

}
