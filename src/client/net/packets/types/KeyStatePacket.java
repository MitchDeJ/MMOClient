package client.net.packets.types;

import game.model.entity.player.KeyState;

public class KeyStatePacket extends Packet {
	
	private KeyState keys;

	public KeyStatePacket(KeyState keys) {
		super(03);
		this.keys = keys;
	}

	public byte[] getData() {
		String[] data = {""+keys.UP, ""+keys.RIGHT, ""+keys.DOWN, ""+keys.LEFT};
		return packData(data).getBytes();
	}

}
