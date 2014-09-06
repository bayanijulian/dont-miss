package com.hypeytrainstudios.dontmiss.components;

import com.badlogic.ashley.core.Component;

public class StateComponent extends Component{
	public static final int ACTIVE = 0;
	public static final int INACTIVE = 1;
	public int state = ACTIVE;
}
