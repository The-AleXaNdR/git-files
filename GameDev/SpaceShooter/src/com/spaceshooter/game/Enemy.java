package com.spaceshooter.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends Obj implements EntityB
{
	public static int enemyCount = 5, enemyKill = 0;
	Random r = new Random();
	
	private int vy=0;
	private BufferedImage enemy;
	
	public Enemy(int x, int y, Game game) {
		super(x, y, game);
		enemy = game.getTexture().getEnemyImage();
	}
	
	public void render(Graphics g) 
	{
		g.drawImage(enemy, x, y, null);
	}
	
	public void tick()
	{
		y+=1; y += vy;
		
		if(game.state == "gameover")
		{
			y = 0;
			x = r.nextInt(Game.WIDTH-32);
			vy = r.nextInt(2);
			enemyCount = 5;
			enemyKill = 0;
		}
		
		if(y >= Game.HEIGHT - 100)
		{
			y = 0;
			x = r.nextInt(Game.WIDTH-32);
			vy = r.nextInt(2);
			enemyKill -= 2;
		}
				
	}
	
////Getters and Setters //////////////////////////////////////////////////////////////

	public int getvy() 
	{
		return vy;
	}
	
	public void setvy(int vy) 
	{
		this.vy = vy;
	}

}
