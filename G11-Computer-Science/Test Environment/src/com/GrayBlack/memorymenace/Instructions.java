package com.GrayBlack.memorymenace;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Instructions {

	private BufferedImage background = null;
	private BufferedImage back = null;

	public void render(Graphics g) {

		BufferedImageLoader loader = new BufferedImageLoader();
		try {

			background = loader.loadImage("instructions.png");
			back = loader.loadImage("back.png");

		} catch (IOException e) {
			e.printStackTrace();
		}
		Graphics2D g2d = (Graphics2D) g;
		g.drawImage(background, 0, 0, null);
		g.drawImage(back, 30, 700, null);

	}
}
