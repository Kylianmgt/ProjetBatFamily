package element;

import java.util.ArrayList;

public class Rock extends Element implements IFall{

	@Override
	public void tryToFall(ArrayList<Position> position) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Boolean interaction(Player player, Direction direction){
		return true;		
	}
	
}
