package main;

import java.awt.Graphics;
import java.awt.Rectangle;

import classes.EntityA;

public class Bullet extends GameObject implements EntityA {

	Textures tex;
	Game game;

	public Bullet(double x, double y, Textures tex, Game game) {
		super(x, y);
		this.tex = tex;
		this.game = game;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public void tick() {
		y -= 2;
	}

	public void render(Graphics g) {
		g.drawImage(tex.bullet, (int) x, (int) y, null);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
