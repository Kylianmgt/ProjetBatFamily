package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingUtilities;

import Utility.Direction;
import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements IView, Runnable {

	/** The frame. */
	private ViewFrame viewFrame;

	public ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	public Direction keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case 37:
				return Direction.LEFT;
			case 39:
				return Direction.RIGHT;
			case 38:
				return Direction.UP;
			case 40:
				return Direction.DOWN;
			default:
				return null;
					
		}
	
	}
	
	

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

	@Override
	public void followMyplayer() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void addListener(KeyListener listener) {
		// TODO Auto-generated method stub
		
	}
}
