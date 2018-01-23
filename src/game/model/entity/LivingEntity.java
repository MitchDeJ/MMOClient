package game.model.entity;

import client.Config;

public abstract class LivingEntity extends Entity {
	protected int renderOffsetX;
	protected int renderOffsetY;
	
	public void setRenderOffset(int x, int y) {
		this.renderOffsetX = x;
		this.renderOffsetY = y;
	}
	
	@Override
	public int getRenderX() {
		return (int) (getX() * Config.tileSize) + renderOffsetX;
	}
	
	@Override
	public int getRenderY() {
		return (int) (getY() * Config.tileSize) + renderOffsetY;
	}	
	
}
