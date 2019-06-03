package element;

import java.util.ArrayList;

import Behaviors.IFall;
import Behaviors.ISlip;
import Utility.Direction;
import Utility.Position;
import model.Model;

import java.lang.Math;
import Behaviors.IExplode;

public class FallingElement extends Element implements IFall, ISlip {
	ArrayList<Direction> direction = new ArrayList<Direction>();
	Position posInitiale = new Position();
	Nothing nothing=new Nothing();
	private boolean AmIFalling= false;



	@Override
	public boolean canIStartToFall(Model model) {
		this.canISlip(model);
		return (canIFallDown(model)|| !(this.direction.isEmpty()));
	}
	
	@Override
	public boolean tryToFall(Model Model) {
		// TODO Auto-generated method stub
		if (canIStartToFall(Model)){
			if (canIFallDown(Model)){
				this.fallDown(Model);
			}else {
				if (this.direction.size()>1){
					if (Math.random()>0.5){
						this.slip(direction.get(0), Model);
					}else{
						this.slip(direction.get(0), Model);
					}
				}else{
					this.slip(direction.get(0), Model);
				}
				
			}
			this.setAmIFalling(true);
		}
		return false;
	}


	@Override
	public boolean continueToFall(Model model) {
		
		posInitiale.setX(this.getElementPosition().getX());
		posInitiale.setY(this.getElementPosition().getY());
		posInitiale.setTaken(this.getElementPosition().isTaken());
		



		if (canIContinueToFallDown(model)){
			this.fallDown(model);
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
				this.setAmIFalling(false);
				return false;
				
			}
		}


		return true;

	}

	


	@Override
	public void canISlip(Model model) {
		this.direction.clear();
		if (isNotOutOfBounds(model,this.getElementPosition().getX(), this.getElementPosition().getY()+1)){
			if (model.getLevel()[this.getElementPosition().getX()][this.getElementPosition().getY()+1]instanceof ISlip){
				this.checkLeftAndRightIfSlip(model);
			}

		}



	}

	private void checkLeftAndRightIfSlip(Model model) {

		for (int i =-1; i<=1; i=i+2){
			if (isNotOutOfBounds(model,this.getElementPosition().getX()+i, this.getElementPosition().getY()) &&
					isNotOutOfBounds(model,this.getElementPosition().getX()+i, this.getElementPosition().getY()+1)	){
				if (model.getLevel()[this.getElementPosition().getX()+i][this.getElementPosition().getY()] instanceof Nothing &&
						model.getLevel()[this.getElementPosition().getX()+i][this.getElementPosition().getY()+1]instanceof Nothing){

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


			return (model.getLevel()[this.getElementPosition().getX()][this.getElementPosition().getY()+1]instanceof Nothing);
		}else {
			return false;
		}
	}

	@Override
	public boolean canIContinueToFallDown(Model model) {
	
		if (isNotOutOfBounds(model,this.getElementPosition().getX(), this.getElementPosition().getY()+1)){
			


			return (canIFallDown(model) || model.getLevel()[this.getElementPosition().getX()][this.getElementPosition().getY()+1]instanceof IExplode);
		}else {
			return false;
		}
	}


	@Override
	public void fallDown(Model model) {		
	

		if (model.getLevel()[this.getElementPosition().getX()][this.getElementPosition().getY()+1].interaction(Direction.NO, model, null)){
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


	public boolean isAmIFalling() {
		return AmIFalling;
	}

	public void setAmIFalling(boolean amIFalling) {
		AmIFalling = amIFalling;
	}


}
