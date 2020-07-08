package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import classes.EntityB;

public class Enemy extends GameObject implements EntityB {

	Random r = new Random();

	private Textures tex;
	private Game game;
	private Controller c;

	int speed = r.nextInt(2) + 1;

	public Enemy(double x, double y, Textures tex, Game game, Controller c) {
		super(x, y);
		this.tex = tex;
		this.game = game;
		this.c = c;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public void tick() {
		y += speed;
		if (y > (Game.WIDTH * Game.SCALE)) {
			y = 0;
			x = r.nextInt(Game.WIDTH * Game.SCALE);
			speed = r.nextInt(3) + 1;
		}
		if (Physics.Collision(this, game.ea)) {
			c.removeEntity(this);
			game.setEnemy_killed(game.getEnemy_killed() + 1);
			Game.count_score += 1;
		}
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void render(Graphics g) {
		g.drawImage(tex.enemy, (int) x, (int) y, null);
	}

	public Rectangle getRectBounds(int i, int j) {
		return null;
	}

}
