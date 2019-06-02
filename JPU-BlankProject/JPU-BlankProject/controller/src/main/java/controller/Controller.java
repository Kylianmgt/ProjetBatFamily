package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import Behaviors.IFall;
import Behaviors.ISlip;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import view.View;
import model.Model;
import element.Player;
import element.Monster;




public class Controller implements  KeyListener, ISlip{
	private final static int SPEED=100;
	private Model model;
	private Direction directionPlayer=Direction.NO;
	private ArrayList<ArrayList<Position>> listIFall;
	private BagOfPossiblePositions bag;
	private ArrayList<Position> listIFall2;
	private View view;

	public Controller(View view, Model model){
		this.view = view;
		this.model= model;
		this.listIFall=new ArrayList<ArrayList<Position>>();
		this.listIFall2=new ArrayList<Position>();
		this.bag=new BagOfPossiblePositions(model.getX(), model.getY());
		makeEverythingFall();

	}




	private void makeEverythingFall() {
		// TODO Auto-generated method stub
		for (int i =0; i< model.getX(); i++){
			for (int j = 0; j<model.getY(); j++){
				if (model.getLevel()[i][j] instanceof IFall){
					if (((IFall) model.getLevel()[i][j]).canIStartToFall(model) &&
							!(bag.getPosition()[i][j].isTaken())){
						this.listIFall2.add(bag.getPosition()[i][j]);
						bag.getPosition()[i][j].setTaken(true);
						refreshIFallArray();
					}
				}
			}
		}
	}




	public void control() {
		for(;;){
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (this.directionPlayer!=Direction.NO){


				((Player) model.getPlayerPosition()).move(listIFall2, model, directionPlayer, bag);
			}
			refreshIFallArray();
			makeMonsterMove();
		

			makeEmFall();

			view.refreshView();

			/*System.out.println(this.listIFall.size());
			if (!(this.listIFall.isEmpty())){
				System.out.println(this.listIFall.get(0).size());
			}*/



		}






	}



	private void removeOldLists() {
		// TODO Auto-generated method stub
		ArrayList<Integer> index = new ArrayList<Integer>();
		index.clear();
		for (ArrayList<Position> listPos : this.listIFall){


			if (listPos.isEmpty()){
				index.add(listIFall.indexOf(listPos));
				
			}
		}
		for(Integer indexInt : index){
			this.listIFall.remove((int) indexInt);
		}
		System.out.println(listIFall.size());
	}




	private void refreshIFallArray() {

		if(!(listIFall2.isEmpty())){


			ArrayList<Position> temp=new ArrayList<Position>();
			temp.addAll(listIFall2);
			listIFall.add(temp);			
			listIFall2.clear();

		}
		removeOldLists();


	}

	private void makeEmFall() {
		// TODO Auto-generated method stub


		for (ArrayList<Position> listPos : this.listIFall){
			boolean test = false;


			while (!test){


				if (!(this.listIFall.isEmpty()) &&
						model.getLevel()[listPos.get(0).getX()][listPos.get(0).getY()] instanceof IFall){
					
					if(!((IFall) model.getLevel()[listPos.get(0).getX()][listPos.get(0).getY()]).tryToFall(listPos, bag, model) &&
							(listPos.get(0).isTaken())){
						bag.getPosition()[listPos.get(0).getX()][listPos.get(0).getY()].setTaken(false);
						listPos.remove(bag.getPosition()[listPos.get(0).getX()][listPos.get(0).getY()]);
						
						
						
						
					}
					test=true;


				}else{
					test=true;
				}
			}
		}

	}




	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getKeyCode()){
		case 37:
			this.directionPlayer=Direction.LEFT;
			break;
		case 38:
			this.directionPlayer=Direction.UP;
			break;
		case 39:
			this.directionPlayer=Direction.RIGHT;
			break;
		case 40:
			this.directionPlayer=Direction.DOWN;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode()>=37 && arg0.getKeyCode()<=40){
			this.directionPlayer=Direction.NO;
		}

		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	private void makeMonsterMove(){
		ArrayList<Monster> monsterlist = model.getMonsterlist();
		for (Monster t:monsterlist){
			
			t.move(null, model, Direction.NO, null);
		}
	}

}
