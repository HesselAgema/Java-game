package object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.UtilityTool;
import main.GamePanel;

public class SuperObject {

	
	public BufferedImage image;
	public String name;
	public boolean colission = false;
	public int worldX,worldY;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public int solidDefaultAreaX = 0;
	public int solidDefaultAreaY = 0;
	UtilityTool uTool = new UtilityTool();
	
	
	public void draw(Graphics g2, GamePanel gp) {
		
		
		
		int screenX = worldX - gp.Player.worldX + gp.Player.screenX;
		int screenY = worldY - gp.Player.worldY + gp.Player.screenY;
		
		if(worldX + gp.tileSize> gp.Player.worldX - gp.Player.screenX &&
		   worldX - gp.tileSize< gp.Player.worldX + gp.Player.screenX &&
		   worldY + gp.tileSize > gp.Player.worldY - gp.Player.screenY &&
		   worldY - gp.tileSize < gp.Player.worldY + gp.Player.screenY) {
			
			g2.drawImage(image , screenX, screenY, gp.tileSize, gp.tileSize, null);

		}
		
		
	}
}
