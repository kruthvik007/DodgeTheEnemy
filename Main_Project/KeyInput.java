package Main_Project;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Main_Project.Game.STATE;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	Game game;

	public KeyInput(Handler handler, Game game) {

		this.handler = handler;

		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {

			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				// all the key events from player1
				if (key == KeyEvent.VK_W)
					tempObject.setVelY(-handler.move);
				if (key == KeyEvent.VK_S)
					tempObject.setVelY(handler.move);
				if (key == KeyEvent.VK_D)
					tempObject.setVelX(handler.move);  
				if (key == KeyEvent.VK_A)
					tempObject.setVelX(-handler.move);
			}
		}

		if (key == KeyEvent.VK_P && Game.gameState == STATE.Game) { 

				if (Game.paused)
					Game.paused = false;
				else
					Game.paused = true;
				return;
		}

		if (key == KeyEvent.VK_ESCAPE)
			System.exit(0);
		
		if (key == KeyEvent.VK_SPACE) {
			if (Game.gameState == STATE.Game)
				Game.gameState = STATE.Shop;
			else if (Game.gameState == STATE.Shop)
				Game.gameState = STATE.Game;
		}

		
		
	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				// all the key events from player1
				if (key == KeyEvent.VK_W)
					tempObject.setVelY(0);
				if (key == KeyEvent.VK_S)
					tempObject.setVelY(0);
				if (key == KeyEvent.VK_D)
					tempObject.setVelX(0);
				if (key == KeyEvent.VK_A)
					tempObject.setVelX(0);
			}

		}
	}

}
