package com.hypetrainstudios.dontmiss;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.screens.MenuScreen;

public class DontMiss extends Game {
	
	private Screen menuScreen;
	@Override
	public void create() {
		//loads assets to a queue
		AssetHandler.load();
		//loads it to ram
		AssetHandler.manager.finishLoading();
		AssetHandler.setTextures();
		
		menuScreen = new MenuScreen(this);
		setScreen(menuScreen);
	}
	
	
}
