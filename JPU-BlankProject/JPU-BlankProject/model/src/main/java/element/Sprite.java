package element;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	private String spritePath;
	 private Image   image;
		
	public Sprite(String spritePath){
		this.setSprite(spritePath);
		try {
			this.setImage(ImageIO.read(getClass().getResource(spritePath)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String getSprite() {
		return spritePath;
	}

	public void setSprite(String spritePath) {
		this.spritePath = spritePath;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}
