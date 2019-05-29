package Behaviors;

import java.util.ArrayList;

import Utility.Direction;
import Utility.Position;
import element.Map;
import element.Player;

public interface IBehavior {
	public default boolean interaction( Direction direction, Map map, ArrayList<Position> position){
		return true;		
	}
	public default boolean tryToFall(ArrayList<Position> position) {
		// TODO Auto-generated method stub
		return false;
		
	}

}
