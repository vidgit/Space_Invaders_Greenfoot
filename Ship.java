import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends SmoothMover
{   private int dx;
    private int dy;
    CoolDown cd;
    GreenfootImage image;
    int flag;
    int shoot=0;
    private int hit=100;
    //private List<EnemyShip> group = getObjectsInRange(600,EnemyShip.class);
    public double mass = 0.0;
    private boolean aft=false;
    boolean jmp=false;

    public boolean getaft()
    {
        return aft;
    }

    public void setaft(boolean a)
    {
        aft=a;
    }

    public Ship()
    {   dx=4;
        dy=4;
        image=getImage();
        GreenfootImage img = new GreenfootImage(image);
        setImage (img);
        flag=1;

    }

    public Ship(double mass, Vector movement)
    {
        addForce(movement);

        this.mass = mass;

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
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   if(BackDrop.pause==true)
        {
            World myWorld=getWorld();
            BackDrop bd=(BackDrop)myWorld;

            if(aft==false)
                move();
            else if(jmp==false)
                move2();
            if(!aft)
            { attack();
                if(!ifCollides(Help.class,30))
                    if(!ifCollides(Asteroid.class,30))
                        if(!ifCollides(Enemyship1.class,20))
                            if(!ifCollides(EnemyBullets.class,20))
                                if(!ifCollides(EShip2.class,20));
                                else
                                {   
                                    //getWorld().addObject(new EShip2(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(100));
                                    bd.w3.count--;

                                }
                                else
                                ;
                                else
                                { bd.w2.count--; 
                                }
                                else
                                {  ;
                }

                if(ifCollides(Enemyship.class,10))
                {

                    bd.w1.count--;
                }

            }
            bd.check();
        }

    }  

    public void attack()
    {
        shoot++;
        World myWorld=getWorld();
        BackDrop bd=(BackDrop)myWorld;
        CoolDown cd=bd.getCooldown();
        if(shoot%3==0)
            cd.update();
        if(shoot%20==0){
            if(cd.getcooldown()>=100)
                if(Greenfoot.isKeyDown("z"))
                {
                    getWorld().addObject(new Bullet(),getX(),getY()-50);
                    getWorld().addObject(new Surround(),getX(),getY()+10);
                    setLocation(getX(),getY()+20);
                    cd.setcooldown();

            }
            if(Greenfoot.isKeyDown("x"))
            {
                if(BackDrop.bulletlvl==0)
                {
                    getWorld().addObject(new MainWeapon( new Vector(this.getRotation(), 10.0), this.getRotation()), this.getX() , this.getY() + 40);
                }
                else if(BackDrop.bulletlvl==1)
                {
                    getWorld().addObject(new MainWeapon( new Vector(this.getRotation(), 10.0), this.getRotation()), this.getX() , this.getY() + 40);
                    getWorld().addObject(new MainWeapon( new Vector(this.getRotation()+15, 10.0), this.getRotation()+15), this.getX() , this.getY() + 30);
                    getWorld().addObject(new MainWeapon( new Vector(this.getRotation()-15, 10.0), this.getRotation()-15), this.getX() , this.getY() + 30);
                }else if(BackDrop.bulletlvl>=2)
                {
                    getWorld().addObject(new MainWeapon( new Vector(this.getRotation(), 10.0), this.getRotation()), this.getX() , this.getY() + 40);
                    getWorld().addObject(new MainWeapon( new Vector(this.getRotation()+15, 10.0), this.getRotation()+15), this.getX() , this.getY() + 30);
                    getWorld().addObject(new MainWeapon( new Vector(this.getRotation()-15, 10.0), this.getRotation()-15), this.getX() , this.getY() + 30);
                    getWorld().addObject(new MainWeapon( new Vector(this.getRotation()+30, 10.0), this.getRotation()+30), this.getX() , this.getY() + 30);
                    getWorld().addObject(new MainWeapon( new Vector(this.getRotation()-30, 10.0), this.getRotation()-30), this.getX() , this.getY() + 30);
                }

            }
            if(Greenfoot.isKeyDown("c"))
            {   if(BackDrop.nuke>0)
                {
                    getWorld().addObject(new FullScreenExplosion(false),getWorld().getWidth()/2,getWorld().getHeight()/2);
                    BackDrop.nuke--;
                }
            }
            if(Greenfoot.isKeyDown("v"))
            {
                if(BackDrop.shield>0)
                {
                    bd.addShield();
                    BackDrop.shield--;
                }
            }
            
        }
    }

    public boolean ifCollides(Class clss,int d){
        if(canSee(clss))
        { getWorld().addObject(new Explosion(),getX(),getY());
            eat(clss);

            World myWorld=getWorld();
            BackDrop bd=(BackDrop)myWorld;
            Health hb=bd.getHealth();
            hb.sethealth(d);
            hb.update();
            if(hb.health<=0){
                getWorld().addObject(new Explosion(),getX(),getY());
                //myWorld.removeObject(this);
                if(aft)
                    getWorld().removeObject(bd.ab);
                FullScreenExplosion FSE=new FullScreenExplosion(true);
                getWorld().addObject(FSE,getWorld().getWidth()/2,getWorld().getHeight()/2);

                //bd.setDead();
            }
            return true;
        }

        return false;
    }

    public void move(){
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+dx,getY());
            setImage ("1++.gif");
            if(aft==false)
                addSmoke2();
        }
        else if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-dx,getY());
            setImage ("1--.gif");
            if(aft==false)
                addSmoke2();
        }
        else if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-dy);
            if(aft==false)
                addSmoke();
        }
        else if(Greenfoot.isKeyDown("down")){
            if(getY()<500)
            {
                setLocation(getX(),getY()+dy);
            }
        }
        else{
            setLocation(getX(),getY());
            if(aft==false)
                addSmoke2();
            setImage("1.gif");
        }
        //checkWalls();
    }

    public void move2()
    {   if(getY()>=500&&getX()>295&&getX()<305)
        {

            jmp=true;
            //getWorld().addObject(new Flag(),300, 300);

        }
        else{
            if(getY()<=500)
            {
                setLocation(getX(),getY()+2);
            }
            if(getX()!=300)
            {
                if(getX()>300)
                {
                    setLocation(getX()-2,getY());
                }
                else if(0<getX()-300&&getX()-300<4)
                {
                    setLocation(getX()+Math.abs(getX()-300),getY());
                }
                else if(-4<getX()-300&&getX()-300<0)
                {
                    setLocation(getX()-Math.abs(getX()-300),getY());
                }
                else
                {
                    setLocation(getX()+2,getY());
                }
            }
        }
    }

    private void checkWalls()
    {
        if (getX() == 0 || getX() == getWorld().getWidth()-1) {
            dx = -dx;
        }
        if (getY() == 0 || getY() == getWorld().getHeight()-1) {
            dy= -dy;
        }
    }

    public void addSmoke(){
        getWorld().addObject (new Smoke(getImage().getHeight()/4,getImage().getWidth()/4), getX(), getY()+getImage().getHeight()/4);

    }

    public void addSmoke2(){
        getWorld().addObject (new Smoke2(getImage().getHeight()/8,getImage().getWidth()/8), getX()+getImage().getWidth()/8, getY()+getImage().getHeight()/4);
        getWorld().addObject (new Smoke2(getImage().getHeight()/8,getImage().getWidth()/8), getX()-getImage().getWidth()/8, getY()+getImage().getHeight()/4);
    }

}
