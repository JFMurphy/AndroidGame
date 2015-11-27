package com.johnmurphy.framework;

public interface Game {
	public Audio getAudio();

	public Input getInput();

	public FileIO getFileIo();

	public Graphics getGraphics();

	public void setScreen(Screen screen);

	public Screen getCurrentScreen();

	public Screen getInitScreen();
}
