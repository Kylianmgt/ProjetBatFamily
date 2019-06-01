package Behaviors;

import Utility.Direction;
import contract.IModel;


public interface IBePushed extends IBehavior{
	public boolean bePushed(Direction direction, IModel Model);
	

}
