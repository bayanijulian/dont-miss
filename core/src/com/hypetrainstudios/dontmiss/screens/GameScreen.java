package com.hypetrainstudios.dontmiss.screens;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;


import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.Challenge;
import com.hypetrainstudios.dontmiss.entity.ProjectileLoading;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.handlers.ChallengeHandler;
import com.hypetrainstudios.dontmiss.handlers.CollisionHandler;
import com.hypetrainstudios.dontmiss.handlers.GameInputHandler;
import com.hypetrainstudios.dontmiss.handlers.SpawnHandler;

public class GameScreen implements Screen {
	
	private Game game;
	private static boolean running;
	private static SpriteBatch batch;
	private static OrthographicCamera cam;
	private static InputMultiplexer inputMultiplexer;
	private static InputProcessor gameInput;
	
	/* User Interface Variables */
	private static Stage stage;
	private static FitViewport view;
	
	private static LabelStyle mainLblStyle;
	private static Label lblTimer;
	private static Label lblChallengeMsg;
	
	private static BitmapFont playFont;
	
	private static DecimalFormat dfMinutes;
	private static DecimalFormat dfSeconds;
	
	private static Image imgTintBG;
	
	private static Button btnRetry;
	private static ButtonStyle retryBtnStyle;
	
	
	/* Actions */
	private static AlphaAction alphaChallengeMsg;
//	private static DelayAction delayChallengeMsg;
//	private static ParallelAction parallelChallengeMsg;
	/*---------*/
	
	/*--------------------------*/
	
	public GameScreen(Game game){
		this.game = game;
		running = true;
		
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		cam.update();
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		gameInput = new GameInputHandler();
		createUserInterface();
		
		inputMultiplexer = new InputMultiplexer(stage, gameInput);
		
		Gdx.input.setInputProcessor(inputMultiplexer);
		
		//moving player it works, just fix spawning to rectangular spawning
		//cam.position.x = 300;
		//cam.update();
		
		ProjectileLoading.create();
	}
	private void createUserInterface(){
		dfSeconds = new DecimalFormat("00");
		dfSeconds.setRoundingMode(RoundingMode.DOWN);
		dfMinutes = new DecimalFormat("0");
		dfMinutes.setRoundingMode(RoundingMode.DOWN);
		view = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(view);
		playFont = AssetHandler.manager.get(AssetHandler.fontPlay);
		playFont.setScale(.5f);
		mainLblStyle = new LabelStyle(playFont, Color.BLACK);
		
		lblTimer = new Label("3:00",mainLblStyle);
		lblTimer.setPosition((Gdx.graphics.getWidth()/2)-(lblTimer.getPrefWidth()/2),Gdx.graphics.getHeight()-lblTimer.getPrefHeight());
		
		
		alphaChallengeMsg = new AlphaAction();
		alphaChallengeMsg.setAlpha(0);
		alphaChallengeMsg.setDuration(3f);
		
//		delayChallengeMsg = new DelayAction();
//		delayChallengeMsg.setDuration(2f);
		
//		parallelChallengeMsg = new ParallelAction();
//		parallelChallengeMsg.addAction(delayChallengeMsg);
//		parallelChallengeMsg.addAction(alphaChallengeMsg);
		
		lblChallengeMsg = new Label("wertewt",mainLblStyle);
		lblChallengeMsg.setColor(0, 0, 0, 0);
		lblChallengeMsg.setPosition((Gdx.graphics.getWidth()/2)-(lblChallengeMsg.getPrefWidth()/2),0);
		
		imgTintBG = new Image(AssetHandler.manager.get(AssetHandler.imgTintBG));
		
		
		
		retryBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("retryBtn"))),
										new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("retryBtnPressed"))),
										new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("retryBtn"))));
		
		btnRetry = new Button(retryBtnStyle);
		btnRetry.setPosition((Gdx.graphics.getWidth()/2-(btnRetry.getWidth()/2)), ((Gdx.graphics.getHeight()/2)-(btnRetry.getHeight()/2)));
		btnRetry.setVisible(false);
		btnRetry.addListener(new ChangeListener() {
			
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				reset();
				
			}
		});
		imgTintBG.setVisible(false);
		
		stage.addActor(lblChallengeMsg);
		stage.addActor(lblTimer);
		stage.addActor(imgTintBG);
		stage.addActor(btnRetry);
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.setTitle("Don't Miss\tFPS:"+Gdx.graphics.getFramesPerSecond());
		if(running&&(!(Creator.gameOver))){
			
			Creator.update(delta);

			drawEntites();

			CollisionHandler.checkCollision();

			updateUI();

			ProjectileLoading.update(delta);
		}
		if(Creator.gameOver){
			//shows retry menu
			showGameOverUI();
			updateUI();
			//this.game.setScreen(new MenuScreen());
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
	private void showGameOverUI(){
		imgTintBG.setVisible(true);
		btnRetry.setVisible(true);
	}
	private void hideGameOverUI(){
		btnRetry.setVisible(false);
		imgTintBG.setVisible(false);
	}
	private void updateUI(){
		if(!Creator.gameOver){
			float timerMins = (Creator.gameTime/60);
			float timerSecs = Creator.gameTime%60;
			lblTimer.setText(dfMinutes.format(timerMins) + ":" + dfSeconds.format(timerSecs));
			lblTimer.validate();
			lblTimer.setPosition((Gdx.graphics.getWidth()/2)-(lblTimer.getPrefWidth()/2),Gdx.graphics.getHeight()-lblTimer.getPrefHeight());
		}
		
		stage.act();
		stage.draw();
	}
	
	private void drawEntites(){
		batch.begin();
		batch.setProjectionMatrix(cam.combined);
		ProjectileLoading.getSprite().draw(batch);
		Creator.player.getSprite().draw(batch);
		
		for(int i = 0; i<Creator.projectiles.size();i++)
			Creator.projectiles.get(i).getSprite().draw(batch);
		for(int i = 0; i < Creator.enemies.size(); i++)
			Creator.enemies.get(i).getSprite().draw(batch);
		
		batch.end();
	}
	
	
	private void reset(){
		hideGameOverUI();
		Creator.reset();
	}
	public static void updateChallengeMessage(String message){
		lblChallengeMsg.setText(message);
		lblChallengeMsg.validate();
		lblChallengeMsg.setPosition((Gdx.graphics.getWidth()/2)-(lblChallengeMsg.getPrefWidth()/2),0);
		lblChallengeMsg.setColor(0, 0, 0, 1);
		lblChallengeMsg.addAction(alphaChallengeMsg);
		alphaChallengeMsg.reset();
	}
}
