package main;

import java.awt.Graphics;
import java.awt.Rectangle;

import classes.EntityA;

public class Player extends GameObject implements EntityA {

	Textures tex;
	private Game game;

	public Player(double x, double y, Textures tex, Game game) {
		super(x, y);
		this.tex = tex;
		this.game = game;
	}

	public void tick() {
		if (x < 0) {
			x = 0;
		} else if (x > Game.WIDTH * Game.SCALE) {
			x = Game.WIDTH * Game.SCALE;
		} else if (y > Game.HEIGHT * Game.SCALE) {
			y = Game.HEIGHT * Game.SCALE;
		} else if (y < 0) {
			y = 0;
		}
		if (Physics.Collision(this, game.eb)) {
			System.exit(0);
		}
	}

	public void render(Graphics g) {
		g.drawImage(tex.player, (int) x, (int) y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}
