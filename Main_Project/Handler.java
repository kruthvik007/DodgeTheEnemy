package Main_Project;

import java.awt.Graphics;
import java.util.LinkedList;

import Main_Project.Game.STATE;

//render all objects, controls all objects and individually update them
public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	//speed of the player
	public int move = 5;

	
//tick and render functions keeps taking in temporary objects for the value of i(ie:-each object at a time)
	public void tick() {
		//this loops for all the game objects present in the game
		for(int i =0;i<object.size();i++)
		{
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for(int i =0;i<object.size();i++)
		{
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
		
	}
	//for removing all present enemies for the boss level
	public void clearEnemies() {
		for(int i =0;i<object.size();i++)
		{
			GameObject tempObject = object.get(i);
			
			if(tempObject.getId()== ID.Player) {
				object.clear();
				addObject(new Player(tempObject.x, tempObject.y, ID.Player, this));
			}
			
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	//function used to make the boss bullets disappear
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}
