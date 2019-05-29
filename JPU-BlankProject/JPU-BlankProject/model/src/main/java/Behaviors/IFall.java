package Behaviors;

import java.util.ArrayList;

import Utility.Position;

public interface IFall extends IBehavior{
	@Override
	public default boolean tryToFall(ArrayList<Position> position) {
		// TODO Auto-generated method stub
		return false;
		
	}

}
