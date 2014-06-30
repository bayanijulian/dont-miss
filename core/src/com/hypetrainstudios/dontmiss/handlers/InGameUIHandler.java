package com.hypetrainstudios.dontmiss.handlers;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.hypetrainstudios.dontmiss.Creator;

public class InGameUIHandler {
	
	public static Stage stage;
	private static FitViewport view;
	
	private static LabelStyle mainLblStyle;
	private static Label lblTimer,lblChallengeMsg;
	
	private static BitmapFont playFont;
	
	private static DecimalFormat dfMinutes,dfSeconds;
	
	private static Image imgTintBG;
	
	private static Button btnRetry;
	private static ButtonStyle retryBtnStyle;
	
	private static ButtonListener btnListener;
	private static AlphaAction alphaChallengeMsg;
	
	public static void update(){
		//when the game is not over it will update the timer
		if(!Creator.gameOver)	updateTimerLbl();
		//updates the stage and draws the stage
		stage.act();
		stage.draw();
		
	}
	public static void createUI(){
		createMisc();
		createActions();
		createLabels();
		createButtons();
		addActors();
	}
	public static void updateChallengeLbl(String message){
		lblChallengeMsg.setText(message);
		lblChallengeMsg.validate();
		lblChallengeMsg.setPosition((Gdx.graphics.getWidth()/2)-(lblChallengeMsg.getPrefWidth()/2),0);
		lblChallengeMsg.setColor(0, 0, 0, 1);
		lblChallengeMsg.addAction(alphaChallengeMsg);
		alphaChallengeMsg.reset();
	}
	private static void updateTimerLbl(){
		float timerMins = (Creator.gameTime/60);
		float timerSecs = Creator.gameTime%60;
		lblTimer.setText(dfMinutes.format(timerMins) + ":" + dfSeconds.format(timerSecs));
		lblTimer.validate();
		lblTimer.setPosition((Gdx.graphics.getWidth()/2)-(lblTimer.getPrefWidth()/2),Gdx.graphics.getHeight()-lblTimer.getPrefHeight());
	}
	private static void createLabels(){
		
		mainLblStyle = new LabelStyle(playFont, Color.BLACK);
		
		lblTimer = new Label("3:00",mainLblStyle);
		//sets the position to the top middle of the screen
		lblTimer.setPosition((Gdx.graphics.getWidth()/2)-(lblTimer.getPrefWidth()/2),Gdx.graphics.getHeight()-lblTimer.getPrefHeight());
		
		lblChallengeMsg = new Label("Challenge",mainLblStyle);
		lblChallengeMsg.setColor(0, 0, 0, 0);
		//sets position to the middle bottom of the screen
		lblChallengeMsg.setPosition((Gdx.graphics.getWidth()/2)-(lblChallengeMsg.getPrefWidth()/2),0);
		
		
	}
	private static void createButtons(){
		retryBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("retryBtn"))),
						new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("retryBtnPressed"))),
						new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("retryBtn"))));

		btnRetry = new Button(retryBtnStyle);
		//sets the position to the middle of the screen
		btnRetry.setPosition((Gdx.graphics.getWidth()/2-(btnRetry.getWidth()/2)), ((Gdx.graphics.getHeight()/2)-(btnRetry.getHeight()/2)));
		btnRetry.setVisible(false);
		btnRetry.addListener(btnListener);
		
		
	}
	private static void addActors(){
		stage.addActor(lblChallengeMsg);
		stage.addActor(lblTimer);
		stage.addActor(imgTintBG);
		stage.addActor(btnRetry);
	}
	private static void createMisc(){
		
		//formats the seconds in the timer label
		dfSeconds = new DecimalFormat("00");
		dfSeconds.setRoundingMode(RoundingMode.DOWN);
		
		//formats the minutes in the timer label
		dfMinutes = new DecimalFormat("0");
		dfMinutes.setRoundingMode(RoundingMode.DOWN);
		
		//creates the stage and view
		view = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(view);
		
		//creates the font
		playFont = AssetHandler.manager.get(AssetHandler.fontPlay);
		playFont.setScale(.5f);
		
		//creates the listener
		btnListener = new ButtonListener();
		
		//creates an image
		imgTintBG = new Image(AssetHandler.manager.get(AssetHandler.imgTintBG));
		imgTintBG.setVisible(false);
	}
	public static void showGameOverUI(){
		imgTintBG.setVisible(true);
		btnRetry.setVisible(true);
	}
	public static void hideGameOverUI(){
		btnRetry.setVisible(false);
		imgTintBG.setVisible(false);
	}
	public static void dispose(){
		stage.dispose();
	}
	private static void createActions(){
		alphaChallengeMsg = new AlphaAction();
		alphaChallengeMsg.setAlpha(0);
		alphaChallengeMsg.setDuration(3f);
	}
	private static class ButtonListener extends ChangeListener{

		@Override
		public void changed(ChangeEvent event, Actor actor) {
			if(actor==btnRetry){
				hideGameOverUI();
				Creator.reset();
			}
		}
		
	}
}
