package com.hypetrainstudios.dontmiss;


import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hypetrainstudios.dontmiss.entities.Bonus;
import com.hypetrainstudios.dontmiss.entities.Projectile;
import com.hypetrainstudios.dontmiss.entities.Turret;
import com.hypetrainstudios.dontmiss.entities.enemies.Enemy;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.screens.GameScreen;



public class DontMiss extends Game {
	
	public static final int GAME_STATE_PLAY = 0;
	public static final int GAME_STATE_PAUSE = 1;
	public static final int GAME_STATE_GAME_OVER = 2;
	
	public static int currentGameState = -1;
	
	public static ArrayList<Bonus> bonuses = new ArrayList<Bonus>(); 
	public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>(); 
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static Turret turret;
	
	public static SpriteBatch renderer;
	public static OrthographicCamera cam;
	
	@Override
	public void create() {
		AssetHandler.load();
		AssetHandler.manager.finishLoading();
		
		turret = new Turret();
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.update();
		renderer = new SpriteBatch();
		renderer.setProjectionMatrix(cam.combined);
		renderer.enableBlending();
		
		setScreen(new GameScreen());
	}
	
	
	public static void createProjectile() {
		projectiles.add(new Projectile());
	}
	
	public static void createEnemy() {
		
	}
	
}
