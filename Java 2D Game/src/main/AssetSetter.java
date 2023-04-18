package main;

import entity.NPC_OldMan;
import object.OBJ_boots;
import object.OBJ_chest;
import object.OBJ_door;
import object.OBJ_hamburger;
import object.OBJ_key;
import object.OBJ_seed;
import object.OBJ_sprout;

public class AssetSetter {

	GamePanel gp;
	
	AssetSetter(GamePanel gp){
		this.gp = gp;
	}
	
	
	
	public void setObject() {

		
		//gp.obj[0] = new OBJ_key(gp);
		
	}
	
	public void setSeedObject(int index, int worldX, int worldY) {
	    gp.obj[index] = new OBJ_seed(gp, worldX, worldY, this);
	}
	
	public void setSproutObject(int index, int worldX, int worldY) {
	    gp.obj[index] = new OBJ_sprout(gp, worldX, worldY);
	}
	public void setNPC() {
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
	}
}

