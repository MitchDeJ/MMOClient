package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.model.entity.player.KeyState;

public class InputHandler implements KeyListener {
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		KeyState keys = Game.getPlayer().getKeys();
		
		if (e.getKeyCode() == KeyEvent.VK_W)
			keys.UP = true;
		if (e.getKeyCode() == KeyEvent.VK_S)
			keys.DOWN = true;
		if (e.getKeyCode() == KeyEvent.VK_A)
			keys.LEFT = true;
		if (e.getKeyCode() == KeyEvent.VK_D)
			keys.RIGHT = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		KeyState keys = Game.getPlayer().getKeys();
		
		if (e.getKeyCode() == KeyEvent.VK_W)
			keys.UP = false;
		if (e.getKeyCode() == KeyEvent.VK_S)
			keys.DOWN = false;
		if (e.getKeyCode() == KeyEvent.VK_A)
			keys.LEFT = false;
		if (e.getKeyCode() == KeyEvent.VK_D)
			keys.RIGHT = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
