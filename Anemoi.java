import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Anemoi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Anemoi extends Actor
{
    private int frame;
    private String posicion;
    private int timer;
    private boolean dialogoCompleto;
    
    public Anemoi(){
      setImage("pj2/anemoi_standL.PNG");
      dialogoCompleto = false;
    }
    
    public Anemoi(boolean rest){
        if(rest){
          setImage("pj2/anemoi_floor.PNG");  
        }
    }
    
    
    public void act() 
    {
       if(dialogoCompleto){
           caminar();
           if(getX() > 820){
               ((Episodio1_2a)getWorld()).setTercerMapa();
               getWorld().removeObject(this);
            }
        }
    } 
    
    public void caminar(){
     timer = (timer+1%1);   
     if (timer==0)
      {
         moveRight();
      }
      animateWalkingRight();
    }

    private void moveRight()
    {
        setLocation(getX() + 1, getY()); 
    }
    
    public void posicionImagen(){
       if(posicion == "left"){
         setImage("pj1/stand_izq.PNG");
       } else if(posicion == "right"){
         setImage("pj1/stand_der.PNG");
       }
    }
    
    public void animateWalkingRight()
    {
        int delay = 8;
        if(frame < 1 * delay) {setImage("pj2/anemoi_walkR1.PNG");}
        else if(frame < 2 * delay) {setImage("pj2/anemoi_walkR1.PNG");}
        else if(frame < 3 * delay) {setImage("pj2/anemoi_walkR1.PNG");}
        else if(frame < 4 * delay) {setImage("pj2/anemoi_walkR2.PNG");}
        else if(frame < 5 * delay) {setImage("pj2/anemoi_walkR2.PNG");}
        else if(frame < 6 * delay) {setImage("pj2/anemoi_walkR2.PNG");
        frame = 1;
        return;       
        }
        frame++;
        posicion = "right";
    } 
    
    public void setDialogoCompleto(){
        dialogoCompleto = true;
    }
}
