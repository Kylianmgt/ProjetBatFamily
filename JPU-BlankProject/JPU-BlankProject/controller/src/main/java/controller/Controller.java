package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


import Behaviors.IFall;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import view.View;
import model.Model;
import element.Player;




public class Controller implements  KeyListener{
	private final static int SPEED=1000;
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
			//makeTheMonsterMove()
			makeEmFall();
			view.refreshView();
		
			
		}






	}



	private void refreshIFallArray() {
		if(!(listIFall2.isEmpty())){
			ArrayList<Position> temp = new ArrayList<Position>();
			temp=listIFall2;
			listIFall.add(temp);

			listIFall2.clear();
		}
	}

	private void makeEmFall() {
		// TODO Auto-generated method stub


		for (ArrayList<Position> listPos : this.listIFall){
			boolean test = false;


			while (!test){
				if (!(this.listIFall.isEmpty())){					
					if(!((IFall) model.getLevel()[listPos.get(0).getX()][listPos.get(0).getY()]).tryToFall(listPos, bag, model) &&
							!(listPos.get(0).isTaken())){
						listPos.remove(bag.getPosition()[listPos.get(0).getX()][listPos.get(0).getY()]);
					}else{
						test= true;
					}

				}else{
					listIFall.remove(listPos);
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



}
