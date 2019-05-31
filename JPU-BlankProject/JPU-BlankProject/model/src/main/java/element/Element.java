package element;

import java.nio.file.Path;
import Behaviors.IElement;
import Utility.Direction;
import Utility.Position;
import model.Model;

public class Element implements IElement{
	protected Path cheminSprite;
	protected char Sprite;
	protected Position positionElement=new Position();
	
	public Element(){
		this.getElementPosition().setTaken(true);
	}
	protected boolean isNotOutOfBounds(Model model, int i, int j) {
		return this.getElementPosition().getX()+i >=0 &&
				this.getElementPosition().getX()+i < model.getX() &&
				this.getElementPosition().getY()+j >=0 &&
				this.getElementPosition().getY()+j <model.getY();
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
	public Position getElementPosition() {
		return positionElement;
	}
	public void setElementPosition(Position positionElement) {
		this.positionElement = positionElement;
	}
	
	
	
	

}
