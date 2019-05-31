package element;

import java.util.ArrayList;

import Behaviors.IFall;
import Behaviors.ISlip;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import model.Model;

import java.lang.Math;
import Behaviors.IExplode;

public class FallingElement extends Element implements IFall, ISlip {
	ArrayList<Direction> direction = new ArrayList<Direction>();
	Position posInitiale = new Position();
	Nothing nothing;


	@Override
	public boolean canIStartToFall(Model model) {
		this.canISlip(model);


		return (canIFallDown(model)|| !(this.direction.isEmpty()));
	}

	@Override
	public boolean tryToFall(ArrayList<Position> position, BagOfPossiblePositions bag, Model model) {

		posInitiale=this.getElementPosition();



		if (canIContinueToFallDown(model)){
			this.fallDown(model, bag);
		}else {
			this.canISlip(model);

			if(!(this.direction.isEmpty())){

				if (this.direction.size()>1){


					if (Math.random()>0.5){
						this.slip(Direction.LEFT, model);
					}else{
						this.slip(Direction.RIGHT, model);

					}
				}else{
					this.slip(this.direction.get(0), model);
				}
			}else{
				return false;
			}
		}
		changeItsPosition(position, bag);
		makeTheFollowingIFallFalling(position, bag, model);
		subscribeFallableIFall(position, bag, model);


		return true;

	}

	private void subscribeFallableIFall(ArrayList<Position> position, BagOfPossiblePositions bag, Model model) {
		// TODO Auto-generated method stub
		for (int i=-1; i<=1; i++){
			if (isNotOutOfBounds(model, posInitiale.getX()+i, posInitiale.getY()-1)){
				if(model.getLevel()[posInitiale.getX()+i][posInitiale.getY()-1].getClass()==IFall.class){
					if(((IFall) model.getLevel()[posInitiale.getX()+i][posInitiale.getY()-1]).canIStartToFall(model) &&
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
		if (!(position.contains(bag.getPosition()[this.getElementPosition().getX()][this.getElementPosition().getY()]))){
			position.add(bag.getPosition()[this.getElementPosition().getX()][this.getElementPosition().getY()]);
			bag.getPosition()[this.getElementPosition().getX()][this.getElementPosition().getY()].setTaken(true);
		}
	}







	@Override
	public void canISlip(Model model) {
		this.direction.clear();
		if (isNotOutOfBounds(model,this.getElementPosition().getX(), this.getElementPosition().getY()+1)){
			if (model.getLevel()[this.getElementPosition().getX()][this.getElementPosition().getY()+1].getClass()==ISlip.class){
				this.checkLeftAndRightIfSlip(model);
			}

		}



	}

	private void checkLeftAndRightIfSlip(Model model) {

		for (int i =-1; i<=1; i=i+2){
			if (isNotOutOfBounds(model,this.getElementPosition().getX()+i, this.getElementPosition().getY()) &&
					isNotOutOfBounds(model,this.getElementPosition().getX()+i, this.getElementPosition().getY()+1)	){
				if (model.getLevel()[this.getElementPosition().getX()+i][this.getElementPosition().getY()].getClass()==Nothing.class&&
						model.getLevel()[this.getElementPosition().getX()+i][this.getElementPosition().getY()+1].getClass()==Nothing.class){

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
	public boolean canIFallDown(Model model) {

		if (isNotOutOfBounds(model,this.getElementPosition().getX(), this.getElementPosition().getY()+1)){


			return (model.getLevel()[this.getElementPosition().getX()][this.getElementPosition().getY()+1].getClass()==Nothing.class);
		}else {
			return false;
		}
	}

	@Override
	public boolean canIContinueToFallDown(Model model) {
		if (isNotOutOfBounds(model,this.getElementPosition().getX(), this.getElementPosition().getY()+1)){


			return (canIFallDown(model) || model.getLevel()[this.getElementPosition().getX()][this.getElementPosition().getY()+1].getClass()==IExplode.class);
		}else {
			return false;
		}
	}


	@Override
	public void fallDown(Model model, BagOfPossiblePositions bag) {		

		if (model.getLevel()[this.getElementPosition().getX()][this.getElementPosition().getY()+1].interaction(Direction.NO, model, bag, null)){
			
			model.setLevel(nothing, this.getElementPosition());
			this.getElementPosition().setY(this.getElementPosition().getY()+1);

			model.setLevel(this, this.getElementPosition());
		}
	}

	@Override
	public void slip(Direction direction, Model model) {
		int[] VectDir=convertDirectionIntoInt(direction);
		model.setLevel(nothing,this.getElementPosition());
		this.getElementPosition().setX(this.getElementPosition().getX()+VectDir[0]);
		model.setLevel(this, this.getElementPosition());




	}
	public void makeTheFollowingIFallFalling(ArrayList<Position> position, BagOfPossiblePositions bag, Model model){
		int index=position.indexOf(this.getElementPosition());
		if (index+1<position.size()){
			Position positionIFall= position.get(index+1);
			((IFall) model.getLevel()[positionIFall.getX()][positionIFall.getY()]).tryToFall(position, bag, model);
		}
	}

}
