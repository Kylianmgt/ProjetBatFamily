package element;






import Behaviors.IBePushed;
import Utility.BagOfPossiblePositions;
import Utility.Direction;



public class Rock extends FallingElement implements IBePushed{
	@Override
	public boolean interaction( Direction direction, Map map, BagOfPossiblePositions bag){
		int[] vecteurDir = this.convertDirectionIntoInt(direction);
		
	return true;		
}



	
}
