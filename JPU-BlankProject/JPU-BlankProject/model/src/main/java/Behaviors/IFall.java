package Behaviors;

import java.util.ArrayList;

import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import model.Model;


public interface IFall extends IBehavior{


	public boolean canIStartToFall( Model Model);
	public boolean canIFallDown(Model Model);
	public boolean canIContinueToFallDown(Model Model);
	public void canISlip(Model Model);
	
	public void fallDown(Model Model, BagOfPossiblePositions bag);
	public void slip(Direction direction, Model Model);


	public boolean tryToFall(ArrayList<Position> position,BagOfPossiblePositions Bag, Model Model);
}
