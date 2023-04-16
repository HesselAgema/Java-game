 package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_hamburger extends SuperObject {

	GamePanel gp;
	
	public OBJ_hamburger(GamePanel gp) {
		name = "hamburger";
		try {
			image = ImageIO.read(getClass().getResource("/objects/hamburger.png")); 
			uTool.scaledImage(image, gp.tileSize, gp.tileSize);

		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//solidArea.x = 5;
		//solidArea.y = 48;
	}
}
