package element;

import Utility.BagOfPossiblePositions;
import Utility.Direction;
import contract.IModel;

public class Diamond extends Element{
	@Override
	public boolean interaction( Direction direction, IModel Model, BagOfPossiblePositions bag, Player player){
		return addToPlayerScore( player);		
	}

	private boolean addToPlayerScore( Player player) {
	player.setScore(player.getScore()+1);
	this.getElementPosition().setTaken(false);
		return true;
	}

}
