package view;

import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class JTextFieldWithTypedKeySupport extends JTextField {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	int timestamp;

	KeyEvent createEvent(final char keyChar) {
		return new KeyEvent(this, KeyEvent.KEY_TYPED, this.timestamp++, 0, KeyEvent.VK_UNDEFINED, keyChar);
	}

	void pressKey(final char key) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> super.processKeyEvent(this.createEvent(key)));
	}
}