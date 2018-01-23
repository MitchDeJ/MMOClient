package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AssetManager {

	public static BufferedImage loadImage(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(AssetManager.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
}
