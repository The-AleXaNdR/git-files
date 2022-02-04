package com.spaceshooter.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu 
{
	public Rectangle play = new Rectangle(Game.WIDTH / 2 -105, 300, 200, 80);
	public Rectangle help = new Rectangle(Game.WIDTH / 2 -105, 500, 200, 80);	
	public Rectangle quit = new Rectangle(Game.WIDTH / 2 -105, 700, 200, 80);	

	public void render(Graphics g)
	{
		Font font0 = new Font("ariel", Font.BOLD, 60);
		g.setFont(font0);
		g.setColor(Color.white);
		g.drawString("SPACE SHOOTER", Game.WIDTH/2 - 275, 150);
		
		drawRects(g);
	}
	
	public void drawRects(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		g.drawString("PLAY", play.x + 16, play.y + 60);
		g2d.draw(play);
		
		g.drawString("HELP", help.x + 16, help.y + 60);
		g2d.draw(help);
		
		g.drawString("QUIT", quit.x + 16, quit.y + 60);
		g2d.draw(quit);

	}
}
