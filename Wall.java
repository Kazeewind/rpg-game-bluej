import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{

    public Wall(){
        this.setImage("wall.PNG");
        getImage().setTransparency(0);
        getImage().scale(40, 390);
    }
    
    public Wall(int anch, int alt){
        this.setImage("wall.PNG");
        getImage().setTransparency(0);
        getImage().scale(anch, alt);        
    }
    
    public void act() 
    {
        // Add your action code here.
    }   

}


