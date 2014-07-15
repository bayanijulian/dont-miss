package com.hypetrainstudios.dontmiss.handlers;


import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.hypetrainstudios.dontmiss.Creator;

public class GameInputHandler implements InputProcessor{

	@Override
	public boolean keyDown(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.A)	log();
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		Creator.createProjectile();
		
		/* Debugging Comments */
		log();
		/* Debugging Comments */
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		
		return false;
	}
	/* Debugging Comments */
	private void log(){
		System.out.println("Fire Rate:\t" + Creator.fireRate);
		System.out.println("Number Of Projectiles Left\t" + Creator.totalProjectiles);
		System.out.println("active bonus is" + BonusHandler.activeBonus);
	}
	/* Debugging Comments */

}
