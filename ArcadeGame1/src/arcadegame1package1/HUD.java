package arcadegame1package1;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

	public static float Health = 100;
	
	private float greenValue = 255;
	private float score = 0;
	private float level = 1;
	
	public void tick(){
		Health = GameMain.clamp(Health, 0, 100);
		greenValue = GameMain.clamp(greenValue, 0, 255);
		
		greenValue = Health * 2;
		
		score++;
	}

	public void render(Graphics g){
		g.setColor(Color.white);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect((int)15, (int)15, (int)Health * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		g.drawString("Score: " + score, 15, 64);
		g.drawString("Level: " + level, 15, 80);
	}
	
	public void score(float score){
		this.score = score;
	}
	
	public float getScore(){
		return score;
	}
	
	public float getLevel(){
		return level;
	}
	
	public void setLevel(float level){
		this.level = level;
	}
}
