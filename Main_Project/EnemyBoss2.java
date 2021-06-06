package Main_Project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss2 extends GameObject{

	private Handler handler;
	Random r = new Random();
	private int timer = 100;
	private int timer2 = 50;
	
	
	public EnemyBoss2(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 0;
		velY = 2;
	}

	public void tick() { 
		x += velX;
		y += velY;
		
		if(timer<=0)
		{	
			velY = 0;
			timer2--;
		}
		else
			timer--;
		
		if(timer2 <= 0) {
			
			if(velX == 0) { velX = -2;}
			
			int spawn = r.nextInt(10);
			if(spawn == 0) handler.addObject(new EnemyBossBullet((int)x + 48, (int)y + 48, ID.BasicEnemy, handler));
		}
		
		if(x < 0 || x > Game.WIDTH-112) velX*=-1;

	}

	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 96, 96);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,96,96);
	}

}