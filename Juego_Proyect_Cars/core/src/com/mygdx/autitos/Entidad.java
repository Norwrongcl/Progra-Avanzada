package com.mygdx.autitos;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entidad extends TipsCol {
	private Rectangle hitbox;
	private Rectangle hitbox1;
	private Rectangle hitbox2;
	private Texture sprite;
	private Sound sound;
	
	
	// METODOS
	public Rectangle getHitboxO() {
		return hitbox;
	}
	public Rectangle getHitboxF() {		
	   	return hitbox;
	}
	public Rectangle getHitboxF1() {		
	   	return hitbox1;
	}
	public Rectangle getHitboxF2() {		
	   	return hitbox2;
	}
	public Sound getSound() {
		return sound;
	}
	
	public Texture getSprite() {
		return sprite;
	}
	
	public void setSprite(Texture tx) {
		this.sprite = tx;
	}
	
	public void setSound(Sound sd) {
		this.sound = sd;
	}
	
	public void setHitbox(Rectangle hb,Rectangle hb1,Rectangle hb2) {
		this.hitbox = hb;
		this.hitbox1 = hb1;
		this.hitbox2 = hb2;
	}
	public int col1(){
		
		return colicion1();
	}
	public int col2(){
		
		return colicion2();
	}
	public int col3(){
		
		return colicion3();
	}
	
}
