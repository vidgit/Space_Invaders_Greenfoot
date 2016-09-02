import greenfoot.*;
import java.awt.*;
import java.util.List;

/**
 * Write a description of class BackDrop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackDrop extends World
{   
    GreenfootSound bM = new GreenfootSound("02.mp3");
    Health hb;
    Ship ship;
    CoolDown cd;
    static int bulletlvl;
    //new
    static int lvl;
    boolean start=true;
    static boolean pause=true;
    Wave1 w1;
    Wave2 w2;
    Wave3 w3;
    Wave4 w4;
    AfterBurner ab;
    int dy=1;
    TextDisplay td;
    Boss1 b1;
    Boss2 b2;
    static String imgno; 
    static int score;
    TextDisplay Score;
    static int nuke;
    TextDisplay Nuke;
    static int death;
    TextDisplay Death;
    static int shield;
    /**
     * Constructor for objects of class BackDrop.
     * 
     */

    public BackDrop()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        /**GreenfootImage background=getBackground();
         *background.setColor(new Color(1,1,10,100));
         *background.fill();
         */

        Greenfoot.setWorld(new TitleScreen());
    }

    public BackDrop(boolean st)
    {  
        super(600, 600, 1);
        //lim=new LimitDetector();
        //addObject(lim,getWidth()/2 ,  getHeight()/2);
        ship=new Ship();
        addObject( ship,getWidth()/2 ,  getHeight()-120 );
        cd=new CoolDown();
        hb=new Health();
        addObject(hb.bOut,60,30);
        addObject(hb.bIn,60,30);
        addObject(cd.bOut,60,48);
        addObject(cd.bIn,60,48);
        bulletlvl=0;
        lvl=1;
        addObject(new Pause(),300,300);
        //addObject(new Wave1(),300,300);
        //addWave3();
        addWave1(18,6,true);
        bM.playLoop();
        score=0;
        Score =new TextDisplay("Score:"+score,40);
        addObject(Score,200,30);
        nuke=1;
        Nuke=new TextDisplay("Nuke:"+nuke,40);
        addObject(Nuke,530,30);
        death=0;
        Death=new TextDisplay("Death:"+death,40);
        addObject(Death,400,30);
        imgno="Back.jpg";
        shield=6;
    }

    public void act()
    {
        if (Greenfoot.getRandomNumber(100000) < 10)
        {
            generateAst();
        }
        updateScore();
        if(bulletlvl>2)
        {
            bulletlvl--;
            nuke++;

        }
        removeObject(Death);
        Death=new TextDisplay("Death:"+death,40);
        addObject(Death,400,30);
        removeObject(Nuke);
        Nuke=new TextDisplay("Nuke:"+nuke,40);
        addObject(Nuke,530,30);
    }

    public void updateScore()
    {
        removeObject(Score);
        Score =new TextDisplay("Score:"+score,40);
        addObject(Score,200,30);
    }

    public void addWave1(int c,int nex,boolean next)
    {
        int X=100;
        int Y=100;
        w1=new Wave1(c,nex,next);
        for(int i=0;i<w1.count;i++)
        {   w1.enemyship[i]=new Enemyship();
            addObject(w1.enemyship[i],X, Y);
            X+=60;
            if(i==5||i==11||i==17)
            {Y+=50;
                X=100;
            }
        }
        addObject(w1,300,300);

    }

    public void addWave2(int c,boolean nex)
    {
        int X=100;
        w2=new Wave2(c,nex);
        for(int i=0;i<w2.count;i++)
        {
            w2.enemyship[i]=new Enemyship1();
            addObject(w2.enemyship[i],X,100);
            X+=80;
            if(X>600)
                X=100;
        }
        addObject(w2,300,400);

    }

    public void addWave3()
    {
        w3=new Wave3();
        addWave1(12,0,false);
        addWave2(6,false);
        w3.w1=w1;
        w3.w2=w2;
        addObject(w3.e,Greenfoot.getRandomNumber(600),100);
        addObject(w3,300,200);
    }

    public void addBoss1()
    {   
        //Greenfoot.playSound("bossarrival.wav");
        b1=new Boss1();
        addObject(b1,300,100);
    }

    public void addBoss2()
    {   
        //Greenfoot.playSound("bossarrival.wav");
        b2=new Boss2();
        addObject(b2,300,100);
    }

    public void addWave4(int c,boolean nex)
    {
        w4=new Wave4(c,nex);
        addObject(w4,300,300);
    }

    public void generateAst()
    {
        int Y=100;

        Asteroid asteroid1 = new Asteroid();
        addObject(asteroid1, Greenfoot.getRandomNumber(600) , Y+Greenfoot.getRandomNumber(100) );

    }

    public Health getHealth(){
        return hb;
    }

    /** public void setHealth(){
    hb.sethealth();
    }
     */
    public CoolDown getCooldown(){
        return cd;
    }

    public void changeBackDrop(String name)
    {   GreenfootImage img=new GreenfootImage(name);
        img.scale(600,600);
        setBackground(img);
    }

    public void check()
    {
        /** if(counte4==0&&counte1<=0&&counte2==0)
        {GreenfootImage img=new GreenfootImage("VICTORY.jpg");
        img.scale(600,600);
        setBackground(img);
        List objects = getObjects(null);
        removeObjects(objects);
        Greenfoot.stop();
        }
         */
    }

    public void setDead(){
        List objects = getObjects(FullScreenExplosion.class);
        removeObjects(objects);
        List objects1 = getObjects(Ship.class);
        removeObjects(objects1);
        List objects2 = getObjects(Health.class);
        removeObjects(objects2);
        bM.pause();
        Greenfoot.setWorld(new GameOver(this));
    }

    public void addShield()
    {   Shield n=new Shield();
        addObject(n,300,ship.getY()-60);
        addObject(n.out,300,ship.getY()-60);
        addObject(n.in,300,ship.getY()-60);
    }

    public void reset()
    {
        ship=new Ship();
        addObject( ship,getWidth()/2 ,  getHeight()-120 );
        hb=new Health();
        addObject(hb.bOut,60,30);
        addObject(hb.bIn,60,30);
        shield=6;
        bM.playLoop();
    }

    public void changeMusic(String name)
    {
        bM=new GreenfootSound(name);
    }

    public void afterburn()
    {   ab=new AfterBurner(ship);
        addObject(ab,ship.getX(),ship.getY()+80);
        List l=getObjects(Enemyship1.class);
        List k=getObjects(EShip2.class);
        List j=getObjects(Enemyship.class);
        List z=getObjects(EnemyBullets.class);
        List a=getObjects(Boss1.class);
        List b=getObjects(Boss2.class);
        List s=getObjects(Help.class);
        removeObject(w4);
        removeObjects(s);
        removeObjects(a);
        removeObjects(b);
        removeObjects(l);
        removeObjects(k);
        removeObjects(j);
        removeObjects(z);
    }

    public void jumpScene()
    {   

        if(ship.getY()>10)
        {   ab.k+=0.05;
            ab.s-=3;
            dy++;
            ship.setLocation(ship.getX(),ship.getY()-dy);
        }
        else
        {
            ship.setaft(false);
            removeObject(ab);
            removeObject(ship);
            Greenfoot.playSound("Clear.mp3");
            td=new TextDisplay("LEVEL "+lvl+" COMPLETED",40);
            addObject(td,300,200);
            //new
            lvl++;
            Greenfoot.delay(280);
            checkLevel();
        }
    }

    public void checkLevel()
    {
        if(BackDrop.lvl==2)
        {   removeObject(td);
            changeBackDrop("02.jpg"); 
            imgno="02.jpg";
            changeMusic("03.mp3");
            reset();
            addWave1(18,8,true);
        }
        else if(BackDrop.lvl==3)
        {
            removeObject(td);
            changeBackDrop("03.jpg"); 
            changeMusic("04.mp3");
            imgno="03.jpg";
            reset();
            addWave1(18,8,true);
        }
        else if(BackDrop.lvl==4)
        {
            removeObject(td);
            changeBackDrop("Bossback.jpg");
            changeMusic("05.mp3");
            imgno="Bossback.jpg";
            reset();
            addBoss1();

        }
        else if(BackDrop.lvl==5)
        {
            removeObject(td);
            changeBackDrop("04.jpg");
            changeMusic("06.mp3");
            imgno="04.jpg";
            reset();
            addWave2(12,true);
            addWave4(8,false);
        }
        else if(BackDrop.lvl==6)
        {
            removeObject(td);
            changeBackDrop("Bossback.jpg");
            changeMusic("bosslevel.mp3");
            imgno="Bossback.jpg";
            reset();
            addBoss2();
        }
        else if(BackDrop.lvl==7)
        {
            Greenfoot.setWorld(new BackDrop2());

        }

    }

}

