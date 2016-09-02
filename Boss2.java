import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Boss2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss2 extends Actor
{
    int time=0;
    GreenfootImage img;
    boolean move=false;
    boolean fwd=true;
    int y;
    int hit;
    int t=-1;
    boolean show;
    int s=255;
    boolean side;
    public Boss2()
    {
        img=new GreenfootImage("boss11.png");
        time=0;
        setImage(img);
        hit=500;
        show=false;
        side=false;

    }

    public int gethit()
    {
        return hit;
    }

    public void sethit(int d)
    {
        hit-=d;
    }

    /**
     * Act - do whatever the Boss1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   if(BackDrop.pause==true)
        {

            time++;
            if(!show)
            {   if(time%20==0)
                {if(s==1)
                        s=255;
                    else
                        s=1;
                    img=getImage();
                    img.setTransparency(s);
                    setImage(img);
                    if(time==180)
                    {   time=0;
                        img.setTransparency(255);
                        setImage(img);
                        show=true;
                        turn(30);
                    }
                }
            }
            else
            {
                if(!checkHealth()&&t==-1){
                    if(!ifCollides()){

                        if(!move)
                        {
                            turn(2);
                            if(time%20==0)
                            {   getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), 45), this.getX()-160, this.getY()-160);
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), 90), this.getX(), this.getY()-190);
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), 135), this.getX()+160, this.getY()-160);
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), 0), this.getX()-195, this.getY());
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), 180), this.getX()+195, this.getY());
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), 225), this.getX()+160, this.getY()+160);
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), 270), this.getX(), this.getY()+190);
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), -45), this.getX()-160, this.getY()+160);
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), -105), this.getX()+120, this.getY()+195);
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), -75), this.getX()-120, this.getY()+195);
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), -60), this.getX()-160, this.getY()+190);
                                getWorld().addObject(new EnemyBullets(new Vector(0, 10.0), -120), this.getX()+160, this.getY()+190);
                            }
                        }
                        else
                            move();
                        if(time==180)
                        {
                            //getWorld().addObject(new Flag(), 300, 300);
                            time=0;
                            move=true;
                            y=getY();
                        }
                        //img=new GreenfootImage("boss1"+(time/10)+".png");
                        //setImage(img);
                        //if(time==19)
                    }
                }

                else
                if(t==time)
                {   
                    getWorld().removeObjects(getWorld().getObjects(Help.class));
                    BackDrop.score+=1000;
                    World myWorld=getWorld();
                    BackDrop bd=(BackDrop)myWorld;
                    bd.afterburn();
                    //getWorld().removeObject(this);
                }
            }
        }    
    }

    public void move()
    {
        if(getY()>=y+100)
            fwd=false;
        if(!fwd&&getY()==y)
        {   if(side)
            {
                getWorld().addObject(new Help(),getX()+70,getY()+190);
                side=false;
            }
            else{
                getWorld().addObject(new Help(),getX()-70,getY()+190);
                side=true;
            }
            fwd=true;
            move=false;
            time=0;
        }
        if(fwd)
            setLocation(getX(),getY()+4);
        else
            setLocation(getX(),getY()-4);
    }

    public boolean ifCollides()
    {   List l=getObjectsInRange(190,Bullet.class);
        if(l.size()!=0)
        {
            sethit(30);
            getWorld().removeObjects(l);
            return true;
        }
        List j=getObjectsInRange(190,MainWeapon.class);
        if(j.size()!=0)
        {
            sethit(5);
            getWorld().removeObjects(j);
            return true;
        }
        List k=getObjectsInRange(190,Ship.class);
        if(k.size()!=0)
        {
            sethit(5);
            World myWorld=getWorld();
            BackDrop bd=(BackDrop)myWorld;
            Health hb=bd.getHealth();
            hb.sethealth(50);
            hb.update();
            if(hb.health<=0){
                getWorld().addObject(new Explosion(),getX(),getY());
                //myWorld.removeObject(this);
                //if(aft)
                //  getWorld().removeObject(bd.ab);
                FullScreenExplosion FSE=new FullScreenExplosion(true);
                getWorld().addObject(FSE,getWorld().getWidth()/2,getWorld().getHeight()/2);

                //bd.setDead();
            }
            return true;
        }
        return false;
    }

    public boolean checkHealth()
    {
        if(hit<=0)
        {
            for(int i=0;i<10;i++)
            {
                getWorld().addObject(new Explosion(),Greenfoot.getRandomNumber(375)+100,Greenfoot.getRandomNumber(195)+100);
            }
            t=time;
            sethit(-100);

            return true;
        }
        return false;
    }
}
