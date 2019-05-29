package element;

import java.nio.file.Path;
import java.util.ArrayList;



import Behaviors.IElement;
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
	
	
	
	

}
