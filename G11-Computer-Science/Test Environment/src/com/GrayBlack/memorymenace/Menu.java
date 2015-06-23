package com.GrayBlack.memorymenace;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu {
	
	private BufferedImage playButton = null;
	private BufferedImage instructButton = null;
	private BufferedImage creditButton = null;

		public void render(Graphics g){
			Graphics2D g2d = (Graphics2D) g;	
			
			BufferedImageLoader loader = new BufferedImageLoader();
			try{
				
				playButton = loader.loadImage("start.png");
				instructButton = loader.loadImage("instruct.png");
				creditButton = loader.loadImage("credits.png");
				
				
			}catch (IOException e){
				e.printStackTrace();
			}
			
			Font menuFont = new Font ("Zorque", Font.PLAIN, 42);
			g.setFont(menuFont);
			g.setColor(Color.BLACK);
			g2d.setRenderingHint(
			        RenderingHints.KEY_TEXT_ANTIALIASING,
			        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			
			g.drawImage(playButton, 500, 200, null);
			g.drawImage(instructButton, 500, 275, null);
			g.drawImage(creditButton, 500, 350, null);
			
		}
}
