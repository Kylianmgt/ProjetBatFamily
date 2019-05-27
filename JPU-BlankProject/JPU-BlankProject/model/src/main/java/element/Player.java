package element;

import java.util.ArrayList;

import model.Dirt;

public class Player extends Element implements IMotion, IExplode{

	@Override
	public ArrayList<Position> explode(Map map, ArrayList<Position> position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(ArrayList<Position> position, Map map, Direction direction, Position positionElement) {
		// TODO Auto-generated method stub

	}

	public boolean canIMove(Direction direction, Map map, Position position) {
		// TODO Auto-generated method stub

	
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
				dirY=1;
				break;
			case BAS:
				dirY=-1;
				break;
			default:
				break;
			}

			if (PlayerIsFullLeft(position)&&direction==Direction.GAUCHE ||
					PlayerIsFullRight(map, position)&&direction==Direction.DROITE||
					PlayerIsFullUp(position)&&direction==Direction.HAUT||
					playerIsFullDown(map, position)&&direction==Direction.BAS){
				return false;

			}else{
				if (map.getNiveau()[position.getX()+dirX][position.getY()+dirY].getClass()==Nothing.class ||
						map.getNiveau()[position.getX()+dirX][position.getY()+dirY].getClass()==Dirt.class){
					return true;
				}else{
					return false;
				}
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
