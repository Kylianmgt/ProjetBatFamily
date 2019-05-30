package element;






import Utility.BagOfPossiblePositions;
import Utility.Direction;



public class Rock extends FallingElement{
	@Override
	public boolean interaction( Direction direction, Map map, BagOfPossiblePositions bag){
	return true;		
}



	
}
