package contract;

import java.util.ArrayList;
import java.util.Observable;

import Utility.Position;
import element.Element;
import element.Monster;
import element.Player;
import entity.EntityPosition;

public interface IModel {

	
	int getX();

	int getY();

	ArrayList<Monster> getMonsterlist();

	void setMonsterlist(ArrayList<Monster> monsterlist);

	
	void loadEntityPosition(int level);


	Observable getObservable();


	EntityPosition getEntityPosition();


	void loadEntityPosition(String code);

	void makeMap(ArrayList<EntityPosition> Tab);

	
	void setLevel(Element Elm, Position pos);

	
	Element[][] getLevel();


	Player getPlayerPosition();


	Element[][] getMap();

	
	void setMap(Element[][] map);

}