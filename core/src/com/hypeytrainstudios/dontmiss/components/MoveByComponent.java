package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class MoveByComponent extends Component{
	//magnitude and direction
	public Vector2 velocity;
	
	public MoveByComponent(Vector2 newVelocity){
		velocity = newVelocity;
	}
	public MoveByComponent(float x,float y){
		velocity = new Vector2(x,y);
	}
	
}
