package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {

	Game game;

	public Rectangle playRect = new Rectangle(250, 150, 100, 30);
	public Rectangle helpRect = new Rectangle(250, 200, 100, 30);
	public Rectangle quitRect = new Rectangle(250, 250, 100, 30);

	public Menu(Game game) {
		this.game = game;
	}

	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(playRect.x, playRect.y, playRect.width, playRect.height);
		g.setColor(Color.ORANGE);
		g.fillRect(helpRect.x, helpRect.y, helpRect.width, helpRect.height);
		g.setColor(Color.RED);
		g.fillRect(quitRect.x, quitRect.y, quitRect.width, quitRect.height);

		Font font = new Font("Arial", Font.BOLD, 35);
		g.setColor(Color.white);
		g.setFont(font);
		g.drawString("Space GAME", 200, 100);
		Graphics2D g2 = (Graphics2D) g;
		Font font1 = new Font("Arial", Font.BOLD, 20);
		g2.setFont(font1);
		g2.drawString("PLay", playRect.x + 30, playRect.y + 25);
		g2.draw(playRect);
		g2.drawString("Help", helpRect.x + 30, helpRect.y + 25);
		g2.draw(helpRect);
		g2.drawString("Quit", quitRect.x + 30, quitRect.y + 25);
		g2.draw(quitRect);
	}

}
