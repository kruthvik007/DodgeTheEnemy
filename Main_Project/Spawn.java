package Main_Project;

import java.util.Random;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	private Game game;

	int scoreKeep = 0;

	public Spawn(Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}

	public int getScoreKeep() {
		return scoreKeep;
	}

	public void setScoreKeep(int scoreKeep) {
		this.scoreKeep = scoreKeep;
	}

	public void tick() {
		scoreKeep++;

		if (scoreKeep >= 750) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			if (game.diff == 0) {
				if (hud.getLevel() == 2)
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));

				if (hud.getLevel() == 3)
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));

				if (hud.getLevel() == 4)
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.SmartEnemy, handler));

				if (hud.getLevel() == 5) {
					handler.clearEnemies();
					handler.addObject(new EnemyBoss2((Game.WIDTH / 2) - 64, -140, ID.EnemyBoss, handler));
				}
				if (hud.getLevel() == 8) {
					handler.clearEnemies();
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
				}

				if (hud.getLevel() == 9) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
				}

				if (hud.getLevel() == 10) {
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.SmartEnemy, handler));
				}
				if (hud.getLevel() == 11) {
					handler.clearEnemies();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 64, -140, ID.EnemyBoss, handler));
				}

				if (hud.getLevel() == 14) {
					handler.clearEnemies();
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
				}

				if (hud.getLevel() == 15) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
				}

				if (hud.getLevel() == 16) {
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.SmartEnemy, handler));
				}
				if (hud.getLevel() == 17) {
					handler.clearEnemies();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 64, -140, ID.EnemyBoss, handler));
					handler.addObject(new EnemyBoss2((Game.WIDTH / 2) - 64, -140, ID.EnemyBoss, handler));
				}

			} else if (game.diff == 1) {
				if (hud.getLevel() == 2)
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));

				if (hud.getLevel() == 3)
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));

				if (hud.getLevel() == 4)
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.SmartEnemy, handler));

				if (hud.getLevel() == 5) {
					handler.clearEnemies();
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 64, -140, ID.EnemyBoss, handler));
				}

				if (hud.getLevel() == 8) {
					handler.clearEnemies();
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
				}
				if (hud.getLevel() == 9) {
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));	
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
									ID.BasicEnemy, handler));
				}
				if (hud.getLevel() == 10) {
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.SmartEnemy, handler));
					
				}
				if (hud.getLevel() == 11) {
					handler.clearEnemies();
					handler.addObject(new EnemyBoss2((Game.WIDTH / 2) - 64, -140, ID.EnemyBoss, handler));
				}
				
				
				
				if (hud.getLevel() == 14) {
					handler.clearEnemies();
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));
				}
				if (hud.getLevel() == 15) {
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.BasicEnemy, handler));	
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
									ID.BasicEnemy, handler));
				}
				if (hud.getLevel() == 16) {
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 64), r.nextInt(Game.HEIGHT - 64),
							ID.SmartEnemy, handler));
					
				}
				if (hud.getLevel() == 17) {
					handler.clearEnemies();
					handler.addObject(new EnemyBoss2((Game.WIDTH / 2) - 64, -140, ID.EnemyBoss, handler));
					handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 64, -140, ID.EnemyBoss, handler));
					
				}
				
			}
		}
	}
}
