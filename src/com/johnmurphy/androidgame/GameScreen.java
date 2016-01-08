package com.johnmurphy.androidgame;

import java.util.List;

import com.johnmurphy.framework.Game;
import com.johnmurphy.framework.Graphics;
import com.johnmurphy.framework.Input.TouchEvent;
import com.johnmurphy.framework.Screen;

import android.graphics.Color;
import android.graphics.Paint;

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

	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {

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

	private void updatePaused(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {

			}
		}
	}

	private void updateGameOver(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (event.x > 300 && event.x < 980 && event.y > 100 && event.y < 500) {
					nullify();
					game.setScreen(new MainMenuScreen(game));
					return;
				}
			}
		}
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();

		// First draw the game elements.

		// Example:
		// g.drawImage(Assets.background, 0, 0);
		// g.drawImage(Assets.character, characterX, characterY);

		// Secondly, draw the UI above the game elements.
		if (state == GameState.Ready)
			drawReadyUI();
		if (state == GameState.Running)
			drawRunningUI();
		if (state == GameState.Paused)
			drawPausedUI();
		if (state == GameState.GameOver)
			drawGameOverUI();
	}

	private void nullify() {
		// Set all variables to null. You will be recreating them in the
		// constructor.

		paint = null;

		// Call garbage collector to clean up memory.
		System.gc();
	}

	private void drawReadyUI() {
		Graphics g = game.getGraphics();

		g.drawARGB(155, 0, 0, 0);
		g.drawString("Tap each side of the screen to move in that direction", 640, 300, paint);

	}

	private void drawRunningUI() {
		Graphics g = game.getGraphics();
	}

	private void drawPausedUI() {
		Graphics g = game.getGraphics();

		// Darken the screen so you can display the paused screen.
		g.drawARGB(155, 0, 0, 0);
	}

	private void drawGameOverUI() {
		Graphics g = game.getGraphics();
		g.drawRect(0, 0, 1281, 801, Color.BLACK);
		g.drawString("GAME OVER", 640, 300, paint);
	}

	@Override
	public void pause() {
		if (state == GameState.Running)
			state = GameState.Paused;
	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void backButton() {
		pause();
	}

}
