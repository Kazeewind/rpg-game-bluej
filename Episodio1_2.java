import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Episodio_1_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Episodio1_2 extends World
{
    private Scroller scroller;
    GreenfootSound bgMusic;
    Actor scrollActor;
    int bLineX;
    int aLineX;
    public int sX, sY;
    
    public Episodio1_2()
    {    
        super(800, 622, 1, false); 
        bLineX = 467;
        aLineX = 467;
        scrollActor = new Kaze("right");
        bgMusic = new GreenfootSound("bgm/run.mp3");
        addObject(new WallHorizontal(100, 60), 41, 416);
        addObject(new WallHorizontal(100, 60), 42, 302);
        addObject(new WallHorizontal(200, 60), 132, 464);
        addObject(new WallHorizontal(2000, 40), 1000, 136);
        addObject(new WallHorizontal(670, 53), 478, 556);
        addObject(new WallHorizontal(1000, 60), 1415, 560);
        addObject(new WallHorizontal(2000, 60), 3200, 555);
        addObject(new WallHorizontal(2000, 40), 3200, 136);
        addObject(new WallHorizontal(320, 53), 2185, 275);
        addObject(new WallHorizontal(280, 100), 2210, 435);
        addObject(new WallHorizontal(280, 100), 2015, 530);
        
        addObject(new WallHorizontal(280, 100), 900, 670);
        
        addObject(new Wall(), 72, 82);
        addObject(new Wall(), 119, 38);
        addObject(new Wall(), -30, 311);
        addObject(new Wall(130, 400), 456, 200);
        addObject(new Wall(140, 400), 1940, 200);
        addObject(new Wall(185, 400), 2690, 200);
        addObject(new Wall(50,100), 210, 539);       
        addObject(scrollActor, 18, 358);
        addObject(new Event(50, 80, 1), 2750, 480);
        scroller = new Scroller(this, new GreenfootImage("map/map_exterior.PNG"), 4311, 622);
        bgMusic.playLoop();
    }
    
    public void act(){
        scroll();
        sX = scroller.getScrolledX();
        sY = scroller.getScrolledY();
    }
    
    public void scroll()
    {
        if (scrollActor == null || scrollActor.getWorld() != this) return;
        int dsx = 0;
        int dsy = 0;
        if (scrollActor.getX() < bLineX) dsx = scrollActor.getX()-bLineX;
        if (scrollActor.getX() > aLineX) dsx = scrollActor.getX()-aLineX;
        scroller.scroll(dsx, dsy);
    }
}
