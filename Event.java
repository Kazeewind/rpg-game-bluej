import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Event extends Actor
{
    int evento;
    
    public Event(int anch, int alt, int event){
        getImage().setTransparency(0);
        getImage().scale(anch, alt);
        evento = event;
    }    
    
    public void act() 
    {
       if(getOneIntersectingObject(Kaze.class) != null ){
           cualEvento();
       }
    }
    
    public void cualEvento(){
       if(evento == 0) {
         Greenfoot.setWorld(new Episodio1_2());
         
         ((Episodio1_1) getWorld()).stopMusic();
       } 
       else if (evento == 1){
          Greenfoot.setWorld(new Episodio1_2b());
          ((Episodio1_2) getWorld()).bgMusic.stop();
       }
       else if (evento == 2){
          Greenfoot.setWorld(new Continuara()); 
          ((Episodio1_2a) getWorld()).bgMusic.stop();
       }  
    }
}
