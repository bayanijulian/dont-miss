package com.hypetrainstudios.dontmiss;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.hypetrainstudios.dontmiss.handlers.AssetHandler;
import com.hypetrainstudios.dontmiss.screens.PlayScreen;

public class DontMiss extends Game {
	
	private Screen playScreen;
	@Override
	public void create() {
		//loads assets to a queue
		AssetHandler.load();
		//loads it to ram
		AssetHandler.manager.finishLoading();
		AssetHandler.setTextures();
		
		playScreen = new PlayScreen(this);
		setScreen(playScreen);
	}
	
	
}
