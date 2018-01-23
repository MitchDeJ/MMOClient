package game.model.entity;

import java.awt.Graphics;

import client.Config;

public abstract class Entity {
	protected double x;
	protected double y;
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public int getRenderX() {
		return (int) (getX() * Config.tileSize);
	}
	
	public int getRenderY() {
		return (int) (getY() * Config.tileSize);
	}
		
	public abstract int getOriginX();
	public abstract int getOriginY();	
	
	public abstract void render(Graphics g);
}
