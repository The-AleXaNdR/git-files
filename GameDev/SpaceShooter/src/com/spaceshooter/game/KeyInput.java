package com.spaceshooter.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	private Game game;
	
	public KeyInput(Game game)
	{
		this.game = game;
		
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		Player player = game.getPlayer();
		Controller con = game.getController();
		
		if(game.state == "game") 
		{
		
		if(key == KeyEvent.VK_LEFT)
		{
			player.setvx(-8);
		}
		if(key == KeyEvent.VK_RIGHT)
		{
			player.setvx(8);
		}
		if(key == KeyEvent.VK_UP)
		{
			player.setvy(-8);
		}
		if(key == KeyEvent.VK_DOWN)
		{
			player.setvy(8);
		}
		if(key == KeyEvent.VK_SPACE && con.shooting)
		{
			con.shooting = false;
			con.addElement(new Bullet(player.getx(), player.gety(), game));
		}
		
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		Player player = game.getPlayer();
		Controller con = game.getController();

		if(game.state == "game") 
		{
			
		if(key == KeyEvent.VK_LEFT)
		{
			player.setvx(0);
		}
		if(key == KeyEvent.VK_RIGHT)
		{
			player.setvx(0);
		}
		if(key == KeyEvent.VK_UP)
		{
			player.setvy(0);
		}
		if(key == KeyEvent.VK_DOWN)
		{
			player.setvy(0);
		}
		if(key == KeyEvent.VK_SPACE)
		{
			con.shooting = true;
		}
		

		}

	}
}
