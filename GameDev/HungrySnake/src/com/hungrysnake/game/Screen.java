package com.hungrysnake.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Screen 
{
	int height = GAME.HEIGHT, width = GAME.WIDTH;
	
	GAME game;
	Graphics g;
	Graphics2D g2d;
	
	Rectangle play = new Rectangle(400, 480, 200,  80);
	Rectangle quit = new Rectangle(400, 650, 200,  80);
	
	public Screen(String screenType, GAME game, Graphics g)
	{
		 this.game = game;
		 this.g = g;
		 g2d = (Graphics2D) g;
		 
		 switch(screenType)
		 {
		 case "menu" : renderMenu(); break;
		 case "gameover" : gameover(); break;
		 }
	}
	
	public void renderMenu()
	{
		g.setColor(new Color(0, 150, 200));
		g.setFont(new Font("yrsa", Font.ITALIC, 150));
		g.drawString(GAME.TITLE, getStringX(GAME.TITLE), 350);
		
		
		g2d.draw(play);
		g2d.draw(quit);

		g.setFont(new Font("quicksand", Font.ITALIC, 50));

		g.drawString("PLAY", (int) play.getX() + 38 , (int) play.getY() + 60 );
		g.drawString("QUTI", (int) play.getX() + 38, (int) quit.getY() + 60);		
	}
	
	public void gameover()
	{
		g.setColor(new Color(250, 0, 0));
		g.setFont(new Font("yrsa", Font.ITALIC, 150));
		g.drawString("Game Over", getStringX("Game Over"), 350);
		
		
		g2d.draw(play);
		g2d.draw(quit);

		g.setFont(new Font("quicksand", Font.ITALIC, 50));

		g.drawString("PLAY", (int) play.getX() + 38 , (int) play.getY() + 60 );
		g.drawString("QUIT", (int) play.getX() + 38, (int) quit.getY() + 60);
		
		g.setFont(new Font("yrsa", Font.ITALIC, 35));
		g.drawString("Score : " + game.eaten * 5, 20, 35);

	}
	
	public int getStringX(String str)
	{
		return ( ( width / 2 ) - ( g.getFontMetrics().stringWidth(str) / 2 ) );
	}
	
}
