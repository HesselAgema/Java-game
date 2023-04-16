 package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_seed extends SuperObject {

	GamePanel gp;
	
	public OBJ_seed(GamePanel gp, int worldX, int worldY) {
        this.gp = gp;
        this.worldX = worldX;
        this.worldY = worldY;

        name = "seed";
        try {
            image = ImageIO.read(getClass().getResource("/objects/seed.png")); 
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch(IOException e) {
            e.printStackTrace();
        }

        //solidArea.x = 5;
        //solidArea.y = 48;
    }

}
