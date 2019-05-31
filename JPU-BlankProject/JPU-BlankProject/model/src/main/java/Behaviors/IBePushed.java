package Behaviors;

import Utility.Direction;
import element.Map;

public interface IBePushed extends IBehavior{
	public boolean bePushed(Direction direction, Map map);
	

}
