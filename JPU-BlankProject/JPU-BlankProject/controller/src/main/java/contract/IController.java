package contract;

import java.awt.event.KeyEvent;

public interface IController {

	void control();

	void keyPressed(KeyEvent arg0);

	void keyReleased(KeyEvent arg0);

	void keyTyped(KeyEvent arg0);

}