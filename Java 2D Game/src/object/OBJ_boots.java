package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_boots extends SuperObject {

	GamePanel gp;
	
	public OBJ_boots(GamePanel gp) {
		name = "boots";
		try {
			image = ImageIO.read(getClass().getResource("/objects/boots.png")); 
			uTool.scaledImage(image, gp.tileSize, gp.tileSize);

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
