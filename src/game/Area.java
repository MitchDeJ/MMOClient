package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import client.Config;

public class Area {
	
	private String name;
	private int width;
	private int height;
	private Tile[][] tiles;
	private List<WorldObject> objects;
	
	
	public Area(String name, int width, int height, List<Tile> tiles, List<WorldObject> objects) {
		 this.name = name;
		 this.width = width;
		 this.height = height;
		 this.tiles = new Tile[width][height];
		 this.objects = objects;
		 init(width, height, tiles);
	}
	
	public void init(int width, int height, List<Tile> tileList) {
		int i = 0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = tileList.get(i);
				i++;
			}
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
	
	public List<WorldObject> getObjects() {
		return objects;
	}
	
	public void addWorldObject(ObjectType type, int x, int y) {
		new WorldObject(
				objects.size(),
				type,
				x,
				y		
		);
	}
	
	public void removeWorldObject(int id) {
		for(WorldObject o : objects) {
			if (o.getId() == id) 
				objects.remove(o);
		}
	}

	public void render(Graphics g) {
		
		/*rendering tiles*/
		for (int x = 0;x < getWidth(); x++) {
			for (int y = 0;y < getHeight(); y++) {
				g.drawImage(tiles[x][y].getType().getSprite(), x * Config.tileSize, y * Config.tileSize, null);
			}
		}
		
		/*rendering entities*/
		for (Entity e : getEntities()) {
			e.render(g);
		}
	}

	private List<Entity> getEntities() {
		List<Entity> entities = new ArrayList<Entity>();
		entities.add(Game.getPlayer()); //add the player
		entities.addAll(objects);		//add all worldobjects
		//sort entites on y value for the renderer
		Collections.sort(entities, Comparator.comparingDouble(Entity::getOriginY));
		// return the list
		return entities;
	}

	public void tick() {
		
	}

}
