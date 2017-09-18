import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AttackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AttackButton extends Actor
{
    boolean mouseOver = false;
    
    public void act() 
    {
       if(((Battle)getWorld()).getTurnoPlayer()){
       if (!mouseOver && Greenfoot.mouseMoved(this))  
        {  
            setImage("attack_yesMouse.PNG");  
            mouseOver = true;  
         }  
       if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this))  
        {  
             setImage("attack_noMouse.PNG");  
             mouseOver = false;  
        }
       if (Greenfoot.mouseClicked(this))  
        {  
             ((Battle)getWorld()).setDamage();
            ((Battle)getWorld()).barEnemy.subtract(30);
             if(Greenfoot.getRandomNumber(11) > 5){
             Greenfoot.playSound("sfx/attackPlayer1.mp3");
            } else {
             Greenfoot.playSound("sfx/attackPlayer2.mp3");
            }
             
             setImage("attack_disabled.PNG");
             ((Battle)getWorld()).turnoPlayer();
        }
    }
    }
}
