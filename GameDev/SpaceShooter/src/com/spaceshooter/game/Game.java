package com.spaceshooter.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends Canvas implements Runnable
{

	private static final long serialVersionUID = -5239746741505202995L;
	
	public static final int WIDTH = 1200, HEIGHT = 1000;
	public static final String TITLE = "2D SPACE SHOOTER GAME";
	public static final int leftLimit=0, rightLimit=Game.WIDTH - 32, topLimit = 20, bottomLimit = HEIGHT - 100;
	
	public static int HEALTH = 200;
	
	private boolean running = false;
	private Thread thread;
	private Texture tex;
	private Player player;
	private Controller con;
	private Menu menu;
	
	String state = "menu";
	
	public Game()
	{
		window();
		addKeyListener(new KeyInput(this));
		addMouseListener(new MouseInput(this));
		requestFocus();
		try
		{
		tex = new Texture();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		menu = new Menu();
		player = new Player(WIDTH/2, HEIGHT-100, this);
		con = new Controller(this);
		start();

	}
	
	private void window()
	{
		JFrame jf = new JFrame(TITLE);		
		jf.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.add(new JPanel());
		jf.add(this);
		jf.pack();
		jf.setVisible(true);
	}
	
	public synchronized void start()
	{
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running) return;
		try
		{
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void run() 
	{
		long lt = System.nanoTime();
		int tks = 60;
		double ns = 1000000000 / tks ;
		double delta = 0;
		while(running)
		{
			long nw = System.nanoTime();
			delta += (nw - lt) / ns ;
			lt = nw ;
			
			if(delta >= 1)
			{
				tick();
				delta -- ;
			}
			
			render();
			
			
		}
		stop();
	}

	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(tex.background, 0, 0, WIDTH, HEIGHT, this);
		
		////////////////////////////////////////////////////////////////
		
		if(state == "game")
		{
			player.render(g);
			con.render(g);
			Status st = new Status();
			st.render(g);
		}
		else if(state == "menu")
		{
			menu.render(g);
		}
		else if(state == "gameover")
		{
			Font font0 = new Font("ariel", Font.BOLD, 60);
			g.setFont(font0);
			g.setColor(Color.red);
			g.drawString("GAME OVER", Game.WIDTH/2 - 205, 150);
			menu.drawRects(g);
		}
		
		////////////////////////////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	public void tick()
	{
		if(state == "game")
		{
			player.tick();
			con.tick();
		}
	}
	
	public static void main(String[] args)
	{
		new Game();
	}
	
	
////	Getters and Setters    //////////////////////////////////////////////////////////////
	
	public Texture getTexture()
	{
		return tex;
	}
	
	public Player getPlayer()
	{
		return player;
	}

	public Controller getController() 
	{
		return con;
	}

	public LinkedList<EntityA> getEnta() {
		return con.getEnta();
	}
	
	public LinkedList<EntityB> getEntb() {
		return con.getEntb();
	}

}
