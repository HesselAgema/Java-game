package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_chest extends SuperObject {
	
	GamePanel gp;

	public OBJ_chest(GamePanel gp) {
		name = "chest";
		try {
			image = ImageIO.read(getClass().getResource("/objects/chest (OLD).png")); 
			uTool.scaledImage(image, gp.tileSize, gp.tileSize);

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
