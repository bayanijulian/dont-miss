package com.hypetrainstudios.dontmiss.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class PlayScreen implements Screen {
	private Game game;
	
	private boolean running;
	
	public PlayScreen(Game game)
	{
		this.game = game;
		running = true;
	}

	@Override
	public void render(float delta) {
		while(running){
			
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

}
