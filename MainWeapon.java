import greenfoot.*;

/**
 * Write a description of class MainWeapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainWeapon extends SmoothMover
{

    private int Damage=5;
    public MainWeapon(){
        turn(-90);
        GreenfootImage img=getImage();
        img.scale(img.getHeight()/2,img.getWidth()/2);
        setImage(img);
        Greenfoot.playSound("MainWeapon.wav");
    }

    public MainWeapon( Vector movement, int rotate) //mass is not actually used
    {
        turn(-90);
        GreenfootImage img=getImage();
        img.scale(img.getHeight()/2,img.getWidth()/2);
        setImage(img);
        addForce(movement);
        turn(rotate);
        Greenfoot.playSound("Gun.wav");
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   if(BackDrop.pause==true)
        {
            move(20);
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
            getWorld().removeObject(this);
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

            getWorld().removeObject(this);
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

            getWorld().removeObject(this);
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

            getWorld().removeObject(this);
            return true;
        }
        if(canSee(Help.class))
        { Help ship=(Help)getOneObjectAtOffset(0,0,Help.class);
            ship.sethit(Damage);
            if(ship.gethit()<=0){
                getWorld().addObject(new Explosion(),getX(),getY());
                eat(Help.class);
                BackDrop.score+=40;
                
            }

            getWorld().removeObject(this);
            return true;
        }
        if(canSee(EnemyBullets.class))
        { 
            getWorld().removeObject(this);
            return true;
        }
        return false;
    }
}