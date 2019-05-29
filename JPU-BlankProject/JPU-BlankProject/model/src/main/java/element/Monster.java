package element;

import java.util.ArrayList;

import Behaviors.IExplode;
import Behaviors.IFall;
import Behaviors.IMotion;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;

public class Monster extends Element implements IMotion, IExplode{
	ArrayList<ArrayList<Position>> arrayArrayPos=new ArrayList<ArrayList<Position>>();



	public boolean interaction(BagOfPossiblePositions bag, Direction direction, Map map){
		this.explode(bag, map);
		return true;		
	}
	public ArrayList<ArrayList<Position>> explode(BagOfPossiblePositions bag, Map map) {
		for (int i =-1; i<=1; i++){
			for (int j = -1; j<=1; j++){
				if(isNotOutOfBounds(map, i, j)){
					if (map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getX()+i] instanceof IExplode &&
							map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getX()+i] != this){

						map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getX()+i].interaction(Direction.NO, map, null);
					}
					map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getX()+j]=new Diamond();
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
					if (map.getNiveau()[this.getPositionElement().getX()+k][this.getPositionElement().getX()+l].canIFall(null)&&
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
	
	private boolean isNotOutOfBounds(Map map, int i, int j) {
		return this.getPositionElement().getX()+i >=0 &&
				this.getPositionElement().getX()+i < map.getX() &&
				this.getPositionElement().getY()+j >=0 &&
				this.getPositionElement().getY()+j <map.getY();
	}

	@Override
	public void move(ArrayList<Position> position, Map map, Direction direction) {
		// TODO Auto-generated method stub

	}


}