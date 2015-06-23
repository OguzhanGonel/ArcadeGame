package arcadegame1package1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

//This is the main class of the game
public class GameMain extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -8529200167762764085L;

	public static final int Width = 640, Height = Width / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	private Random r;
	private Spawn spawner;
	
	// The GameMain constructor
	public GameMain(){
		
		handler = new Handler();
		
		//listening to key inputs such as A, W, S, D
		this.addKeyListener(new KeyInput(handler));
		
		//creating the game window
		new Window(Width, Height, "Building a game", this);	
		
		hud = new HUD();
		spawner = new Spawn(handler, hud);
		r = new Random();
		
		//Adding the player
		handler.addObject(new Player(Width/2-32, Height/2, ID.Player, handler));

		//Adding the enemy that starts at level 1
		handler.addObject(new BasicEnemy(r.nextInt(GameMain.Width), r.nextInt(GameMain.Height), ID.BasicEnemy, handler));

		
	}
	
	//This creates a thread for the game
	public synchronized void start(){
		
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
	public synchronized void stop(){
		
		try {
			thread.join();
			running = false;
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	
		
	}
	
	//This method runs the game
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now -lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	//The tick method for GameMain
	private void tick(){
		handler.tick();
		hud.tick();
		spawner.tick();
	}
	
	//This renders the game window
	private void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g= bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, Width, Height);
		
		handler.render(g);

		hud.render(g);

		
		g.dispose();
		bs.show();
		
	}
	
	// This method makes sure the player stays within the game boundaries
	public static float clamp(float var, float min, float max){
		if(var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}
	
	//This is the main method of the project
	public static void main(String args[]){
		
		new GameMain();
		
	}

}
