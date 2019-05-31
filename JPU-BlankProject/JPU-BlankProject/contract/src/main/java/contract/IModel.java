package contract;

import java.util.Observable;

import element.Element;
import entity.EntityPosition;


/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	EntityPosition getEntityPosition();
	Element getPlayerPosition();
	int getX();
	int getY();
	Element[][] getLevel();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	void loadEntityPosition(String code);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
