package Behaviors;



import Utility.BagOfPossiblePositions;
import Utility.Direction;
import element.Map;
import element.Player;


public interface IBlock extends IBehavior {
@Override
public default boolean interaction( Direction direction, Map map, BagOfPossiblePositions bag, Player player){
	return false;
	
}

}
