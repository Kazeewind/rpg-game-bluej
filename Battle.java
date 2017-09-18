import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Battle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Battle extends World
{
    GreenfootSound bgMusic = new GreenfootSound("bgm/battle.mp3");
    public Bar barEnemy = new Bar("Blue Dragon", "HP", 100, 100);
    public Bar barPlayer = new Bar("Kaze", "HP", 100, 100);
    public Bar turno = new Bar("Turno", "Segundos", 10, 10);
    public Enemy enemy = new Enemy();
    public Victory victory = new Victory();
    public GameOver gameOver = new GameOver();
    public AttackButton attack = new AttackButton();
    private int timer;
    private int timerAttack;
    private boolean turnoPlayer;
    private boolean turnoEnemy;
    private boolean victoria;
    private boolean damage;
    private int counter = 1;
    private int tr = 1;
    
    public Battle()
    {    
        super(800, 622, 1);
        addObject(new BattleGui(), 400, 313);
        addObject(barEnemy, 408, 100);
        addObject(barPlayer, 290, 450);
        addObject(enemy, 414, 200);
        addObject(attack, 94, 515);
        addObject(turno, 102, 410);
        setBackground(new GreenfootImage("battle_background.png"));
        turnoPlayer = true;
        turnoEnemy = false;
        victoria = false;
        damage = false;
        bgMusic.playLoop();
    }

    public void act(){
        if(!victoria){
        if(barEnemy.getValue() == barEnemy.getMinimumValue()){
            removeObject(enemy);
            removeObject(barEnemy);
            Greenfoot.delay(100);
            bgMusic.stop();
            bgMusic = new GreenfootSound("bgm/victory.mp3");
            bgMusic.play();
            victoria = true;
            addObject(victory, 401, 311);
        } 
        }
        if(barPlayer.getValue() == barPlayer.getMinimumValue()){
            addObject(gameOver, 401, 311);
            bgMusic.stop();
            Greenfoot.playSound("bgm/gameover.mp3");
            Greenfoot.stop();
        } 
        
        if(!bgMusic.isPlaying()){
                if (victoria){
                  Greenfoot.setWorld(new Episodio1_2a()); 
               }
           }
        
        if(damage){
           if (--counter == 0)
           {
            checkAttack();
            counter = 10;
          }
        } 
        
        runTurn();
        checkTurn();
    
    } 
        
            
    private void runTurn()
    {
       if(!victoria){
       timer = (timer+1)%60;
       if(turnoPlayer){
        if (timer==0)
        {
            turno.subtract(1);
        }
       }
      }
    }
    
    private void checkAttack(){
        if(enemy.getImage().getTransparency() == 250){
           enemy.getImage().setTransparency(0); 
        } else {
           enemy.getImage().setTransparency(250); 
        }
    }
    
    private void checkTurn(){
        if(!victoria){
        if(turnoPlayer){
          if(turno.getValue() == turno.getMaximumValue()){
          for (Object attack : getObjects(AttackButton.class))
            {
              ((AttackButton) attack).setImage("attack_noMouse.PNG"); 
            }
        }
        if(turno.getValue() == turno.getMinimumValue()){
          for (Object attack : getObjects(AttackButton.class))
            {
              Greenfoot.playSound("sfx/attackEnemy.mp3");
              barPlayer.subtract(50);
              ((AttackButton) attack).setImage("attack_disabled.PNG"); 
            }
          Greenfoot.delay(100);
          turno.add(10);
        }
       } else if (!turnoPlayer) {
           Greenfoot.delay(100);
           Greenfoot.playSound("sfx/attackEnemy.mp3");
           barPlayer.subtract(20);
           turno.add(10);
           Greenfoot.delay(50);
           setDamage();
           turnoPlayer();
        }
      }
    }
    
    public void turnoPlayer(){
       if (turnoPlayer){
           turnoPlayer = false;
        } else {
           turnoPlayer = true;
        }
    }
    
    public void setDamage(){
        if(damage){
            damage = false;
        } else {
            damage = true;
        }
    }
    
    public boolean getTurnoPlayer(){
        return turnoPlayer;
    }
}