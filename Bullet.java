import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends SmoothMover
{GreenfootImage image;
    int lazerno=1;
    private int Damage=10;

    public Bullet(){
        turn(-90);
        image=new GreenfootImage("l1.png");
        image.scale(70,15);
        setImage(image);
        Greenfoot.playSound("Laser.wav");
    }

    public int getDamage()
    {
        return Damage;   
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   if(BackDrop.pause==true)
        {
        move(10);
        if(!ifCollides())
            checkWalls();
        }

    }    

    private void checkWalls()
    {
        if (getY() == 0|| getY() == getWorld().getHeight()-1) {
            getWorld().removeObject(this);
        }
    }

    public boolean ifCollides()
    {
        World myWorld=getWorld();
            BackDrop bd=(BackDrop)myWorld;
        if(canSee(Asteroid.class))
        { Asteroid a=(Asteroid)getOneObjectAtOffset(0,0,Asteroid.class);
            a.sethit(Damage);
            if(a.gethit()<=0){
                getWorld().addObject(new Explosion(),getX(),getY());
                eat(Asteroid.class);
                BackDrop.bulletlvl++;
                BackDrop.score+=50;
                
            }
            //getWorld().removeObject(this);
            return true;
        }
        
         if(canSee(Enemyship1.class))
        { Enemyship1 ship=(Enemyship1)getOneObjectAtOffset(0,0,Enemyship1.class);
            ship.sethit(Damage);
            if(ship.gethit()<=0){
                getWorld().addObject(new Explosion(),getX(),getY());
                eat(Enemyship1.class);
                bd.w2.count--; 
                BackDrop.score+=20;        
                    }
            
            //getWorld().removeObject(this);
            return true;
        }
          if(canSee(EShip2.class))
        { EShip2 ship=(EShip2)getOneObjectAtOffset(0,0,EShip2.class);
            ship.sethit(Damage);
            if(ship.gethit()<=0){
                getWorld().addObject(new Explosion(),getX(),getY());
                eat(EShip2.class);
                bd.w3.count--;
                BackDrop.score+=30;
            }
            
            //getWorld().removeObject(this);
            return true;
        }
        
        if(canSee(Enemyship.class))
        { Enemyship ship=(Enemyship)getOneObjectAtOffset(0,0,Enemyship.class);
            ship.sethit(Damage);
            if(ship.gethit()<=0){
                getWorld().addObject(new Explosion(),getX(),getY());
                eat(Enemyship.class);
                bd.w1.count--;
                BackDrop.score+=10;        
            }

            //getWorld().removeObject(this);
            return true;
        }
        if(canSee(Help.class))
        { Help ship=(Help)getOneObjectAtOffset(0,0,Help.class);
            ship.sethit(Damage);
            if(ship.gethit()<=0){
                getWorld().addObject(new Explosion(),getX(),getY());
                eat(Help.class);
                //bd.w2.count--; 
                        BackDrop.score+=50;
                    }
            
            //getWorld().removeObject(this);
            return true;
        }
        return false;
    }

}
