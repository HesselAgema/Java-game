package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener {
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	
	boolean drawTimes = false;

	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		// TITLE STATE
		if(gp.gameState == gp.titleState) {
			
			if(gp.ui.titleScreenState == 0) {
				if(code == KeyEvent.VK_W) {
					gp.ui.commandNum--;

					if(gp.ui.commandNum < 0) {
						gp.ui.commandNum = 2;
					}
					
				}
				if(code == KeyEvent.VK_S) {
					gp.ui.commandNum++;
					if(gp.ui.commandNum > 2) {
						gp.ui.commandNum = 0;
					}
				}
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandNum == 0) {
						gp.ui.titleScreenState = 1;
						gp.playMusic(0);
						
					}
					if(gp.ui.commandNum == 1) {
						
					}
					if(gp.ui.commandNum == 2) {
						System.exit(0);
					}
				}
				
			}
			else if(gp.ui.titleScreenState == 1) {
				if(code == KeyEvent.VK_W) {
					gp.ui.commandNum--;

					if(gp.ui.commandNum < 0) {
						gp.ui.commandNum = 2;
					}
					
				}
				if(code == KeyEvent.VK_S) {
					gp.ui.commandNum++;
					if(gp.ui.commandNum > 2) {
						gp.ui.commandNum = 0;
					}
				}
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandNum == 0) {
						gp.gameState = gp.playState;

						
					}
					if(gp.ui.commandNum == 1) {
						gp.gameState = gp.playState;

					}
					if(gp.ui.commandNum == 2) {
						gp.ui.titleScreenState = 0;
						gp.ui.commandNum =0;
					}
				}
				
			}

			
		}
		
		
		
		// PLAY STATE
		else if(gp.gameState == gp.playState) {
			if(code == KeyEvent.VK_W) {
				upPressed = true;
				
			}
			if(code == KeyEvent.VK_S) {
				downPressed = true;
				
			}
			if(code == KeyEvent.VK_A) {
				leftPressed = true;
				
			}
			if(code == KeyEvent.VK_D) {
				rightPressed =true;
			}
			if(code == KeyEvent.VK_P) {
				gp.gameState = gp.pauseState;
			}
			if(code == KeyEvent.VK_ENTER) {
				enterPressed = true;
			}
			if(code == KeyEvent.VK_J) {
				gp.Player.placeBlock(6);
			}
			if (code == KeyEvent.VK_K) {
			    // Get the tile index corresponding to the player's position
			    int playerTileX = gp.Player.worldX / gp.tileSize;
			    int playerTileY = gp.Player.worldY / gp.tileSize;
			    
			    gp.Player.placeBlock(6);

			    // Check if the tile is a dirt tile
			    if (gp.tileM.mapTileNum[playerTileX][playerTileY] == 6) {
			        // Create a seed object at the player's position
			    	
			        gp.aSetter.setSeedObject(0, gp.Player.worldX, gp.Player.worldY);
			        
			    }
			}
			}
			
			
			// DEBUG
			if(code == KeyEvent.VK_T) {
				if(drawTimes == false) {
					drawTimes = true;
				}else if (drawTimes == true) {
					drawTimes = false;
				}
			}
			

		
		
		// PAUSE STATE
		else if (gp.gameState == gp.pauseState) {
			if (code == KeyEvent.VK_P) {
				gp.gameState = gp.playState;
			}
		}
		
		// DIALOGUE STATE
		if(gp.gameState == gp.dialogueState) {
			if(code == KeyEvent.VK_ENTER) {
				gp.gameState = gp.playState;
			}
		}
	}

	@Override	
	public void keyReleased(KeyEvent e) {

	int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
			
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
			
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
			
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}	
		
	}

	

}
