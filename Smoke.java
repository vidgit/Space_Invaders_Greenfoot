import greenfoot.*;
import java.awt.*;
/**
 * Write a description of class Smoke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smoke extends Actor
{
    private GreenfootImage image;
    private int fade;
    public Smoke(){
        image=getImage();
        fade=Greenfoot.getRandomNumber(4)+1;
    }
    public Smoke(int h,int w){
        image=new GreenfootImage(h,w);
        image.setColor(Color.WHITE);
        image.fillOval(0,0,h,w);
        setImage(image);
        fade=Greenfoot.getRandomNumber(4)+1;
    }

    public void act() 
    {
        shrink();
    }    

    private void shrink()
    {
        if(getImage().getWidth() < 10) {
            getWorld().removeObject(this);
        }
        else {
            GreenfootImage img = new GreenfootImage(image);
            img.scale( getImage().getWidth()-fade, getImage().getHeight()-fade );
            img.setTransparency( getImage().getTransparency() - (fade*5) );
            setImage (img);
        }
    }
}
