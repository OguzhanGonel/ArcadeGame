package arcadegame1package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	
	private Handler handler;

	//BasicEnemy constructor
	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 5;
		velY = 5;
	}

	//Creating how the basic enemy looks
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	//Implementing the tick method for the BasicEnemy
	public void tick() {
		x += velX;
		y += velY;
		
		//Making sure that the enemy stays within the boundaries of the game
		if(y <= 0 || y >= GameMain.Height - 32) velY *= -1;
		if(x <= 0 || x >= GameMain.Width - 16) velX *= -1;

		//Adding the trail for the enemy
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
	}


	//Designing the enemy
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
	

}
