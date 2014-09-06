package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.ashley.core.Component;

public class MoveToComponent extends Component{
	
	public float duration;
	public float time = 0;
	public float startX;
	public float endX;
	public float startY;
	public float endY;
	public float speed;
	
	public MoveToComponent(float newDuration,float newStartX,float newEndX,float newStartY, float newEndY, float newSpeed){
		duration = newDuration;
		startX = newStartX;
		endX = newEndX;
		startY = newStartY;
		endY = newEndY;
		speed = newSpeed;
	}
}
