package com.GrayBlack.memorymenace;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;



import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 700;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Memory Menace";
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	private BufferedImage background = null;
	private BufferedImage whiteground = null;
	
	public static enum STATE{
		MENU, OPTIONS, GAME, INSTRUCTIONS, CREDITS
	};
	
	public static enum TCONFIG{
		CLASSIC, MAPLE, LEAGUE
	};
	
	public static enum ACONFIG{
		SMALL, REG, LARGE
	};
	
	
	public static STATE State = STATE.MENU;
	public static TCONFIG Theme = TCONFIG.CLASSIC;
	public static ACONFIG Area = ACONFIG.SMALL;
	
	private Menu menu;
	private Options options;
	private NewGame game;
	private Instructions instructions;
	
	public void init(){
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			
			background = loader.loadImage("menuMain2.png");
			whiteground = loader.loadImage("whiteback.png");
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
		menu = new Menu();
		options = new Options();
		game = new NewGame();
		instructions = new Instructions();
		
		this.addMouseListener(new MouseInput());
		
	}
	
	private synchronized void start(){
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " Ticks, Fps " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null){
			
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////
		
		if (State == STATE.MENU){
			g.drawImage(background, 0, 0, this);
			menu.render(g);
		}
		
		if (State == STATE.OPTIONS){
			g.drawImage(background, 0, 0, this);
			options.render(g);
		}
		
		if (State == STATE.GAME){
			g.drawImage(whiteground, 0, 0, this);
			game.play();
			game.render(g);
		}
		if (State == STATE.INSTRUCTIONS){
			instructions.render(g);
		}
		
		
		
		//////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public static void main (String[] args){
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}

	
	
	

}
