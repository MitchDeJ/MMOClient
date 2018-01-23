package game;

import java.awt.Graphics;

public class WorldObject extends Entity {
	
	private int id; // object indentifier
	private ObjectType type; // what definition to load
	
	public WorldObject(int id, ObjectType type, double x, double y) {
		this.id = id;
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public ObjectType getType() {
		return type;
	}

	public void render(Graphics g) {
		g.drawImage(getType().getSprite(), getRenderX(), getRenderY(), null);
	}

	public int getOriginX() {
		return getRenderX()+16;
	}

	public int getOriginY() {
		return getRenderY()+25;
	}
	
}

