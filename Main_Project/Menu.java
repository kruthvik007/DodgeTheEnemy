package Main_Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import Main_Project.Game.STATE;

public class Menu extends MouseAdapter {

	private Handler handler;
	private HUD hud;
	private Spawn spawn;
	Random r = new Random();

	// to initialize this constructor in the main game file
	public Menu(Game game, Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}

	// function to determine what happens when the mouse is clicked
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (Game.gameState == STATE.Menu) {
			// play button
			if (mouseOver(mx, my, 205, 150, 200, 64)) {
				Game.gameState = STATE.Select;
				return;
			}

			// help button
			if (mouseOver(mx, my, 205, 250, 200, 64)) {
				Game.gameState = STATE.Help;
			}

			// quit game
			if (mouseOver(mx, my, 205, 350, 200, 64)) {
				System.exit(0);
			}
		}

		// in the select screen
		if (Game.gameState == STATE.Select) {
			// normal button
			if (mouseOver(mx, my, 205, 150, 200, 64)) {
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.BasicEnemy,
						handler));

				Game.diff = 0;
			}

			// hard button
			if (mouseOver(mx, my, 205, 250, 200, 64)) {
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64), ID.BasicEnemy, handler));

				Game.diff = 1;
			}

			// back button
			if (mouseOver(mx, my, 205, 350, 200, 64)) {
				Game.gameState = STATE.Menu;
			}
		}
 
		// back button in the help page
		if (Game.gameState == STATE.Help) {
			if (mouseOver(mx, my, 500, 350, 100, 32)) {
				Game.gameState = STATE.Menu;
			}
		}

		if (Game.gameState == STATE.End) {
			if (mouseOver(mx, my, 200, 350, 200, 64)) {
				Game.gameState = STATE.Menu;
				hud.setLevel(1);
				hud.setScore(0);
				spawn.setScoreKeep(0);
			}
		}

	}

	public void mouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < (x + width)) {
			if (my > y && my < (y + height)) {
				return true;
			} else
				return false;
		} else
			return false;

	}

	public void tick() {

	}

	public void render(Graphics g) {
		if (Game.gameState == STATE.Menu) {
			g.setColor(Color.GREEN);
			Font fnt = new Font("Arial", 1, 50);
			Font fnt2 = new Font("Times New Roman", 1, 40);

			g.setFont(fnt);
			g.drawString("Dodge the Enemy", 120, 100);

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(205, 150, 200, 64);
			g.drawString("Play", 265, 193);

			g.setColor(Color.white);
			g.drawRect(205, 250, 200, 64);
			g.drawString("Help", 265, 293);

			g.setColor(Color.white);
			g.drawRect(205, 350, 200, 64);
			g.drawString("Quit", 265, 393);
		} else if (Game.gameState == STATE.Help) {
			g.setColor(Color.GREEN);
			Font fnt2 = new Font("Times New Roman", 1, 30);
			Font fnt3 = new Font("Fraktur", 1, 20);
			Font fnt = new Font("Arial", 1, 50);
			g.setFont(fnt);
			g.drawString("Help", 260, 100);

			g.setColor(Color.white);
			g.setFont(fnt3);
			g.drawString("Main aim in this game is to dodge the enemies.", 50, 150);
			g.drawString("Use keys W A S D to move your player.", 50, 175);
			g.drawString("W -> to move your character up.", 50, 200);
			g.drawString("S -> to move your character down.", 50, 225);
			g.drawString("A -> to move your character left.", 50, 250);
			g.drawString("D -> to move your character right.", 50, 275);
			g.drawString("P -> to pause the game.", 50, 300);

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(500, 350, 100, 32);
			g.drawString("Back", 518, 375);

		} else if (Game.gameState == STATE.End) {
			g.setColor(Color.GREEN);
			Font fnt2 = new Font("Times New Roman", 1, 30);
			Font fnt3 = new Font("Fraktur", 1, 20);
			Font fnt = new Font("Arial", 1, 50);
			g.setFont(fnt);
			g.drawString("Game Over", 180, 100);

			g.setColor(Color.white);
			g.setFont(fnt3);
			g.drawString("Your Score is " + hud.getScore(), 50, 150);
			g.drawString("Your Level is " + hud.getLevel(), 50, 175);

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(200, 350, 200, 64);
			g.drawString("Try Again", 230, 385);

		} else if (Game.gameState == STATE.Select) {
			g.setColor(Color.GREEN);
			Font fnt = new Font("Arial", 1, 50);
			Font fnt2 = new Font("Times New Roman", 1, 40);

			g.setFont(fnt);
			g.drawString("Select Difficulty", 100, 100);

			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(205, 150, 200, 64);
			g.drawString("Normal", 245, 193);

			g.setColor(Color.white);
			g.drawRect(205, 250, 200, 64);
			g.drawString("Hard", 265, 293);

			g.setColor(Color.white);
			g.drawRect(205, 350, 200, 64);
			g.drawString("Back", 265, 393);
		} 
	}

}
