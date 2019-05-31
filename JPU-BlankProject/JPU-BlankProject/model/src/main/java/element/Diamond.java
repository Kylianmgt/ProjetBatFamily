package element;

import Utility.BagOfPossiblePositions;
import Utility.Direction;

public class Diamond extends Element{
	@Override
	public boolean interaction( Direction direction, Map map, BagOfPossiblePositions bag, Player player){
		return addToPlayerScore( player);		
	}

	private boolean addToPlayerScore( Player player) {
	player.setScore(player.getScore()+1);
	this.getPositionElement().setTaken(false);
		return true;
	}

}
