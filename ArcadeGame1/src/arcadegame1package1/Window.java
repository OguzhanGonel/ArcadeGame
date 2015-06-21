package arcadegame1package1;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;




public class Window extends Canvas{

	
	private static final long serialVersionUID = 8060522679042715877L;

	public Window(int width, int height, String title, GameMain game){
		
		JFrame frame = new JFrame(title);
		
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
