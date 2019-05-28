package element;

import java.util.ArrayList;

public interface IFall extends IBehavior{
	@Override
	public default boolean tryToFall(ArrayList<Position> position) {
		// TODO Auto-generated method stub
		return false;
		
	}

}
