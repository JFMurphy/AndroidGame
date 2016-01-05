package com.johnmurphy.androidgame;

import com.johnmurphy.framework.Game;
import com.johnmurphy.framework.Graphics;
import com.johnmurphy.framework.Graphics.ImageFormat;
import com.johnmurphy.framework.Screen;
import com.johnmurphy.framework.Image;

public class LoadingScreen extends Screen {
	
	public LoadingScreen (Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		Assets.menu = g.newImage("menu.jpg", ImageFormat.RGB565);
		Assets.click = game.getAudio().createSound("explode.oog");
		
		game.setScreen(new MainMenuScreen(game));
		
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void backButton() {
		// TODO Auto-generated method stub
		
	}
	
	
}
