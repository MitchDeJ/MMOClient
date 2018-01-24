package game.model.entity.player;

public class KeyState {
	
	public boolean UP = false;
	public boolean RIGHT = false;
	public boolean DOWN = false;
	public boolean LEFT = false;
	
	
	public boolean changed(KeyState prevKeys) {
		if (UP == prevKeys.UP && 
			DOWN == prevKeys.DOWN &&
			LEFT == prevKeys.LEFT &&
			RIGHT == prevKeys.RIGHT
			)
			return false;
		
		return true;
	}


	public void copy(KeyState keys) {
		DOWN = keys.DOWN;
		UP  = keys.UP;
		LEFT = keys.LEFT;
		RIGHT = keys.RIGHT;		
	}

}
