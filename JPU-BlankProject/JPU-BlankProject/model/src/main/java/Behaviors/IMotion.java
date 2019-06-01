package Behaviors;

import java.util.ArrayList;

import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import contract.IModel;


public interface IMotion extends IBehavior{
	public void move(ArrayList<Position> position, IModel Model, Direction direction, BagOfPossiblePositions bag);
}
