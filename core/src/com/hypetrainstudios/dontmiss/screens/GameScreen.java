package com.hypetrainstudios.dontmiss.screens;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.enemies.Boss;
import com.hypetrainstudios.dontmiss.handlers.AnimationHandler;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.handlers.CollisionHandler;
import com.hypetrainstudios.dontmiss.handlers.GameInputHandler;
import com.hypetrainstudios.dontmiss.handlers.GarbageHandler;
import com.hypetrainstudios.dontmiss.handlers.InGameUIHandler;
import com.hypetrainstudios.dontmiss.handlers.LogicHandler;


public class GameScreen implements Screen {
	
	private Game game;
	private static boolean running;
	private static SpriteBatch batch;
	private static OrthographicCamera cam;
	private static InputMultiplexer inputMultiplexer;
	private static InputProcessor gameInput;
	
	public GameScreen(Game game){
		Creator.setUp();
		this.game = game;
		running = true;

		cam = new OrthographicCamera();
		cam.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		cam.update();
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
	
		gameInput = new GameInputHandler();
		
		inputMultiplexer = new InputMultiplexer(InGameUIHandler.stage, gameInput);
		
		Gdx.input.setInputProcessor(inputMultiplexer);
		//Creator.enemies.add(new Boss(new Sprite(AssetHandler.manager.get(AssetHandler.imgEnemyRed)), Creator.midTurret.getSprite(), 3, 40));
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
			
			update(delta);
			draw();
			
		}
		if(Creator.gameOver){
			//shows game over menu
			InGameUIHandler.showGameOverUI();
		}
	}
	@Override
	public void resize(int width, int height) {
		InGameUIHandler.stage.getViewport().update(width, height, true);
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
	private static void update(float delta){
		LogicHandler.update(delta);
		AnimationHandler.update(delta);
		CollisionHandler.update();
		GarbageHandler.update();
	}
	
	private static void draw(){
		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		
		
		for(int i = 0; i<Creator.projectiles.size();i++)
			Creator.projectiles.get(i).getSprite().draw(batch);
		for(int i = 0; i < Creator.enemies.size(); i++)
			Creator.enemies.get(i).getSprite().draw(batch);
		for(int i =0; i < Creator.bonuses.size(); i++)
			Creator.bonuses.get(i).getSprite().draw(batch);
		for(int i = 0; i< Creator.misc.size(); i ++)
			Creator.misc.get(i).getSprite().draw(batch);
		
		Creator.midTurret.getSprite().draw(batch);
		
		
		
		batch.end();
	}	
}
