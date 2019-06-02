package element;

import Behaviors.IFall;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import model.Model;

public class Diamond extends FallingElement implements IFall{

	public Diamond(){
		super();
		this.Sprite='+';
	}
	@Override
	public boolean interaction( Direction direction, Model Model, BagOfPossiblePositions bag, Player player){
		return addToPlayerScore( player);		
	}

	private boolean addToPlayerScore( Player player) {
	player.setScore(player.getScore()+1);
	this.getElementPosition().setTaken(false);
		return true;
	}

}
