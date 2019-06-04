package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;

import Behaviors.IFall;
import Behaviors.ISlip;
import Utility.Direction;
import Utility.Position;
import view.View;
import model.Model;
import element.Player;
import element.Monster;




public class Controller extends Observable implements  KeyListener, ISlip{
	private final static int SPEED=200;
	private Model model;
	private Direction directionPlayer=Direction.NO;
	private View view;
	private final int scoreWin = 10;

	public Controller(View view, Model model){
		this.view = view;
		this.model= model;
		this.addObserver(view.getViewFrame().getPane());
		makeEverythingFall();

	}




	private void makeEverythingFall() {
		// TODO Auto-generated method stub
		for (int i =0; i< model.getX(); i++){
			for (int j = 0; j<model.getY(); j++){
				if (model.getLevel()[i][j] instanceof IFall){
					if (((IFall) model.getLevel()[i][j]).canIStartToFall(model)){

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
				e.printStackTrace();
			}
			refreshIFallArray();	
			makeMonsterMove();
			if (this.directionPlayer!=Direction.NO){


				((Player) model.getPlayerPosition()).move( model, directionPlayer);
			}


			view.getViewFrame().buildViewFrame(model);
			//view.refreshView();
			if (model.getPlayerPosition().getScore()>this.scoreWin){
				model.portalAppear();
			}
			

			/*System.out.println(this.listIFall.size());
			if (!(this.listIFall.isEmpty())){
				System.out.println(this.listIFall.get(0).size());
			}*/



		}






	}







	private void refreshIFallArray() {
		for (int i = model.getX()-1 ; i>=0; i--){
			for (int j =model.getY() -1;j>=0;j--){
				if (model.getLevel()[i][j] instanceof IFall){
					if ( ((IFall) model.getLevel()[i][j]).isAmIFalling() ){
						((IFall) model.getLevel()[i][j]).continueToFall(model);
					} else{
						((IFall) model.getLevel()[i][j]).tryToFall(model);

					}
				}
			}
		}




	}

	//private void makeEmFall() {






	// TODO Auto-generated method stub
	/*

		for (ArrayList<Position> listPos : this.listIFall){
			boolean test = false;


			while (!test){


				if (!(this.listIFall.isEmpty()) &&
						model.getLevel()[listPos.get(0).getX()][listPos.get(0).getY()] instanceof IFall){

					if(!((IFall) model.getLevel()[listPos.get(0).getX()][listPos.get(0).getY()]).tryToFall(model) &&
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
	 */

	//}




	@Override
	public void keyPressed(KeyEvent arg0) {		
		if (view.keyCodeToControllerOrder(arg0.getKeyCode()) != null){
			this.directionPlayer=	view.keyCodeToControllerOrder(arg0.getKeyCode());
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
		ArrayList<Integer> indexDel = new ArrayList<Integer>();
		indexDel.clear();
		for (Monster t:monsterlist){
			if (t.getElementPosition().isTaken()){

				t.move( model, Direction.NO);



			}else{
				indexDel.add(monsterlist.indexOf(t));
			}
		}
		for (Integer index : indexDel){
			monsterlist.remove(index);
		}
	}

}
