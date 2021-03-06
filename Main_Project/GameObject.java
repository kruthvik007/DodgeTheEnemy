package Main_Project;

import java.awt.Graphics;
import java.awt.Rectangle;

//enemy and player are examples of game object 
public abstract class GameObject {

	//coordinates of the objects
	protected float x,y;
	protected ID id;
	protected float velX,velY;

	//to take in details like coordinates and to differentiate between player and enemy
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;	
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	//to check if the enemy is touching the player or not
	public abstract Rectangle getBounds();
	
	public void setX(float x) {
		this.x = x;
	}	

	public float getX() {
		return x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float getY() {
		return y;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public ID getId() {
		return id;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
}
