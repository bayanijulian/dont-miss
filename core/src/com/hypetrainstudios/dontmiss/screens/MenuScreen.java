package com.hypetrainstudios.dontmiss.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.screens.GameScreen;

public class MenuScreen implements Screen{
	//UI Variables
	private static Stage stage;
	private static FitViewport view;
	private static OrthographicCamera cam;
	
//	private static Table mainMenu, playMenu, optionsMenu;
	private static WidgetGroup mainMenu, playMenu, optionsMenu, scoresMenu, achievementsMenu, aboutMenu, storeMenu;
	
	private static Button playBtn, optionsBtn, rightArrowBtn, leftArrowBtn, oneBtn, twoBtn, threeBtn, backBtn, backBtnOptions, backBtnAchievements, backBtnPlay, backBtnAbout, backBtnScores, backBtnStore, scoresBtn, aboutBtn, achievementsBtn, storeBtn;
	private static ButtonStyle playBtnStyle, optionsBtnStyle, rightArrowBtnStyle, leftArrowBtnStyle, oneBtnStyle, twoBtnStyle, threeBtnStyle, backBtnStyle, scoresBtnStyle, aboutBtnStyle, achievementsBtnStyle, storeBtnStyle;
	private static Listener listener;
	
	private static Image mainMenuBG, playMenuBG, optionsMenuBG, storeMenuBG, achievementsMenuBG, scoresMenuBG, aboutMenuBG;
	
	private static Slider brightnessSlider;
	private static SliderStyle brightnessSliderStyle;
	
	private static boolean mainMenuBool, playMenuBool, optionsMenuBool, scoresMenuBool, achievementsMenuBool, storeMenuBool, aboutMenuBool;
	private static float checkpointNum, showBtnTargetX, hideBtnTargetX, scaleX, scaleY;
	
	private Game game;
	
	public MenuScreen(Game game) {
		mainMenuBool=true;
		this.game=game;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		cam.update();
		
		view = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(view);
		
		scaleX = view.getWorldWidth()/1920;
		scaleY = view.getWorldHeight()/1080;
		
		listener = new Listener();
		
		createBackgrounds();
		createButtons();
		
		createMainMenu();
		createOptionsMenu();
		createAchievementsMenu();
		createScoresMenu();
		createAboutMenu();
		createStoreMenu();
		createPlayMenu();
		
		addActors();
		
		Gdx.input.setInputProcessor(stage);
	}
	
	private void createButtons() {
		//initializes all buttons being used in menu
		playBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("playBtn"))),
									   new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("playBtnPressed"))),
									   new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("playBtn"))));
		playBtn = new Button(playBtnStyle);
		playBtn.setPosition((view.getWorldWidth()/2-(playBtn.getWidth()/2)), ((view.getWorldHeight()/2)-(playBtn.getHeight()/2)));
		playBtn.addListener(listener);
	
		optionsBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("optionsBtn"))),
									   	  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("optionsBtnPressed"))),
									   	  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("optionsBtn"))));
		optionsBtn = new Button(optionsBtnStyle);
		optionsBtn.setPosition(view.getWorldWidth()-optionsBtn.getWidth(), view.getWorldHeight()-optionsBtn.getHeight());
		optionsBtn.addListener(listener);
	
		rightArrowBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("rightArrowBtn"))),
			   	  			 				 new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("rightArrowBtnPressed"))),
			   	  			 				 new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("rightArrowBtn"))));
		rightArrowBtn = new Button(rightArrowBtnStyle);
		rightArrowBtn.setPosition(((view.getWorldWidth()-(110*scaleX))-(rightArrowBtn.getWidth()/2)), ((view.getWorldHeight()/2)-(rightArrowBtn.getHeight()/2)));
		rightArrowBtn.addListener(listener);

		leftArrowBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("leftArrowBtn"))),
  	  			 							new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("leftArrowBtnPressed"))),
  	  			 							new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("leftArrowBtn"))));
		leftArrowBtn = new Button(leftArrowBtnStyle);
		leftArrowBtn.setPosition(((110*scaleX)-(leftArrowBtn.getWidth()/2)), ((view.getWorldHeight()/2)-(leftArrowBtn.getHeight()/2)));
		leftArrowBtn.addListener(listener);
		
		oneBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("oneBtn"))),
	  				  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("oneBtnPressed"))),
	  				  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("oneBtn"))));
		oneBtn = new Button(oneBtnStyle);
		oneBtn.setVisible(false);
		oneBtn.addListener(listener);
		
		twoBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("twoBtn"))),
			  				  		  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("twoBtnPressed"))),
			  				  		  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("twoBtn"))));
		twoBtn = new Button(twoBtnStyle);
		twoBtn.setVisible(false);
		twoBtn.addListener(listener);
		
		threeBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("threeBtn"))),
										new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("threeBtnPressed"))),
										new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("threeBtn"))));
		threeBtn = new Button(threeBtnStyle);
		threeBtn.setPosition((view.getWorldWidth()/2-(threeBtn.getWidth()/2)), ((view.getWorldHeight()/2)-(threeBtn.getHeight()/2)));
		threeBtn.addListener(listener);
		
		backBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("backBtn"))),
				   	   new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("backBtnPressed"))),
				   	   new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("backBtn"))));

		backBtnOptions = new Button(backBtnStyle);
		backBtnOptions.setPosition(0, view.getWorldHeight()-backBtnOptions.getHeight());
		backBtnOptions.addListener(listener);
		
		backBtnAchievements = new Button(backBtnStyle);
		backBtnAchievements.setPosition(0, view.getWorldHeight()-backBtnAchievements.getHeight());
		backBtnAchievements.addListener(listener);
		
		backBtnScores = new Button(backBtnStyle);
		backBtnScores.setPosition(0, view.getWorldHeight()-backBtnScores.getHeight());
		backBtnScores.addListener(listener);
		
		backBtnStore = new Button(backBtnStyle);
		backBtnStore.setPosition(0, view.getWorldHeight()-backBtnStore.getHeight());
		backBtnStore.addListener(listener);
		
		backBtnAbout = new Button(backBtnStyle);
		backBtnAbout.setPosition(0, view.getWorldHeight()-backBtnAbout.getHeight());
		backBtnAbout.addListener(listener);
		
		backBtnPlay = new Button(backBtnStyle);
		backBtnPlay.setPosition(0, view.getWorldHeight()-backBtnPlay.getHeight());
		backBtnPlay.addListener(listener);
		
		scoresBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("scoresBtn"))),
			   	   		 new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("scoresBtnPressed"))),
			   	   		 new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("scoresBtn"))));
		scoresBtn = new Button(scoresBtnStyle);
		scoresBtn.setPosition(view.getWorldWidth()-scoresBtn.getWidth(), view.getWorldHeight()-scoresBtn.getHeight());
		scoresBtn.addListener(listener);
		
		aboutBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("aboutBtn"))),
			   	   		new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("aboutBtnPressed"))),
			   	   		new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("aboutBtn"))));
		aboutBtn = new Button(aboutBtnStyle);
		aboutBtn.setPosition(view.getWorldWidth()-aboutBtn.getWidth(), 0);
		aboutBtn.addListener(listener);
		
		achievementsBtnStyle = new ButtonStyle(new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("achievementsBtn"))),
			   	   			  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("achievementsBtnPressed"))),
			   	   			  new TextureRegionDrawable((AssetHandler.manager.get(AssetHandler.atlasButtons).findRegion("achievementsBtn"))));
		achievementsBtn = new Button(achievementsBtnStyle);
		achievementsBtn.setPosition(0, view.getWorldHeight()-achievementsBtn.getHeight());
		achievementsBtn.addListener(listener);
	}

	private void createBackgrounds() {
		mainMenuBG = new Image(AssetHandler.manager.get(AssetHandler.mainMenuBG));
		playMenuBG = new Image(AssetHandler.manager.get(AssetHandler.playMenuBG));
		playMenuBG.setScale(scaleX, scaleY);
		mainMenuBG.setScale(scaleX, scaleY);
	}
	
	private void createMainMenu() {
		mainMenu = new WidgetGroup();
		mainMenu.setFillParent(true);
		
//		mainMenu.addActor(mainMenuBG);
		mainMenu.addActor(achievementsBtn);
		mainMenu.addActor(playBtn);
		mainMenu.addActor(aboutBtn);
		mainMenu.addActor(optionsBtn);
		
	}
	
	private void createOptionsMenu() {
		optionsMenu = new WidgetGroup();
		optionsMenu.setFillParent(true);
		
//		optionsMenu.addActor(optionsMenuBG);
		optionsMenu.addActor(backBtnOptions);
		
		optionsMenu.setVisible(false);
	}
	
	private void createScoresMenu() {
		scoresMenu = new WidgetGroup();
		scoresMenu.setFillParent(true);
		
//		scoresMenu.addActor(scoresMenuBG);
		scoresMenu.addActor(backBtnScores);
		
		scoresMenu.setVisible(false);
	}
	
	private void createAboutMenu() {
		aboutMenu = new WidgetGroup();
		aboutMenu.setFillParent(true);
		
//		aboutMenu.addActor(aboutMenuBG);
		aboutMenu.addActor(backBtnAbout);
		
		aboutMenu.setVisible(false);
	}
	
	private void createAchievementsMenu() {
		achievementsMenu = new WidgetGroup();
		achievementsMenu.setFillParent(true);
		
//		achievementsMenu.addActor(achievementsMenuBG);
		achievementsMenu.addActor(backBtnAchievements);
		
		achievementsMenu.setVisible(false);
	}
	
	private void createStoreMenu() {
		storeMenu = new WidgetGroup();
		storeMenu.setFillParent(true);
		
//		storeMenu.addActor(storeMenuBG);
		storeMenu.addActor(backBtnStore);
		
		storeMenu.setVisible(false);
	}
	
	private void createPlayMenu() {
		playMenu = new WidgetGroup();
		playMenu.setFillParent(true);
		
//		playMenu.addActor(playMenuBG);
		playMenu.addActor(backBtnPlay);
		playMenu.addActor(threeBtn);
		playMenu.addActor(twoBtn);
		playMenu.addActor(oneBtn);
		playMenu.addActor(rightArrowBtn);
		playMenu.addActor(leftArrowBtn);
		playMenu.addActor(scoresBtn);
//		playMenu.addActor(storeBtn);
		
		playMenu.setVisible(false);
	}
	
	private void addActors() {
		stage.addActor(mainMenu);
		stage.addActor(optionsMenu);
		stage.addActor(scoresMenu);
		stage.addActor(achievementsMenu);
		stage.addActor(aboutMenu);
		stage.addActor(storeMenu);
		stage.addActor(playMenu);
	}
	private void updateMenu(float delta) {
		stage.act(delta);
		stage.draw();
	}
	
	private void updateScale() {
		scaleX = view.getWorldWidth()/1920;
		scaleY = view.getWorldHeight()/1080;
	}
	
	@Override
	public void render(float delta) {
		//clears the screen
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//updates scale values
		updateScale();
		//updates everything on menu
		updateMenu(delta);
//		mainMenu.drawDebug(stage);
	}
	
	@SuppressWarnings("unused")
	private void animateBtn(Button showBtn, Button hideBtn, float dir) {
		//sets showBtn target to middle of screen
		showBtn.validate();
		hideBtn.validate();
		
		showBtnTargetX=(view.getWorldWidth()/2)-(showBtn.getWidth()/2);
		
		//sets showBtn position and hideBtn target depending on direction of movement
		if(dir==-1) {
			showBtn.setPosition(view.getWorldWidth(),(view.getWorldHeight()/2)-(showBtn.getHeight()/2));
			hideBtnTargetX=-hideBtn.getWidth();
		}
		else if(dir==1) {
			showBtn.setPosition(-showBtn.getWidth(),(view.getWorldHeight()/2)-(showBtn.getHeight()/2));
			hideBtnTargetX=view.getWorldWidth();
		}
		showBtn.setVisible(true);
		
		//hides arrow buttons and unhides them after a delay(after button animations finish)
		rightArrowBtn.addAction(Actions.sequence(Actions.visible(false),Actions.delay(.15f, Actions.visible(true))));
		leftArrowBtn.addAction(Actions.sequence(Actions.visible(false),Actions.delay(.15f, Actions.visible(true))));
		
		//moves showBtn and hideBtn to destinations over a period of time
		showBtn.addAction(Actions.moveTo(showBtnTargetX,(view.getWorldHeight()/2)-(showBtn.getHeight()/2),.12f));
		hideBtn.addAction(Actions.moveTo(hideBtnTargetX, (view.getWorldHeight()/2)-(showBtn.getHeight()/2),.12f));
		//hides and resets hideBtn
		hideBtn.addAction(Actions.delay(.15f,Actions.visible(false)));
		hideBtn.addAction(Actions.delay(.15f,Actions.moveTo((view.getWorldWidth()/2)-(hideBtn.getWidth()/2), (view.getWorldHeight()/2)-(hideBtn.getHeight()/2))));
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
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
				mainMenu.setVisible(false);
				playMenu.setVisible(true);
				
				checkpointNum=3;
			}
			else if(actor==optionsBtn) {
				mainMenu.setVisible(false);
				optionsMenu.setVisible(true);
			}
			else if(actor==backBtnStore) {
				storeMenu.setVisible(false);
				playMenu.setVisible(true);
			}
			else if(actor==backBtnScores) {
				scoresMenu.setVisible(false);
				playMenu.setVisible(true);
			}
			else if(actor==backBtnOptions) {
				optionsMenu.setVisible(false);
				mainMenu.setVisible(true);
			}
			else if(actor==backBtnAchievements) {
				achievementsMenu.setVisible(false);
				mainMenu.setVisible(true);
			}
			else if(actor==backBtnAbout) {
				aboutMenu.setVisible(false);
				mainMenu.setVisible(true);
			}
			else if(actor==backBtnPlay) {
				playMenu.setVisible(false);
				mainMenu.setVisible(true);
			}
			else if(actor==scoresBtn) {
				playMenu.setVisible(false);
				scoresMenu.setVisible(true);
			}
			else if(actor==aboutBtn) {
				mainMenu.setVisible(false);
				aboutMenu.setVisible(true);
			}
			else if(actor==achievementsBtn) {
				mainMenu.setVisible(false);
				achievementsMenu.setVisible(true);
			}
			else if(actor==oneBtn) {
				
			}
			else if(actor==twoBtn) {
				
			}
			else if(actor==threeBtn) {
				game.setScreen(new GameScreen(game));
			}
			else if(actor==rightArrowBtn) {
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
			else if(actor==leftArrowBtn) {
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
