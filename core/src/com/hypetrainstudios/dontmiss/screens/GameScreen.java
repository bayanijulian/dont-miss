package com.hypetrainstudios.dontmiss.screens;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hypetrainstudios.dontmiss.Creator;
//import com.hypetrainstudios.dontmiss.entity.ProjectileLoading;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.handlers.BonusHandler;
import com.hypetrainstudios.dontmiss.handlers.CollisionHandler;
import com.hypetrainstudios.dontmiss.handlers.GameInputHandler;
import com.hypetrainstudios.dontmiss.handlers.InGameUIHandler;


public class GameScreen implements Screen {
	
	private Game game;
	private static boolean running;
	private static SpriteBatch batch;
	private static OrthographicCamera cam;
	private static InputMultiplexer inputMultiplexer;
	private static InputProcessor gameInput;
	
	public GameScreen(Game game){
		this.game = game;
		running = true;

		cam = new OrthographicCamera();
		cam.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		cam.update();
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		gameInput = new GameInputHandler();
		InGameUIHandler.createUI();
		inputMultiplexer = new InputMultiplexer(InGameUIHandler.stage, gameInput);
		
		Gdx.input.setInputProcessor(inputMultiplexer);

		Creator.setUp();
		//ProjectileLoading.create();
		BonusHandler.createChances();
		//Creator.createBonus();
	}
	
	@Override
	public void render(float delta) {
		//clears the screen
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//puts the fps in the title
		Gdx.graphics.setTitle("Don't Miss\tFPS:"+Gdx.graphics.getFramesPerSecond());
		
		//updates the UI, ui is always on even if the game is over
		InGameUIHandler.update();
		
		//when the game is not over and its not paused it will update game logic and draw
		if(running&&(!(Creator.gameOver))){
			
			Creator.update(delta);
			CollisionHandler.update();
			draw();
			
			//ProjectileLoading.update(delta);
		}
		if(Creator.gameOver){
			//shows game over menu
			InGameUIHandler.showGameOverUI();
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
		InGameUIHandler.dispose();
		AssetHandler.dispose();
	}
	private void draw(){
		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		//ProjectileLoading.getSprite().draw(batch);
		
		
		
		for(int i = 0; i<Creator.projectiles.size();i++)
			Creator.projectiles.get(i).getSprite().draw(batch);
		for(int i = 0; i < Creator.enemies.size(); i++)
			Creator.enemies.get(i).getSprite().draw(batch);
		for(int i =0; i < Creator.bonuses.size(); i++)
			Creator.bonuses.get(i).getSprite().draw(batch);
		for(int i = 0; i< Creator.misc.size(); i ++)
			Creator.misc.get(i).getSprite().draw(batch);
		Creator.player.getSprite().draw(batch);
		
		batch.end();
	}	
}
