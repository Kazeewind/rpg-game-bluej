import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstruccionesButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstruccionesButton extends Actor
{  
    public void act() 
    {
       if (Greenfoot.mouseClicked(this))  
        {  
          ((Episodio1_1)getWorld()).addObject(new InstruccionesWindow(), 415, 309);
        }        
    }    
}
