package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_sprout extends SuperObject {

    GamePanel gp;
    public long growthTime;
    public long timePlanted;

    public OBJ_sprout(GamePanel gp, int worldX, int worldY) {
        this.gp = gp;
        this.worldX = worldX;
        this.worldY = worldY;
        
        growthTime = 3000; // Set growth time in milliseconds (e.g., 10000ms = 10 seconds)
        timePlanted = System.currentTimeMillis();

        name = "sprout";
        try {
            image = ImageIO.read(getClass().getResource("/objects/sprout.png"));
            uTool.scaledImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //solidArea.x = 5;
        //solidArea.y = 48;
    }
    
 // OBJ_sprout.java
    @Override
    public void update() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - timePlanted > growthTime) {
            // Replace the sprout with a flower
            OBJ_flower flower = new OBJ_flower(gp, worldX, worldY);

            // Find the sprout object index
            int sproutIndex = -1;
            for (int i = 0; i < gp.obj.length; i++) {
                if (gp.obj[i] == this) {
                    sproutIndex = i;
                    break;
                }
            }

            if (sproutIndex != -1) {
                gp.obj[sproutIndex] = flower;
            }
        }
    }

    
    
}
