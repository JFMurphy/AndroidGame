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
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		
		// We have four seperate update methods in this example.
		// Depending on the state of the game, we call different update methods.
		// Refer to unit 3's code. We did a similar thing without separating the
		// update methods.
		
		if (state == GameState.Ready)
			updateReady(touchEvents);
		if (state == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if (state == GameState.Paused)
			updatePaused(touchEvents);
		if (state == GameState.GameOver)
			updateGameOver(touchEvents);
	}
	
	private void updateReady(List<TouchEvent> touchEvents) {
		
		// This examoke starts with a "Ready" screen.
		// When the user touched the screen, the game begins.
		// state now becomes GameState.Running.
		// Now the updateRunning() method will be called!
		
		if (touchEvents.size() > 0)
			state = GameState.Running;
	}
	
	private void updateRunning (List<TouchEvent> touchEvents, float deltaTime) {
		
		// This is identical to the update() method from the Unit 2/3 game.
		
		// 1. All touch input is handled here.
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (event.x < 640) {
					// Move left.
				} else if (event.x > 640) {
					// Move Right.
				}
			}
			
			if (event.type == TouchEvent.TOUCH_UP) {
				if (event.x < 640) {
					// Stop moving left.
				} else if (event.x > 640) {
					// Stop moving right.
				}
			}
			
			// 2. Check miscellaneous events like death.
			if (livesLeft == 0) {
				state = GameState.GameOver;
			}
			
			// 3. Call individual update methods here.
			// This is where all the game updates happen.
			// For example, robot.update();
			
		}
	}
	
	private void updatePaused (List<TouchEvent> touchEvents) {
		
	}
	
	private void updateGameOver (List<TouchEvent> touchEvents) {
		
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
