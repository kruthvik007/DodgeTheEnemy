package Main_Project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class HardEnemy extends GameObject{

	private Handler handler;
	private Random r = new Random();
	
	public HardEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 5;
		velY = 5;
	}

	public void tick() { 
		x += velX;
		y += velY;
		//to make the enemy bounce of  the walls
		if(y < 0 || y > Game.HEIGHT-64) { 
			if(velY<0)
				velY = -(r.nextInt(7)+1)*-1;
			else
				velY = (r.nextInt(7)+1)*-1;

		}
		if(x < 0 || x > Game.WIDTH-48) { 
			if(velX<0)
			velX = -(r.nextInt(7)+1)*-1;
		else
			velX = (r.nextInt(7)+1)*-1;
		 }
		
		//for trial
		handler.addObject(new Trial(x,y,ID.Trial,Color.yellow,16,16,0.02f,handler));
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

}