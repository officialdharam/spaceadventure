package com.sa.model;

import java.awt.Rectangle;

import com.sa.textures.Texture;

public abstract class GameObject implements Entity {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Texture texture;

	public GameObject() {
	}

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public Rectangle getBounds() {
		return new Rectangle(this.x, this.y, this.width, this.height);
	}
}
