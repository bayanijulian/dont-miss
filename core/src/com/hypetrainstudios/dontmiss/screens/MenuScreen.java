package com.hypetrainstudios.dontmiss.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.screens.GameScreen;

public class MenuScreen implements Screen{
	//UI Variables
	private static Stage stage;
	private static FitViewport view;
	private static OrthographicCamera cam;
	
	private static Button playBtn, optionsBtn, rightArrowBtn, leftArrowBtn, oneBtn, twoBtn, threeBtn, backBtn, scoresBtn;
	private static ButtonStyle playBtnStyle, optionsBtnStyle, rightArrowBtnStyle, leftArrowBtnStyle, oneBtnStyle, twoBtnStyle, threeBtnStyle, backBtnStyle, scoresBtnStyle;
	private static Listener listener;
	
	private static Image mainMenuBackground, playMenuBackground;
	
	private static boolean mainMenu;
	private float checkpointNum, showBtnTargetX, hideBtnTargetX;
	
	private Game game;
	
	public MenuScreen(Game game) {
		mainMenu=true;
		this.game=game;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		cam.update();
		
		view = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(view);
		
		listener = new Listener();
		
		createBackgrounds();
		createButtons();
		addActors();
		
		Gdx.input.setInputProcessor(stage);
	}
	
	private void createButtons() {
		//initializes all buttons being used in menu
		playBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("playBtn"))),
									   new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("playBtnPressed"))),
									   new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("playBtn"))));
		playBtn = new Button(playBtnStyle);
		playBtn.setPosition((Gdx.graphics.getWidth()/2-(playBtn.getWidth()/2)), ((Gdx.graphics.getHeight()/2)-(playBtn.getHeight()/2)));
		playBtn.setVisible(true);
		playBtn.addListener(listener);
	
		optionsBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("optionsBtn"))),
									   	  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("optionsBtnPressed"))),
									   	  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("optionsBtn"))));
		optionsBtn = new Button(optionsBtnStyle);
		optionsBtn.setPosition(Gdx.graphics.getWidth()-optionsBtn.getWidth(), Gdx.graphics.getHeight()-optionsBtn.getHeight());
		optionsBtn.setVisible(true);
		optionsBtn.addListener(listener);
	
		rightArrowBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("rightArrowBtn-01"))),
			   	  			 				 new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("rightArrowBtnPressed"))),
			   	  			 				 new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("rightArrowBtn-01"))));
		rightArrowBtn = new Button(rightArrowBtnStyle);
		rightArrowBtn.setPosition((3*Gdx.graphics.getWidth()/4-(rightArrowBtn.getWidth()/2)), ((Gdx.graphics.getHeight()/2)-(rightArrowBtn.getHeight()/2)));
		rightArrowBtn.setVisible(false);
		rightArrowBtn.addListener(listener);

		leftArrowBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("leftArrowBtn"))),
  	  			 							new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("leftArrowBtnPressed"))),
  	  			 							new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("leftArrowBtn"))));
		leftArrowBtn = new Button(leftArrowBtnStyle);
		leftArrowBtn.setPosition((Gdx.graphics.getWidth()/4-(leftArrowBtn.getWidth()/2)), ((Gdx.graphics.getHeight()/2)-(leftArrowBtn.getHeight()/2)));
		leftArrowBtn.setVisible(false);
		leftArrowBtn.addListener(listener);
		
		oneBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("oneBtn"))),
	  				  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("oneBtnPressed"))),
	  				  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("oneBtn"))));
		oneBtn = new Button(oneBtnStyle);
		oneBtn.setPosition((Gdx.graphics.getWidth()/2-(oneBtn.getWidth()/2)), ((Gdx.graphics.getHeight()/2)-(oneBtn.getHeight()/2)));
		oneBtn.setVisible(false);
		oneBtn.addListener(listener);
		
		twoBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("twoBtn"))),
			  				  		  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("twoBtnPressed"))),
			  				  		  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("twoBtn"))));
		twoBtn = new Button(twoBtnStyle);
		twoBtn.setPosition((Gdx.graphics.getWidth()/2-(twoBtn.getWidth()/2)), ((Gdx.graphics.getHeight()/2)-(twoBtn.getHeight()/2)));
		twoBtn.setVisible(false);
		twoBtn.addListener(listener);
		
		threeBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("threeBtn"))),
										new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("threeBtnPressed"))),
										new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("threeBtn"))));
		threeBtn = new Button(threeBtnStyle);
		threeBtn.setPosition((Gdx.graphics.getWidth()/2-(threeBtn.getWidth()/2)), ((Gdx.graphics.getHeight()/2)-(threeBtn.getHeight()/2)));
		threeBtn.setVisible(false);
		threeBtn.addListener(listener);
		
		backBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("backBtn"))),
				   	   new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("backBtnPressed"))),
				   	   new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("backBtn"))));
		backBtn = new Button(backBtnStyle);
		backBtn.setPosition(0, Gdx.graphics.getHeight()-backBtn.getHeight());
		backBtn.setVisible(false);
		backBtn.addListener(listener);
		
		scoresBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("scoresBtn"))),
			   	   new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("scoresBtnPressed"))),
			   	   new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("scoresBtn"))));
		scoresBtn = new Button(scoresBtnStyle);
		scoresBtn.setPosition(Gdx.graphics.getWidth()-scoresBtn.getWidth(), Gdx.graphics.getHeight()-scoresBtn.getHeight());
		scoresBtn.setVisible(false);
		scoresBtn.addListener(listener);
	}

	private void createBackgrounds() {
		mainMenuBackground = new Image(AssetHandler.manager.get(AssetHandler.mainMenuBG));
	}
	
	private void addActors() {
		stage.addActor(mainMenuBackground);
		stage.addActor(oneBtn);
		stage.addActor(twoBtn);
		stage.addActor(threeBtn);
		stage.addActor(playBtn);
		stage.addActor(optionsBtn);
		stage.addActor(leftArrowBtn);
		stage.addActor(rightArrowBtn);
		stage.addActor(backBtn);
		stage.addActor(scoresBtn);
	}
	private void updateMenu(float delta) {
		stage.act(delta);
		stage.draw();
	}
	
	@Override
	public void render(float delta) {
		//clears the screen
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//updates everything on menu
		updateMenu(delta);
	}
	
	private void animateBtn(Button showBtn, Button hideBtn, float dir) {
		//sets showBtn target to middle of screen
		showBtnTargetX=(Gdx.graphics.getWidth()/2)-(showBtn.getWidth()/2);
		
		//sets showBtn position and hideBtn target depending on direction of movement
		if(dir==-1) {
			showBtn.setPosition(Gdx.graphics.getWidth(),(Gdx.graphics.getHeight()/2)-(showBtn.getHeight()/2));
			hideBtnTargetX=-hideBtn.getWidth();
		}
		else if(dir==1) {
			showBtn.setPosition(-showBtn.getWidth(),(Gdx.graphics.getHeight()/2)-(showBtn.getHeight()/2));
			hideBtnTargetX=Gdx.graphics.getWidth();
		}
		showBtn.setVisible(true);
		
		//hides arrow buttons and unhides them after a delay(after button animations finish)
		rightArrowBtn.addAction(Actions.sequence(Actions.visible(false),Actions.delay(.15f, Actions.visible(true))));
		leftArrowBtn.addAction(Actions.sequence(Actions.visible(false),Actions.delay(.15f, Actions.visible(true))));
		
		//moves showBtn and hideBtn to destinations over a period of time
		showBtn.addAction(Actions.moveTo(showBtnTargetX,(Gdx.graphics.getHeight()/2)-(showBtn.getHeight()/2),.12f));
		hideBtn.addAction(Actions.moveTo(hideBtnTargetX, (Gdx.graphics.getHeight()/2)-(showBtn.getHeight()/2),.12f));
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

	private class Listener extends ChangeListener{
		public void changed(ChangeEvent event, Actor actor) {
			if(actor==playBtn) {
				mainMenu=false;
				playBtn.setVisible(false);
				optionsBtn.setVisible(false);
				checkpointNum=3;
				threeBtn.setVisible(true);
				rightArrowBtn.setVisible(true);
				leftArrowBtn.setVisible(true);
				backBtn.setVisible(true);
				scoresBtn.setVisible(true);
			}
			else if(actor==optionsBtn) {
				
			}
			else if(actor==backBtn) {
				rightArrowBtn.setVisible(false);
				leftArrowBtn.setVisible(false);
				backBtn.setVisible(false);
				oneBtn.setVisible(false);
				twoBtn.setVisible(false);
				threeBtn.setVisible(false);
				scoresBtn.setVisible(false);
				optionsBtn.setVisible(true);
				playBtn.setVisible(true);
			}
			else if(actor==scoresBtn) {
				
			}
			else if(actor==oneBtn) {
				
			}
			else if(actor==twoBtn) {
				
			}
			else if(actor==threeBtn) {
				game.setScreen(new GameScreen(game));
			}
			else if(actor==rightArrowBtn) {
				if(mainMenu) {
					playBtn.setVisible(false);
					optionsBtn.setVisible(true);
				}
				else {
					if(checkpointNum==3) {
						animateBtn(twoBtn,threeBtn,-1);
						checkpointNum=2;
					}
					else if(checkpointNum==2) {
						animateBtn(oneBtn,twoBtn,-1);
						checkpointNum=1;
					}
					else {
						animateBtn(threeBtn,oneBtn,-1);
						checkpointNum=3;
					}
				}
			}
			else if(actor==leftArrowBtn) {
				if(mainMenu) {
					optionsBtn.setVisible(false);
					playBtn.setVisible(true);
				}
				else {
					if(checkpointNum==2) {
						animateBtn(threeBtn,twoBtn,1);
						checkpointNum=3;
					}
					else if(checkpointNum==1) {
						animateBtn(twoBtn,oneBtn,1);
						checkpointNum=2;
					}
					else {
						animateBtn(oneBtn,threeBtn,1);
						checkpointNum=1;
					}
				}
			}
		}
	}
}
