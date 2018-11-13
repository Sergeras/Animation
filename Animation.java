/* 	Animation class that allow you to manipulate the animation used. It is supposed to be used for changing the
*	animation properties or order of frames in animation.
*/
import java.awt.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Animation extends Sprite {
	
	private int frameDelay;		//Delay between frames
	private int totalFrame = 1;	//Total amount of frames in animation
	private boolean running;	//To use for looping the animation
	
	// Place to store all frames/images
	private java.util.List<Frame> frames = new ArrayList<Frame>();
	
	//TODO method for making background invisible/ignored
	//TODO method for loading animation in Y axis
	public Animation () {
	}
	
	//Load specified amount the pictures from specified position on X axis, with 0 duration
	public void loadAnimation(int xPos, int yPos, int tileSize, int numberOfImages) {
		//Add the frames to array in a order so it can be played later
		for (int i = 1; i < numberOfImages; i++) {
			frames.add(new Frame (getSprite((xPos * i), yPos, tileSize),0));
			this.totalFrame += 1;
		}
	}
	
	//Load specified amount the pictures from specified position on X axis, with specified duration
	public void loadAnimation(int xPos, int yPos, int tileSize, int numberOfImages, int duration) {
		//Add the frames to array in a order so it can be played later
		for (int i = 1; i < numberOfImages; i++) {
			frames.add(new Frame (getSprite((xPos * i), yPos, tileSize),duration));
			this.totalFrame += 1;
		}
	}
	// allows to add frame at specified position
	public void addFrame (Frame frame, int framePosition) {
		frames.add(framePosition, frame);
	}
	
	// allows to change the frames in the animation as needed
	public void setFrame (Frame frame, int framePosition) {
		frames.set(framePosition, frame);
	}
	// return specific frame/image/sprite
	public BufferedImage getFrame (int i) {
		return frames.get(i).getFrame();
	}
	// allow to get duration for a specific frame
	public int getDuration (int i) {
		return frames.get(i).getDuration();
	}
	// set duration for a specific frame
	public void setDuration (int i, int duration) {
		frames.get(i).setDuration(duration);
	}
	// set duration for all the frames
	public void setDuration (int duration) {
		for (int i = 0; i < frames.size(); i++) {
			frames.get(i).setDuration(duration);
		}
	}
	// allows to set frame delay between animation frames
	public void setFrameDelay (int delay) {
		frameDelay = delay;
	}
	// return FrameDelay
	public int getFrameDelay () {
		return frameDelay;
	}
	// return the amount of pictures in animation
	public int getTotalFrame () {
		return totalFrame;
	}
	// return check for loop
	public boolean getRunning () {
		return running;
	}
	// allows to turn on/off loop
	public void setRunning(boolean running) {
		this.running = running;
	}
	
}//Animation end

