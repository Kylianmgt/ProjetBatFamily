package Behaviors;

import java.util.ArrayList;

import Utility.Direction;
import Utility.Position;
import element.Map;


public interface IBlock extends IBehavior {
	@Override
	public default boolean interaction(Direction direction, Map map, ArrayList<Position> position){
		return false;		
	}

}
