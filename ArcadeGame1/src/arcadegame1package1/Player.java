package arcadegame1package1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
	
	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler){
		super(x, y, id);	
		this.handler = handler;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 32, 32);
	}
	
	
	public void tick(){
		x += velX;
		y += velY;
		
		x = GameMain.clamp(x, 0, GameMain.Width - 37);
		y = GameMain.clamp(y, 0, GameMain.Height - 60);

		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));

		collision();

	}
	
	private void collision(){
		for (int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.BasicEnemy){
				if(getBounds().intersects(tempObject.getBounds())){
					//collision code
					HUD.Health -=2;
				}
			}
		}
	}
	
	public void render(Graphics g){
		
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	

}
