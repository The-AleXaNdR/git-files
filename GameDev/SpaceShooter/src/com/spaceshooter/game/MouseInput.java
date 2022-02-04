package com.spaceshooter.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener
{
	Game game;
	
	public MouseInput(Game game)
	{
		this.game = game;
	}
	
	public void mousePressed(MouseEvent e) 
	{
		int mx = e.getX(), my = e.getY(), bx = Game.WIDTH / 2 -105, by[] = {300, 500, 700};
		
		if(mx >= bx && mx <= (bx + 200) )
		{
			if(my >= by[0] && my <= by[0] + 80)
			{
				if(game.state == "menu") game.state = "game";
				else if(game.state == "gameover") game.state = "game";
			}
			else if(my >= by[1] && my <= by[1] + 80)
			{
				// help button
			}
			else if(my >= by[2] && my <= by[2] + 80)
			{
				System.exit(0);
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
