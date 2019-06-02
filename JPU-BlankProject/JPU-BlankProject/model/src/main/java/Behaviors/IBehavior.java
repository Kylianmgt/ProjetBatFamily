package Behaviors;



import Utility.BagOfPossiblePositions;
import Utility.Direction;
import element.Player;
import model.Model;


public interface IBehavior {
	public default boolean interaction( Direction direction, Model map, BagOfPossiblePositions bag, Player player){
		return true;		
	}
	


}
