package com.hypetrainstudios.dontmiss.challenges;

public abstract class Challenge {
	protected boolean active;
	public static int codeDefault = 0;
	public static int codeCollision = 1;
	public static int codeMiss = 2;
	public static int currentCode = 0;
	public abstract void update();
}
