package com.sa.model;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity {

	public int getX();

	public int getY();
	
	public int getWidth();

	public int getHeight();

	public void tick();

	public void render(Graphics g);

	public Rectangle getBounds();
}
