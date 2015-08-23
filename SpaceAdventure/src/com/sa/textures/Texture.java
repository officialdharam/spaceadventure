package com.sa.textures;

import java.awt.image.BufferedImage;

import com.sa.resources.ResourceManager;

public class Texture {
	private BufferedImage background;

	public Texture(ResourceManager _rm) {
		this.background = _rm.getBackground();
	}

	public BufferedImage getBackground() {
		return this.background;
	}
}
