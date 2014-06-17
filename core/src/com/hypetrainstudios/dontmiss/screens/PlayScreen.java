package com.hypetrainstudios.dontmiss.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.handlers.GameInputHandler;

public class PlayScreen implements Screen {
	
	private Game game;
	private boolean running;
	private boolean gameOver;
	private SpriteBatch batch;
	private OrthographicCamera cam;
	private InputProcessor gameInput;
	public PlayScreen(Game game)
	{
		this.game = game;
		running = true;
		gameOver = false;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		cam.update();
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		gameInput = new GameInputHandler();
		Gdx.input.setInputProcessor(gameInput);
		
		Creator.createEnemy();
	}
	
	@Override
	public void render(float delta) {
		if(running&&(!(gameOver))){
			Gdx.gl.glClearColor(1,1,1,1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			drawEntites();
			updateEntites(delta);
			
			
		}
		if(gameOver){
			
		}
	}
	
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
	public void updateEntites(float delta){
		Creator.player.update(delta);
		
		for(int i = 0; i<Creator.projectiles.size();i++)
			Creator.projectiles.get(i).update(delta);
		for(int i = 0; i < Creator.enemies.size(); i++)
			Creator.enemies.get(i).update(delta);
		
	}
	public void drawEntites(){
		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		
		Creator.player.getSprite().draw(batch);
		
		for(int i = 0; i<Creator.projectiles.size();i++)
			Creator.projectiles.get(i).getSprite().draw(batch);
		for(int i = 0; i < Creator.enemies.size(); i++)
			Creator.enemies.get(i).getSprite().draw(batch);
		
		batch.end();
	}
}
