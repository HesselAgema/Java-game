 package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.AssetSetter;
import main.GamePanel;

public class OBJ_seed extends SuperObject {

	GamePanel gp;
	public long growthTime;
    public long timePlanted;
    AssetSetter assetSetter;

	
	public OBJ_seed(GamePanel gp, int worldX, int worldY, AssetSetter assetSetter) {
        this.gp = gp;
        this.worldX = worldX;
        this.worldY = worldY;
        this.assetSetter = assetSetter;

        growthTime = 3000; // Set growth time in milliseconds (e.g., 5000ms = 5 seconds)
        timePlanted = System.currentTimeMillis();

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
	
	public void update() {
	    long timeElapsed = System.currentTimeMillis() - timePlanted;

	    if (timeElapsed >= growthTime) {
	    	OBJ_sprout sprout = new OBJ_sprout(gp, worldX, worldY);
	    	//sprout.worldX = worldX;
	        //sprout.worldY = worldY;

	        // Find the seed object index
	        int seedIndex = -1;
	        for (int i = 0; i < gp.obj.length; i++) {
	            if (gp.obj[i] == this) {
	                seedIndex = i;
	                break;
	            }
	        }

	        if (seedIndex != -1) {
	            assetSetter.setSproutObject(seedIndex, worldX, worldY);
	        }
	    }
	}

}
