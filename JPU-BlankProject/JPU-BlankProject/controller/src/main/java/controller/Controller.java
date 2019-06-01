package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Utility.Direction;
import Utility.Position;
import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import element.Player;

public class Controller implements IController, KeyListener {
	private final IView view;
	private final IModel model;
	private Direction directionPlayer = Direction.NO;
	Position position = this.model.getPlayerPosition().getElementPosition();

	Player player = this.model.getMap()[this.position.getX()][this.position.getY()];

	public Controller(final IView view, final IModel model) {
		this.model = model;
		this.view = view;

	}

	@Override
	public void control() {

	}

	// test
	@Override
	public void keyPressed(final KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getKeyCode()) {
		case 37:
			this.directionPlayer = Direction.LEFT;
			break;
		case 38:
			this.directionPlayer = Direction.UP;
			break;
		case 39:
			this.directionPlayer = Direction.RIGHT;
			break;
		case 40:
			this.directionPlayer = Direction.DOWN;
		}
	}

	@Override
	public void keyReleased(final KeyEvent arg0) {
		if ((arg0.getKeyCode() >= 37) && (arg0.getKeyCode() <= 40)) {
			this.directionPlayer = Direction.NO;
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(final KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void orderPerform(final ControllerOrder controllerOrder) {
		// TODO Auto-generated method stub

	}

}
