package element;

import java.util.ArrayList;
import java.util.Arrays;

import Behaviors.IExplode;
import Behaviors.IMotion;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import contract.IModel;
import model.Model;

public class Monster extends Element implements IMotion, IExplode{

	ArrayList<ArrayList<Position>> arrayArrayPos=new ArrayList<ArrayList<Position>>();
	Position explodePos = new Position();
	private Nothing nothing  = new Nothing();
	private Direction[] directionmonstre = new Direction[4];

	public Monster(){
		super();
		this.Sprite='M';
		this.directionmonstre[0]=Direction.LEFT;
		this.directionmonstre[1]=Direction.UP;
		this.directionmonstre[2]=Direction.RIGHT;
		this.directionmonstre[3]=Direction.DOWN;

	}

	public Direction[] getDirectionmonstre() {
		return directionmonstre;
	}

	public void setDirectionmonstre(Direction[] directionmonstre) {
		this.directionmonstre = directionmonstre;
	}

	public boolean interaction(BagOfPossiblePositions bag, Direction direction, Model model){
		this.explode(bag, model);
		return true;		
	}

	public ArrayList<ArrayList<Position>> explode(BagOfPossiblePositions bag, Model model) {

		for (int i =-1; i<=1; i++){
			for (int j = -1; j<=1; j++){
				if(isNotOutOfBounds(model, i, j)){
					if (model.getLevel()[this.getElementPosition().getX()+i][this.getElementPosition().getY()+j] instanceof IExplode &&
							model.getLevel()[this.getElementPosition().getX()+i][this.getElementPosition().getY()+j] != this){

						model.getLevel()[this.getElementPosition().getX()+i][this.getElementPosition().getY()+j].interaction(Direction.NO, model, null, null);
					}
					model.getLevel()[this.getElementPosition().getX()+i][this.getElementPosition().getY()+j].getElementPosition().setTaken(false);
					this.explodePos.setX(this.getElementPosition().getX()+i);
					this.explodePos.setY(this.getElementPosition().getY()+i);

					model.setLevel(new Diamond(), this.explodePos);
				}
			}
		}
		refreshArrayArrayPos(bag, model);
		return arrayArrayPos;
	}


	private void refreshArrayArrayPos(BagOfPossiblePositions bag, Model model) {
		this.arrayArrayPos.clear();
		for (int k =-1; k<=1; k++){
			for (int l = -1; l<=1; l++){		
				if (isNotOutOfBounds(model,k, l)){
					if (((FallingElement) model.getLevel()[this.getElementPosition().getX()+k][this.getElementPosition().getX()+l]).canIStartToFall(null)&&
							!(bag.getPosition()[k][l].isTaken())){
						ArrayList<Position> pos = new ArrayList<Position>();
						pos.add(bag.getPosition()[k][l]);
						bag.getPosition()[k][l].setTaken(true);
						this.arrayArrayPos.add(pos);
					}
				}
			}
		}
	}



	public void move(ArrayList<Position> position, Model model, Direction direction, BagOfPossiblePositions bag) {
		
		if (this.canImove(directionmonstre[0], model, elementPosition)){

			int [] intDir=convertDirectionIntoInt(directionmonstre[0]);
			moveMonster(model, intDir);
			rotationTab(3);
			
			

		}


		else if (canImove(directionmonstre[1], model, elementPosition)){


			int [] intDir=convertDirectionIntoInt(directionmonstre[1]);

			moveMonster(model, intDir);	
		}



		else if (canImove(directionmonstre[2], model, elementPosition)){

			int [] intDir=convertDirectionIntoInt(directionmonstre[2]);
			moveMonster(model, intDir);
			rotationTab(1);
		}
		else if (canImove(directionmonstre[3], model, elementPosition)){
			int [] intDir=convertDirectionIntoInt(directionmonstre[3]);
			moveMonster(model, intDir);
			rotationTab(2);
		}

	}

	private void moveMonster(Model model, int[] intDir) {
		model.getLevel()[elementPosition.getX()][elementPosition.getY()]=nothing;
		model.getLevel()[elementPosition.getX()+intDir[0]][elementPosition.getY()+intDir[1]]=this;			
		this.getElementPosition().setX(this.getElementPosition().getX()+intDir[0]);
		this.getElementPosition().setY(this.getElementPosition().getY()+intDir[1]);
	}

	public boolean canImove( Direction directionactuel, Model model, Position position){
		
	

		int [] intDir = convertDirectionIntoInt(directionactuel);
		

		if (isNotOutOfBounds(model, elementPosition.getX()+intDir[0], elementPosition.getY()+intDir[1])){
			
		
			return(model.getLevel()[elementPosition.getX()+intDir[0]][elementPosition.getY()+intDir[1]]instanceof Nothing);

		}				
		else{
			
			return false;
		}
	}

	private void rotationTab(int amount){
		for (int i=0; i<amount; i++){	
			Direction temp = directionmonstre[0];
			directionmonstre[0]= directionmonstre[1];
			directionmonstre[1]= directionmonstre[2];
			directionmonstre[2]= directionmonstre[3];
			directionmonstre[3]=temp;
		}
	}



}

