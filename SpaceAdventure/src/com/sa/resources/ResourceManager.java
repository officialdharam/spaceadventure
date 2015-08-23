package com.sa.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManager {

	private BufferedImage backgroundImage;

	public void initialize() {
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			backgroundImage = loader.loadImage("/background.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedImage getBackground() {
		return this.backgroundImage;
	}
}
