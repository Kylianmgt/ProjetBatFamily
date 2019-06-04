package contract;

import java.awt.event.KeyListener;

public interface IView {

	void followMyplayer();
	void printMessage(final String message);
	public void addListener(KeyListener listener);
}
