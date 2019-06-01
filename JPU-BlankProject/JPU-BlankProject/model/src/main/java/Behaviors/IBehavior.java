package Behaviors;



import Utility.BagOfPossiblePositions;
import Utility.Direction;
import contract.IModel;
import element.Player;


public interface IBehavior {
	public default boolean interaction( Direction direction, IModel map, BagOfPossiblePositions bag, Player player){
		return true;		
	}
	


}
