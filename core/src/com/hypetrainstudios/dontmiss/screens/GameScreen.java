package com.hypetrainstudios.dontmiss.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.hypetrainstudios.dontmiss.DontMiss;
import com.hypetrainstudios.dontmiss.handlers.EntityHandler;

public class GameScreen implements Screen{

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		EntityHandler.update(delta);
		EntityHandler.draw(DontMiss.renderer);
	
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(DontMiss.turret);
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
