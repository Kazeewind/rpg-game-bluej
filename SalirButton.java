import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SalirButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SalirButton extends Actor
{
    boolean mouseOver = false;
    
    public void act() 
    {
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            Greenfoot.playSound("sfx/click.mp3");
            setImage("salirButtonOn.PNG");  
            mouseOver = true;  
         }  
       
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
        {  
             setImage("salirButtonOff.PNG");  
             mouseOver = false;  
        } 
        
       if (Greenfoot.mouseClicked(this))  
       {  
         Greenfoot.stop();
         ((Title)getWorld()).stopMusic();
         ((Title)getWorld()).removeObjects(((Title)getWorld()).getObjects(null));
       }
    }    
}
