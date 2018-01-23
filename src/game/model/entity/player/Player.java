package game.model.entity.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import client.net.packets.types.KeyStatePacket;
import client.net.packets.types.Packet;
import game.Game;
import game.graphics.SpriteRepository;
import game.model.entity.LivingEntity;

public class Player extends LivingEntity {
	
	private KeyState keys = new KeyState();
	private KeyState prevKeys = keys;
	
	public Player() {
		
		setRenderOffset(-16, -40);
		
		x = 8;
		y = 4.5;
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
		checkKeys();
	}

	public KeyState getKeys() {
		return keys;
	}
	
	private void checkKeys() {
		if (keys.changed(prevKeys)) {
			 Packet packet = new KeyStatePacket(getKeys());
			 packet.sendData(Game.getClient().getConnection());
		}
		
			prevKeys = keys;
	}

}
