package contract;

import java.awt.event.KeyListener;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	void followMyplayer();

	/**
	 * Prints the message.
	 *
	 * @param message the message
	 */
	void printMessage(final String message);
	public void addListener(KeyListener listener);
}
