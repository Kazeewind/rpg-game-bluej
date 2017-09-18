import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kaze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kaze extends Actor
{
    private int frame;
    private boolean introCompleta;
    private String posicion;
    private int seccion;
    private boolean spaceDown;
    private boolean segundoMapa;
    private boolean tercerMapa;
    private boolean isKeyPressed; 
    private boolean dialogoCompleto;
    private boolean dialogoBatalla;
    private boolean dialogoBatallaCompleto;
    private int timer;
    private int speed;
    Episodio1_1 ep1 = (Episodio1_1) getWorld();
    
    public Kaze(){
        setImage("pj1/stand_abj.PNG");
        seccion = 0;
        frame = 0;
        speed = 0;
        introCompleta = false;
        segundoMapa = false;
        tercerMapa = false;
        dialogoBatalla = false;
        dialogoBatallaCompleto = true;
     }
    
    public Kaze(String posicion){
      setImagen(posicion); 
      seccion = 0;
      frame = 0;
      speed = 0;
      introCompleta = true;
      segundoMapa = true;
      tercerMapa = false;
      dialogoBatalla = false;
      dialogoBatallaCompleto = true;
    }
     
    public void act() 
    {
       isKeyPressed = false;
       String keyPressed = Greenfoot.getKey(); 
     
       if (!introCompleta){
        if ("enter".equals(keyPressed))
        {
         introDialogo();
        }
       }
    
       if(tercerMapa){
        if (!dialogoCompleto){
         if ("enter".equals(keyPressed))
         {
          dialogo();
         }
        }         
       }
       
       if(Greenfoot.isKeyDown("shift")){
        speed = 4;
        } else {
        speed = 2;
        }
    
       if(dialogoBatallaCompleto){
       if(!tercerMapa){
        if(introCompleta){
        int dx = 0;
        int dy = 0;
        if (Greenfoot.isKeyDown("right")){ 
            isKeyPressed = true; 
            animateWalkingRight();
            posicion = "right";
            dx++;
        }
        if (Greenfoot.isKeyDown("left")){
            isKeyPressed = true; 
            animateWalkingLeft(); 
            posicion = "left";
            dx--;
        }
        if (Greenfoot.isKeyDown("down")){ 
            isKeyPressed = true; 
            animateWalkingDown(); 
            posicion = "down";
            dy++;
        }
        if (Greenfoot.isKeyDown("up")){ 
            isKeyPressed = true; 
            animateWalkingUp(); 
            posicion = "up";         
            dy--;
        }
        
        for (int i=0; i<speed; i++)
        {
            setLocation(getX()+dx, getY()+dy);
            if (isTouching(Wall.class) || isTouching(WallHorizontal.class))
            {
        setLocation(getX()-dx, getY()-dy);
        break;
        }
        }
       }
       }
       }
       
       if(!isKeyPressed){
            posicionImagen();
        }
       
       if(dialogoBatalla){
           if(getX() < 100){
            caminarSolo();
           } else if(getX() == 100){
                dialogoBatallaIntro();
                if ("enter".equals(keyPressed))
                {
                  dialogoBatalla();
                }
            }
        }
     }
     
    public void posicionImagen(){
       if(posicion == "left"){
         setImage("pj1/stand_izq.PNG");
       } else if(posicion == "right"){
         setImage("pj1/stand_der.PNG");
       } else if(posicion == "down"){
         setImage("pj1/stand_abj.PNG");
       } else if(posicion == "up"){
         setImage("pj1/stand_arr.PNG");
       }     
    }

    public void caminarSolo(){
     timer = (timer+1%1);   
     if (timer==0)
      {
         moveRight();
      }
      animateWalkingRight();
    }
    
    public void setImagen(String posicion){
       if(posicion == "left"){
         setImage("pj1/stand_izq.PNG");
           } else if(posicion == "right"){
          setImage("pj1/stand_der.PNG");
            } else if(posicion == "down"){
           setImage("pj1/stand_abj.PNG");
            } else if(posicion == "up"){
          setImage("pj1/stand_arr.PNG");
           }          
    }
     
    public void introDialogo(){
        if (seccion == 0){
       ((Episodio1_1)getWorld()).text.setImage("ep_1_diag/kaz_2.PNG");
        seccion++;
        }
        else if (seccion == 1){
        Greenfoot.playSound("sfx/monster.mp3");
        ((Episodio1_1)getWorld()).text.setImage("ep_1_diag/kaz_3.PNG");
        ((Episodio1_1)getWorld()).stopMusic();
        ((Episodio1_1)getWorld()).cambiarMusica("bgm/run.mp3");
        ((Episodio1_1)getWorld()).bgMusic.playLoop();
        seccion++;
        }
        else if (seccion == 2){
        ((Episodio1_1)getWorld()).text.setImage("ep_1_diag/kaz_4.PNG");
        seccion++;
        } else if (seccion == 3){
          ((Episodio1_1)getWorld()).borrarDialogo();
          introCompleta = true;
       }
    }

    public void dialogo(){
        if (seccion == 0){
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/anemoi_2.PNG");
        seccion++;
        }
        else if (seccion == 1){
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/anemoi_3.PNG");
        seccion++;
        }
        else if (seccion == 2){
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/anemoi_3.PNG");
        seccion++;         
        }
        else if (seccion == 3){
        ((Episodio1_2a)getWorld()).fondo.setImage("dialogo_kaze2.PNG");
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/kaze_1.PNG");
        seccion++;         
        }        
        else if (seccion == 4){
        ((Episodio1_2a)getWorld()).fondo.setImage("dialogo_anemoi.PNG");
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/anemoi_4.PNG");
        seccion++;         
        }        
        else if (seccion == 5){
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/anemoi_5.PNG");
        seccion++;         
        }        
        else if (seccion == 6){
        ((Episodio1_2a)getWorld()).fondo.setImage("dialogo_kaze2.PNG");
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/kaze_2.PNG");
        seccion++;         
        }        
        else if (seccion == 7){
        ((Episodio1_2a)getWorld()).fondo.setImage("dialogo_anemoi.PNG");
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/anemoi_6.PNG");
        seccion++;         
        } 
        else if (seccion == 8){
        ((Episodio1_2a)getWorld()).fondo.setImage("dialogo_kaze2.PNG");
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/kaze_3.PNG");
        seccion++;         
        }
        else if (seccion == 9){
        ((Episodio1_2a)getWorld()).fondo.setImage("dialogo_anemoi.PNG");
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/anemoi_7.PNG");
        seccion++;         
        }
        else if (seccion == 10){
        ((Episodio1_2a)getWorld()).fondo.setImage("dialogo_kaze2.PNG");
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/kaze_4.PNG");
        seccion++;         
        }
        else if (seccion == 11){
        ((Episodio1_2a)getWorld()).fondo.setImage("dialogo_anemoi.PNG");
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/anemoi_8.PNG");
        seccion++;         
        }
        else if (seccion == 12){
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/anemoi_9.PNG");
        seccion++;         
        }
        else if (seccion == 13){
        ((Episodio1_2a)getWorld()).fondo.setImage("dialogo_kaze2.PNG");
        ((Episodio1_2a)getWorld()).text.setImage("ep_1_diag/after/kaze_5.PNG");
        seccion++;         
        }
        else if (seccion == 14){
        ((Episodio1_2a)getWorld()).borrarDialogo();
        ((Episodio1_2a)getWorld()).setDialogoCompleto();
        dialogoCompleto = true;
        } 
    }
    
    public void dialogoBatallaIntro(){
        if (seccion == 0){
        ((Episodio1_2b)getWorld()).fondo.setImage("dialogo_kaze2.PNG");
        ((Episodio1_2b)getWorld()).text.setImage("ep_1_diag/before/kaze_1.PNG");
        seccion++;
        }
    }
    
    public void dialogoBatalla(){
        if (seccion == 1){
        ((Episodio1_2b)getWorld()).text.setImage("ep_1_diag/before/kaze_2.PNG");
        seccion++;
        }
        else if (seccion == 2){
        ((Episodio1_2b)getWorld()).fondo.setImage("dialogo_anemoi.PNG");
        ((Episodio1_2b)getWorld()).text.setImage("ep_1_diag/before/anemoi_1.PNG");
        seccion++;         
        }
        else if (seccion == 3){
        ((Episodio1_2b)getWorld()).fondo.setImage("dialogo_kaze2.PNG");
        ((Episodio1_2b)getWorld()).text.setImage("ep_1_diag/before/kaze_3.PNG");
        seccion++;         
        }        
        else if (seccion == 4){
         ((Episodio1_2b)getWorld()).bgMusic.stop();
         Greenfoot.setWorld(new Battle());
         setBatallaDialogo();
        }
       
    }
    
    public void setTercerMapa(){
        if (tercerMapa){
            tercerMapa = false;
        } else {
            tercerMapa = true;
        }
    }
    
    public void setBatallaDialogo(){
        if (dialogoBatalla){
            dialogoBatalla = false;
        } else {
            dialogoBatalla = true;
        }
    }
    
    public void caminar(){
        if(Greenfoot.isKeyDown("left")){
           isKeyPressed = true; 
           moveLeft();
           animateWalkingLeft();
        }
       else if(Greenfoot.isKeyDown("right")){
           isKeyPressed = true; 
           moveRight();
           animateWalkingRight();
       } 
       else if(Greenfoot.isKeyDown("down")){
           isKeyPressed = true; 
           moveDown();
           animateWalkingDown();
       } 
       else if(Greenfoot.isKeyDown("up")){
           isKeyPressed = true; 
           moveUp();
           animateWalkingUp();
        }    
    }
    
    public void animateWalkingLeft()
    {
        int delay = 5;
        if(frame < 1 * delay) {setImage("pj1/cam_izq_1.PNG");}
        else if(frame < 2 * delay) {setImage("pj1/cam_izq_1.PNG");}
        else if(frame < 3 * delay) {setImage("pj1/cam_izq_1.PNG");}
        else if(frame < 4 * delay) {setImage("pj1/cam_izq_2.PNG");}
        else if(frame < 5 * delay) {setImage("pj1/cam_izq_2.PNG");}
        else if(frame < 6 * delay) {setImage("pj1/cam_izq_2.PNG");
        frame = 1;
        return;       
        }
        frame++;
        posicion = "left";
    }    
    
    public void animateWalkingRight()
    {
        int delay = 5;
        if(frame < 1 * delay) {setImage("pj1/cam_der_1.PNG");}
        else if(frame < 2 * delay) {setImage("pj1/cam_der_1.PNG");}
        else if(frame < 3 * delay) {setImage("pj1/cam_der_1.PNG");}
        else if(frame < 4 * delay) {setImage("pj1/cam_der_2.PNG");}
        else if(frame < 5 * delay) {setImage("pj1/cam_der_2.PNG");}
        else if(frame < 6 * delay) {setImage("pj1/cam_der_2.PNG");
        frame = 1;
        return;       
        }
        frame++;
        posicion = "right";
    }   

    public void animateWalkingDown()
    {
        int delay = 5;
        if(frame < 1 * delay) {setImage("pj1/cam_abj_1.PNG");}
        else if(frame < 2 * delay) {setImage("pj1/cam_abj_1.PNG");}
        else if(frame < 3 * delay) {setImage("pj1/cam_abj_1.PNG");}
        else if(frame < 4 * delay) {setImage("pj1/cam_abj_2.PNG");}
        else if(frame < 5 * delay) {setImage("pj1/cam_abj_2.PNG");}
        else if(frame < 6 * delay) {setImage("pj1/cam_abj_2.PNG");
        frame = 1;
        return;       
        }
        frame++;
        posicion = "down";
    }   
    
    public void animateWalkingUp()
    {
        int delay = 5;
        if(frame < 1 * delay) {setImage("pj1/cam_arr_1.PNG");}
        else if(frame < 2 * delay) {setImage("pj1/cam_arr_1.PNG");}
        else if(frame < 3 * delay) {setImage("pj1/cam_arr_1.PNG");}
        else if(frame < 4 * delay) {setImage("pj1/cam_arr_2.PNG");}
        else if(frame < 5 * delay) {setImage("pj1/cam_arr_2.PNG");}
        else if(frame < 6 * delay) {setImage("pj1/cam_arr_2.PNG");
        frame = 1;
        return;       
        }
        frame++;
        posicion = "up";
    }       
    
    private void moveLeft()
    {
        if(getOneIntersectingObject(Wall.class) != null || getOneIntersectingObject(WallHorizontal.class) != null){
            setLocation(getX() + 15, getY()); 
        } else {
            setLocation(getX() - speed, getY()); 
        }
    }   
    
    private void moveRight()
    {
        if(getOneIntersectingObject(Wall.class) != null || getOneIntersectingObject(WallHorizontal.class) != null){
           setLocation(getX() - 15, getY()); 
        } else {
           setLocation(getX() + speed, getY());
        }
    }
    
    private void moveDown()
    {
        if(getOneIntersectingObject(Wall.class) != null || getOneIntersectingObject(WallHorizontal.class) != null){
           setLocation(getX(), getY() - 15); 
        } else {
        setLocation(getX(), getY() + speed);
        }
    }
    
    private void moveUp()
    {
        if(getOneIntersectingObject(Wall.class) != null || getOneIntersectingObject(WallHorizontal.class) != null){
           setLocation(getX(), getY() + 15); 
        } else {
        setLocation(getX(), getY() - speed);
        }
    }     
    
   } 