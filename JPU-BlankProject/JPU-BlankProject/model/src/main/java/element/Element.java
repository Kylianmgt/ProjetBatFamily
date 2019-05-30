package element;

import java.nio.file.Path;
import java.util.ArrayList;



import Behaviors.IElement;
import Utility.Position;

public class Element implements IElement{
	protected Path cheminSprite;
	protected char Sprite;
	protected Position positionElement=new Position();
	protected boolean isNotOutOfBounds(Map map, int i, int j) {
		return this.getPositionElement().getX()+i >=0 &&
				this.getPositionElement().getX()+i < map.getX() &&
				this.getPositionElement().getY()+j >=0 &&
				this.getPositionElement().getY()+j <map.getY();
	}
	
	


	
	
	
	public Path getCheminSprite() {
		return cheminSprite;
	}
	public void setCheminSprite(Path cheminSprite) {
		this.cheminSprite = cheminSprite;
	}
	public char getSprite() {
		return Sprite;
	}
	public void setSprite(char sprite) {
		Sprite = sprite;
	}
	public Position getPositionElement() {
		return positionElement;
	}
	public void setPositionElement(Position positionElement) {
		this.positionElement = positionElement;
	}
	
	
	
	

}
