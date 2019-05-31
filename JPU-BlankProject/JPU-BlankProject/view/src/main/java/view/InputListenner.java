package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import contract.IController;


public class InputListenner implements KeyListener{
	IController controller;
	public InputListenner(IController controller){
		this.controller=controller;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
