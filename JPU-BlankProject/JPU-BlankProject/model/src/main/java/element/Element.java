package element;


import Behaviors.IElement;
import Utility.Direction;
import Utility.Position;
import model.Model;

public class Element implements IElement{
	

	protected Position elementPosition=new Position();
	protected Sprite sprite;
	
	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}


	public Element(){
		this.getElementPosition().setTaken(true);
		
	}

	protected boolean isNotOutOfBounds(Model model, int i, int j) {
		return i >=0 &&
				i < model.getX() &&
				j >=0 &&
			j <model.getY();

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

	public Position getElementPosition() {
		return elementPosition;
	}
	public void setElementPosition(Position positionElement) {
		this.elementPosition = positionElement;
	}

}
