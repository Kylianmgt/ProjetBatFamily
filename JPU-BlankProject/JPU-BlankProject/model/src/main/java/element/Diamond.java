package element;

import Behaviors.IFall;
import Utility.Direction;
import model.Model;

public class Diamond extends FallingElement implements IFall{

	public Diamond(){
		super();
		this.sprite = new Sprite("/diamond.png");
	}
	@Override
	public boolean interaction( Direction direction, Model Model, Player player){
		return addToPlayerScore( player);		
	}

	private boolean addToPlayerScore( Player player) {
	player.setScore(player.getScore()+1);
	this.getElementPosition().setTaken(false);
		return true;
	}

}
