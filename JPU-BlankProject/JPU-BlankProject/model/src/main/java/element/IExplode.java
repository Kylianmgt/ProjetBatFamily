package element;

import java.util.ArrayList;

public interface IExplode extends IBehavior{
	public ArrayList<Position> explode(Map map, ArrayList<Position> position);
}
