package element;

import java.util.ArrayList;

import Behaviors.IExplode;
import Behaviors.IMotion;
import Utility.Direction;
import Utility.Position;





public class Monster extends Element implements IMotion, IExplode{

	
private Nothing nothing  = new Nothing();
private String[] directionmonstre = {"LEFT","DOWN","RIGHT","UP"};
//private String  directionactuel = directionmonstre[0];










	public boolean interaction( Direction direction, Map map, ArrayList<Position> position){
		this.explode(direction, map, position);
		return true;		
	}
	public void explode(Direction direction, Map map, ArrayList<Position> position) {
		
		
		for (int i =-1; i<=1; i++){
			for (int j = -1; j<=1; j++){
				if(this.getPositionElement().getX()+i >=0 &&
						this.getPositionElement().getX()+i < map.getX() &&
						this.getPositionElement().getY()+j <=0 &&
						this.getPositionElement().getY()+j <map.getY()){

					if (map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getX()+i] instanceof IExplode){
						map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getX()+i].interaction(direction, map, position);
					}
					map.getNiveau()[this.getPositionElement().getX()+i][this.getPositionElement().getX()+i]=new Diamond();
				}


			}
		}
	

	}

	@Override
	public void move(ArrayList<Position> position, Map map, Direction direction, Position positionElement) {
		
		
		
		
		
		
		
		if (this.canImove(directionmonstre[1], map, positionElement)){
			int [] intDir=convertDirectionIntoInt(directionmonstre[1]);
			map.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;
			rotationTab(1);
			
		}
		
		else if (canImove(directionmonstre[0], map, positionElement)){
			int [] intDir=convertDirectionIntoInt(directionmonstre[0]);
			map.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;
			
		
		}
		
		else if (canImove(directionmonstre[3], map, positionElement)){
			int [] intDir=convertDirectionIntoInt(directionmonstre[3]);
			map.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;
			rotationTab(3);
			
			rotationTab(2);
		}else if (canImove(directionmonstre[2], map, positionElement)){
			int [] intDir=convertDirectionIntoInt(directionmonstre[2]);
			map.getNiveau()[positionElement.getX()][positionElement.getY()]=nothing;
			map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]]=this;
		}	rotationTab(3);
			
		}
		
	
	
	
	
	public int[] convertDirectionIntoInt(String directionactuel){
		int dirX = 0;
		int dirY = 0;
		
		switch (directionactuel){
		case "RIGHT":
			dirX=1;
			break;
		case "LEFT":
			dirX=-1;
			break;
		case "UP":
			dirY=-1;
			break;
		case "DOWN":
			dirY=1;
			break;
		default:
			break;
		}
		int[] tab = {dirX,dirY};
		return tab;
	}
	
	
	
	public boolean canImove( String directionactuel, Map map, Position position){
		
		int [] intDir = convertDirectionIntoInt(directionactuel);
		
		if(map.getNiveau()[positionElement.getX()+intDir[0]][positionElement.getY()+intDir[1]] == nothing){
			return true;
		}
		else{
			return false;
		
		}
	
	}
	
	private void rotationTab(int amount){
		
		
	for (int i=0; i<amount; i++){	
		String temp = directionmonstre[0];
		directionmonstre[0]= directionmonstre[1];
		directionmonstre[1]= directionmonstre[2];
		directionmonstre[2]= directionmonstre[3];
		directionmonstre[1]=temp;
	}
	}
	}
