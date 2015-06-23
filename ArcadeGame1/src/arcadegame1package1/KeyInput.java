package arcadegame1package1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];	
	
	// The KeyInput constructor
	public KeyInput(Handler handler){
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		
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
				if(key == KeyEvent.VK_W){
					tempObject.setVelY(-5);
					keyDown[0] = true;
				}
				if(key == KeyEvent.VK_S){
					tempObject.setVelY(5);
					keyDown[1] = true;
				}
				if(key == KeyEvent.VK_D){
					tempObject.setVelX(5);
					keyDown[2] = true;
				}
				if(key == KeyEvent.VK_A){
					tempObject.setVelX(-5);
					keyDown[3] = true;
				}
				
				
				
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
				if(key == KeyEvent.VK_W){
					keyDown[0] = false;
				}
				if(key == KeyEvent.VK_S){
					keyDown[1] = false;
				}
				if(key == KeyEvent.VK_D){
					keyDown[2] = false;
				}
				if(key == KeyEvent.VK_A){
					keyDown[3] = false;

				}
				
				// For vertical movement
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				
				// For horizontal movement
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
			}
	}
	
	

}
