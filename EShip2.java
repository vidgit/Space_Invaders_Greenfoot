import greenfoot.*;
import java.util.List;

/**
 * Write a description of class EShip2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EShip2 extends SmoothMover
{   private int time=0;
    public static int counter = 0; //counter for the number of ships on screen
    public static boolean notEnoughShips = false; //used to denote whether the number of ships on screen should be incremented
    private Vector move = new Vector();
    public static final int WALKING_SPEED = -8;   //speed used for all members of the ship class
    public static boolean upScore = false;  //used to denote whether score should be incremented
    private int hit=20;
    public int gethit()
    {
        return hit;
    }

    public void sethit(int d)
    {
        hit-=d;
    }

    public EShip2(){
        turn(90);
        GreenfootImage img=getImage();
        img.scale(img.getHeight(),img.getWidth());
        setImage(img);
    }

    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   if(BackDrop.pause==true)
        {
            time++;
            if(getY()<200){
                move(3);
            }
            else{
                List l=getObjectsInRange(800,Ship.class);

                {
                    Ship p=(Ship)l.get(0);
                    if(time%2==0)
                    {
                        if(p.getX()>this.getX()) 
                        {
                            turn (90);
                            move (-5);
                            turn (-90);
                        }
                        else if(p.getX()<this.getX()) 
                        {
                            turn (-90);
                            move (-5);
                            turn (90);

                        }
                        else
                            move(8);
                    }

                    else
                        move(5);
                    ifBottom();

                } 
            }
        }
    }

    public EShip2(double mass, Vector movement)
    {
        move = movement;
        addForce(move);           
        GreenfootImage img=getImage();
        img.scale(img.getHeight()/2,img.getWidth()/2);
        setImage(img);
    }   

    private void ifBottom()
    {
        if (getY() == 0|| getY() == getWorld().getHeight()-1) {
            getWorld().addObject(new EShip2(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(100));
            getWorld().removeObject(this);
        }
    }

}
