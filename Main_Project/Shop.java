package Main_Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter{

	Handler handler;
	HUD hud;
	
	private int B1 = 500;
	private int B2 = 500;
	private int B3 = 200;
	
	
	public Shop(Handler handler,HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.setFont(new Font("Arial",0,48));
		g.drawString("SHOP", 250, 50);
		
		g.setFont(new Font("Arial",0,21));
		g.setColor(Color.white);
		
		//Box 1
		g.drawString("Upgrade Health", 60, 130);
		g.drawString("Cost: " + B1, 60, 160);
		g.drawRect(55, 105, 160, 70);
		
		//Box 2
		g.drawString("Upgrade Speed", 240, 130);
		g.drawString("Cost: " + B2, 240, 160);
		g.drawRect(235, 105, 160, 70);
		
		//Box 3
		g.drawString("Refill Health", 420, 130);
		g.drawString("Cost: " + B3, 420, 160);
		g.drawRect(415, 105, 160, 70);
		
		g.drawString("Your Score: " + hud.getScore(), 240, 80);
		
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//for box 1
		if(mx >= 55 && mx <= 215) {
			if(my >= 105 && my <= 175) {
				
				if(hud.getScore() >= B1) {
					hud.setScore(hud.getScore() - B1);
					B1 += 500;
					hud.bounds += 30;
					hud.HEALTH = (100 +(hud.bounds/2));
				}
			}
		}
		//for box 2
		if(mx >= 235 && mx <= 385) {
			if(my >= 105 && my <= 175) {				
				
				if(hud.getScore() >= B2) {
					hud.setScore(hud.getScore() - B2);
					B2 += 500;
					handler.move++;
				}
				
			}
		}
		//for box 3
		if(mx >= 415 && mx <= 575) {
			if(my >= 105 && my <= 175 ) {
				
				if(hud.getScore() >= B3) {
					hud.setScore(hud.getScore() - B3);
					B3 += 250;
					hud.HEALTH = (100 +(hud.bounds/2));

				}
			}	
		}
	}
}
