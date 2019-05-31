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
	Position posInitiale = new Position();
	Nothing nothing;


	@Override
	public boolean canIStartToFall(Map map) {
		this.canISlip(map);


		return (canIFallDown(map)|| !(this.direction.isEmpty()));
	}

	@Override
	public boolean tryToFall(ArrayList<Position> position, BagOfPossiblePositions bag, Map map) {

		posInitiale=this.getPositionElement();



		if (canIContinueToFallDown(map)){
			this.fallDown(map, bag);
		}else {
			this.canISlip(map);

			if(!(this.direction.isEmpty())){

				if (this.direction.size()>1){


					if (Math.random()>0.5){
						this.slip(Direction.LEFT, map);
					}else{
						this.slip(Direction.RIGHT, map);

					}
				}else{
					this.slip(this.direction.get(0), map);
				}
			}else{
				return false;
			}
		}
		changeItsPosition(position, bag);
		makeTheFollowingIFallFalling(position, bag, map);
		subscribeFallableIFall(position, bag, map);


		return true;

	}

	private void subscribeFallableIFall(ArrayList<Position> position, BagOfPossiblePositions bag, Map map) {
		// TODO Auto-generated method stub
		for (int i=-1; i<=1; i++){
			if (isNotOutOfBounds(map, posInitiale.getX()+i, posInitiale.getY()-1)){
				if(map.getNiveau()[posInitiale.getX()+i][posInitiale.getY()-1].getClass()==IFall.class){
					if(((IFall) map.getNiveau()[posInitiale.getX()+i][posInitiale.getY()-1]).canIStartToFall(map) &&
							!(position.contains(bag.getPosition()[posInitiale.getX()+i][posInitiale.getY()-1]))){
						position.add(bag.getPosition()[posInitiale.getX()+i][posInitiale.getY()-1]);

					}
				}

			}
		}

	}

	private void changeItsPosition(ArrayList<Position> position, BagOfPossiblePositions bag) {
		position.remove(bag.getPosition()[posInitiale.getX()][posInitiale.getY()]);
		bag.getPosition()[posInitiale.getX()][posInitiale.getY()].setTaken(false);
		if (!(position.contains(bag.getPosition()[this.getPositionElement().getX()][this.getPositionElement().getY()]))){
			position.add(bag.getPosition()[this.getPositionElement().getX()][this.getPositionElement().getY()]);
			bag.getPosition()[this.getPositionElement().getX()][this.getPositionElement().getY()].setTaken(true);
		}
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
	public void fallDown(Map map, BagOfPossiblePositions bag) {		
		map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()+1].interaction(Direction.NO, map, bag);


		map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()]=nothing;
		map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()+1]=this;
		this.getPositionElement().setY(this.getPositionElement().getY()+1);
	}

	@Override
	public void slip(Direction direction, Map map) {
		int[] VectDir=convertDirectionIntoInt(direction);
		map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()]=nothing;
		map.getNiveau()[this.getPositionElement().getX()+VectDir[0]][this.getPositionElement().getY()]=this;




	}
	public void makeTheFollowingIFallFalling(ArrayList<Position> position, BagOfPossiblePositions bag, Map map){
		int index=position.indexOf(this.getPositionElement());
		if (index+1<position.size()){
			Position positionIFall= position.get(index+1);
			((IFall) map.getNiveau()[positionIFall.getX()][positionIFall.getY()]).tryToFall(position, bag, map);
		}
	}

}
