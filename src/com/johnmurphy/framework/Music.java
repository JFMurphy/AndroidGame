package com.johnmurphy.framework;

public interface Music {
	public void play();
	
	public void stop();
	
	public void pause();
	
	public void setLooping(boolean looping);
	
	public void setVolume(float volume);
	
	public void isPlaying();
	
	public void isStopped();
	
	public void isLooping();
	
	public void dispose();
	
	void seekBegin();

}
