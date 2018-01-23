package game.model.entity.player;

public class KeyState {
	
	public boolean UP = false;
	public boolean RIGHT = false;
	public boolean DOWN = false;
	public boolean LEFT = false;
	
	
	public boolean changed(KeyState prevKeys) {
		if (UP != prevKeys.UP)
			return true;
		if (DOWN != prevKeys.DOWN)
			return true;
		if (LEFT != prevKeys.LEFT)
			return true;
		if (RIGHT != prevKeys.RIGHT)
			return true;
		
		return false;
	}

}
