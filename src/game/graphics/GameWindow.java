package game.graphics;

import java.awt.Dimension;
import javax.swing.JFrame;


public class GameWindow {
	
	private JFrame frame;
	
	public GameWindow(int w, int h, String title, Renderer renderer) {
		
		renderer.setPreferredSize(new Dimension(w, h));
		renderer.setMinimumSize(new Dimension(w, h));		
		renderer.setMaximumSize(new Dimension(w, h));	
		
		frame = new JFrame(title);
		frame.add(renderer);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public JFrame getFrame() {
		return frame;
	}

}
