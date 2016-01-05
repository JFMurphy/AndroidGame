package com.johnmurphy.androidgame;

import com.johnmurphy.framework.Screen;
import com.johnmurphy.framework.implementation.AndroidGame;

public class SampleGame extends AndroidGame {

	@Override
	public Screen getInitScreen() {
		return new LoadingScreen(this);
	}
	
	@Override
	public void onBackPressed() {
		getCurrentScreen().backButton();
	}
	
	
}
