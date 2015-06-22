package arcadegame1package1;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x, y;
	protected ID id;
	protected int velX, velY;
	
	
	//GameObject constructor
	public GameObject(int x, int y, ID id){
		
		this.x = x;
		this.y = y;
		this.id = id;
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	//Sets the x value
	public void setX(int x){
		this.x = x;
	}
	
	//Gets the y value
	public int getX(){
		return x;
	}
	
	//Sets the y value
	public void setY(int y){
		this.y = y;
	}
	
	//Gets the y value
	public int getY(){
		return y;
	}
	
	//Sets the ID value
	public void setID(ID id){
		this.id = id;
	}
	
	//Gets the ID value
	public ID getID(){
		return id;
	}
	
	//Sets the velocity of x 
	public void setVelX(int velX){
		this.velX = velX;
	}
	
	//Gets the velocity of x 
	public int getVelX(){
		return velX;
	}
	
	//Sets the velocity of y 
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	//Gets the velocity of y
	public int getVelY(){
		return velY;
	}
	
	
	
}
