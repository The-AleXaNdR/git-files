package com.hungrysnake.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	
	GAME game;
	
	public KeyInput(GAME game)
	{
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		switch(key)
		{
		case KeyEvent.VK_RIGHT: if(game.getDir() != 2) game.setDir(0); break;
		case KeyEvent.VK_DOWN: if(game.getDir() != 3) game.setDir(1); break;
		case KeyEvent.VK_LEFT: if(game.getDir() != 0) game.setDir(2); break;
		case KeyEvent.VK_UP: if(game.getDir() != 1) game.setDir(3); break;
		}
	}

}
