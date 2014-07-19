package com.hypetrainstudios.dontmiss.handlers;

import com.hypetrainstudios.dontmiss.Creator;
import com.hypetrainstudios.dontmiss.challenges.ColorMatchChallenge;
import com.hypetrainstudios.dontmiss.challenges.DisappearingEnemyChallenge;
import com.hypetrainstudios.dontmiss.challenges.DisappearingPlayerChallenge;
import com.hypetrainstudios.dontmiss.challenges.FrostChallenge;
import com.hypetrainstudios.dontmiss.challenges.IncreasingDifficultyChallenge;
import com.hypetrainstudios.dontmiss.challenges.LimitedProjeciltesChallenge;
import com.hypetrainstudios.dontmiss.challenges.ReverseRotationChallenge;
import com.hypetrainstudios.dontmiss.challenges.ReverseShootingChallenge;





public class ChallengeHandler {
	
	public static int challengeCounter = 0;
	private static boolean frost = false;
	private static boolean reverseRotation = false;
	private static boolean disappearingPlayer = false;
	private static boolean limitedProjectiles = false;
	private static boolean reverseShooting = false;
	private static boolean increasingDifficulty = false;
	private static String message = "";
	public static void update(float time){
		if(time<=180&&challengeCounter==0){
			challengeCounter++;
			frost = true;
			if(challengeCounter==1&&frost) {
				//Creator.challenges.add(new ColorMatchChallenge());
				//Creator.challenges.add(new FrostChallenge()); 
				//Creator.challenges.add(new DisappearingEnemyChallenge()); 
				//Creator.challenges.add(new SuperSpeedChallenge());
				frost = false;
				message="Challenge: Frost";
				InGameUIHandler.updateChallengeLbl(message);
			}
		}
		if(time<=165&&challengeCounter==1){
			challengeCounter++;
			reverseRotation = true;
			if(challengeCounter==2 && reverseRotation){
				Creator.challenges.add(new ReverseRotationChallenge());
				reverseRotation = false;
				message="Challenge: The ol' Switcheroo";
				InGameUIHandler.updateChallengeLbl(message);
			}
		}
		if(time<=150&&challengeCounter==2){
			challengeCounter++;
			disappearingPlayer = true;
			if(challengeCounter==3 && disappearingPlayer){
				Creator.challenges.add(new DisappearingPlayerChallenge());
				disappearingPlayer = false;
				message="Challenge: Where'd he go?";
				InGameUIHandler.updateChallengeLbl(message);
			}
		}
		if(time<=135&&challengeCounter==3){
			challengeCounter++;
			limitedProjectiles = true;
			if(challengeCounter==4&&limitedProjectiles){
				Creator.challenges.add(new LimitedProjeciltesChallenge());
				limitedProjectiles = false;
				message="Challenge: Running Low";
				InGameUIHandler.updateChallengeLbl(message);
			}
		}
		if(time<=120&&challengeCounter==4){
			challengeCounter++;
			increasingDifficulty = true;
			if(challengeCounter==5&&increasingDifficulty){
				Creator.challenges.add(new IncreasingDifficultyChallenge());
				increasingDifficulty = false;
				message="Challenge: Damn, did it get harder?";
				InGameUIHandler.updateChallengeLbl(message);
			}
		}
		if(time<=105&&challengeCounter==5){
			challengeCounter++;
			reverseShooting = true;
			if(challengeCounter==6&&reverseShooting){
				Creator.challenges.add(new ReverseShootingChallenge());
				reverseShooting = false;
				message="Challenge: Malfunction";
				InGameUIHandler.updateChallengeLbl(message);
			}
		}
		
		
	}
}
