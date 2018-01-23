package client;

import client.net.ServerConnection;
import client.net.packets.PacketParser;
import client.net.packets.PacketReceiver;
import client.net.packets.types.NewPlayerPacket;
import client.net.packets.types.Packet;
import game.Game;

public class Client implements Runnable {
	
	private Config config = new Config();
	
	/*networking*/
	private ServerConnection connection;
	private PacketReceiver packetReceiver;
	private PacketParser packetParser;

	private Thread thread;
	private boolean running = false;
	
	private Game game = new Game(this);
	
	public static void main(String args[]) {
		new Client().start();
	}

	
	public void run() {
		init();
		game.start();
		Packet packet;
		packet = new NewPlayerPacket(config.playerName);
		packet.sendData(connection);
	}
	
	public void init() {
		 connection = new ServerConnection(config.hostName, config.hostPort);
		 packetReceiver = new PacketReceiver(this);
		 packetReceiver.start();
		 packetParser = new PacketParser(this);
		 log("Initialized.");
	}
	
	public synchronized void start() {
		if (running)
			return; // cancel if already running

		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void log(String message) {
		System.out.println("["+config.logPrefix+"] > "+message);
	}


	public ServerConnection getConnection() {
		return connection;
	}


	public PacketParser getPacketParser() {
		return packetParser;
	}


	public Game getGame() {
		return game;
	}


	public Config getConfig() {
		return this.config;
	}
}
