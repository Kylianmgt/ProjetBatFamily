package Behaviors;

import Utility.Direction;
import element.Player;
import model.Model;


public interface IBlock extends IBehavior {
@Override
public default boolean interaction( Direction direction, Model Model, Player player){
	return false;
	
}

}
