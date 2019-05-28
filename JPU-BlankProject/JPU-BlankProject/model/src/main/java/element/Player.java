package element;

import java.util.ArrayList;
import java.lang.Class;
import java.util.Arrays;

public class Player extends Element implements IMotion, IExplode{
	Nothing nothing=new Nothing();

	@Override
	public ArrayList<Position> explode(Map map, ArrayList<Position> position) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void move(ArrayList<Position> position, Map map, Direction direction, Position positionElement) {
		// TODO Auto-generated method stub
		int [] intDir=convertDirectionIntoInt(direction);
		ArrayList<Direction> amIOnALedge = amIOnALedge(positionElement, map);


		if (this.canIMove(direction, map, positionElement)){
			map.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;

		}else{
			if (!amIOnALedge.contains(direction)){
				if(map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]].interaction(this, direction)){
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
					if (map.getNiveau()[positionElement.getY()-1][positionElement.getX()+i].getClass()==IFall.class){
						map.getNiveau()[positionElement.getY()-1][positionElement.getX()+i].tryToFall(position);
					}
				}

			}
		}
	}
	public int[] convertDirectionIntoInt(Direction direction){
		int dirX = 0;
		int dirY = 0;
		switch (direction){
		case DROITE:
			dirX=1;
			break;
		case GAUCHE:
			dirX=-1;
			break;
		case HAUT:
			dirY=-1;
			break;
		case BAS:
			dirY=1;
			break;
		default:
			break;
		}
		int[] tab = {dirX,dirY};
		return tab;

	}
	public ArrayList<Direction> amIOnALedge(Position position, Map map){
		ArrayList<Direction> ledges=new ArrayList<Direction>();
		if (position.getX()==0 ){
			ledges.add(Direction.GAUCHE);
		}
		if (position.getX()==map.getX()-1){
			ledges.add(Direction.DROITE);
		}
		if (position.getY()==0){
			ledges.add(Direction.HAUT);

		}
		if (position.getY()==map.getY()-1){
			ledges.add(Direction.BAS);
		}
		return ledges;


	}

	public boolean canIMove(Direction direction, Map map, Position position) {
		// TODO Auto-generated method stub


		int[] intDir = convertDirectionIntoInt(direction);
		ArrayList<Direction> amIOnALedge=amIOnALedge(position, map);

		if (amIOnALedge.contains(direction)){
			return false;

		}else{
			return !(map.getNiveau()[position.getX()+intDir[0]][position.getY()+intDir[1]] instanceof IBlock);
			
		
			
			

		}

	}










}
