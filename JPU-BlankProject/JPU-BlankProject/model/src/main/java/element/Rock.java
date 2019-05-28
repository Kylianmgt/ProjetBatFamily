package element;

import java.util.ArrayList;

public class Rock extends Element implements IFall{


	@Override
	public Boolean interaction(Player player, Direction direction){
		return true;		
	}
	
}
