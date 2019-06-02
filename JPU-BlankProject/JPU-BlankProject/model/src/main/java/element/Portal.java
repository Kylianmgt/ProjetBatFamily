package element;

import Utility.BagOfPossiblePositions;
import Utility.Direction;
import model.Model;

public class Portal extends Element {
	public Portal(){
		super();
		this.Sprite='╬';
	}
	@Override
	public boolean interaction( Direction direction, Model map, BagOfPossiblePositions bag, Player player){
		System.out.println("You're winner!!!");
		System.exit(0);
		return true;
	}
	 
}
