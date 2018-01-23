package client.net.packets;

import java.net.InetAddress;
import java.util.ArrayList;

import client.Client;
import client.net.packets.types.Packet;
import client.net.packets.types.PacketTypes;
import client.net.packets.types.PingPacket;
import game.AreaManager;

public class PacketParser {

	private Client client;

	public PacketParser(Client client) {
		this.client = client;
	}

	public void parsePacket(byte[] data, InetAddress address, int port) {

		String message = new String(data).trim();
		PacketTypes type = Packet.lookupPacket(message.substring(0, 2));
		int status;
		Packet packet;
		switch (type) {
		
		case AREA:
			
			String tilesData = parseIndex(message, 3);
			String objectsJSON = parseIndex(message, 4);
			
			//create the area
			client.getGame().setArea(AreaManager.loadArea
			(
					parseIndex(message, 0),						//name
					Integer.parseInt(parseIndex(message, 1)),	//width
					Integer.parseInt(parseIndex(message, 2)),	//height
					tilesData,									//tiles data
					objectsJSON									//objects JSON
			));
			break;
			
		case PING:
			packet = new PingPacket();
			packet.sendData(client.getConnection());
			break;

		default:
			client.log("Received an unhandled packet!");
			break;
		}

	}

	private String parseIndex(String message, int index) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		char divider = ';';
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == divider) {
				list.add(i);
			}
		}
		int[] div = new int[list.size()];

		for (int i = 0; i < div.length; i++) {
			div[i] = list.get(i).intValue();
		}

		return message.substring(div[index] + 1, div[index + 1]);
	}
}
