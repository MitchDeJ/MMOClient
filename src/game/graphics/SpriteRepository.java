package game.graphics;

import java.awt.image.BufferedImage;

import game.AssetManager;

public class SpriteRepository {
	
	/*TILES*/
	
	//overworld
	public static final BufferedImage TILE_GRASS = AssetManager.loadImage("/tiles/grass.png");
	public static final BufferedImage TILE_DIRT = AssetManager.loadImage("/tiles/dirt.png");
	
	//path
	public static final BufferedImage TILE_STONE_PATH = AssetManager.loadImage("/tiles/stonepath.png");
	
	public static final BufferedImage TILE_PATH_EDGE_TOP = AssetManager.loadImage("/tiles/path_edge_top.png");
	public static final BufferedImage TILE_PATH_EDGE_BOTTOM = AssetManager.loadImage("/tiles/path_edge_bottom.png");
	public static final BufferedImage TILE_PATH_EDGE_LEFT = AssetManager.loadImage("/tiles/path_edge_left.png");
	public static final BufferedImage TILE_PATH_EDGE_RIGHT = AssetManager.loadImage("/tiles/path_edge_right.png");
	
	
	/*OBJECTS*/
	
	public static final BufferedImage OBJECT_BUSH = AssetManager.loadImage("/objects/bush.png");
	public static final BufferedImage OBJECT_SIGN = AssetManager.loadImage("/objects/sign.png");
	
	/* PLAYER */
	
	public static final BufferedImage PLAYER = AssetManager.loadImage("/player/player.png");
	
}
