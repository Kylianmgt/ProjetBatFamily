package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import Utility.Direction;
import javax.swing.text.View;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public class Controller implements IController, KeyListener{
	private IView view;
	private IModel model;
	private Direction directionPlayer=Direction.NO;
	public Controller(IView view, IModel model){
		this.model= model;
		this.view = view;
		
	}

	@Override
	public void control() {
		

	}

	@Override
	public void orderPerform(ControllerOrder controllerOrder) {
		// TODO Auto-generated method stub

	}
//test
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
