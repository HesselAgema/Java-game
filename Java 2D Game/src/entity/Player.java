package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Sound;
import main.UtilityTool;
import object.OBJ_flower;
import main.GamePanel;
import main.KeyHandler;
import tile.Tile;

public class Player extends Entity {

	KeyHandler keyH;
	Sound sounds;
	//public Inventory inventory;

	
	public final int screenX;
	public final int screenY;
	public int seedsPlanted = 0;
 	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		
		super(gp);// we are calling the constructor of the super class, of this class, and were passing this gp.
		this.keyH = keyH;
		
	    //inventory = new Inventory();

		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		// SET HITBOX CHARACTER 
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.height = 24;
		solidArea.width = 28;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
	
		worldX = gp.tileSize * 23;      // player position in world map
		worldY = gp.tileSize * 21;	   // player position in world map
		speed = 4;
		direction = "down";
		
	}
	
	public void getPlayerImage() {
		
		
		
		up1 = setup("/Player/boy_up_1");
		up2 = setup("/Player/boy_up_2");
		down1 = setup("/Player/boy_down_1");
		down2 = setup("/Player/boy_down_2");
		right1 = setup("/Player/boy_right_1");
		right2 = setup("/Player/boy_right_2");
		left1 = setup("/Player/boy_left_1");
		left2 = setup("/Player/boy_left_2");
	}
	
	
	
	public void update() {
		
		
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed ==true || keyH.rightPressed) {
			
		
			if (keyH.upPressed && keyH.leftPressed) {
			    direction = "up_left";
			}
			else if (keyH.upPressed && keyH.rightPressed) {
			    direction = "up_right";
			}
			else if (keyH.downPressed && keyH.leftPressed) {
			    direction = "down_left";
			}
			else if (keyH.downPressed && keyH.rightPressed) {
			    direction = "down_right";
			}
			else if (keyH.upPressed) {
			    direction = "up";
			}
			else if (keyH.downPressed) {
			    direction = "down";
			}
			else if (keyH.leftPressed) {
			    direction = "left";
			}
			else if (keyH.rightPressed) {
			    direction = "right";
			}

		
		// CHECK TILE COLISSION
		colissionOn = false;
		gp.cChecker.checkTile(this);
		
		
		
		// CHECK OBJECT COLISSION
		int objIndex = gp.cChecker.checkObject(this, true);
		pickUpObject(objIndex);
		
		// CHECK NPC COLISSION
		int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
		interactNpc(npcIndex);
		
		// IF COLISSION IS FALSE, PLAYER CAN MOVE
		if(colissionOn == false) {
				
			switch (direction) {
		    case "up": worldY -= speed; break;
		    case "down": worldY += speed; break;
		    case "left": worldX -= speed; break;
		    case "right": worldX += speed; break;
		    case "up_right": worldX += speed / Math.sqrt(2); worldY -= speed / Math.sqrt(2); break;
		    case "up_left": worldX -= speed / Math.sqrt(2); worldY -= speed / Math.sqrt(2); break;
		    case "down_right": worldX += speed / Math.sqrt(2); worldY += speed / Math.sqrt(2); break;
		    case "down_left": worldX -= speed / Math.sqrt(2); worldY += speed / Math.sqrt(2); break;
		}
			
		}
		
		
		
		spriteCounter++;
		if (spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if (spriteNum == 2) {
				spriteNum =1;
			}
			spriteCounter = 0;
		}
	}
	}	
		
	
	
	

	public void pickUpObject(int i) {
		if(i != 999) {
			
		}
	}
	
	public void placeBlock(int i) {
			int playerTileX = (worldX + gp.tileSize / 2) / gp.tileSize;
			int playerTileY = (worldY + gp.tileSize / 2) / gp.tileSize;
	        //int tiledDirtTileIndex = 1; // assuming you have added the "tiled dirt" tile as index 6
	        gp.tileM.setTile(playerTileX, playerTileY, i);
	        System.out.println("setting block!\n");
	}
	
	private void interactNpc(int npcIndex) {

		if(npcIndex != 999) {
			if(gp.keyH.enterPressed == true) {
				gp.gameState = gp.dialogueState;
				gp.npc[npcIndex].speak();
			}
			
		}
		gp.keyH.enterPressed = false;
	}
	
	public void harvest() {
        // Loop through all objects
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null && gp.obj[i] instanceof OBJ_flower) {
                // Check if the player is close enough to the flower (e.g., within one tile)
                if (Math.abs(gp.obj[i].worldX - worldX) <= gp.tileSize &&
                    Math.abs(gp.obj[i].worldY - worldY) <= gp.tileSize) {
                    // Harvest the flower
                    //inventory.addFlower();
                    gp.inventory.flowerCount++;
                    // Remove the flower object (or replace it with an empty space)
                    gp.obj[i] = null;
                    int playerTileX = (gp.Player.worldX + gp.tileSize / 2) / gp.tileSize;
    				int playerTileY = (gp.Player.worldY + gp.tileSize / 2) / gp.tileSize;
                    gp.tileM.seedsPlanted[playerTileX][playerTileY] = 0;
                    
                    // Optional: play a sound effect or show an animation
                    
                    // If you want to stop at the first harvested flower, add a break statement
                    break;
                }
            }
        }
	}
	
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			else if(spriteNum == 2) {
				image = up2;
			}
			
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			else if(spriteNum == 2) {
				image= down2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			 
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			
			break;
		}
		
		g2.drawImage(image,screenX, screenY, null); 
		
			
		
		
	}
}
