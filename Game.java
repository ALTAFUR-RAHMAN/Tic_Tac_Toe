package ttt7;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Game extends JFrame {
	
	
	Position position = new Position();
	JButton[] buttons = new JButton[Position.SIZE];
	
	
	
	
	public Game()
	{
		setLayout(new GridLayout(Position.dim, Position.dim));
		for(int i = 0;i<Position.SIZE;i++)
		{
			final JButton button = createButtons();
			buttons[i] = button;
			final int idx = i;
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					button.setText(Character.toString(position.turn));
				   position.move(idx);
				   
				   if(!position.isGameEnd())
				   {
					   int best = position.bestMove();
					   buttons[best].setText(Character.toString(position.turn));
					   position.move(best);
				   }
				   if(position.isGameEnd())
				   {
					   String message = position.isWinFor('x') ? "You Won!" :
						                position.isWinFor('o') ? "Computer Won!" : "Draw" ; 
					   
					   JOptionPane.showMessageDialog(null, message);
				   }
				}
			
			});
		}
		
		
		pack();
		setVisible(true);
		
	}

	private JButton createButtons() {
		// TODO Auto-generated method stub
		
		JButton button =new JButton();
		button.setPreferredSize(new Dimension(100, 100));
		button.setBackground(Color.WHITE);
		button.setOpaque(true);
		button.setFont(new Font(null, Font.PLAIN,70));
		add(button);
		
		return button;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				new Game();
			}
		});

	}

}
