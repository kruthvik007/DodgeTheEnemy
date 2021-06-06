package Main_Project;

import java.awt.*;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -8074370659981218511L;

	//function for the size of the screen of the game
	public Window(int width, int height, String title,Game game) {
		JFrame frame = new JFrame(title);
		
		//setting the size
		frame.setPreferredSize(new Dimension (width,height));
		frame.setMaximumSize(new Dimension (width,height));
		frame.setMinimumSize(new Dimension (width,height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		
		//game is initialized
		game.start();		
	}
}