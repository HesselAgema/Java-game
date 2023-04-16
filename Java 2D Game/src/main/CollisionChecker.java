package main;

import entity.Entity;

public class CollisionChecker {

	GamePanel gp;

	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}

	public void checkTile(Entity entity, String text) {
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;
		
		int tileNum1, tileNum2, tileNum3, tileNum4;
	    int topLeftTileX, topLeftTileY, topRightTileX, topRightTileY, bottomLeftTileX, bottomLeftTileY, bottomRightTileX, bottomRightTileY;


		switch(entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			if(gp.tileM.Tile[tileNum1].colission == true || gp.tileM.Tile[tileNum2].colission == true ) {
				entity.colissionOn = true;
			}
			
			break;
		case "up_left":
		    int diagonalX = (int) Math.ceil(entity.speed / Math.sqrt(2));
		    int diagonalY = (int) Math.ceil(entity.speed / Math.sqrt(2));
		    entityTopRow = (entityTopWorldY - diagonalY) / gp.tileSize;
		    entityLeftCol = (entityLeftWorldX - diagonalX) / gp.tileSize;
		    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
		    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
		    tileNum3 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
		    tileNum4 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
		    if (gp.tileM.Tile[tileNum1].colission == true || gp.tileM.Tile[tileNum2].colission == true || gp.tileM.Tile[tileNum3].colission == true || gp.tileM.Tile[tileNum4].colission == true) {
		        entity.colissionOn = true;
		    }
		    break;
		case "up_right":
		    int diagonalX2 = (int) Math.ceil(entity.speed / Math.sqrt(2));
		    int diagonalY2 = (int) Math.ceil(entity.speed / Math.sqrt(2));
		    entityTopRow = (entityTopWorldY - diagonalY2) / gp.tileSize;
		    entityRightCol = (entityRightWorldX + diagonalX2) / gp.tileSize;
		    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
		    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
		    tileNum3 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
		    tileNum4 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
		    if (gp.tileM.Tile[tileNum1].colission == true || gp.tileM.Tile[tileNum2].colission == true || gp.tileM.Tile[tileNum3].colission == true || gp.tileM.Tile[tileNum4].colission == true) {
		        entity.colissionOn = true;
		    }
		    break;
		case "down_right":
		    int diagonalX3 = (int) Math.ceil(entity.speed / Math.sqrt(2));
		    int diagonalY3 = (int) Math.ceil(entity.speed / Math.sqrt(2));
		    entityBottomRow = (entityBottomWorldY + diagonalY3) / gp.tileSize;
		    entityRightCol = (entityRightWorldX + diagonalX3) / gp.tileSize;
		    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
		    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
		    tileNum3 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
		    tileNum4 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
		    if (gp.tileM.Tile[tileNum1].colission == true || gp.tileM.Tile[tileNum2].colission == true || gp.tileM.Tile[tileNum3].colission == true || gp.tileM.Tile[tileNum4].colission == true) {
		        entity.colissionOn = true;
		    }
		    break;
		case "down_left":
		    int diagonalX4 = (int) Math.ceil(entity.speed / Math.sqrt(2));
		    int diagonalY4 = (int) Math.ceil(entity.speed / Math.sqrt(2));
		    entityBottomRow = (entityBottomWorldY + diagonalY4) / gp.tileSize;
		    entityLeftCol = (entityLeftWorldX - diagonalX4) / gp.tileSize;
		    tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
		    tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
		    tileNum3 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
		    tileNum4 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
		    if (gp.tileM.Tile[tileNum1].colission == true || gp.tileM.Tile[tileNum2].colission == true || gp.tileM.Tile[tileNum3].colission == true || gp.tileM.Tile[tileNum4].colission == true) {
		        entity.colissionOn = true;
		    }
		    break;
				case "down":
			entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.Tile[tileNum1].colission == true || gp.tileM.Tile[tileNum2].colission == true ) {
				entity.colissionOn = true;
			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
			if(gp.tileM.Tile[tileNum1].colission == true || gp.tileM.Tile[tileNum2].colission == true ) {
				entity.colissionOn = true;
			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
			if(gp.tileM.Tile[tileNum1].colission == true || gp.tileM.Tile[tileNum2].colission == true ) {
				entity.colissionOn = true;
			}
			break;
		}
	}

		
	
	public void checkTile(Entity e) {
		checkTile(e, "both");
	}

	public int checkObject(Entity Entity, boolean player) {

		int index = 999;

		for (int i = 0; i < gp.obj.length; i++) {

			if (gp.obj[i] != null) {
				// Get entity solid area position
				Entity.solidArea.x = Entity.worldX + Entity.solidArea.x;
				Entity.solidArea.y = Entity.worldY + Entity.solidArea.y;

				gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
				gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

				switch (Entity.direction) {
				case "up":
					Entity.solidArea.y -= Entity.speed;
					if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (gp.obj[i].colission == true) {
							Entity.colissionOn = true;
						}
						if (player == true) {
							index = i;
						}

					}
					break;
				case "down":
					Entity.solidArea.y += Entity.speed;
					if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if (gp.obj[i].colission == true) {
								Entity.colissionOn = true;
							}
							if (player == true) {
								index = i;
							}

						}

					}
					break;
				case "left":
					Entity.solidArea.x -= Entity.speed;
					if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if (gp.obj[i].colission == true) {
								Entity.colissionOn = true;
							}
							if (player == true) {
								index = i;
							}

						}

					}
					break;
				case "right":
					Entity.solidArea.x += Entity.speed;
					if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
						if (Entity.solidArea.intersects(gp.obj[i].solidArea)) {
							if (gp.obj[i].colission == true) {
								Entity.colissionOn = true;
							}
							if (player == true) {
								index = i;
							}

						}
					}
					break;
				}
				// get object solid area position
				Entity.solidArea.x = Entity.solidAreaDefaultX;
				Entity.solidArea.y = Entity.solidAreaDefaultY;

				gp.obj[i].solidArea.x = gp.obj[i].solidDefaultAreaX;
				gp.obj[i].solidArea.y = gp.obj[i].solidDefaultAreaY;
			}
		}

		return index;
	}

	public int checkEntity(Entity Entity, Entity[] target) {

		int index = 999;

		for (int i = 0; i < target.length; i++) {

			if (target[i] != null) {
				// Get entity solid area position
				Entity.solidArea.x = Entity.worldX + Entity.solidArea.x;
				Entity.solidArea.y = Entity.worldY + Entity.solidArea.y;

				target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
				target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

				switch (Entity.direction) {
				case "up":
					Entity.solidArea.y -= Entity.speed;
					if (Entity.solidArea.intersects(target[i].solidArea)) {
						Entity.colissionOn = true;
						index = i;
					}
					break;
				case "down":
					Entity.solidArea.y += Entity.speed;
					if (Entity.solidArea.intersects(target[i].solidArea)) {
						Entity.colissionOn = true;
						index = i;
					}
					break;
				case "left":
					Entity.solidArea.x -= Entity.speed;
					if (Entity.solidArea.intersects(target[i].solidArea)) {
						Entity.colissionOn = true;
						index = i;
					}
					break;
				case "right":
					Entity.solidArea.x += Entity.speed;
					if (Entity.solidArea.intersects(target[i].solidArea)) {
						Entity.colissionOn = true;
						index = i;
					}
					break;
				}
				// get object solid area position
				Entity.solidArea.x = Entity.solidAreaDefaultX;
				Entity.solidArea.y = Entity.solidAreaDefaultY;

				target[i].solidArea.x = target[i].solidAreaDefaultX;
				target[i].solidArea.y = target[i].solidAreaDefaultY;
			}
		}

		return index;

	}

	public void checkPlayer(Entity Entity) {

		// Get entity solid area position
		Entity.solidArea.x = Entity.worldX + Entity.solidArea.x;
		Entity.solidArea.y = Entity.worldY + Entity.solidArea.y;

		gp.Player.solidArea.x = gp.Player.worldX + gp.Player.solidArea.x;
		gp.Player.solidArea.y = gp.Player.worldY + gp.Player.solidArea.y;

		switch (Entity.direction) {
		case "up":
			Entity.solidArea.y -= Entity.speed;
			if (Entity.solidArea.intersects(gp.Player.solidArea)) {
				Entity.colissionOn = true;
			}
			break;
		case "down":
			Entity.solidArea.y += Entity.speed;
			if (Entity.solidArea.intersects(gp.Player.solidArea)) {
				Entity.colissionOn = true;
			}
			break;
		case "left":
			Entity.solidArea.x -= Entity.speed;
			if (Entity.solidArea.intersects(gp.Player.solidArea)) {
				Entity.colissionOn = true;
			}
			break;
		case "right":
			Entity.solidArea.y += Entity.speed;
			if (Entity.solidArea.intersects(gp.Player.solidArea)) {
				Entity.colissionOn = true;
			}
			break;
		}
		// get object solid area position
		Entity.solidArea.x = Entity.solidAreaDefaultX;
		Entity.solidArea.y = Entity.solidAreaDefaultY;

		gp.Player.solidArea.x = gp.Player.solidAreaDefaultX;
		gp.Player.solidArea.y = gp.Player.solidAreaDefaultY;
	}

}