package com.mygdx.autitos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import patterndesign.MovementStrat;


public class Carrera{
	private ListaObstaculos lista;

	private Ferrari ferrari;
	private Camino carretera;
	private int dificultad;
	private int nivel;
    private long lastDropTime;
    private Music music;
    private Music gameOver;

	public Carrera() {
		dificultad = 999999999;
		nivel = 0;
		music = Gdx.audio.newMusic(Gdx.files.internal("music.wav"));
		gameOver = Gdx.audio.newMusic(Gdx.files.internal("FF7GameOverTheme.wav"));
	}

	public void crear() {
		lista = new ListaObstaculos();
		ferrari = Ferrari.getInstance();
		carretera = new Camino();
		crearObstaculo();
	    music.setLooping(true);
	    music.play();
	}

	private void crearObstaculo() {
		lista.crearObstaculo();
		lastDropTime = TimeUtils.nanoTime();
	}

   public void actualizarMovimiento() { 
	   MovementStrat strat;
	   
	   for(int i = 0 ; i <= 1; i++) {
		   if (i==0)strat = carretera;
		   else strat = ferrari;
		   
		   strat.actualizarMovimiento();
	   }
	     
	   if(TimeUtils.nanoTime() - lastDropTime > dificultad) crearObstaculo();
	   lista.actualizarMovimiento(ferrari);
	   
	   int pt = ferrari.getPuntos();
	   if (pt > nivel && pt < 5000) {
		   nivel += 500;
		   dificultad /= 1.2;
	   }   
   }

   public void actualizarDibujoObstaculos(SpriteBatch batch) { 
	  lista.actualizarDibujoObstaculos(batch);
	  ferrari.dibujar(batch);
   }
   
   public boolean estadoCarrera(SpriteBatch batch) {
	   // False - Lose
	   // True - Still Playing
	   int est = ferrari.estado();
	   
	   if (est == 0) {
		   music.stop();
		   gameOver.setLooping(true);
		   gameOver.play();
		   return false;
	   }
	   else if (est == 1) {
		   ferrari.dibujar(batch);
		   actualizarMovimiento();
	   }
	   carretera.dibujar(batch);
	   actualizarDibujoObstaculos(batch);
	   return true;
   }
   
   public int getPuntosF() {
	   return ferrari.getPuntos();
   }
   
   public int getGasolinaF() {
	   return ferrari.getGasolina();
   }
   
   public void destruir() {
	      music.dispose();
	      lista.clear();
	      ferrari.destruir();
   }

}
