package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class VisualComponent extends Component{
	public Sprite visual;
	public VisualComponent(Sprite newVisual){
		visual = newVisual;
	}
	public VisualComponent(TextureRegion texture){
		visual = new Sprite(texture);
	}
}
