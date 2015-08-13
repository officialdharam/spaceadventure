package com.sa.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.sa.statemachine.GameFSM;

public class Game extends Canvas implements Runnable {

	private Thread thread;
	private boolean running;
	private GameFSM fsm = null;
	public static final int SCALE = 2;
	public static final int WIDTH = 500;
	public static final int HEIGHT = WIDTH * 9 / 12; // aspect ratio 12 : 9
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame initialFrame = new JFrame("Space Adventure");
		initialFrame.setSize(new Dimension(WIDTH, HEIGHT));
		initialFrame.add(game);
		initialFrame.pack();
		initialFrame.setResizable(false);
		initialFrame.setLocationRelativeTo(null);
		initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialFrame.setVisible(true);
		game.start();
	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		init();
		int tick = 0, requiredFramesPerSecond = 60;
		long frames = 0, currentTime = 0, lastTime = System.nanoTime(), timer = System.currentTimeMillis();
		double delta = 0, ns = 1e9 / requiredFramesPerSecond;

		// FPS is frames per second - ideally it should be 50-60 if it is more
		// than that, it would be waste of CPU cycles.
		while (running) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / ns;
			if (delta >= 1) {
				tick(); // tick only 60 times a second
				delta--;
				tick++;
			}

			render();
			frames++;

			// this is not a part of the game loop.. just for checking the FPS
			if (System.currentTimeMillis() - timer >= 1000) {
				System.out.println(" TICKS " + tick + " FPS " + frames);
				tick = 0;
				frames = 0;
				timer += 1000;
			}
			lastTime = currentTime;
		}
		stop();
	}

	public void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public void init() {
		fsm = new GameFSM();
		fsm.initialize();

		requestFocusInWindow();
	}

	private void tick() {
		fsm.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		fsm.render(g);
		g.dispose();
		bs.show();
	}
}
