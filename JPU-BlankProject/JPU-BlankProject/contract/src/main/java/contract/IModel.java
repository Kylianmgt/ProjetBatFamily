package contract;

import java.util.Observable;

import entity.EntityPosition;
import entity.HelloWorld;

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
