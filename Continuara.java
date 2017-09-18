import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Continuara here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Continuara extends World
{

    GreenfootSound bgMusic = new GreenfootSound("bgm/ending.mp3");
    
    public Continuara()
    {    
        super(800, 622, 1); 
        setBackground(new GreenfootImage("continuara.PNG"));
        bgMusic.playLoop();
    }
}
