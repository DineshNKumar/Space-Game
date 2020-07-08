package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import classes.EntityA;
import classes.EntityB;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	private final String title = "Space Game";

	private boolean running = false;
	private Thread thread;

	private BufferedImage image;
	private BufferedImage tempImage = new BufferedImage(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

	private Player p;
	private Controller c;
	private Textures tex;

	private int enemy_count = 8;
	private int enemy_killed = 0;
	public static int count_score = 0;

	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;

	public void init() {
		try {
			image = ImageIO.read(getClass().getResource("/scene.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tex = new Textures(this);
		System.out.println(tex.toString());
		p = new Player(100, 300, tex, this);
		c = new Controller(tex, this);
		ea = c.getEntityA();
		eb = c.getEntityB();
		c.addEnemy(enemy_count);

		this.addKeyListener(new KeyInput(this));
	}

	public int getEnemy_count() {
		return enemy_count;
	}

	public void setEnemy_count(int enemy_count) {
		this.enemy_count = enemy_count;
	}

	public int getEnemy_killed() {
		return enemy_killed;
	}

	public void setEnemy_killed(int enemy_killed) {
		this.enemy_killed = enemy_killed;
	}

	private synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if (!running)
			return;

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}

	public void keyPressed(KeyEvent event) {
		double pos = 0;
		int key = event.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			c.addEntity(new Bullet(p.getX(), p.getY(), tex, this));
			running = true;
		} else if (key == KeyEvent.VK_A) {
			pos = p.getX();
			p.setX(pos - 10);
		} else if (key == KeyEvent.VK_S) {
			pos = p.getY();
			p.setY(pos + 10);
		} else if (key == KeyEvent.VK_D) {
			pos = p.getX();
			p.setX(pos + 10);
		} else if (key == KeyEvent.VK_W) {
			pos = p.getY();
			p.setY(pos - 10);
		}

	}

	public void keyReleased(KeyEvent event) {
		double pos = 0;
		int key = event.getKeyCode();
		if (key == KeyEvent.VK_A) {
			pos = p.getX();
			p.setX(pos - 10);
		} else if (key == KeyEvent.VK_S) {
			pos = p.getY();
			p.setY(pos + 10);
		} else if (key == KeyEvent.VK_D) {
			pos = p.getX();
			p.setX(pos + 10);
		} else if (key == KeyEvent.VK_W) {
			pos = p.getY();
			p.setY(pos - 10);
		}
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountsOfTicks = 60.0;
		double ns = 1000000000 / amountsOfTicks;
		double delta = 0;

		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " Ticks, Fs " + frames);
				frames = 0;
				updates = 0;
			}
		}
		stop();

	}

	private void tick() {

		if (c.getEntityA().size() > 0) {
			p.tick();
			c.tick();
		}
		if (enemy_killed >= enemy_count) {
			enemy_count += 1;
			enemy_killed = 0;
			c.addEnemy(enemy_count);
		}

	}

	private void render() {
		BufferStrategy s = this.getBufferStrategy();
		if (s == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = s.getDrawGraphics();

		/////////////////////////

		////////////////////////
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		p.render(g);
		c.render(g);
		Font font = new Font("Arial", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Score : " + String.valueOf(count_score), 0, 20);
		g.dispose();
		s.show();
	}

	public static void main(String[] args) {

		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		JFrame frame = new JFrame(game.title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.pack();

		game.start();

	}

}
