package arcadegame1package1;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static int Health = 100;
	
	private int greenValue = 255;
	
	public void tick(){
		Health = GameMain.clamp(Health, 0, 100);
		greenValue = GameMain.clamp(greenValue, 0, 255);
		
		greenValue = Health * 2;
	}

	public void render(Graphics g){
		g.setColor(Color.white);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, greenValue, 0));
		g.fillRect(15, 15, Health * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
	}
}
