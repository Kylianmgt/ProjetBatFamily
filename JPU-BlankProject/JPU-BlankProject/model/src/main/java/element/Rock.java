package element;



import java.util.ArrayList;

import Behaviors.IFall;
import Utility.Direction;
import Utility.Position;


public class Rock extends Element implements IFall{
	@Override
	public boolean interaction( Direction direction, Map map, ArrayList<Position> position){
	return true;		
}



	
}
