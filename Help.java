import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends Actor
{   int i=1;
    int time=0;
    private int hit;
     public int gethit()
    {
        return hit;
    }

    public void sethit(int d)
    {
        hit-=d;
    }
    public Help()
    {   hit=20;
        setImage(new GreenfootImage("k1.png"));
        turn(90);
    }
    /**
     * Act - do whatever the Help wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      if(BackDrop.pause==true)
        {
            time++;
            if(time%10==0)
            {
            if(i==3)
            i=0;
            i++;
            setImage(new GreenfootImage("k"+i+".png"));
        }
            if(getY()<200){
                move(2);
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
                            move (-4);
                            turn (-90);
                        }
                        else if(p.getX()<this.getX()) 
                        {
                            turn (-90);
                            move (-4);
                            turn (90);

                        }
                        else
                            move(4);
                    }

                    else
                        move(4);
                    ifBottom();

                } 
            }
        }
    }    
       private void ifBottom()
    {
        if (getY() == 0|| getY() == getWorld().getHeight()-1) {
           getWorld().removeObject(this);
        }
    }
}
