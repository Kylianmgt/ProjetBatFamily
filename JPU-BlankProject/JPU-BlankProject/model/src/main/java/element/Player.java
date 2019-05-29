package element;

import java.util.ArrayList;
import java.lang.Class;
import java.util.Arrays;

import Behaviors.IBlock;
import Behaviors.IExplode;
import Behaviors.IMotion;
import Utility.Direction;
import Utility.Position;

public class Player extends Element implements IMotion, IExplode{
	Nothing nothing=new Nothing();

	int score = 0;


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}





	@Override
	public void move(ArrayList<Position> position, Map map, Direction direction, Position positionElement) {
		// TODO Auto-generated method stub
		int [] intDir=convertDirectionIntoInt(direction);
		ArrayList<Direction> amIOnALedge = amIOnALedge(map);


		if (this.canIMove(direction, map)){
			map.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;

		}else{
			if (!amIOnALedge.contains(direction)){
				if(map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]].interaction(direction,map, position)){
					map.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
					map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;
				}



			}else{
				return;
			}


		}
		tellRocksToFall(position, map, positionElement);

	}


	private void tellRocksToFall(ArrayList<Position> position, Map map, Position positionElement) {
		if (positionElement.getY()-1>=0){
			for (int i = -1; i<=1;i++){
				if (positionElement.getX()+i>=0 && positionElement.getX()+i< map.getX()){

					map.getNiveau()[positionElement.getY()-1][positionElement.getX()+i].tryToFall(position);

				}

			}
		}
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
	public boolean interaction(Direction direction, Map map, ArrayList<Position> position){
		this.explode(map, position, this.getPositionElement());
		return true;
	}


	@Override
	public void explode(Map map, ArrayList<Position> position, Position positionElement) {
		map.getNiveau()[this.getPositionElement().getX()][this.getPositionElement().getY()]=nothing;
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
		// TODO Auto-generated method stub
		
	}


	
	













}
