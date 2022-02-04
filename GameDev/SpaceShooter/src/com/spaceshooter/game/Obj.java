package com.spaceshooter.game;

import java.awt.Rectangle;
import java.util.LinkedList;

public class Obj 
{
	public int x, y;
	public Game game;
	
	public Obj(int x, int y, Game game)
	{
		this.x = x;
		this.y = y;
		this.game = game;
	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle(x, y, 32, 32);
	}
	
	public static boolean collision(EntityA ea, LinkedList<EntityB> eb)
	{
		for(int i=0; i<eb.size(); i++)
		{
			if(ea.getBounds().intersects(eb.get(i).getBounds()))
			{
				ea = null;
				eb.remove(eb.get(i));
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean collision(EntityB eb, LinkedList<EntityA> ea) 
	{
		for(int i=0; i<ea.size(); i++)
		{
			if(eb.getBounds().intersects(ea.get(i).getBounds()))
			{
				eb = null;
				ea.remove(ea.get(i));
				return true;
			}
		}

		return false;
	}
	
	public static boolean collision(EntityB eb, EntityA ea) 
	{
		if(eb.getBounds().intersects(ea.getBounds()))
		{
			ea = null;
			eb = null;
		}

		return false;
	}

	public static boolean collision(EntityA ea, EntityB eb) 
	{
		if(eb.getBounds().intersects(ea.getBounds()))
		{
			ea = null;
			eb = null;
			return true;
		}

		return false;
	}
	
////Getters and Setters //////////////////////////////////////////////////////////////

	public int getx() 
	{
		return x;
	}
	
	public int gety() 
	{
		return y;
	}
	
	public void setx(int x) 
	{
		this.x = x;
	}
	
	public void sety(int y) 
	{
		this.y = y;
	}
	
}
