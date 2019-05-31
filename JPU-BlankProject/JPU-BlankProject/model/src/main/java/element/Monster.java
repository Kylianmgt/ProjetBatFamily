package element;

import java.util.ArrayList;

import Behaviors.IExplode;
import Behaviors.IMotion;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;

public class Monster extends Element implements IMotion, IExplode{
	ArrayList<ArrayList<Position>> arrayArrayPos=new ArrayList<ArrayList<Position>>();
	Position explodePos = new Position();



	public boolean interaction(BagOfPossiblePositions bag, Direction direction, Map map){
		this.explode(bag, map);
		return true;		
	}
	public ArrayList<ArrayList<Position>> explode(BagOfPossiblePositions bag, Map map) {
		for (int i =-1; i<=1; i++){
			for (int j = -1; j<=1; j++){
				if(isNotOutOfBounds(map, i, j)){
					if (map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getY()+j] instanceof IExplode &&
							map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getY()+j] != this){

						map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getY()+j].interaction(Direction.NO, map, null, null);
					}
					map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getY()+j].getPositionElement().setTaken(false);
					this.explodePos.setX(this.getPositionElement().getX()+i);
					this.explodePos.setY(this.getPositionElement().getY()+i);
						
					map.setNiveau(new Diamond(), this.explodePos);
				}
			}
		}
		refreshArrayArrayPos(bag, map);
		return arrayArrayPos;
	}
	
	
	private void refreshArrayArrayPos(BagOfPossiblePositions bag, Map map) {
		this.arrayArrayPos.clear();
		for (int k =-1; k<=1; k++){
			for (int l = -1; l<=1; l++){		
				if (isNotOutOfBounds(map,k, l)){
					if (((FallingElement) map.getNiveau()[this.getPositionElement().getX()+k][this.getPositionElement().getX()+l]).canIStartToFall(null)&&
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
	public void move(ArrayList<Position> position, Map map, Direction direction, BagOfPossiblePositions bag) {
		// TODO Auto-generated method stub

	}


}