package contract;

import java.util.ArrayList;
import java.util.Observable;

import Utility.Position;
import element.Element;
import element.Monster;
import entity.EntityPosition;

public interface IModel {

	/* (non-Javadoc)
	 * @see model.IModel#getX()
	 */
	int getX();

	/* (non-Javadoc)
	 * @see model.IModel#getY()
	 */
	int getY();

	ArrayList<Monster> getMonsterlist();

	void setMonsterlist(ArrayList<Monster> monsterlist);

	/* (non-Javadoc)
	 * @see model.IModel#loadEntityPosition(int)
	 */
	void loadEntityPosition(int level);

	/* (non-Javadoc)
	 * @see model.IModel#getObservable()
	 */
	Observable getObservable();

	/* (non-Javadoc)
	 * @see model.IModel#getEntityPosition()
	 */
	EntityPosition getEntityPosition();

	/* (non-Javadoc)
	 * @see model.IModel#loadEntityPosition(java.lang.String)
	 */
	void loadEntityPosition(String code);

	/* (non-Javadoc)
	 * @see model.IModel#makeMap(java.util.ArrayList)
	 */
	void makeMap(ArrayList<EntityPosition> Tab);

	/* (non-Javadoc)
	 * @see model.IModel#setLevel(element.Element, Utility.Position)
	 */
	void setLevel(Element Elm, Position pos);

	/* (non-Javadoc)
	 * @see model.IModel#getLevel()
	 */
	Element[][] getLevel();

	/* (non-Javadoc)
	 * @see model.IModel#getPlayerPosition()
	 */
	Element getPlayerPosition();

	/* (non-Javadoc)
	 * @see model.IModel#getMap()
	 */
	Element[][] getMap();

	/* (non-Javadoc)
	 * @see model.IModel#setMap(element.Element[][])
	 */
	void setMap(Element[][] map);

}