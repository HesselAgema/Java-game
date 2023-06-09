package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;



public class TileManager { 
	
	GamePanel gp;
	public Tile[] Tile;
	public int mapTileNum[][];
	public int[][] seedsPlanted;
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		
		Tile = new Tile[10]; 
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		seedsPlanted = new int[gp.maxWorldCol][gp.maxWorldRow];
		getTileImage();
		loadMap("/maps/world01.txt");
	}
	
	public void getTileImage() {
		
			setup(0, "grass01", false);
			setup(1, "wall", false);
			setup(2, "water01", true);
			setup(3, "earth", false);
			setup(4, "tree", true);
			setup(5, "sand", false);
			setup(6, "tiled dirt", false);
			
			

			
		
	}
	
	
	public void setup(int index, String imageName, boolean colission) {
		UtilityTool uTool = new UtilityTool();
		
		try {
			Tile[index] = new Tile(); 
			Tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
			Tile[index].image = uTool.scaledImage(Tile[index].image, gp.tileSize, gp.tileSize);
			Tile[index].colission = colission;
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filePath) {
		
		try {
		InputStream is = getClass().getResourceAsStream(filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		int col = 0;
		int row = 0;
		
		while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String []numbers = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col =0;
					row++;
				}
				
			} 
		br.close();
			
			
			
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
	
	public void setTile(int x, int y, int tileIndex) {
	    if (x >= 0 && x < gp.maxWorldCol && y >= 0 && y < gp.maxWorldRow) {
	        mapTileNum[x][y] = tileIndex;
	    }
	}
	
	
	public void draw(Graphics2D g2) {
		
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			
			int screenX = worldX - gp.Player.worldX + gp.Player.screenX;
			int screenY = worldY - gp.Player.worldY + gp.Player.screenY;
			
			if(worldX + gp.tileSize> gp.Player.worldX - gp.Player.screenX &&
			   worldX - gp.tileSize< gp.Player.worldX + gp.Player.screenX &&
			   worldY + gp.tileSize > gp.Player.worldY - gp.Player.screenY &&
			   worldY - gp.tileSize < gp.Player.worldY + gp.Player.screenY) {
				
				g2.drawImage(Tile[tileNum].image , screenX, screenY, null);

			}
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
				}
			
		}
		
		
		
		
		
	}

}
