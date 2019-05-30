package Behaviors;

import java.util.ArrayList;

import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import element.Map;

public interface IMotion extends IBehavior{
	public void move(ArrayList<Position> position, Map map, Direction direction, BagOfPossiblePositions bag);
}
