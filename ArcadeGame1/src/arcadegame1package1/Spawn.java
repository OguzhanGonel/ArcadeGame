package arcadegame1package1;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	//The Spawn Constructor
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}

	//Implementing the abstract method tick for Spawn class
	public void tick(){
		scoreKeep++;
		
		//Adding new enemies etc as the levels get higher
		if(scoreKeep >= 200){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			//Adding a basic enemy 
			if(hud.getLevel() == 2){
				handler.addObject(new BasicEnemy(r.nextInt(GameMain.Width), r.nextInt(GameMain.Height), ID.BasicEnemy, handler));
			}
			
			//Adding a basic enemy 
			if(hud.getLevel() == 3){
				handler.addObject(new BasicEnemy(r.nextInt(GameMain.Width), r.nextInt(GameMain.Height), ID.BasicEnemy, handler));
			}
			
			//Adding a fast enemy 
			if(hud.getLevel() == 4){
				handler.addObject(new FastEnemy(r.nextInt(GameMain.Width), r.nextInt(GameMain.Height), ID.FastEnemy, handler));
			}
		}
	}
}
