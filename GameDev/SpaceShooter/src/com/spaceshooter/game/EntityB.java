package com.spaceshooter.game;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface EntityB 
{
	public void render(Graphics g);
	public void tick();
	public int getx();
	public int gety();
	public int getvy();
	public void setvy(int vy);
	public Rectangle getBounds();
}
