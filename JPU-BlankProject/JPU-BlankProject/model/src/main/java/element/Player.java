package element;

import java.util.ArrayList;
import Behaviors.IFall;


import Behaviors.IBlock;
import Behaviors.IExplode;
import Behaviors.IMotion;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import contract.IModel;
import model.Model;

public class Player extends Element implements IMotion, IExplode{
	Nothing nothing=new Nothing();
	Position initialPosition = new Position();

	int score = 0;
	public Player(){
		super();
		this.Sprite='☻';
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}





	@Override
	public void move(ArrayList<Position> position, Model model, Direction direction, BagOfPossiblePositions bag) {
		// TODO Auto-generated method stub
		this.initialPosition=this.getElementPosition();
		int [] vecteurDir=convertDirectionIntoInt(direction);
		ArrayList<Direction> amIOnALedge = amIOnALedge(model);
		


		if (this.canIMove(direction, model)){			
			model.setLevel(nothing, this.getElementPosition());
			model.getLevel()[this.getElementPosition().getX()+vecteurDir[0]][this.getElementPosition().getY()+vecteurDir[1]]=this;

		}else{
			
			if (!amIOnALedge.contains(direction)){
				if(model.getLevel()[this.getElementPosition().getX()+vecteurDir[0]][this.getElementPosition().getY()+vecteurDir[1]].interaction(direction,model, null, this)){
					model.setLevel(nothing, this.getElementPosition());
					model.getLevel()[this.getElementPosition().getX()+vecteurDir[0]][this.getElementPosition().getY()+vecteurDir[1]]=this;
				}else{
					return;
				}



			}else{
				return;
			}		
		}
		tellIFallToFall(position, model, bag);
		this.getElementPosition().setX(this.getElementPosition().getX()+vecteurDir[0]);
		this.getElementPosition().setY(this.getElementPosition().getY()+vecteurDir[1]);



	}


	private void tellIFallToFall(ArrayList<Position> position, Model model, BagOfPossiblePositions bag) {
		for (int i = -1; i<=1;i++){
			for (int j=-1; j<=0; j++){
				if (isNotOutOfBounds(model, initialPosition.getX()+i, initialPosition.getY()+j)){
					//IFall.class.isAssignableFrom(model.getLevel()[this.initialPosition.getX()+i][this.initialPosition.getY()-1].getClass())
					
					if (model.getLevel()[this.initialPosition.getX()+i][this.initialPosition.getY()+j] instanceof IFall && 
							!(model.getLevel()[this.initialPosition.getX()+i][this.initialPosition.getY()+j] instanceof Player)){
					
						
					
						if (((IFall) model.getLevel()[this.initialPosition.getX()+i][this.initialPosition.getY()+j]).canIStartToFall(model)
								&& !(bag.getPosition()[this.initialPosition.getX()+i][this.initialPosition.getY()+j].isTaken())){
							position.add(bag.getPosition()[this.initialPosition.getX()+i][this.initialPosition.getY()+j]);
							bag.getPosition()[this.initialPosition.getX()+i][this.initialPosition.getY()+j].setTaken(true);
						}

					}

				}
			}

		}
	}


	public ArrayList<Direction> amIOnALedge(IModel model){
		ArrayList<Direction> ledges=new ArrayList<Direction>();
		if (this.getElementPosition().getX()==0 ){
			ledges.add(Direction.LEFT);
		}
		if (this.getElementPosition().getX()==model.getX()-1){
			ledges.add(Direction.RIGHT);
		}
		if (this.getElementPosition().getY()==0){
			ledges.add(Direction.UP);

		}
		if (this.getElementPosition().getY()==model.getY()-1){
			ledges.add(Direction.DOWN);
		}
		return ledges;


	}

	public boolean canIMove(Direction direction, IModel model) {
		// TODO Auto-generated method stub


		int[] intDir = convertDirectionIntoInt(direction);
		ArrayList<Direction> amIOnALedge=amIOnALedge( model);

		if (amIOnALedge.contains(direction)){
			return false;

		}else{

			return (model.getLevel()[this.getElementPosition().getX()+intDir[0]][this.getElementPosition().getY()+intDir[1]] instanceof Nothing ||
					model.getLevel()[this.getElementPosition().getX()+intDir[0]][this.getElementPosition().getY()+intDir[1]] instanceof Dirt);





		}

	}

	@Override
	public boolean interaction(Direction direction, Model model, BagOfPossiblePositions bag, Player player){
		this.explode(bag, model);
		return true;
	}


	@Override
	public ArrayList<ArrayList<Position>> explode(BagOfPossiblePositions bag, Model model) {
		model.setLevel(nothing, this.getElementPosition());
		this.getElementPosition().setTaken(false);
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
