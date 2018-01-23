package game.model.map;

import java.awt.image.BufferedImage;

import game.graphics.SpriteRepository;

public enum TileType {
	
	GRASS(0),
	DIRT(1),
	STONE_PATH(2),
	PATH_EDGE_TOP(3),
	PATH_EDGE_BOTTOM(4),
	PATH_EDGE_LEFT(5),
	PATH_EDGE_RIGHT(6);
	
	private int id;

	private TileType(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static TileType getType(int id) {
		for (TileType t: TileType.values()) {
			if (t.getId() == id) {
				return t;
			}
		}
			return TileType.GRASS;
	}
	
	public BufferedImage getSprite() {
		switch (getType(id)) {
		case GRASS:
			return SpriteRepository.TILE_GRASS;
		case DIRT:
			return SpriteRepository.TILE_DIRT;
		case STONE_PATH:
			return SpriteRepository.TILE_STONE_PATH;
		case PATH_EDGE_BOTTOM:
			return SpriteRepository.TILE_PATH_EDGE_BOTTOM;
		case PATH_EDGE_LEFT:
			return SpriteRepository.TILE_PATH_EDGE_LEFT;
		case PATH_EDGE_RIGHT:
			return SpriteRepository.TILE_PATH_EDGE_RIGHT;
		case PATH_EDGE_TOP:
			return SpriteRepository.TILE_PATH_EDGE_TOP;
		default:
			return null;
		}
	}

}
