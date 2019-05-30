package Behaviors;

import java.util.ArrayList;

import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import element.Map;

public interface IFall extends IBehavior{
	public boolean canIStartToFall( Map map);
	public boolean canIFallDown(Map map);
	public boolean canIContinueToFallDown(Map map);
	public void canISlip(Map map);
	
	public void fallDown(Map map, BagOfPossiblePositions bag);
	public void slip(Direction direction, Map map);


	public boolean tryToFall(ArrayList<Position> position,BagOfPossiblePositions Bag, Map map);
}
