package Behaviors;

import java.util.ArrayList;

import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import element.Map;
import element.Player;

public interface IBehavior {
	public default boolean interaction( Direction direction, Map map, BagOfPossiblePositions bag){
		return true;		
	}
	


}
