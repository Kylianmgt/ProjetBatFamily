package element;



import java.util.ArrayList;

import Behaviors.IFall;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;


public class Rock extends Element implements IFall{
	@Override
	public boolean interaction( Direction direction, Map map, BagOfPossiblePositions bag){
	return true;		
}



	
}
