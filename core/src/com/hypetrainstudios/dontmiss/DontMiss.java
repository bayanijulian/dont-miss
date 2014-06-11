package com.hypetrainstudios.dontmiss;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.hypetrainstudios.dontmiss.screens.PlayScreen;

public class DontMiss extends Game {
	
	private Screen playScreen;
	@Override
	public void create() {
		playScreen = new PlayScreen(this);
		setScreen(playScreen);
	}
	
	
}
