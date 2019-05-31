package element;

import java.nio.file.Path;
import java.util.ArrayList;



import Behaviors.IElement;
import Utility.Direction;
import Utility.Position;

public class Element implements IElement{
	protected Path cheminSprite;
	protected char Sprite;
	protected Position positionElement;
	public Position getPositionElement() {
		return positionElement;
	}
	public void setPositionElement(Position positionElement) {
		this.positionElement = positionElement;
	}
	public int[] convertDirectionIntoInt(Direction direction){
		int dirX = 0;
		int dirY = 0;
		switch (direction){
		case RIGHT:
			dirX=1;
			break;
		case LEFT:
			dirX=-1;
			break;
		case UP:
			dirY=-1;
			break;
		case DOWN:
			dirY=1;
			break;
		default:
			break;
		}
		int[] tab = {dirX,dirY};
		return tab;

	}
	
	
	
	

}
