package client.net.packets.types;

public enum PacketTypes {
	INVALID(-1), AREA(00), PING(01);
	
	private int packetId;
	
	private PacketTypes(int packetId) {
		this.packetId = packetId;
	}
	
	public int getId() {
		return packetId;
	}
}