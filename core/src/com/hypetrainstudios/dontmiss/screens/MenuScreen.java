package com.hypetrainstudios.dontmiss.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
	
	private static Button playBtn, optionsBtn, rightArrowBtn, leftArrowBtn, oneBtn, twoBtn, threeBtn, backBtn, scoresBtn, showBtn=new Button(), hideBtn=new Button();
	private static ButtonStyle playBtnStyle, optionsBtnStyle, rightArrowBtnStyle, leftArrowBtnStyle, oneBtnStyle, twoBtnStyle, threeBtnStyle, backBtnStyle, scoresBtnStyle;
	private static Listener listener;
	
	private static Image mainMenuBackground, playMenuBackground;
	
	private static boolean mainMenu, showBtnAtDestination=false, hideBtnAtDestination=false, animationActivated=false;
	private float runShow, runHide, dir, checkpointNum, showBtnTargetX, hideBtnTargetX, btnSpeed=25;
	
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
		createButtons();
		
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

	private void updateMenu() {
		stage.act();
		stage.draw();
	}
	
	@Override
	public void render(float delta) {
		//clears the screen
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//updates button's movement if the animation is activated
		updateBtnAnimation(delta);
		//updates everything on menu
		updateMenu();
	}
	
	private void startBtnAnimation(Button newShowBtn, Button newHideBtn, float newDirection) {
		showBtnAtDestination=false;
		hideBtnAtDestination=false;
		dir=newDirection;
		showBtn=newShowBtn;
		hideBtn=newHideBtn;
		//checks for movement direction of button being moved onto screen to set starting position for animation
		if(dir==-1) {
			showBtn.setPosition(Gdx.graphics.getWidth(),(Gdx.graphics.getHeight()/2)-(showBtn.getHeight()/2));
		}
		else if(dir==1) {
			showBtn.setPosition(-showBtn.getWidth(),(Gdx.graphics.getHeight()/2)-(showBtn.getHeight()/2));
		}
		
		showBtn.setVisible(true);
		rightArrowBtn.setVisible(false);
		leftArrowBtn.setVisible(false);
		showBtnTargetX=(Gdx.graphics.getWidth()/2)-(showBtn.getWidth()/2);
		//checks movement direction of button being moved off screen to set its destination
		if(dir==-1) {
			hideBtnTargetX=-hideBtn.getWidth();
		}
		else if(dir==1) {
			hideBtnTargetX=Gdx.graphics.getWidth();
		}
		//sets the animation to active
		animationActivated=true;
	}
	
	private void updateBtnAnimation(float delta) {
		//checks if the animation is active
		if(animationActivated==false)
			return;
		//finishes animation if buttons at destinations
		if(showBtnAtDestination && hideBtnAtDestination) {
			rightArrowBtn.setVisible(true);
			leftArrowBtn.setVisible(true);
			animationActivated=false;
			return;
		}
		
		if(hideBtnAtDestination==false) {
			//checks if the button being moved off screen is 1 pixel away from its destination to speed up movement at the end of animation
			if(Math.abs(hideBtn.getX()-hideBtnTargetX)<=1) {
				hideBtn.moveBy((hideBtn.getX()-hideBtnTargetX)*-1,0);
			}
			//moves button being moved off screen for each frame using delta
			else {
				runHide=((hideBtn.getX()-hideBtnTargetX)*btnSpeed);
				hideBtn.moveBy(runHide*delta*-1,0);
			}
		}
		
		if(showBtnAtDestination==false) {
			//checks if the button being moved onto screen is 1 pixel away from its destination to speed up movement at the end of animation
			if(Math.abs(showBtn.getX()-showBtnTargetX)<=1) {
				showBtn.moveBy((showBtn.getX()-showBtnTargetX)*-1,0);
			}
			//moves button being moved into screen for each frame using delta
			else {
				runShow=((showBtn.getX()-showBtnTargetX)*btnSpeed);
				showBtn.moveBy(runShow*delta*-1,0);
			}
		}
		//checks if button being moved onto screen is at destination
		if(showBtn.getX()==showBtnTargetX) {
			showBtnAtDestination=true;
		}
		//checks if button being moved off screen is at destination
		if(hideBtn.getX()==hideBtnTargetX) {
			hideBtnAtDestination=true;
			hideBtn.setVisible(false);
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
						startBtnAnimation(twoBtn,threeBtn,-1);
						checkpointNum=2;
					}
					else if(checkpointNum==2) {
						startBtnAnimation(oneBtn,twoBtn,-1);
						checkpointNum=1;
					}
					else {
						startBtnAnimation(threeBtn,oneBtn,-1);
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
						startBtnAnimation(threeBtn,twoBtn,1);
						checkpointNum=3;
					}
					else if(checkpointNum==1) {
						startBtnAnimation(twoBtn,oneBtn,1);
						checkpointNum=2;
					}
					else {
						startBtnAnimation(oneBtn,threeBtn,1);
						checkpointNum=1;
					}
				}
			}
		}
	}
}
