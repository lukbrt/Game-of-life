package pl.s15487.Game;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javafx.scene.layout.Border;

public class GameFrame extends JFrame
{
	public final static int WIDTH = 600;
	public final static int HEIGHT = 660;
	
	public GameFrame()
	{
		setLayout(new BorderLayout());
		setTitle("Gra w ĹĽycie");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(WIDTH, HEIGHT));
		
		BoardPanel boardPanel = new BoardPanel();
		boardPanel.setPreferredSize(new Dimension(600, 600));
		add(boardPanel, BorderLayout.CENTER);
		
		JPanel southPanel = new JPanel(new BorderLayout());
		
		JButton clearButton = new JButton("Clear area");
		clearButton.addActionListener(e -> 
		{
			boardPanel.clearArea();
			boardPanel.grabFocus();
		});
		southPanel.add(clearButton, BorderLayout.WEST);
		
		JPanel contrPanel = new JPanel();
		JTextField contraintsField = new JTextField(10);
		contrPanel.add(contraintsField);
		JButton enterContraints = new JButton("Dodaj ograniczenia");
		enterContraints.addActionListener(e ->
		{
			String rules = contraintsField.getText();
			if (rules != null && rules != "")
				boardPanel.setNewRules(rules);
			
			boardPanel.grabFocus();
		});
		contrPanel.add(enterContraints);
		southPanel.add(contrPanel,BorderLayout.EAST);
		
		add(southPanel, BorderLayout.SOUTH);
		
		
		//JButton clearButton = new JButton("Clear area");
		//add(clearButton);
		//panel.add(clearButton);

		
//		JPanel panel = new JPanel(new BorderLayout());
//		
//		panel.add(new BoardPanel(), BorderLayout.CENTER);
//		
//		JButton buttonStart = new JButton("Start");
//		buttonStart.addActionListener(e ->
//			{
//				
//			});
//		panel.add(buttonStart, BorderLayout.SOUTH);
//		add(panel);
		
		setVisible(true);
	}

}
