package element;

public class Block extends Element implements IBlock{
	@Override
	public Boolean interaction(Player player, Direction direction){
		return false;		
	}
	

}
