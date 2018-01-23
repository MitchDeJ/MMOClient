package game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.graphics.SpriteRepository;

public class Player extends LivingEntity {
	
	public Player() {
		
		setRenderOffset(-16, -40);
		
		x = 2.5;
		y = 4;
	}
	
	public void render(Graphics g) {
		g.drawImage(getSprite(), getRenderX(), getRenderY(), null);
	}
	
	public BufferedImage getSprite() {
		return SpriteRepository.PLAYER;
	}

	public int getOriginX() {
		return getRenderX() + (renderOffsetX * -1);
	}

	public int getOriginY() {
		return getRenderY() + (renderOffsetY * -1);
	}

	public void tick() {
		//
	}

}
