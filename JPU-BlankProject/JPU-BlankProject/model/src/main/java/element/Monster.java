package element;

import java.util.ArrayList;

import Behaviors.IExplode;
import Behaviors.IMotion;
import Utility.Direction;
import Utility.Position;

public class Monster extends Element implements IMotion, IExplode{



	public boolean interaction( Direction direction, Map map, ArrayList<Position> position){
		this.explode(map, position, this.getPositionElement());
		return true;		
	}
	public void explode(Map map, ArrayList<Position> position, Position positionElement) {
		for (int i =-1; i<=1; i++){
			for (int j = -1; j<=1; j++){
				if(this.getPositionElement().getX()+i >=0 &&
						this.getPositionElement().getX()+i < map.getX() &&
						this.getPositionElement().getY()+j <=0 &&
						this.getPositionElement().getY()+j <map.getY()){

					if (map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getX()+i] instanceof IExplode){
						map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getX()+i].interaction(Direction.NO, map, position);
					}
					map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getX()+i]=new Diamond();
				}


			}
		}
	

	}

	@Override
	public void move(ArrayList<Position> position, Map map, Direction direction, Position positionElement) {
		// TODO Auto-generated method stub
		
	}
	
}