package Main_Project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {

	Handler handler;

	// controls of the player are here
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	// this is for the movement of the blocks velX and velY are initiated in the
	// player
	public void tick() {
		x += velX;
		y += velY;

		handler.addObject(new Trial(x, y, ID.Trial, Color.WHITE, 32, 32, 0.08f, handler));

		x = Game.clamp((int) x, 0, Game.WIDTH - 44);
		y = Game.clamp((int) y, 0, Game.HEIGHT - 64);

		collision();
	}

	public void collision() {

		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy
					|| tempObject.getId() == ID.SmartEnemy) {
				// in the above condition, temp object is the basic enemy
				if (getBounds().intersects(tempObject.getBounds())) {
					// code for what happens if there is a collision
					HUD.HEALTH -= 2;
				}
			}
			if (tempObject.getId() == ID.EnemyBoss) {
				// in the above condition, temp object is the basic enemy
				if (getBounds().intersects(tempObject.getBounds())) {
					// code for what happens if there is a collision
					HUD.HEALTH -= 20;
				}

			}
		}
	}

	// character is formed here
	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect((int) x, (int) y, 32, 32);

	}

}
