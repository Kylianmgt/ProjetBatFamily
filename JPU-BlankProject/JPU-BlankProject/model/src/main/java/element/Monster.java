package element;

import java.util.ArrayList;

import Behaviors.IExplode;
import Behaviors.IMotion;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import model.Model;





public class Monster extends Element implements IMotion, IExplode{

	ArrayList<ArrayList<Position>> arrayArrayPos=new ArrayList<ArrayList<Position>>();
	Position explodePos = new Position();



	private Nothing nothing  = new Nothing();
	private Direction[] directionmonstre = {Direction.LEFT,Direction.UP,Direction.RIGHT,Direction.DOWN};
	//private String  directionactuel = directionmonstre[0];







	public boolean interaction(BagOfPossiblePositions bag, Direction direction, Model model){
		this.explode(bag, model);
		return true;		
	}

	public ArrayList<ArrayList<Position>> explode(BagOfPossiblePositions bag, Model model) {

		for (int i =-1; i<=1; i++){
			for (int j = -1; j<=1; j++){
				if(isNotOutOfBounds(model, i, j)){
					if (model.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getY()+j] instanceof IExplode &&
							model.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getY()+j] != this){

						model.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getY()+j].interaction(Direction.NO, model, null, null);
					}
					model.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getY()+j].getPositionElement().setTaken(false);
					this.explodePos.setX(this.getPositionElement().getX()+i);
					this.explodePos.setY(this.getPositionElement().getY()+i);

					model.setNiveau(new Diamond(), this.explodePos);
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
					if (((FallingElement) model.getNiveau()[this.getPositionElement().getX()+k][this.getPositionElement().getX()+l]).canIStartToFall(null)&&
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



	@Override

	public void move(ArrayList<Position> position, Model model, Direction direction, BagOfPossiblePositions bag) {
		// TODO Auto-generated method stub








		if (this.canImove(directionmonstre[0], model, positionElement)){
			int [] intDir=convertDirectionIntoInt(directionmonstre[1]);
			model.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			model.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;
			rotationTab(1);

		}

		else if (canImove(directionmonstre[1], model, positionElement)){
			int [] intDir=convertDirectionIntoInt(directionmonstre[0]);
			model.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			model.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;


		}

		else if (canImove(directionmonstre[2], model, positionElement)){
			int [] intDir=convertDirectionIntoInt(directionmonstre[3]);
			model.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			model.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;
			rotationTab(3);

			rotationTab(2);
		}else if (canImove(directionmonstre[3], model, positionElement)){
			int [] intDir=convertDirectionIntoInt(directionmonstre[2]);
			model.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			model.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;
		}	rotationTab(3);

	}








	public boolean canImove( Direction directionactuel, Model model, Position position){

		int [] intDir = convertDirectionIntoInt(directionactuel);

		if(model.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]] == nothing){
			return true;
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
			directionmonstre[1]=temp;
		}
	}
}

