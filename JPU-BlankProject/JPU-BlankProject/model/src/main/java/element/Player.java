package element;

import java.util.ArrayList;
import Behaviors.IFall;


import Behaviors.IBlock;
import Behaviors.IExplode;
import Behaviors.IMotion;
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
	public void move( Model model, Direction direction) {
		// TODO Auto-generated method stub
		this.initialPosition=this.getElementPosition();
		int [] vecteurDir=convertDirectionIntoInt(direction);
		ArrayList<Direction> amIOnALedge = amIOnALedge(model);
		


		if (this.canIMove(direction, model)){			
			model.setLevel(nothing, this.getElementPosition());
			model.getLevel()[this.getElementPosition().getX()+vecteurDir[0]][this.getElementPosition().getY()+vecteurDir[1]]=this;

		}else{
			
			if (!amIOnALedge.contains(direction)){
				if(model.getLevel()[this.getElementPosition().getX()+vecteurDir[0]][this.getElementPosition().getY()+vecteurDir[1]].interaction(direction,model,  this)){
					model.setLevel(nothing, this.getElementPosition());
					model.getLevel()[this.getElementPosition().getX()+vecteurDir[0]][this.getElementPosition().getY()+vecteurDir[1]]=this;
				}else{
					return;
				}



			}else{
				return;
			}		
		}
		this.getElementPosition().setX(this.getElementPosition().getX()+vecteurDir[0]);
		this.getElementPosition().setY(this.getElementPosition().getY()+vecteurDir[1]);



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
	public boolean interaction(Direction direction, Model model, Player player){
		this.explode( model);
		return true;
	}


	@Override
	public void explode( Model model) {
		
		model.setLevel(nothing, this.getElementPosition());
		this.getElementPosition().setTaken(false);
		System.out.println("GameOver =(");
		System.exit(0);
		// TODO Auto-generated method stub

	}

















}
