package element;

import java.util.ArrayList;

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
		if (this.canIMove(direction, map, positionElement)){
			map.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;
		}else{
			
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
				return(map.getNiveau()[position.getX()+intDir[0]][position.getY()+intDir[1]].getClass()==Nothing.class ||
						map.getNiveau()[position.getX()+intDir[0]][position.getY()+intDir[1]].getClass()==Dirt.class);
				
			}
		
	}

	private boolean playerIsFullDown(Map map, Position position) {
		// TODO Auto-generated method stub
		return (position.getY()==map.getY()-1);
	}

	private boolean PlayerIsFullUp(Position position) {
		// TODO Auto-generated method stub
		return (position.getY()==0);
	}

	private boolean PlayerIsFullRight(Map map, Position position) {
		// TODO Auto-generated method stub
		return (position.getX()==map.getX()-1);
	}

	private boolean PlayerIsFullLeft(Position position) {
		// TODO Auto-generated method stub
		return (position.getX()==0);
	}









}
