package client.net.packets.types;

public class PingPacket extends Packet {

	public PingPacket() {
		super(02);
	}

	@Override
	public byte[] getData() {
		String[] data = {""};
		return packData(data).getBytes();
	}

}
