package com.GrayBlack.memorymenace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import com.GrayBlack.memorymenace.Game.ACONFIG;
import com.GrayBlack.memorymenace.Game.STATE;
import com.GrayBlack.memorymenace.Game.TCONFIG;

public class NewGame {

	private int x = 0;
	private int y = 0;
	
	private int[] pictures;
	private int[] cards;
	private int[] values;
	private int assignCount = 0;
	private int position = 0;

	private BufferedImage back = null;
	private BufferedImage test = null;
	private BufferedImage[] images = new BufferedImage[32];
	private BufferedImage cardBack = null;

	public void render (Graphics g){
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			back = loader.loadImage("back.png");
			
			
			if (Game.Theme == Game.Theme.CLASSIC){
				cardBack = loader.loadImage("back0.png");
				for (int i=0; i < pictures.length; i++){
					images [i] = loader.loadImage("classic__" + i + ".png");
				}
			}
			
			if (Game.Theme == Game.Theme.MAPLE){
				cardBack = loader.loadImage("back1.png");
				for (int i=0; i < pictures.length; i++){
					images [i] = loader.loadImage("maple__" + i + ".png");
				}
			}
			
			if (Game.Theme == Game.Theme.LEAGUE){
				cardBack = loader.loadImage("back2.png");
				for (int i=0; i < pictures.length; i++){
					images [i] = loader.loadImage("league__" + i + ".png");
				}
			}
			
		}catch (IOException e){
			e.printStackTrace();
		}
		Graphics2D g2d = (Graphics2D) g;
		g.drawImage(back, 30,700, null);
		
		if (Game.Area == Game.Area.SMALL){
			g.drawImage (cardBack, 400, 10, null);
			g.drawImage (cardBack, 600, 10, null);
			g.drawImage (cardBack, 800, 10, null);
			g.drawImage (cardBack, 1000, 10, null);
			
			g.drawImage (cardBack, 400, 210, null);
			g.drawImage (cardBack, 600, 210, null);
			g.drawImage (cardBack, 800, 210, null);
			g.drawImage (cardBack, 1000, 210, null);
		
			g.drawImage (cardBack, 400, 410, null);
			g.drawImage (cardBack, 600, 410, null);
			g.drawImage (cardBack, 800, 410, null);
			g.drawImage (cardBack, 1000, 410, null);
			
			g.drawImage (cardBack, 400, 610, null);
			g.drawImage (cardBack, 600, 610, null);
			g.drawImage (cardBack, 800, 610, null);
			g.drawImage (cardBack, 1000, 610, null);
		}
		
		if (Game.Area == Game.Area.REG){
			
			g.drawImage (cardBack, 325, 10, null);
			g.drawImage (cardBack, 325, 210, null);
			g.drawImage (cardBack, 325, 410, null);
			g.drawImage (cardBack, 325, 610, null);
			
			g.drawImage (cardBack, 450, 10, null);
			g.drawImage (cardBack, 450, 210, null);
			g.drawImage (cardBack, 450, 410, null);
			g.drawImage (cardBack, 450, 610, null);
			
			g.drawImage (cardBack, 575, 10, null);
			g.drawImage (cardBack, 575, 210, null);
			g.drawImage (cardBack, 575, 410, null);
			g.drawImage (cardBack, 575, 610, null);
			
			g.drawImage (cardBack, 700, 10, null);		
			g.drawImage (cardBack, 700, 210, null);
			g.drawImage (cardBack, 700, 410, null);
			g.drawImage (cardBack, 700, 610, null);
			
			g.drawImage (cardBack, 825, 10, null);		
			g.drawImage (cardBack, 825, 210, null);
			g.drawImage (cardBack, 825, 410, null);
			g.drawImage (cardBack, 825, 610, null);
			
			g.drawImage (cardBack, 950, 10, null);		
			g.drawImage (cardBack, 950, 210, null);
			g.drawImage (cardBack, 950, 410, null);
			g.drawImage (cardBack, 950, 610, null);
		}
		
		if (Game.Area == Game.Area.LARGE){
			
			g.drawImage (cardBack, 200, 10, null);
			g.drawImage (cardBack, 200, 210, null);
			g.drawImage (cardBack, 200, 410, null);
			g.drawImage (cardBack, 200, 610, null);
			
			g.drawImage (cardBack, 325, 10, null);
			g.drawImage (cardBack, 325, 210, null);
			g.drawImage (cardBack, 325, 410, null);
			g.drawImage (cardBack, 325, 610, null);
			
			g.drawImage (cardBack, 450, 10, null);
			g.drawImage (cardBack, 450, 210, null);
			g.drawImage (cardBack, 450, 410, null);
			g.drawImage (cardBack, 450, 610, null);
			
			g.drawImage (cardBack, 575, 10, null);
			g.drawImage (cardBack, 575, 210, null);
			g.drawImage (cardBack, 575, 410, null);
			g.drawImage (cardBack, 575, 610, null);
			
			g.drawImage (cardBack, 700, 10, null);		
			g.drawImage (cardBack, 700, 210, null);
			g.drawImage (cardBack, 700, 410, null);
			g.drawImage (cardBack, 700, 610, null);
			
			g.drawImage (cardBack, 825, 10, null);		
			g.drawImage (cardBack, 825, 210, null);
			g.drawImage (cardBack, 825, 410, null);
			g.drawImage (cardBack, 825, 610, null);
			
			g.drawImage (cardBack, 950, 10, null);		
			g.drawImage (cardBack, 950, 210, null);
			g.drawImage (cardBack, 950, 410, null);
			g.drawImage (cardBack, 950, 610, null);
			
			g.drawImage (cardBack, 1075, 10, null);
			g.drawImage (cardBack, 1075, 210, null);
			g.drawImage (cardBack, 1075, 410, null);
			g.drawImage (cardBack, 1075, 610, null);
		}
		
	}

	public void play() {

		if (Game.Area == Game.Area.SMALL) {
			pictures = new int[8];
			cards = new int[16];
			values = new int[16];
		}

		if (Game.Area == Game.Area.REG) {
			pictures = new int[16];
			cards = new int[36];
			values = new int[36];
		}

		if (Game.Area == Game.Area.LARGE) {
			pictures = new int[32];
			cards = new int[64];
			values = new int[64];
		}

		// Lays out cards
		for (int i = 0; i < cards.length; i++) {
			values[i] = -1;

		}

		// Assigns the card a picture id
		for (int i = 0; i < pictures.length; i++) {
			while (assignCount < 2) {
				position = (int) (Math.random() * cards.length);

				if (values[position] == -1) {
					values[position] = i;
					assignCount++;
				}
			}
			assignCount = 0;
		}

	}

}
