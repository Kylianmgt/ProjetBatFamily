package Behaviors;

import java.util.ArrayList;

import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import contract.IModel;


public interface IFall extends IBehavior{
	public boolean canIStartToFall( IModel Model);
	public boolean canIFallDown(IModel Model);
	public boolean canIContinueToFallDown(IModel Model);
	public void canISlip(IModel Model);
	
	public void fallDown(IModel Model, BagOfPossiblePositions bag);
	public void slip(Direction direction, IModel Model);


	public boolean tryToFall(ArrayList<Position> position,BagOfPossiblePositions Bag, IModel Model);
}
