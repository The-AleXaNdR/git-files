package com.spaceshooter.game;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Controller 
{
	boolean shooting = true;

	Game game;
	Random r = new Random();
	LinkedList<EntityA> enta = new LinkedList<EntityA>();
	LinkedList<EntityB> entb = new LinkedList<EntityB>();	
	
	public Controller( Game game )
	{
		this.game = game;
		addEnemyBlock();
	}
	
	public void render(Graphics g)
	{
		for(int i=0, j=0; i<enta.size() || j<entb.size(); i++, j++)
		{
			if(i<enta.size()) enta.get(i).render(g);
			if(j<entb.size()) entb.get(i).render(g);
		}
		
//		for(int i=0; i<enta.size(); i++)
//		{
//			enta.get(i).render(g);
//		}
//		
//		for(int i=0; i<entb.size(); i++)
//		{
//			entb.get(i).render(g);
//		}

	}
	
	public void tick()
	{
		
		for(int i=0, j=0; i<enta.size() || j<entb.size(); i++, j++)
		{
			if(i<enta.size())
			{
				enta.get(i).tick();
				if(enta.get(i).gety() == Game.topLimit) enta.remove(enta.get(i));
			}
			if(j<entb.size())
			{
				entb.get(j).tick();
			}
		}
		
		if(entb.size() == 0)
		{
			Enemy.enemyCount += 2;
			addEnemyBlock();
		}
	}
	
	public void addEnemyBlock()
	{
		for(int i=0; i<Enemy.enemyCount; i++)
		{
			entb.add(new Enemy(r.nextInt(Game.rightLimit) , 0 , game));
			entb.get(i).setvy(r.nextInt(2));
		}
	}
	
	public void addElement(EntityA e)
	{
		enta.add(e);
	}
	
	public LinkedList<EntityA> getEnta() {
		return enta;
	}
	
	public LinkedList<EntityB> getEntb() {
		return entb;
	}
	
}
