package arcadegame1package1;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;



// This is the game window where the game is played
public class Window extends Canvas{

	
	private static final long serialVersionUID = 8060522679042715877L;

	// The Window constructor
	public Window(int width, int height, String title, GameMain game){
		
		JFrame frame = new JFrame(title);
		
		// The games frames are set below
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
				
	}

	

}
