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
			
			//Adding the enemies
			if(hud.getLevel() == 2){
				handler.addObject(new BasicEnemy(r.nextInt(GameMain.Width), r.nextInt(GameMain.Height), ID.BasicEnemy, handler));
			}
			/*
			//Adding a basic enemy 
			else if(hud.getLevel() == 3){
				handler.addObject(new BasicEnemy(r.nextInt(GameMain.Width), r.nextInt(GameMain.Height), ID.BasicEnemy, handler));
			}
			
			//Adding a fast enemy 
			else if(hud.getLevel() == 4){
				handler.addObject(new FastEnemy(r.nextInt(GameMain.Width), r.nextInt(GameMain.Height), ID.FastEnemy, handler));
			}
			
			//Adding a smart enemy 
			else if(hud.getLevel() == 5){
				handler.addObject(new FastEnemy(r.nextInt(GameMain.Width), r.nextInt(GameMain.Height), ID.FastEnemy, handler));
			}

			//Adding a smart enemy 
			else if(hud.getLevel() == 6){
				handler.addObject(new SmartEnemy(r.nextInt(GameMain.Width), r.nextInt(GameMain.Height), ID.SmartEnemy, handler));
			}*/

			//Adding Enemy Boss #1 
			else if(hud.getLevel() == 4){
				handler.clearEnemies();
				handler.addObject(new EnemyBoss1((GameMain.Width / 2 - 48), -120, ID.EnemyBoss1, handler));
			}
		}
	}
}
