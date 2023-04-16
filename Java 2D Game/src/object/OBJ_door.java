package object;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_door extends SuperObject {

	GamePanel gp;
	
	public OBJ_door(GamePanel gp) {
		name = "door";
		try {
			image = ImageIO.read(getClass().getResource("/objects/door.png")); 
			uTool.scaledImage(image, gp.tileSize, gp.tileSize);

		}catch(IOException e) {
			e.printStackTrace();
		}
		
		colission = true;
	}
}
