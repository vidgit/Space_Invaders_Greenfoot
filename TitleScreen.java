import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    GreenfootSound bM = new GreenfootSound("menu.mp3");
    World toWorld=null;
    GreenfootImage img1;
    Title title1;
    Title title2;
    start_button stb;
    invader1 i1;
    invader2 i2;
    invader3 i3;
    TextDisplay td1;
    TextDisplay td2;
    TextDisplay md1;
    TextDisplay md2;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        super(600, 600, 1); 
        bM.playLoop();
        img1=new GreenfootImage("Back.jpg");
        img1.scale(600,600);
        setBackground(img1);
        stb=new start_button("PRESS ENTER TO START");
        title1=new Title("SPACE",120,Color.WHITE);
        addObject(title1,300,100);
        title2=new Title("INVADERS",80,new Color(0,204,255,255));
        addObject(title2,300,180);
        addObject(stb,300, 500);
        i1=new invader1();
        addObject(i1,300,350);
        i2=new invader2();
        addObject(i2,400,350);
        i3=new invader3();
        addObject(i3,200,350);
        td1=new TextDisplay("Game Design:",20);
        addObject(td1,500,550);
        td2=new TextDisplay("Vibhor Joshi Prem Sharma",20);
        addObject(td2,500,570);
        md1=new TextDisplay("Original Design:",20);
        addObject(md1, 90,550);
        md2=new TextDisplay("TEITO",20);
        addObject(md2, 90,570);
        
    }

    public void act()
    {   
        if (Greenfoot.isKeyDown("enter"))
        {   removeObject(stb);
            bM.pause();
            Greenfoot.setWorld(new BackDrop(true));
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
   
}
