package main;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textures {

	public BufferedImage player, bullet, enemy;

	static Rectangle playerRect;
	static Rectangle bulletRect;
	static Rectangle enemyRect;

	public Textures(Game game) {
		getTextures();
		playerRect = new Rectangle(player.getData().getBounds());
		bulletRect = new Rectangle(bullet.getData().getBounds());
		enemyRect = new Rectangle();
	}

	private void getTextures() {
		try {
			player = ImageIO.read(getClass().getResource("/player.png"));
			bullet = ImageIO.read(getClass().getResource("/Aag.png"));
			enemy = ImageIO.read(getClass().getResource("/enemy.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Rectangle checkBounds(Rectangle rect) {
		return rect.getBounds();
	}
}
