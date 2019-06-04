package view;

import java.awt.event.KeyListener;
import javax.swing.SwingUtilities;
import Utility.Direction;
import contract.IController;
import contract.IModel;
import contract.IView;

public final class View implements IView, Runnable {

	private ViewFrame viewFrame;

	public ViewFrame getViewFrame() {
		return this.viewFrame;
	}


	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}
	
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
		
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

		public void run() {
		this.viewFrame.setVisible(true);
	}

		public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

	@Override
	public void followMyplayer() {
			
	}

	@Override
	public void addListener(KeyListener listener) {
		
	}
}
