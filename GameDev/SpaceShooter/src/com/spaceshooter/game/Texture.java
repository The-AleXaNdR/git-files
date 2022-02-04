package com.spaceshooter.game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture 
{
	BufferedImage background, spriteSheet, player, bullet, enemy;
	
	public Texture() throws IOException
	{
		background = loadImage("/background.jpg");
		spriteSheet = loadImage("/spriteSheet.png");
		player = subImageAt(1, 1, 32, 32, spriteSheet);
		bullet = subImageAt(2, 1, 32, 32, spriteSheet);
		enemy = subImageAt(3, 1, 32, 32, spriteSheet);
	}
	
	public BufferedImage loadImage(String path) throws IOException
	{
		return ImageIO.read(getClass().getResource(path));
	}

	public BufferedImage subImageAt(int col, int row, int width, int height, BufferedImage ss)
	{
		return ss.getSubimage((col - 1) * 32, (row - 1) * 32, width, height);
	}

	
//// Getters and Setters //////////////////////////////////////////////////////////////
	
	public BufferedImage getPlayerImage()
	{
		return player;
	}
	
	public BufferedImage getBulletImage()
	{
		return bullet;
	}
	
	public BufferedImage getEnemyImage()
	{
		return enemy;
	}
}
