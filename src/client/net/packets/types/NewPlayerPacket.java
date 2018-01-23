package client.net.packets.types;

public class NewPlayerPacket extends Packet {

	private String name;
	
	public NewPlayerPacket(String name) {
		super(01);
		this.name = name;
	}
//temporary packet to test players

	@Override
	public byte[] getData() {
		String[] data = new String[] {name,};
		return packData(data).getBytes();
	}
	
	
}
