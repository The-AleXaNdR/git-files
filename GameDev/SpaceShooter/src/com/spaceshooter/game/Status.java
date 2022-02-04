package com.spaceshooter.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Status 
{
	public void render(Graphics g)
	{
		if(Game.HEALTH > 50)
		{
			g.setColor(Color.gray);
			g.fillRect(5, 5, 200, 20);				
		}
		else
		{
			g.setColor(Color.red);
			g.fillRect(5, 5, 200, 20);				
		}
		
		g.setColor(Color.green);
		g.fillRect(5, 5, Game.HEALTH, 20);
		
		Font font = new Font("freeserif", Font.ITALIC, 20);
		g.setFont(font);
		g.setColor(Color.blue);
		g.drawString("Score : " + Enemy.enemyKill, 20, 50);
		
	}
}
