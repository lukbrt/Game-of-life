package pl.s15487.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class BoardPanel extends JPanel implements KeyListener, MouseListener
{
	private Board board;
	private boolean activePull = false;
	
	public BoardPanel()
	{
		board = new Board();
		
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void paint(Graphics g)
	{
		/*
		 * Przygotowywanie tła
		 */
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillRect(2, 2, GameFrame.WIDTH, GameFrame.HEIGHT);
		
		/*
		 * Rysowanie planszy
		 */
		board.draw(g2d);
		
		//przyciski
//		g2d.setColor(Color.BLUE);
//		g2d.fillRect(20, GameFrame.HEIGHT - 70, 80, 25);
//		g2d.setColor(Color.WHITE);
//		g2d.drawString("Clear area", 28, GameFrame.HEIGHT - 60);
		
		
		g2d.dispose();
		
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			board.nextStep();
		}
//		else if(e.getKeyCode() == KeyEvent.VK_S)
//		{
//			activePull = !activePull;
//		}
		
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		//System.out.println("here");
//		if (started == false)
//		{
//			int mouseX = e.getX();
//			int mouseY = e.getY();
//			System.out.println(mouseX + "\t" + mouseY);
//			if (board.setElement(mouseX, mouseY))
//				repaint();
			//System.out.println(board.setElement(mouseX, mouseY));
			
//		}
		
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		activePull = true;
		int mouseX = e.getX();
		int mouseY = e.getY();
		System.out.println(mouseX + "\t" + mouseY);
		if (board.setElement(mouseX, mouseY))
			repaint();
		
	}
	
	public void clearArea()
	{
		board.clearArrays();
		repaint();
	}

	public void setNewRules(String rulesSet)
	{
		if (rulesSet.length() < 1)
		{
			board.initRules(new int[]{2}, new int[]{3});
			return;
		}
			
		String[] splitedRules = rulesSet.split("/");
		int[] revive = splitStringOnInts(splitedRules[1]);
		int[] alives = splitStringOnInts(splitedRules[0]);
		
		board.initRules(alives, revive);
	}
	
	public int[] splitStringOnInts(String rules)
	{
		int[] array = new int[rules.length()];
		int i = 0;
		for (String num : rules.split(""))
		{
			array[i++] = Integer.parseInt(num);
		}
		
		return array;
	}

	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
//		// TODO Auto-generated method stub
//		if (activePull)
//		{
//			int mouseX = e.getX();
//			int mouseY = e.getY();
//			System.out.println(mouseX + "\t" + mouseY);
//			if (board.setElement(mouseX, mouseY))
//				repaint();
//		}
	}

}
