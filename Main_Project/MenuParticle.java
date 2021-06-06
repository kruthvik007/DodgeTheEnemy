package Main_Project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

//this class is just for background effects
public class MenuParticle extends GameObject{

	private Handler handler;
	Random r = new Random();

	private Color col;
	
	public MenuParticle(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = (r.nextInt(5 - -5) + -5);
		if(velX == 0) velX = 1;
		if(velY == 0) velY = 1;
		
		
		col = new Color( r.nextInt(255), r.nextInt(255), r.nextInt(255));
		
	}

	public void tick() { 
		x += velX;
		y += velY;
		if(y < 0 || y > Game.HEIGHT-48) velY*=-1;
		if(x < 0 || x > Game.WIDTH-32) velX*=-1;
		
		//for trail
		handler.addObject(new Trial(x,y,ID.Trial,col,16,16,0.02f,handler));
		
	}

	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}

}