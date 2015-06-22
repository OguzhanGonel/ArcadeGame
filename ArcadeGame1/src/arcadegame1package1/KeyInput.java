package arcadegame1package1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	
	// The KeyInput constructor
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	// Handles the keys pressed by the player, such as A, W, S, D
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		System.out.println(key);
		
		// loops through the objects in the game
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			// if the current object is the player in the game, then the if statement is true
			if(tempObject.getID() == ID.Player){
				//Key events for player 1
				
				// The game keys make actions
				if(key == KeyEvent.VK_W) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_S) tempObject.setVelY(5);
				if(key == KeyEvent.VK_D) tempObject.setVelX(5);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-5);
			}
		}
		// This closes the game if the user hits the Escape key on the key board
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	
	// Handlers the keys released by the player
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		// loops through the objects in the game
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			// if the current object is the player in the game, then the if statement is true
			if(tempObject.getID() == ID.Player){
				//Key events for player 1
				
				// If the key is released, the velocity is set to 0
				if(key == KeyEvent.VK_W) tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
			}
			}
	}
	
	

}
