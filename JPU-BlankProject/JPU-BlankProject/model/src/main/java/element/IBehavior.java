package element;

import java.util.ArrayList;

public interface IBehavior {
	public default Boolean interaction(Player player, Direction direction){
		return true;		
	}
	public default boolean tryToFall(ArrayList<Position> position) {
		// TODO Auto-generated method stub
		return false;
		
	}

}
