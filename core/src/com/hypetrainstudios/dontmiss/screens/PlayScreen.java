package com.hypetrainstudios.dontmiss.screens;

import java.text.DecimalFormat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.Challenge;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.handlers.ChallengeHandler;
import com.hypetrainstudios.dontmiss.handlers.GameInputHandler;
import com.hypetrainstudios.dontmiss.handlers.SpawnHandler;

public class PlayScreen implements Screen {
	
	private Game game;
	private boolean running;
	private boolean gameOver;
	private SpriteBatch batch;
	private OrthographicCamera cam;
	private InputProcessor gameInput;
	
	/* User Interface Variables */
	private Stage stage;
	private LabelStyle mainLblStyle;
	private Label lblTimer;
	private BitmapFont playFont;
	private DecimalFormat dfMinutes;
	private DecimalFormat dfSeconds;
	private FitViewport view;
	/*--------------------------*/
	
	
	public PlayScreen(Game game){
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
		createUserInterface();
		
	}
	private void createUserInterface(){
		dfSeconds = new DecimalFormat("00");
		dfMinutes = new DecimalFormat("0");
		//view = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage();
		playFont = AssetHandler.manager.get(AssetHandler.fontPlay);
		mainLblStyle = new LabelStyle(playFont, Color.BLACK);
		lblTimer = new Label("3:00",mainLblStyle);
		lblTimer.setPosition((Gdx.graphics.getWidth()/2)-(lblTimer.getWidth()/2),Gdx.graphics.getHeight()-100);
		stage.addActor(lblTimer);
	}
	
	@Override
	public void render(float delta) {
		if(running&&(!(gameOver))){
			Gdx.gl.glClearColor(1,1,1,1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			Creator.update(delta);
			
			updateChallenge(delta);
			
			updateSpawn(delta);
			
			updateUI();
			
			drawEntites();
			
			updateEntites(delta);
			
			checkCollision();
			
			removeEntities();
			
		}
		if(gameOver){
			//shows retry menu
			this.game.setScreen(new MenuScreen());
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
	
	private void removeEntities()
	{
		//removes projectiles
		for(int i=0;i<Creator.projectiles.size();i++)
		{
			if(!(Creator.projectiles.get(i).isActive()))
				Creator.projectiles.remove(i);
		}
		//removes enemies
		for(int i=0;i<Creator.enemies.size();i++)
		{
			if(!(Creator.enemies.get(i).isActive()))
				Creator.enemies.remove(i);
		}
	}
	private void updateUI(){
		float timerMins = (Creator.gameTime/60)-1;
		float timerSecs = Creator.gameTime%60;
		lblTimer.setText(dfMinutes.format(timerMins) + ":" + dfSeconds.format(timerSecs));
		lblTimer.setPosition((Gdx.graphics.getWidth()/2)-(lblTimer.getWidth()/2),Gdx.graphics.getHeight()-100);
		stage.act();
		stage.draw();
	}
	private void checkCollision()
	{
		//Checks collision between projectile and enemies
		for (int x=0; x<Creator.projectiles.size();x++)
		{
			for (int k=0; k<Creator.enemies.size();k++)
			{
				if( Creator.projectiles.get(x).getCircle().overlaps( Creator.enemies.get(k).getCircle() ) )
				{
					//Removes both the projectile and enemy from the screen
					Creator.enemies.get(k).setActive(false);
					Creator.projectiles.get(x).setActive(false);
					Challenge.currentCode = Challenge.codeCollision;
				}
			}
		}
		
		//Checks collision between projectiles and the player
		for(int  x= 0; x<Creator.enemies.size();x++)
		{
			if(Creator.enemies.get(x).getCircle().overlaps(Creator.player.getCircle())){
				gameOver = true;
				//end game code
				System.exit(0);
			}
		}
		
	}
	private void updateEntites(float delta){
		Creator.player.update(delta);
		
		for(int i = 0; i<Creator.projectiles.size();i++)
			Creator.projectiles.get(i).update(delta);
		for(int i = 0; i < Creator.enemies.size(); i++)
			Creator.enemies.get(i).update(delta);
		
	}
	private void drawEntites(){
		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		
		Creator.player.getSprite().draw(batch);
		
		for(int i = 0; i<Creator.projectiles.size();i++)
			Creator.projectiles.get(i).getSprite().draw(batch);
		for(int i = 0; i < Creator.enemies.size(); i++)
			Creator.enemies.get(i).getSprite().draw(batch);
		
		batch.end();
	}
	private void updateSpawn(float delta){
		SpawnHandler.update(Creator.gameTime);
	}
	private void updateChallenge(float delta){
		ChallengeHandler.update(Creator.gameTime);
		for(int i = 0; i < Creator.challenges.size(); i ++){
			Creator.challenges.get(i).update(delta);
		}
		Challenge.currentCode = Challenge.codeDefault;
	}
}
