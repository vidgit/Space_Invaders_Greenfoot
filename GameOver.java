import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{   GreenfootSound bM = new GreenfootSound("continue.mp3");
    Title gm;
    World toWorld;
    start_button cont;
    GreenfootImage img;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(World w)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        img=new GreenfootImage(BackDrop.imgno);
        img.scale(600,600);
        setBackground(img);
        gm=new Title("GAME OVER",120,Color.white);
        addObject(gm,300,180);
        toWorld=w;
        cont=new start_button("CONTINUE ?");
        addObject(cont, 300,300);
        bM.playLoop();
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            bM.pause();
         Greenfoot.setWorld(toWorld);
         BackDrop bd=(BackDrop)toWorld;
         bd.reset();
        }
    }
}
