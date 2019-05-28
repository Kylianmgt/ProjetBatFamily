package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.SwingUtilities;

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

	private static final int roadView = 10;

	private static final int squareSize = 50;

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_G:
			return ControllerOrder.English;
		case KeyEvent.VK_F:
			return ControllerOrder.Francais;
		case KeyEvent.VK_D:
			return ControllerOrder.Deutsch;
		case KeyEvent.VK_I:
			return ControllerOrder.Indonesia;
		default:
			return ControllerOrder.English;
		}
	}

	private Rectangle closeView;
	private IMap map;
	private IMobile myplayer;
	private int view;
	private IOrderPerformer orderPerformer;

	/** The frame. */
	private final ViewFrame viewFrame;

	public View(final IMap map, final IMobile myplayer) throws IOException {
		this.setView(mapView);
		this.setMap(map);
		this.setplayer(myplayer);
		this.getMyplayer().getSprite().loadImage();
		this.setCloseView(new Rectangle(0, this.getMyplayer().getY(), this.getmap().getWidth(), mapView));
		SwingUtilities.invokeLater(this);
	}

	/**
	 * Instantiates a new view.
	 *
	 * @param model the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	@Override
	public final void followMyplayer() {
		this.getCloseView().y = this.getMyplayer().getY() - 1;
	}

	private Rectangle getCloseView() {
		return this.closeView;
	}

	private Imap getmap() {
		return this.map;
	}

	private IMobile getMyplayer() {
		return this.myplayer;
	}

	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	private int getView() {
		return this.view;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	@Override
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	@Override
	public void run() {
		final BoardFrame boardFrame = new BoardFrame("Close view");
		boardFrame.setDimension(new Dimension(this.getmap().getWidth(), this.getmap().getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		boardFrame.setHeightLooped(true);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		for (int x = 0; x < this.getmap().getWidth(); x++) {
			for (int y = 0; y < this.getmap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnThemapXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getMyplayer());

		this.getmap().getObservable().addObserver(boardFrame.getObserver());
		this.followMyplayer();

		boardFrame.setVisible(true);
	}

	private void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}

	private void setmap(final Imap map) throws IOException {
		this.road = road;
		for (int x = 0; x < this.getmap().getWidth(); x++) {
			for (int y = 0; y < this.getmap().getHeight(); y++) {
				this.getmap().getOnThemapXY(x, y).getSprite().loadImage();
			}
		}
	}

	private void setMyplayer(final IMobile myVehicle) {
		this.myplayer = this.myplayer;
	}

	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */

	private void setView(final int view) {
		this.view = view;
	}
}
