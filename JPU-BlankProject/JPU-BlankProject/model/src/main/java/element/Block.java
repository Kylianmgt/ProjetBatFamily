package element;

import Behaviors.IBlock;
import Behaviors.ISlip;

public class Block extends Element implements IBlock, ISlip{
public Block(){
	super();
	this.sprite = new Sprite("/wall.png");
	
}
	
	

}
