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
		//loads queue to ram
		AssetHandler.manager.finishLoading();
		//sets textures for individual pictures
		AssetHandler.setTextures();
		//creates the main menu for the game
		menuScreen = new MenuScreen(this);
		//sets screen to the main menu
		setScreen(menuScreen);
	}
	
	
}
