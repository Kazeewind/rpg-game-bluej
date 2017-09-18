import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Actor
{
    boolean mouseOver = false;
    public void act() 
    {
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            Greenfoot.playSound("sfx/click.mp3");
            setImage("playButtonOn.PNG");  
            mouseOver = true;  
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
        {  
             setImage("playButtonOff.PNG");  
             mouseOver = false;  
        }
       if (Greenfoot.mouseClicked(this))  
        {  
         
         Greenfoot.setWorld(new Episodio1_1());
         ((Title)getWorld()).stopMusic();
        }
    }
}
