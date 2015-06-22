package arcadegame1package1;

import java.awt.Graphics;
import java.util.LinkedList;

// This class keeps track of all the players and handles them
public class Handler {
	
	// LinkedList for the game objects such as players and enemies
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	// Implements the tick method for the Handler class
	public void tick(){
		
		for(int i = 0; i < object.size(); i++){

			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	// Renders the Game Objects to the game
	public void render(Graphics g){
		
		for(int i = 0; i < object.size(); i++){

			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	// Adds an object to the LinkedLIst
	public void addObject(GameObject object){
		this.object.add(object);
	}

	//Removes an object from the LinkedList
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
}
