package element;

import java.util.ArrayList;
import Behaviors.IExplode;
import Behaviors.IMotion;
import Utility.Direction;
import Utility.Position;
import model.Model;

public class Monster extends Element implements IMotion, IExplode{

	ArrayList<ArrayList<Position>> arrayArrayPos=new ArrayList<ArrayList<Position>>();
	Position explodePos = new Position();
	private Nothing nothing  = new Nothing();
	private Direction[] directionmonstre = new Direction[4];

	public Monster(){
		super();
		//this.Sprite='M';
		this.sprite = new Sprite("/monster.png");
		this.directionmonstre[0]=Direction.LEFT;
		this.directionmonstre[1]=Direction.UP;
		this.directionmonstre[2]=Direction.RIGHT;
		this.directionmonstre[3]=Direction.DOWN;
		

	}

	public Direction[] getDirectionmonstre() {
		return directionmonstre;
	}

	public void setDirectionmonstre(Direction[] directionmonstre) {
		this.directionmonstre = directionmonstre;
	}

	public boolean interaction( Direction direction, Model model, Player player){
		this.explode(model);
		this.getElementPosition().setTaken(false);
		return true;		
	}
@Override
	public void explode(Model model) {
	
		
		
	
		
		for (int i =-1; i<=1; i++){
			for (int j = -1; j<=1; j++){
				if (isNotOutOfBounds(model, this.getElementPosition().getX()+i , this.getElementPosition().getY()+j)){
					if (model.getLevel()[this.getElementPosition().getX()+i][ this.getElementPosition().getY()+j] instanceof IExplode &&
							model.getLevel()[this.getElementPosition().getX()+i][ this.getElementPosition().getY()+j] != this){
						model.getLevel()[this.getElementPosition().getX()+i][ this.getElementPosition().getY()+j].interaction(null, model, null);
					}
						
					Position explodePos = new Position();
					explodePos.setTaken(true);
					explodePos.setX(this.getElementPosition().getX()+i);
					explodePos.setY(this.getElementPosition().getY()+j);
					Diamond diamond = new Diamond();
					diamond.getElementPosition().setTaken(true);
					diamond.setElementPosition(explodePos);
					model.setLevel(diamond , explodePos);
				
				
				

				}
			}
		}

	}







	public void move( Model model, Direction direction) {

		if (this.canImove(directionmonstre[0], model, elementPosition)){

			int [] intDir=convertDirectionIntoInt(directionmonstre[0]);
			moveMonster(model, intDir);
			rotationTab(3);



		}


		else if (canImove(directionmonstre[1], model, elementPosition)){


			int [] intDir=convertDirectionIntoInt(directionmonstre[1]);

			moveMonster(model, intDir);	
		}



		else if (canImove(directionmonstre[2], model, elementPosition)){

			int [] intDir=convertDirectionIntoInt(directionmonstre[2]);
			moveMonster(model, intDir);
			rotationTab(1);
		}
		else if (canImove(directionmonstre[3], model, elementPosition)){
			int [] intDir=convertDirectionIntoInt(directionmonstre[3]);
			moveMonster(model, intDir);
			rotationTab(2);
		}

	}

	private void moveMonster(Model model, int[] intDir) {
		model.getLevel()[elementPosition.getX()][elementPosition.getY()]=nothing;
		model.getLevel()[elementPosition.getX()+intDir[0]][elementPosition.getY()+intDir[1]]=this;			
		this.getElementPosition().setX(this.getElementPosition().getX()+intDir[0]);
		this.getElementPosition().setY(this.getElementPosition().getY()+intDir[1]);
		checkPlayer(model);
	}

	private void checkPlayer(Model model) {
		// TODO Auto-generated method stub
		for (int i = -1 ; i <=1; i=i+2){
			if (isNotOutOfBounds(model, this.getElementPosition().getX()+i, this.getElementPosition().getY())){
				if (model.getLevel()[this.getElementPosition().getX()+i][this.getElementPosition().getY()] instanceof Player){
					this.explode(model);
				}

			}
			if (isNotOutOfBounds(model, this.getElementPosition().getX(), this.getElementPosition().getY()+i)){

			}
		}

	}

	public boolean canImove( Direction directionactuel, Model model, Position position){



		int [] intDir = convertDirectionIntoInt(directionactuel);
		if (isNotOutOfBounds(model, elementPosition.getX()+intDir[0], elementPosition.getY()+intDir[1])){	
			if (model.getLevel()[elementPosition.getX()+intDir[0]][elementPosition.getY()+intDir[1]]instanceof Nothing ||
					model.getLevel()[elementPosition.getX()+intDir[0]][elementPosition.getY()+intDir[1]]instanceof Player){

				return(model.getLevel()[elementPosition.getX()+intDir[0]][elementPosition.getY()+intDir[1]].interaction(null, model, null));
			}

		}				


		return false;

	}

	private void rotationTab(int amount){
		for (int i=0; i<amount; i++){	
			Direction temp = directionmonstre[0];
			directionmonstre[0]= directionmonstre[1];
			directionmonstre[1]= directionmonstre[2];
			directionmonstre[2]= directionmonstre[3];
			directionmonstre[3]=temp;
		}
	}



}

