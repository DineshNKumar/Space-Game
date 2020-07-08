package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Game game;

	private Player p;
	private Controller c;

	public KeyInput(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		game.keyPressed(event);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		game.keyReleased(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
