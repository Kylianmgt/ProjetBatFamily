package element;

import java.nio.file.Path;



import Behaviors.IElement;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;

public class Element implements IElement{
	protected Path cheminSprite;
	protected char Sprite;
	protected Position positionElement=new Position();
	
	public Element(){
		this.getPositionElement().setTaken(true);
	}
	protected boolean isNotOutOfBounds(Map map, int i, int j) {
		return this.getPositionElement().getX()+i >=0 &&
				this.getPositionElement().getX()+i < map.getX() &&
				this.getPositionElement().getY()+j >=0 &&
				this.getPositionElement().getY()+j <map.getY();
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
