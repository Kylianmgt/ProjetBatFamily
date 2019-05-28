package element;

public interface IBlock extends IBehavior {
	@Override
	public default Boolean interaction(Player player, Direction direction){
		return false;		
	}

}
