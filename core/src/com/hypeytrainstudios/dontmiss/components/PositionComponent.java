package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class PositionComponent extends Component{
	public Vector2 position;
	
	public PositionComponent(Vector2 newPostion){
		position = newPostion;
	}
	public PositionComponent(float x, float y){
		position = new Vector2(x,y);
	}
}
