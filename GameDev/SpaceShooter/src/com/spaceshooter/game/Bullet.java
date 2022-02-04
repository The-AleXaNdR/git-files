package com.spaceshooter.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends Obj implements EntityA
{
	private int vy=10;
	private BufferedImage bullet;
	
	public Bullet(int x, int y, Game game) 
	{
		super(x, y, game);
		this.bullet = this.game.getTexture().getBulletImage();
	}
	
	public void render(Graphics g) 
	{
		g.drawImage(bullet, x, y, null);
	}
	
	public void tick() 
	{
		y -= vy;
		if(Obj.collision(this, game.getEntb())) Enemy.enemyKill += 5;
	}
	
//// Getters and Setters //////////////////////////////////////////////////////////////
	
	public void setvy(int vy) 
	{
		this.vy = vy;
	}
}
