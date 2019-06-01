package Behaviors;



import Utility.BagOfPossiblePositions;
import Utility.Direction;
import contract.IModel;
import element.Player;


public interface IBlock extends IBehavior {
@Override
public default boolean interaction( Direction direction, IModel Model, BagOfPossiblePositions bag, Player player){
	return false;
	
}

}
