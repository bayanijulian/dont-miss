package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.ashley.core.Component;

public class RotatationComponent extends Component{
	public float rotationSpeed;
	public float rotationCounter;
	public RotatationComponent(float newRotationSpeed){
		rotationSpeed = newRotationSpeed;
	}
}
