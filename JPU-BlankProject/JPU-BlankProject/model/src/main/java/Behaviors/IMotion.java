package Behaviors;

import java.util.ArrayList;

import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import model.Model;


public interface IMotion extends IBehavior{
	public void move(ArrayList<Position> position, Model Model, Direction direction, BagOfPossiblePositions bag);
}
