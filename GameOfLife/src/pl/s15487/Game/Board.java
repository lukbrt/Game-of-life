package pl.s15487.Game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Arrays;

import javax.swing.JPanel;

public class Board
{ 
	public final static int ROWS = 40, COL = 40;
	
	private int prevArray[][], currentArray[][];
	public int bw, bh;
	
	private int aliveArray[], reviveArray[];
	
	public Board()
	{
		prevArray = new int[ROWS][COL];
		currentArray = new int[ROWS][COL];
		
		//Initial rules: default rules of Game of Life
		aliveArray = new int[] {2};
		reviveArray = new int[] {3};
		
		
//		for (int i = 0; i < ROWS; i++)
//		{
//			for (int j = 0; j < COL; j++)
//			{
//				prevArray[i][j] = 0;
//				currentArray[i][j] = 0;
//			}
//		}
		
		prevArray[10][20] = 1;
		prevArray[10][22] = 1;
		prevArray[11][19] = 1;
		prevArray[11][20] = 1;
		prevArray[30][0] = 1;
		prevArray[0][0] = 1;
		
		prevArray[30][30] = 1;
		prevArray[30][31] = 1;
		prevArray[31][30] = 1;
		prevArray[31][31] = 1;
		
		prevArray[35][5] = 1;
		prevArray[36][5] = 1;
		prevArray[37][5] = 1;
		prevArray[36][4] = 1;
		prevArray[36][6] = 1;
		
		prevArray[3][0] = 1;
		prevArray[4][0] = 1;
		prevArray[3][39] = 1;
		prevArray[4][39] = 1;
		
		currentArray[10][20] = 1;
		currentArray[10][22] = 1;
		currentArray[11][19] = 1;
		currentArray[11][20] = 1;
		currentArray[30][0] = 1;
		currentArray[0][0] = 1;
		
		currentArray[30][30] = 1;
		currentArray[30][31] = 1;
		currentArray[31][30] = 1;
		currentArray[31][31] = 1;
		
		currentArray[35][5] = 1;
		currentArray[36][5] = 1;
		currentArray[37][5] = 1;
		currentArray[36][4] = 1;
		currentArray[36][6] = 1;
		
		currentArray[3][0] = 1;
		currentArray[4][0] = 1;
		currentArray[3][39] = 1;
		currentArray[4][39] = 1;
		
		bw = GameFrame.WIDTH / (COL + 1);
		bh = (GameFrame.HEIGHT - 60) / (ROWS + 1);
	}

	public void draw(Graphics2D g2d)
	{
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				if (currentArray[i][j] == 1)
					g2d.setColor(Color.YELLOW);
				else if (currentArray[i][j] == 0)
					g2d.setColor(Color.lightGray);
				g2d.fillRect(j * bw + 15, i * bh + 15, bw, bh);
				
				g2d.setStroke(new BasicStroke(2));
				g2d.setColor(Color.BLACK);
				g2d.drawRect(j * bw + 15, i * bh + 15, bw, bh);
			}
		}
	}
	
	public void nextStep()
	{
		int neighbors = 0;
		int l, r, t, b;
		
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				neighbors = 0;
				l = j - 1;
				r = j + 1;
				t = i - 1;
				b = i + 1;
				if (l < 0)
					l = COL - 1;
				if (r > COL - 1)
					r = 0;
				if (t < 0)
					t = ROWS - 1;
				if (b > ROWS - 1)
					b = 0;
				
				//rogi
				if (prevArray[t][l] == 1)
					neighbors++;
				if (prevArray[t][r] == 1)
					neighbors++;
				if (prevArray[b][l] == 1)
					neighbors++;
				if (prevArray[b][r] == 1)
					neighbors++;
				//boki
				if (prevArray[t][j] == 1)
					neighbors++;
				if (prevArray[b][j] == 1)
					neighbors++;
				if (prevArray[i][r] == 1)
					neighbors++;
				if (prevArray[i][l] == 1)
					neighbors++;
				
				
//				if (neighbors == 2 && prevArray[i][j] == 1)
//				{
//					currentArray[i][j] = 1;
//				}
//				else if (neighbors == 3)
//				{
//					currentArray[i][j] = 1;
//				}
//				else
//				{
//					currentArray[i][j] = 0;
//				}
				
				if (inSet(aliveArray, neighbors) && prevArray[i][j] == 1)
				{
					currentArray[i][j] = 1;
				}
				else if (inSet(reviveArray, neighbors))
				{
					currentArray[i][j] = 1;
				}
				else
				{
					currentArray[i][j] = 0;
				}
				
			}
		}
		
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				prevArray[i][j] = currentArray[i][j];
			}
		}
		
	}
	
	public boolean setElement(int x, int y)
	{
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				if (x >= j * bw + 15 && x <= j * bw + 15 + bw && y >= i * bh + 15 && y <= i * bh + 15 + bh)
				{
					if (prevArray[i][j] == 0)
					{
						prevArray[i][j] = 1;
						currentArray[i][j] = 1;
					}
					else
					{
						prevArray[i][j] = 0;
						currentArray[i][j] = 0;
					}
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void clearArrays()
	{
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				prevArray[i][j] = 0;
				currentArray[i][j] = 0;
			}
		}
	}
	
	public void initRules(int[] alive, int[] revives)
	{
		aliveArray = alive;
		reviveArray = revives;
	}
	
	private boolean inSet(int[] array, int neighboursCells)
	{
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == neighboursCells)
				return true;
		}
		
		return false;
	}
}
