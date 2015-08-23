package com.sa.screens;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sa.model.GameObject;
import com.sa.textures.Texture;

public class FlashScreen extends GameObject {
	int WIDTH = 1000;
	int HEIGHT = 9 * WIDTH / 12;
	BufferedImage background = null;

	public FlashScreen(Texture tx) {
		super();
		this.texture = tx;
		this.background = tx.getBackground();
	}
	
	@Override
	public synchronized void tick() {
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);
	}
}
