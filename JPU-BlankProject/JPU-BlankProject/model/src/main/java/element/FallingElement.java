package element;

import java.util.ArrayList;

import Behaviors.IFall;
import Behaviors.ISlip;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import java.lang.Math;
import Behaviors.IExplode;

public class FallingElement extends Element implements IFall, ISlip {
	ArrayList<Direction> direction = new ArrayList<Direction>();


	@Override
	public boolean canIStartToFall(Map map) {
		this.canISlip(map);


		return (canIFallDown(map)|| !(this.direction.isEmpty()));
	}

	@Override
	public boolean tryToFall(ArrayList<Position> position, BagOfPossiblePositions Bag, Map map) {
		if (this.canIStartToFall(map)){
			if (this.canIFallDown(map)){
				this.fallDown(map);

			}else{
				if (direction.size()>1){
					if (Math.random()>0.5){
						this.slip(Direction.RIGHT, map);
					}else{
						this.slip(Direction.LEFT, map);
					}

				}

			}

		}else{
			if (canIContinueToFallDown(map)){
				this.fallDown(map);
			}else if(canIContinueToSlip(map)){
				this.slip( null, map);

			}
		}





		return false;
	}



	@Override
	public void canISlip(Map map) {
		this.direction.clear();
		if (isNotOutOfBounds(map,this.getPositionElement().getX(), this.getPositionElement().getY()+1)){
			if (map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()+1].getClass()==ISlip.class){
				this.checkLeftAndRightIfSlip(map);
			}

		}



	}

	private void checkLeftAndRightIfSlip(Map map) {

		for (int i =-1; i<=1; i=i+2){
			if (isNotOutOfBounds(map,this.getPositionElement().getX()+i, this.getPositionElement().getY()) &&
					isNotOutOfBounds(map,this.getPositionElement().getX()+i, this.getPositionElement().getY()+1)	){
				if (map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getY()].getClass()==Nothing.class&&
						map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getY()+1].getClass()==Nothing.class){

					if (i==-1){
						direction.add(Direction.LEFT);
					}else{
						direction.add(Direction.RIGHT);
					}
				}

			}


		}


	}

	@Override
	public boolean canIFallDown(Map map) {

		if (isNotOutOfBounds(map,this.getPositionElement().getX(), this.getPositionElement().getY()+1)){


			return (map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()+1].getClass()==Nothing.class);
		}else {
			return false;
		}
	}

	@Override
	public boolean canIContinueToFallDown(Map map) {
		if (isNotOutOfBounds(map,this.getPositionElement().getX(), this.getPositionElement().getY()+1)){


			return (canIFallDown(map) || map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()+1].getClass()==IExplode.class);
		}else {
			return false;
		}
	}

	@Override
	public boolean canIContinueToSlip(Map map) {
		return false;


	}

	@Override
	public void fallDown(Map map) {


	}

	@Override
	public void slip(Direction direction, Map map) {
		// 

	}

}
