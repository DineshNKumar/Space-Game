package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Menu implements MouseMotionListener, MouseListener {

	Game game;

	public Rectangle playRect = new Rectangle(250, 150, 100, 30);
	public Rectangle helpRect = new Rectangle(250, 200, 100, 30);
	public Rectangle quitRect = new Rectangle(250, 250, 100, 30);

	public Menu(Game game) {
		this.game = game;
	}

	public void render(Graphics g) {
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

	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent event) {

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		Rectangle rect = getBounds(x, y);
		if (rect.intersects(playRect)) {
		} else if (rect.intersects(quitRect)) {
			System.exit(1);
		}
	}

	public Rectangle getBounds(int x, int y) {
		return new Rectangle(x, y, 100, 30);
	}

	@Override
	public void mouseEntered(MouseEvent event) {

	}

	@Override
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
