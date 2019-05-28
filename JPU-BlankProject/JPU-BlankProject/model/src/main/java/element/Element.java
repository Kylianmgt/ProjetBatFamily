package element;

import java.nio.file.Path;
import java.util.ArrayList;

public class Element implements IElement{
	protected Path cheminSprite;
	protected char Sprite;
	public Boolean interaction(Player player, Direction direction){
		return true;		
	}
	public void tryToFall(ArrayList<Position> position) {
		// TODO Auto-generated method stub
		
	}
	
	

}
