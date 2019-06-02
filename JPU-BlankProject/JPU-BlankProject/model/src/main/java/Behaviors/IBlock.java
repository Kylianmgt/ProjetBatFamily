package Behaviors;



import Utility.BagOfPossiblePositions;
import Utility.Direction;
import element.Player;
import model.Model;


public interface IBlock extends IBehavior {
@Override
public default boolean interaction( Direction direction, Model Model, BagOfPossiblePositions bag, Player player){
	return false;
	
}

}
