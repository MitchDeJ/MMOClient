package game.model.map;

import java.awt.image.BufferedImage;

import game.graphics.SpriteRepository;

public enum ObjectType {
	
	BUSH(0),
	SIGN(1);
	
	private int id;

	private ObjectType(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static ObjectType getType(int id) {
		for (ObjectType t: ObjectType.values()) {
			if (t.getId() == id) {
				return t;
			}
		}
			return ObjectType.BUSH;
	}
	
	public BufferedImage getSprite() {
		switch (getType(id)) {
		case BUSH:
			return SpriteRepository.OBJECT_BUSH;
		case SIGN:
			return SpriteRepository.OBJECT_SIGN;
		default:
			return null;
		}
	}
}
