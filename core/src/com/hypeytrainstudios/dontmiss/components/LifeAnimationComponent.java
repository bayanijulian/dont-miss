package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;

public class LifeAnimationComponent extends Component{
	public Animation animation;
	public float counter = 0;
	public LifeAnimationComponent(Animation newAnimation){
		animation = newAnimation;
	}
}
