package com.spaceshooter.game;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface EntityA 
{
	public void render(Graphics g);
	public void tick();
	public int getx();
	public int gety();
	public Rectangle getBounds();
}
