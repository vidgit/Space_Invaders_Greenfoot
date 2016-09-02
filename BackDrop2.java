import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class BackDrop2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackDrop2 extends World
{
    GreenfootSound bM = new GreenfootSound("13.mp3");
    GreenfootImage img;
    Title t1;
    TextDisplay td2;
    TextDisplay Death;
    TextDisplay Score;
    int time;
    public BackDrop2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        img=new GreenfootImage("Finish.jpg");
        img.scale(600,600);
        setBackground(img);
        t1=new Title("CONGRATULATIONS!",60,Color.white);
        td2=new TextDisplay("YOU WIN!",40);
        Death=new TextDisplay("DEATHS:"+BackDrop.death,40);
        Score=new TextDisplay("SCORE:"+BackDrop.score,40);
        addObject(t1,300,200);
        addObject(td2,300,300);
        addObject(Death,200,400);
        addObject(Score,400,400);
        bM.playLoop();
        time=0;
    }

    public void act()
    {   
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new TitleScreen());
            bM.pause();
        }
    }
}
