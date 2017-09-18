import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Episodio1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Episodio1_1 extends World
{
    GreenfootSound bgMusic = new GreenfootSound("bgm/room.mp3");
    DialogoTexto text = new DialogoTexto();
    DialogoFondo fondo = new DialogoFondo("dialogo_kaze.PNG");
    Kaze kaze = new Kaze();
    
    public Episodio1_1()
    {    
        super(815, 624, 1); 
        addObject(kaze, 697, 311);
        addObject(new Wall(), 503, 265);
        addObject(new Wall(), 744, 410);
        addObject(new Wall(), 71, 248);
        addObject(new Wall(), 73, 604);
        addObject(new WallHorizontal(), 90, 603);
        addObject(new WallHorizontal(), 289, 103);
        addObject(new WallHorizontal(), 739, 245);
        addObject(new WallHorizontal(), 632, 605);
        addObject(new Event(50, 10, 0), 360, 623);
        addObject(new InstruccionesButton(), 777, 38);
        addObject(fondo, 397, 317);
        addObject(text, 405, 314);
        text.setImage("ep_1_diag/kaz_1.PNG");
        bgMusic.playLoop();
    }
    
    public void borrarDialogo(){
        removeObject(text);
        removeObject(fondo);
    }
    
    public void borrarObjetos(){
       this.removeObject(kaze);
    }
    
    public void stopMusic(){
        bgMusic.stop(); 
    }
    
    public void cambiarMusica(String url){
        
        bgMusic = new GreenfootSound(url);
        
    }
}
