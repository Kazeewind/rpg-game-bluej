import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wallHorizontal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WallHorizontal extends Actor
{
    public WallHorizontal(){
        this.setImage("wallHorizontal.PNG");
        getImage().setTransparency(0);
    } 
    
    public WallHorizontal(int anch, int alt){
        this.setImage("wallHorizontal.PNG");
        getImage().setTransparency(0);
        getImage().scale(anch, alt);        
    }
    
    public void act() 
    {
        // Add your action code here.
    }   
    
}
