package com.hypetrainstudios.dontmiss.entity;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

public class Entity extends Actor{
	
	Action act;
	public Entity(){
		
		act = new MoveToAction();
		
	}
}
