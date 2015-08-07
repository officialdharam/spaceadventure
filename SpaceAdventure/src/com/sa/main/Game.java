package com.sa.main;

public class Game implements Runnable {

	private Thread thread;
	private boolean running;

	public static void main(String[] args) {
		Game game = new Game();
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

	private void tick() {
		// System.out.println("Updating System State");
	}

	private void render() {
		// System.out.println("Rendering Objects");
	}
}
