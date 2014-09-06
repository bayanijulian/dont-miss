package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.ashley.core.Component;

public class CoordinatesComponent extends Component{
	public int counter = 0;
	public boolean loop;
	public float coordinatesX[];
	public float coordinatesY[];
	public CoordinatesComponent(float [] newCoordinatesX, float [] newCoordinatesY, boolean newLoop){
		coordinatesX = newCoordinatesX;
		coordinatesY = newCoordinatesY;
		loop = newLoop;
	}
}
