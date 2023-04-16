 package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_key extends SuperObject {

	GamePanel gp;
	
	public OBJ_key(GamePanel gp) {
		name = "key";
		try {
			image = ImageIO.read(getClass().getResource("/objects/key.png")); 
			uTool.scaledImage(image, gp.tileSize, gp.tileSize);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//solidArea.x = 5;
		//solidArea.y = 48;	
	}
}
