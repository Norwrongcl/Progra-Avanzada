package com.mygdx.autitos;

import com.badlogic.gdx.Gdx; 
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Obstaculo extends Entidad {
	
	private int tipo;
	
	public Obstaculo(Rectangle hb, Texture tx, Sound sd, int tp){
		Rectangle h= new Rectangle();
		h.x = 0;
	   	h.y = 0;
	   	h.width = 0;
	   	h.height = 0;
		setHitbox(hb,h,h);
		setSprite(tx);
		setSound(sd);
	   	this.tipo = tp;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public boolean actualizarMovimiento() {
		getHitboxO().y -= 300 * Gdx.graphics.getDeltaTime();
	      //cae al suelo y se elimina
	      if(getHitboxO().y + 180 < 0)
	    	  return true; 
	     return false;
	}
	
	public boolean choque(Ferrari ferrari) {
		if(getHitboxO().overlaps(ferrari.getArea())) {
			
	    	if(getTipo() == 0) {
	    		ferrari.aumentarGasolina();
	    	}
	      		
	    	else if (getTipo() == 1) {
	    		ferrari.sumarPuntos(25);
		    }
	    	
	    	else{
	    		ferrari.setCol(col1());
	    		ferrari.dañar();
		    }	
	    	getSound().play();
	    	return true;
		}
		
		
		if(getHitboxO().overlaps(ferrari.getArea1())) {
			
	    	if(getTipo() == 0) {
	    		ferrari.aumentarGasolina();
	    	}
	      		
	    	else if (getTipo() == 1) {
	    		ferrari.sumarPuntos(25);
	    	}
	    	
	    	else{
	    		ferrari.setCol(col2());
	    		ferrari.dañar();
	    	}	
	    	getSound().play();
	    	return true;
		}
		
		if(getHitboxO().overlaps(ferrari.getArea2())) {
			
    		if(getTipo() == 0) {
    			ferrari.aumentarGasolina();
    		}
      		
    		else if (getTipo() == 1) {
    			ferrari.sumarPuntos(25);
    		}
    	
    		else{
    			ferrari.setCol(col3());
    			ferrari.dañar();
    		}	
    		getSound().play();
    		return true;
	    }
	
		return false;
	}
}
