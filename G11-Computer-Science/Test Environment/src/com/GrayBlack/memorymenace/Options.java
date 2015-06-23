package com.GrayBlack.memorymenace;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.GrayBlack.memorymenace.Game.ACONFIG;
import com.GrayBlack.memorymenace.Game.TCONFIG;


public class Options {
	
	private BufferedImage back = null;
	private BufferedImage classicButton = null;
	private BufferedImage mapleButton = null;
	private BufferedImage leagueButton = null;
	private BufferedImage selected = null;
	private BufferedImage button = null;
	private BufferedImage bSelected = null;
	private BufferedImage playButton = null;
	
	public void render(Graphics g){
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			
			back = loader.loadImage("back.png");
			classicButton = loader.loadImage("button0.png");
			mapleButton = loader.loadImage("button1.png");
			leagueButton = loader.loadImage("button2.png");
			selected = loader.loadImage("selected.png");
			button = loader.loadImage("button.png");
			bSelected = loader.loadImage("bselected.png");
			playButton = loader.loadImage("playGame.png");
			
			
		}catch (IOException e){
			e.printStackTrace();
		}
		Graphics2D g2d = (Graphics2D) g;	
		g2d.setRenderingHint(
		        RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		Font font = new Font ("Zorque", Font.PLAIN, 42);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("Themes:", 150, 250);
		g.drawString("Board Size:" , 150, 420);
		
		g.drawImage(back, 30,700, null);
		g.drawImage(classicButton, 150,260, null);
		g.drawImage(mapleButton, 500,260, null);
		g.drawImage(leagueButton, 850,260, null);
		
		g.drawImage(button, 540,370,null);
		g.drawImage(button, 740,370,null);
		g.drawImage(button, 940,370,null);
		
		g.drawString("4x4", 550, 420);
		g.drawString("4x6", 750, 420);
		g.drawString("4x8", 950, 420);
		
		g.drawImage(playButton, 550, 550, null);
		
		if (Game.Theme == TCONFIG.CLASSIC){
			g.drawImage(selected, 141, 252, null);
			
		}
		
		if (Game.Theme == TCONFIG.MAPLE){
			g.drawImage(selected, 491, 252, null);
			
		}
		
		if (Game.Theme == TCONFIG.LEAGUE){
			g.drawImage(selected, 841, 252, null);
			
		}
		
		if (Game.Area == ACONFIG.SMALL){
			g.drawImage(bSelected, 535,365, null);
			
		}
		if (Game.Area == ACONFIG.REG){
			g.drawImage(bSelected, 735,365, null);
			
		}
		if (Game.Area == ACONFIG.LARGE){
			g.drawImage(bSelected, 935,365, null);
			
		}
		
		
		
		//g.drawString("Insructions", Game.WIDTH / 2 + 275, 320);
		//g.drawString("Credits", Game.WIDTH / 2 + 275, 390);
		
		
		
	}
}
