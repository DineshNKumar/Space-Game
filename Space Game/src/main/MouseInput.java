package main;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import main.Game.STATE;

public class MouseInput implements MouseListener {

	private TextArea area;

	@Override
	public void mouseClicked(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		if ((mx >= 250 && mx <= 350) && (my >= 150 && my <= 180)) {
			Game.State = STATE.GAME;
		}
		if ((mx >= 250 && mx <= 350) && (my >= 200 && my <= 230)) {
			JFrame frame = new JFrame("Help");
			frame.setVisible(true);
			frame.setPreferredSize(new Dimension(250, 150));
			frame.setMaximumSize(new Dimension(250, 150));
			frame.setMinimumSize(new Dimension(250, 150));
			frame.setResizable(false);
			area = new TextArea();
			area.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
			area.setMaximumSize(new Dimension(frame.getWidth(), frame.getHeight()));
			area.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
			area.setText("PRESS\n (A,D,W,S) \n(LEFT,RIGHT,UP,DOWN)" + "\nPRESS\n (SPACE) to SHOOT");

			area.setFocusable(true);
			area.setFocusTraversalKeysEnabled(true);
			area.setEditable(false);
			frame.add(area);
			frame.setLocationRelativeTo(new Game());

			frame.pack();
		}
		if ((mx >= 250 && mx <= 350) && (my >= 250 && my <= 280)) {
			System.exit(0);
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
