package com.spaceshooter.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Obj implements EntityA
{
	private int vx, vy;
	private BufferedImage player;
	public Player(int x, int y, Game game) 
	{
		super(x, y, game);
		player = game.getTexture().getPlayerImage();
	}
	
	public void render(Graphics g)
	{
		g.drawImage(player, x, y, null);
	}

	public void tick()
	{
		x += vx;
		y += vy;
		
		if(x >= Game.rightLimit) x = Game.rightLimit;
		else if(x <= Game.leftLimit) x = Game.leftLimit;
		
		if(y >= Game.bottomLimit) y = Game.bottomLimit;
		else if(y <= Game.topLimit) y = Game.topLimit;
		
		if(Obj.collision(this, game.getEntb())) 
		{
			if(Game.HEALTH > 10) 
			{
				Game.HEALTH = Game.HEALTH * 9 / 10;
			}
			else
			{
				game.state = "gameover";
				y = Game.bottomLimit;
				vy = 0;
				Game.HEALTH = 200;
			}
		}

	}
	
////Getters and Setters //////////////////////////////////////////////////////////////
	
	public int getvx() 
	{
		return vx;
	}
	
	public int getvy() 
	{
		return vy;
	}

	public void setvx(int vx) 
	{
		this.vx = vx;
	}
	
	public void setvy(int vy) 
	{
		this.vy = vy;
	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, 32, 32);
	}
}
