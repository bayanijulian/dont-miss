package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.ashley.core.Component;

public class SizeComponent extends Component{
	public float width;
	public float height;
	public SizeComponent(float newWidth, float newHeight){
		width = newWidth;
		height = newHeight;
	}
}
