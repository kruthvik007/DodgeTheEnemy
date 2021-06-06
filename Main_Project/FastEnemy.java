package Main_Project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{

	private Handler handler;
	
	public FastEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = 2;
		velY = 9;
	}

	public void tick() { 
		x += velX;
		y += velY;
		//to make the enemy bounce of  the walls
		if(y < 0 || y > Game.HEIGHT-48) velY*=-1;
		if(x < 0 || x > Game.WIDTH-32) velX*=-1;
		
		//for trial
		handler.addObject(new Trial(x,y,ID.Trial,Color.CYAN,16,16,0.02f,handler));
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

}