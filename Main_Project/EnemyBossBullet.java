package Main_Project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	public EnemyBossBullet(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = 5;
	}

	public void tick() { 
		x += velX;
		y += velY;
		
		//to make the bullet disappear
		if(y>=Game.HEIGHT) handler.removeObject(this);
		
		//for trial
		//handler.addObject(new Trial(x,y,ID.Trial,Color.LIGHT_GRAY,8,8,0.05f,handler));
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect((int)x, (int)y, 8, 8);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,8,8);
	}

}