import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Episodio1_2a here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Episodio1_2a extends World
{
    DialogoTexto text = new DialogoTexto();
    DialogoFondo fondo = new DialogoFondo("dialogo_anemoi.PNG");
    Kaze kaze = new Kaze("right");
    Anemoi anemoi = new Anemoi();
    GreenfootSound bgMusic = new GreenfootSound("bgm/ep1.mp3");
   
    public Episodio1_2a()
    {    
        super(800, 622, 1, false); 
        addObject(kaze, 297, 405);
        addObject(anemoi, 340, 405);
        addObject(fondo, 397, 317);
        addObject(text, 405, 314);
        addObject(new Event(40, 80, 2), 785, 389);
        
        addObject(new WallHorizontal(900, 60), 410, 127);
        addObject(new WallHorizontal(900, 60), 406, 557);
        
        addObject(new WallHorizontal(200, 20), 660, 347);
        addObject(new WallHorizontal(300, 20), 710, 443);
        
        
        addObject(new Wall(), -20, 346);
        addObject(new Wall(), 822, 355);
        addObject(new Wall(60, 100), 781, 290);
        
        text.setImage("ep_1_diag/after/anemoi_1.PNG");
        setBackground(new GreenfootImage("map/map_exterior5.PNG"));
        setTercerMapa();
        bgMusic.playLoop();
    }
    
    public void borrarDialogo(){
        removeObject(text);
        removeObject(fondo);
    }
    
    public void setFondo(String url){
        fondo.setImage(url);
    }
    
    public void setDialogoCompleto(){
        anemoi.setDialogoCompleto();
    }
    
    public void setTercerMapa(){
        kaze.setTercerMapa();
    }
}
