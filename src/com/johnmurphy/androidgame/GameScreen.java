package com.johnmurphy.androidgame;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;

import com.johnmurphy.framework.Game;
import com.johnmurphy.framework.Graphics;
import com.johnmurphy.framework.Image;
import com.johnmurphy.framework.Screen;
import com.johnmurphy.framework.Input.TouchEvent;

public class GameScreen extends Screen {
	
	enum GameState {
		Ready, Running, Paused, GameOver
	}
	
	GameState state = GameState.Ready;
	
	// Variable setup
	// Create game objects here.
	
	int livesLeft = 1;
	Paint paint;
	
	public GameScreen(Game game) {
		super(game);
		
		// Initialize game objects here
		
		// Defining a paint object
		paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.WHITE);
		
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		
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
