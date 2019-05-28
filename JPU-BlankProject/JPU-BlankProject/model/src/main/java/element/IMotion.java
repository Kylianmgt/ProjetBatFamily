package element;

import java.util.ArrayList;

public interface IMotion extends IBehavior{
	public void move(ArrayList<Position> position, Map map, Direction direction, Position positionElement);
}
