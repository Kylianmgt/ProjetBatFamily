package Behaviors;



import Utility.BagOfPossiblePositions;
import Utility.Direction;

import element.Map;


public interface IBehavior {
	public default boolean interaction( Direction direction, Map map, BagOfPossiblePositions bag){
		return true;		
	}
	


}
