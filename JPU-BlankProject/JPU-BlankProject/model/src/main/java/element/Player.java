package element;

import java.util.ArrayList;
import Behaviors.IFall;


import Behaviors.IBlock;
import Behaviors.IExplode;
import Behaviors.IMotion;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;

public class Player extends Element implements IMotion, IExplode{
	Nothing nothing=new Nothing();
	Position initialPosition = new Position();

	int score = 0;


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}





	@Override
	public void move(ArrayList<Position> position, Map map, Direction direction, BagOfPossiblePositions bag) {
		// TODO Auto-generated method stub
		this.initialPosition=this.getPositionElement();
		int [] vecteurDir=convertDirectionIntoInt(direction);
		ArrayList<Direction> amIOnALedge = amIOnALedge(map);


		if (this.canIMove(direction, map)){
			map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()]=nothing;
			map.getNiveau()[this.getPositionElement().getX()+vecteurDir[0]][this.getPositionElement().getY()+vecteurDir[1]]=this;

		}else{
			if (!amIOnALedge.contains(direction)){
				if(map.getNiveau()[this.getPositionElement().getX()+vecteurDir[0]][this.getPositionElement().getY()+vecteurDir[1]].interaction(direction,map, null)){
					map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()]=nothing;
					map.getNiveau()[this.getPositionElement().getX()+vecteurDir[0]][this.getPositionElement().getY()+vecteurDir[1]]=this;
				}else{
					return;
				}



			}else{
				return;
			}		
		}
		tellIFallToFall(position, map, bag);
		this.getPositionElement().setX(this.getPositionElement().getX()+vecteurDir[0]);
		this.getPositionElement().setY(this.getPositionElement().getY()+vecteurDir[1]);



	}


	private void tellIFallToFall(ArrayList<Position> position, Map map, BagOfPossiblePositions bag) {
		for (int i = -1; i<=1;i++){
			for (int j=-1; j<=0; j++){
				if (isNotOutOfBounds(map, initialPosition.getX()+i, initialPosition.getY()+j)){

					if (map.getNiveau()[this.initialPosition.getY()-1][this.initialPosition.getX()+i].getClass()==IFall.class){
						if (((IFall) map.getNiveau()[this.initialPosition.getY()-1][this.initialPosition.getX()+i]).canIStartToFall(map)
								&& !(bag.getPosition()[this.initialPosition.getY()-1][this.initialPosition.getX()+i].isTaken())){
							position.add(bag.getPosition()[this.initialPosition.getY()-1][this.initialPosition.getX()+i]);
							bag.getPosition()[this.initialPosition.getY()-1][this.initialPosition.getX()+i].setTaken(true);
						}

					}

				}
			}

		}
	}


	public ArrayList<Direction> amIOnALedge(Map map){
		ArrayList<Direction> ledges=new ArrayList<Direction>();
		if (this.getPositionElement().getX()==0 ){
			ledges.add(Direction.LEFT);
		}
		if (this.getPositionElement().getX()==map.getX()-1){
			ledges.add(Direction.RIGHT);
		}
		if (this.getPositionElement().getY()==0){
			ledges.add(Direction.UP);

		}
		if (this.getPositionElement().getY()==map.getY()-1){
			ledges.add(Direction.DOWN);
		}
		return ledges;


	}

	public boolean canIMove(Direction direction, Map map) {
		// TODO Auto-generated method stub


		int[] intDir = convertDirectionIntoInt(direction);
		ArrayList<Direction> amIOnALedge=amIOnALedge( map);

		if (amIOnALedge.contains(direction)){
			return false;

		}else{

			return !(map.getNiveau()[this.getPositionElement().getX()+intDir[0]][this.getPositionElement().getY()+intDir[1]] instanceof IBlock);





		}

	}

	@Override
	public boolean interaction(Direction direction, Map map, BagOfPossiblePositions bag){
		this.explode(bag, map);
		return true;
	}


	@Override
	public ArrayList<ArrayList<Position>> explode(BagOfPossiblePositions bag, Map map) {
		map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()]=nothing;
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
		return new ArrayList<ArrayList<Position>>();
		// TODO Auto-generated method stub

	}

















}
