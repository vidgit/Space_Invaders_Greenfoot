import greenfoot.*;

/**
 * Write a description of class Enemyship1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemyship1 extends SmoothMover
{
    private int Damage=10;
    private int hit=10;
    public double exactX;
    public double exactY;
    private Vector move = new Vector();
    public Ship user = new Ship();
    int time;
    int rot[]={45,-45,-45,0,45,45,0,-45,-45};
    int f;

    public Enemyship1()
    {   time=0;
        f=0;
        
        turn(270);
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
        {   time++;
            move (-2);
            if(time%30==0)
            {
                turn(rot[f]);
                if(f==7)
                f=-1;
                f++;

            }
            if ( Greenfoot.getRandomNumber(1500)<15)
            {
                getWorld().addObject(new EnemyBullets( 
                        new Vector(this.getRotation(), 10.0), 
                        this.getRotation()), this.getX() , this.getY() + 20);
            }
            if (atWorldEdge())
            {
                getWorld().addObject(new Enemyship1(),
                  Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(100));
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

}
