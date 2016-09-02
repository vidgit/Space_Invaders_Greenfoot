import greenfoot.*;

/**
 * Write a description of class AfterBurner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AfterBurner extends Actor
{   
    GreenfootSound bM = new GreenfootSound("Effect 1.wav");
    GreenfootSound bM2 = new GreenfootSound("jump.wav");
    GreenfootImage img;
    int im=0;
    double k;
    Ship sh;
    int s=0;
    boolean ini=false;
    boolean ini2=true;
    public AfterBurner(Ship ship)
    {   sh=ship;
        k=2;
        img=new GreenfootImage("af0.png");
        img.rotate(-90);
        img.scale((int)(img.getWidth()/k),(int)(img.getHeight()/k));
        setImage(img);
        sh.setaft(true);
        bM.play();
    }

    /**
     * Act - do whatever the AfterBurner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        World myWorld=getWorld();
        BackDrop bd=(BackDrop)myWorld;
        bd.bM.pause();
        if(sh.jmp&&k>0.9)
        {
            k-=0.05;
            s+=2;
        }
        if(k<=0.9)
            ini=true;
        im++;
        if(im==19)
            im=0;
        img=new GreenfootImage("af"+(im/5)+".png");
        img.scale((int)(img.getWidth()/k),(int)(img.getHeight()/k));
        img.rotate(-90);
        setImage(img);
        setLocation(sh.getX()+3,sh.getY()+50+s);
        if(ini)
        {
            bM.pause();
            if(ini2)
            {
                ini2=false;
                bM2.setVolume(80);
                bM2.play();
            }
            bd.jumpScene();
        }
    }    
}
