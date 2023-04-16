package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_hamburger;
import object.OBJ_key;


public class UI {

	GamePanel gp;
	Graphics2D g2;
	Font Arial_20 = new Font("Arial", Font.PLAIN, 20);
	Font Arial_30 = new Font("Arial", Font.PLAIN, 30);
	Font Arial_40 = new Font("Arial", Font.PLAIN, 40);


	Font Arial_80 = new Font("Arial", Font.PLAIN, 60);
	Font Arial_50B = new Font("Arial", Font.BOLD, 40);
	private static final DecimalFormat df = new DecimalFormat("0.00");

	public boolean messageOn = false;
	public String message = "";
	public int messageCounter = 0;
	public boolean gameFinished = false;
	public String currentDialogue = "";
	public int commandNum = 0;
	public int titleScreenState ; // first title screen
	
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
	
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		g2.setFont(Arial_40);
		g2.setColor(Color.white);
		
		
		// TITLE STATE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		
		// PLAY STATE
		if(gp.gameState == gp.playState) {
			// do playstuff
		}
		
		// PAUSE STATE
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
		
		// DIALOGUE STATE
		if(gp.gameState == gp.dialogueState){
			drawDialogueScreen();
		}
		}

	private void drawTitleScreen() {

		if(titleScreenState == 0) {
			g2.setColor(new Color(47, 122, 214));
			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			// TITLE NAME
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
			String text = "Blue Boy Adventure";
			
			int x = getXforCenteredText(text);
			int y = gp.tileSize * 3;
			
			// SHADOW
			g2.setColor(Color.BLACK);
			g2.drawString(text, x+5, y+5);
			
			//MAIN COLOR
			g2.setColor(Color.WHITE);
			g2.drawString(text, x, y);
			
			// BLUE BOY IMAGE 
			x = gp.screenWidth/2 - gp.tileSize;
			y += 2*gp.tileSize;
			g2.drawImage(gp.Player.down1, x, y, gp.tileSize*2, gp.tileSize*2, null);
			
			// MENU
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
			
			text = "NEW GAME";
			x = getXforCenteredText(text);
			y += gp.tileSize*4;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.drawString(">", x - gp.tileSize, y);
			}
			
			
			text = "LOAD GAME";
			x = getXforCenteredText(text);
			y += gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">", x - gp.tileSize, y);
			}
			
			text = "QUIT";
			x = getXforCenteredText(text);
			y += gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.drawString(">", x - gp.tileSize, y);
			}
		}
		else if(titleScreenState == 1) {
			
			//CLASS
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(42F));
			
			String text = "select our class!";
			int x = getXforCenteredText(text);
			int y = gp.tileSize*3;
			g2.drawString(text, x, y);
			
			text = "Fighter";
			x = getXforCenteredText(text);	
			y += gp.tileSize*3;
			g2.drawString(text, x, y);
			if(commandNum == 0) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			text = "Farmer";
			x = getXforCenteredText(text);
			y += gp.tileSize;
			g2.drawString(text, x, y);
			if(commandNum == 1) {
				g2.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Back";
			x = getXforCenteredText(text);
			y += gp.tileSize*2;
			g2.drawString(text, x, y);
			if(commandNum == 2) {
				g2.drawString(">", x-gp.tileSize, y);
			}
		}
	}

	private void drawPauseScreen() {

		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
		String text = "paused";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight / 2; 
		g2.drawString(text,x,y);
	}
	
	public void drawDialogueScreen() {
		
		// WINDOW
		int x = gp.tileSize*2;
		int y = gp.tileSize * 2;
		int width = gp.screenWidth - (gp.tileSize*4);
		int height = gp.tileSize*3;
		
		drawSubWindow(x,y,width,height);
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25));
		x += gp.tileSize/2;
		y += gp.tileSize;
		
		for(String line : currentDialogue.split("\n")) {
			g2.drawString(line, x, y);
			y += 40;
		}
		
		
	}
	
	private void drawSubWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0,0,0);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255,255,255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
		
		
	}

	public int getXforCenteredText(String text) {
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
	

}
