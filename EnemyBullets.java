import greenfoot.*;

/**
 * Write a description of class EnemyBullets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullets extends SmoothMover
{

    private int Damage=10;
    public EnemyBullets(){
        GreenfootImage img=getImage();
        img.scale(img.getHeight()/4,img.getWidth()/4);
        setImage(img);
    }

    public EnemyBullets( Vector movement, int rotate)
    {
        GreenfootImage img=getImage();
        img.scale(img.getHeight()/6,img.getWidth()/6);
        setImage(img);
        addForce(movement);
        turn(rotate);
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   if(BackDrop.pause==true)
        {
        move(-10);
        if(!ifCollides())
            checkWalls();
        }
    }    

    private void checkWalls()
    {
        if (getY() == 0|| getY() == getWorld().getHeight()-1) {
            getWorld().removeObject(this);
        }
        else if(getX()==0||getX()==getWorld().getWidth()-1)
        {
            getWorld().removeObject(this);
        }
    }

    public boolean ifCollides()
    {
       if(canSee(Ship.class))
        {   Ship s=(Ship)getOneObjectAtOffset(0,0,Ship.class);
            World myWorld=getWorld();
            BackDrop bd=(BackDrop)myWorld;
            Health hb=bd.getHealth();
            hb.sethealth(5);
            hb.update();
            
            if(hb.health<=0){
                getWorld().addObject(new Explosion(),getX(),getY());
                //myWorld.removeObject(this);
                FullScreenExplosion FSE=new FullScreenExplosion(true);
                getWorld().addObject(FSE,getWorld().getWidth()/2,getWorld().getHeight()/2);
                
                //bd.setDead();
            }
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }
}