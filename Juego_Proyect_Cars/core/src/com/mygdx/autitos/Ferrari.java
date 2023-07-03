package com.mygdx.autitos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

import patterndesign.MovementStrat;


public class Ferrari extends Entidad implements MovementStrat{
	   //Singleton   
	   private static Ferrari instance;
	
	   private int gasolina = 100;
	   private int col = 0;
	   private int puntos = 0;
	   private int velx = 300;
	   private boolean herido = false;
	   private int tiempoHeridoMax=50;
	   private int tiempoHerido;
	   private int timer;
	   
	   private Ferrari() {
		   setSprite(new Texture(Gdx.files.internal("Ferrari48x99.png")));
		   setSound(null);
		   timer = 50;
		   crear();
	   }

	   public static synchronized Ferrari getInstance() {
	       if (instance == null) {
	           instance = new Ferrari();
	       }
	       return instance;
	   }
	   
	   
	    public int getGasolina() {
			return gasolina;
		}
		public int getPuntos() {
			return puntos;
		}
		public void setCol(int col) {
			this.col=col;
		}
		public Rectangle getArea() {
			return getHitboxF();
		}
		public Rectangle getArea1() {
			return getHitboxF1();
		}
		public Rectangle getArea2() {
			return getHitboxF2();
		}
		public void sumarPuntos(int pp) {
			puntos+=pp;
		}
		
		public void aumentarGasolina() {
			gasolina=100;
		}
	
	   public void crear() {
		   	Rectangle hitbox = new Rectangle();
		   	hitbox.x = (800 / 2 - 64 / 2)-12;
		   	hitbox.y = 20;
		   	hitbox.width = 24;
		   	hitbox.height = 94;
		   	Rectangle hitbox1 = new Rectangle();
		   	hitbox1.x = (800 / 2 - 64 / 2)+12;
		   	hitbox1.y = 20;
		   	hitbox1.width = 24;
		   	hitbox1.height = 94;
		   	Rectangle hitbox2 = new Rectangle();
		   	hitbox2.x = (800 / 2 - 64 / 2);
		   	hitbox2.y = 117;
		   	hitbox2.width = 24;
		   	hitbox2.height = 5;
		   	setHitbox(hitbox,hitbox1,hitbox2);
	   }
	   
	   public void dañar() {
		  gasolina-=20;
		  herido = true;
		  tiempoHerido=tiempoHeridoMax;
		  
	   }
	   
	   public void dibujar(SpriteBatch batch) {
		 Sprite sprite = new Sprite(getSprite());  
		 if (!herido)  
		   batch.draw(getSprite(),(getHitboxF().x+12), getHitboxF().y);  
		 
		 else if(col==1){
		   for(int i=0;i<40;i++) {
			   sprite.setPosition(getHitboxF().x, getHitboxF().y);
			   sprite.setRotation(-i);
			   sprite.draw(batch);
		   }
		   tiempoHerido--;
		   if (tiempoHerido<=0) herido = false;
		 }
		 
		 else if(col==2) {
		   for(int i=0;i<40;i++) {
			   sprite.setPosition(getHitboxF().x, getHitboxF().y);
			   sprite.setRotation(i);
			   sprite.draw(batch);
		   }
		   tiempoHerido--;
		   if (tiempoHerido<=0) herido = false;
		 }
		 
		 else if(col==3) {
		   batch.draw(getSprite(), getHitboxF().x, getHitboxF().y+ MathUtils.random(-5,5));
		   tiempoHerido--;
	       if (tiempoHerido<=0) herido = false;
		 }
	   
	   } 
	   
	   public void actualizarMovimiento() { 
		   timer -= 1;
		   if (timer == 0) {
			   sumarPuntos(1);
			   timer = 50;
		   }
		   if (timer == 50) {
			  gasolina-=1;
		   }
		   
		   Rectangle hitbox = getArea();
		   if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) 	hitbox.x -= velx  * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) hitbox.x += velx * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.UP)) hitbox.y += velx * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) hitbox.y -= velx * Gdx.graphics.getDeltaTime();
		   
		   
		   Rectangle hitbox1 = getArea1();
		   if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) 	hitbox1.x -= velx  * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) hitbox1.x += velx * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.UP)) hitbox1.y += velx * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) hitbox1.y -= velx * Gdx.graphics.getDeltaTime();
		   
		   Rectangle hitbox2 = getArea2();
		   if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) 	hitbox2.x -= velx  * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) hitbox2.x += velx * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.UP)) hitbox2.y += velx * Gdx.graphics.getDeltaTime();
		   if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) hitbox2.y -= velx * Gdx.graphics.getDeltaTime();
		   
		   // que no se salga de los bordes izq y der
		   if(hitbox.x < 0) hitbox.x = 0; 
		   if(hitbox.x > (800 - 64)-24) hitbox.x = (800 - 64)-24;	   
		   if(hitbox.y < 0) hitbox.y = 0;
		   if(hitbox.y > 800-402) hitbox.y = 800 - 402;
		   
		   if(hitbox1.x < 24) hitbox1.x = 24; 
		   if(hitbox1.x > 800 - 64) hitbox1.x = 800 - 64;
		   if(hitbox1.y < 0) hitbox1.y = 0;
		   if(hitbox1.y > 800-402) hitbox1.y = 800 - 402;
		   
		   if(hitbox2.x < 12) hitbox2.x = 12; 
		   if(hitbox2.x > (800 - 64)-12) hitbox2.x = (800 - 64)-12;
		   if(hitbox2.y < 97) hitbox2.y = 97;
		   if(hitbox2.y > 800-400) hitbox2.y = 800 - 400;
		   
		   

	   }
	    

	public void destruir() {
		    getSprite().dispose();
	   }
	
   public boolean estaHerido() {
	   return herido;
   }
   
   public int estado() {
	   if (getGasolina() <= 0) 
		   return 0;
	   else if (!estaHerido()) {
		   return 1;
	   }
	   return 2;
   }
	   
}
