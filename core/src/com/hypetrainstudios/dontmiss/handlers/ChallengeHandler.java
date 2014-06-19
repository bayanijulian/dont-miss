package com.hypetrainstudios.dontmiss.handlers;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.FrostChallenge;
import com.hypetrainstudios.dontmiss.challenges.ReverseRotationChallenge;



public class ChallengeHandler {
	
	private static int challengeCounter = 0;
	private static boolean frost = false;
	private static boolean reverseRotation =false;
	public static void update(float time){
		if(time<=180&&challengeCounter==0){
			challengeCounter++;
			frost = true;
			if(challengeCounter==1&&frost) {
				Creator.challenges.add(new FrostChallenge()); 
				frost = false;
			}
		}
		if(time<=165&&challengeCounter==1){
			challengeCounter++;
			reverseRotation = true;
			if(challengeCounter==2 && reverseRotation){
				Creator.challenges.add(new ReverseRotationChallenge());
				reverseRotation = false;
			}
		}
		
	}
}
