package main;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import classes.EntityA;
import classes.EntityB;

public class Controller {
	private LinkedList<EntityA> ea = new LinkedList<EntityA>();
	private LinkedList<EntityB> eb = new LinkedList<EntityB>();

	EntityA ena;
	EntityB enb;
	Textures tex;
	private Game game;

	Random r = new Random();

	public Controller(Textures tex, Game game) {
		this.tex = tex;
		this.game = game;
	}

	public void addEnemy(int enemy_count) {
		for (int i = 0; i < enemy_count; i++) {
			addEntity(new Enemy(r.nextInt(Game.WIDTH * Game.SCALE), -10, tex, game, this));
		}
	}

	public LinkedList<EntityA> getEntityA() {
		return ea;
	}

	public LinkedList<EntityB> getEntityB() {
		return eb;
	}

	public void tick() {
		// Class A
		for (int i = 0; i < ea.size(); i++) {
			ena = ea.get(i);
			ena.tick();
		}

		// Classs B

		for (int i = 0; i < eb.size(); i++) {
			enb = eb.get(i);
			enb.tick();
		}
	}

	public void render(Graphics g) {
		// Class A
		for (int i = 0; i < ea.size(); i++) {
			ena = ea.get(i);
			ena.render(g);
		}

		// Classs B

		for (int i = 0; i < eb.size(); i++) {
			enb = eb.get(i);
			enb.render(g);
		}
	}

	public void addEntity(EntityA entity) {
		ea.add(entity);
	}

	public void removeEntity(EntityA entity) {
		ea.remove(entity);
	}

	public void addEntity(EntityB entity) {
		eb.add(entity);
	}

	public void removeEntity(EntityB entity) {
		eb.remove(entity);
	}

}
