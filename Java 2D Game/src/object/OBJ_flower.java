// OBJ_flower.java
package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_flower extends SuperObject {

    GamePanel gp;

    
    public OBJ_flower(GamePanel gp, int worldX, int worldY) {
        this.gp = gp;
        this.worldX = worldX;
        this.worldY = worldY;
        name = "flower";
        try {
            image = ImageIO.read(getClass().getResource("/objects/flower.png"));
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
