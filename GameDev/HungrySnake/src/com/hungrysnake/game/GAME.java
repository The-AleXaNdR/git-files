package com.hungrysnake.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GAME extends JPanel implements ActionListener
{
	static final String TITLE = "Hungry Snake";
	
	static final int WIDTH = 1000, HEIGHT = 1000;
	static final int UNITSIZE = 20, TOTALUNITS = (WIDTH*HEIGHT)/UNITSIZE;
	static final int DELAY = 100;
	static final int RLM = WIDTH - UNITSIZE, DLM = HEIGHT - UNITSIZE;
	
	int[] x = new int[TOTALUNITS], y = new int[TOTALUNITS];
		
	
	String state = "menu";
	Random r = new Random();
	Timer timer = new Timer(DELAY, this);
	
	int parts = 5, eaten = 0, applex = 0, appley = 0, dir = r.nextInt(4);
	int rand = r.nextInt( (int) ((WIDTH - 200) / UNITSIZE) ) * UNITSIZE + 2 * UNITSIZE;
	
	{
		for(int i=0; i<parts; i++) { x[i] = rand; y[i] = rand;}
	}
	
	
	public static void main(String[] args)
	{
		new GAME();
	}
	
	public GAME()
	{
		window();
		this.addKeyListener(new KeyInput(this));
		this.addMouseListener(new MouseInput());
		newApple();
		timer.start();
	}
	
	public void window()
	{
		JFrame jf = new JFrame("Hungry Snake");
		jf.add(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.pack();
		jf.setVisible(true);
	}
	
	public void newApple()
	{
		applex = r.nextInt( (int) (WIDTH / UNITSIZE) ) * UNITSIZE;
		
		appley = r.nextInt( (int) (HEIGHT / UNITSIZE) ) * UNITSIZE;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(state=="game")
		{
			move();
			checkApple();
			checkCollision();
		}
		repaint();
	}
	
	public void move()
	{
		for(int i=parts; i>0; i--)
		{
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(dir)
		{
		case 0 : x[0] += UNITSIZE; break;
		case 1 : y[0] += UNITSIZE; break;
		case 2 : x[0] -= UNITSIZE; break;
		case 3 : y[0] -= UNITSIZE; break;
		}
	}
	
	public void checkApple()
	{
		if(x[0] == applex && y[0] == appley)
		{
			newApple();
			parts ++ ;
			eaten ++ ;
		}
	}
	
	public void checkCollision()
	{
		for(int i=1; i<parts; i++) if(x[0] == x[i] && y[0] == y[i]) state = "gameover";
		
		for(int i=0; i<parts; i++)
		{
			if(x[i] < 0) x[i] = RLM;
			else if(x[i] > RLM) x[i] = 0;
			else if(y[i] < 0) y[i] = DLM;
			else if(y[i] > DLM) y[i] = 0;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(state == "game") 
		{
			g.setColor(Color.red);
			g.fillOval(applex, appley, UNITSIZE, UNITSIZE);
			
			g.setColor(Color.green);
			g.fillRect(x[0], y[0], UNITSIZE, UNITSIZE);
			for(int i=1; i<parts; i++)
			{
				g.setColor(new Color(45, 180, 0));
				g.fillRect(x[i], y[i], UNITSIZE, UNITSIZE);
			}
			
			g.setColor(Color.cyan);
			g.setFont(new Font("yrsa", Font.ITALIC, 25));
			g.drawString("Score : " + eaten * 5, 10, 25);

		}
		else new Screen(state, this, g);
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private class MouseInput implements MouseListener
	{
		@Override
		public void mousePressed(MouseEvent e) 
		{
			int mx = e.getX(), my = e.getY() ;
			
			if((state == "menu" || state == "gameover") && mx >= 400 && mx <= 600 )
			{
				if( my >= 480 && my <= 540 )
				{
					
					if(state == "gameover")
					{
						rand = r.nextInt( (int) ((WIDTH - 200) / UNITSIZE) ) * UNITSIZE + 2 * UNITSIZE;
						for(int i=0; i<parts; i++) { x[i] = rand; y[i] = rand;}
						parts = 5;
						eaten = 0;
						dir = r.nextInt(4);
						newApple();
					}
					
					state = "game";
				}
				else if( my >= 650 && my <= 710 )
				{
					System.exit(1);
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

		}
	}
}
