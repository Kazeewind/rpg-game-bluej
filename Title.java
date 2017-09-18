import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{
    GreenfootSound bgMusic = new GreenfootSound("bgm/title.mp3");
    
    public Title()
    {    
        super(817, 460, 1);
    }
    
    public void started(){
        playMusic();
        addObject(new Menu(), 115, 49);
        addObject(new PlayButton(), 117, 192);
        addObject(new SalirButton(), 116, 260);
        this.setBackground(new GreenfootImage("title.PNG"));
    }

    public void playMusic(){
        bgMusic.playLoop();
    }
    
    public void stopMusic(){
        bgMusic.stop(); 
    }
    
}
