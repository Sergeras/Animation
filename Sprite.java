import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private static BufferedImage spriteSheet;
	
	static public BufferedImage loadSprite (String file) {
		
		BufferedImage sprite = null;
		// get file from root location
		try {
			
			sprite = ImageIO.read(Display.class.getResource(file + ".png"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		spriteSheet = sprite;
		return sprite;
	}
	
	static public BufferedImage getSprite (int xPos, int yPos, int tileSize) {
		
		if (spriteSheet == null) {
			
			spriteSheet = loadSprite("AnimationSpriteSheeet");
			
		} 
			return spriteSheet.getSubimage(xPos , yPos , tileSize, tileSize);
			
	}
	
}//Sprite end
