package Behaviors;



import Utility.Direction;
import element.Player;
import model.Model;


public interface IBehavior {
	public default boolean interaction( Direction direction, Model map, Player player){
		return true;		
	}
	


}
