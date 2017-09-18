import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Episodio1_2b here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Episodio1_2b extends World
{
    Kaze kaze = new Kaze("right");
    GreenfootSound bgMusic;
    Anemoi anemoi = new Anemoi(true);
    DialogoTexto text = new DialogoTexto();
    DialogoFondo fondo = new DialogoFondo();
    
    public Episodio1_2b()
    {    
        super(800, 622, 1, false);
        bgMusic = new GreenfootSound("bgm/run.mp3");
        setBackground(new GreenfootImage("map/map_exterior5.PNG"));
        addObject(anemoi, 380, 405);
        addObject(kaze, -20, 405);
        addObject(fondo, 397, 317);
        addObject(text, 405, 314);
        kaze.setBatallaDialogo();
        bgMusic.playLoop();
    }
}
