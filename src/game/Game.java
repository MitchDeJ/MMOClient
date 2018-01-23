package game;

import client.Client;
import client.Config;
import game.graphics.GameWindow;
import game.graphics.Renderer;
import game.model.entity.player.Player;
import game.model.map.Area;

public class Game implements Runnable {
	 
	private static Client client;
	
	private boolean running = false;
	private Thread thread;
	
	private Area area;
	
	private Config config;
	
	private Renderer renderer;
	private GameWindow window;

	private static Player player;

	public Game(Client client) {
		this.client = client;
	}
	
	public synchronized void start() {
		if (running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		init();
		renderer.requestFocus();

		/* Game loop */
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			renderer.render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
				updates = 0;
			}
		}
		/* end of game loop */
	}

	private void init() {
		config = client.getConfig();
		renderer = new Renderer(this);// RENDERER HAS TO BE INIT'ED BEFORE THE GAME WINDOW
		window = new GameWindow(config.windowWidth, config.windowHeight, config.windowName, renderer);
		player = new Player(); // player has to be added before input handler
		renderer.addKeyListener(new InputHandler());
	}

	private void tick() {
		area.tick();
		player.tick();
	}
	
	public void setArea(Area area) {
		this.area = area;		
	}
	
	public Area getArea() {
		return this.area;
	}

	public Config getConfig() {
		return config;
	}

	public static Player getPlayer() {
		return player;
	}

	public static Client getClient() {
		return client;
	}


}
