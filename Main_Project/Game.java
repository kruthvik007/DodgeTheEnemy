package Main_Project;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -623912424945458201L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	public boolean running = false;

	public static boolean paused = false;
	//normal = 0
	//hard = 1
	public static int diff = 0;
	

	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	
	// an enum class for the display screens of the game as menu and others
	public enum STATE {
		Menu,
		Select,
		Help,
		Shop,
		End,
		Game
	};

	public static STATE gameState = STATE.Menu;

	// the function that will initiate the game
	public Game() {
		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler,hud);
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		this.addMouseListener(shop);

		new Window(WIDTH, HEIGHT, "Let's start the Games...", this);

		spawner = new Spawn(handler, hud,this);
		r = new Random();

		if (gameState == STATE.Game) {
			// player initialize
			handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
			handler.addObject(
					new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.BasicEnemy, handler));
		} else {
			for (int i = 0; i < 10; i++) {
				handler.addObject(new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler));
			}
		}
	}

	// this function will start the game
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	// this function will end the game
	public synchronized void stop() {
		try {
			thread.join();
			running = false;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// loop for the game to rum
	public void run() {
		// loop for all basic games
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;
			// displays the FPS(can be decreased if the 100 is increased to 1000)
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {

		if (gameState == STATE.Game) {

			if (!paused) { 
				hud.tick();
				spawner.tick();
				handler.tick();

				if (HUD.HEALTH <= 0) {
					HUD.HEALTH = 100;	
					gameState = STATE.End;
					handler.clearEnemies();
				}

			}
		} else if (gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Help || gameState == STATE.Select) {
			menu.tick();
			handler.tick();
		}
	}

	// the function used to remove volatile images and decrease the frames per
	// second
	private void render() {
		// to render the volatile images
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		// this part is to set the background color
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if (paused) {
			g.setColor(Color.red);
			g.drawString("PAUSED", this.WIDTH/2-36,this.HEIGHT/2-36);
		}
		
		if (gameState == STATE.Game) {
			hud.Render(g);
			handler.render(g);
		} else if(gameState == STATE.Shop) {
			shop.render(g);
		} else if (gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select) {
			menu.render(g);
			handler.render(g);
		}
		

		
		g.dispose();
		bs.show();
	}

	// to keep the characters in the screen or in its specific value limit
	public static float clamp(float var, float min, float max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;

	}

	// main function to run the game
	public static void main(String[] args) {
		new Game();
	}
}
