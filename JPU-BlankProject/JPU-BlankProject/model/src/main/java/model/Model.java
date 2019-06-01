package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import Utility.ElementFactory;
import Utility.Position;
import contract.IModel;
import contract.IView;
import element.Element;
import element.Player;
import entity.EntityPosition;



/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public  class Model extends Observable implements IModel {
	
	
	private Element player; 
	private final int X= 25;
	private final int Y= 25;
	
	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	private int level= 1;
	private ArrayList<EntityPosition> Tab;
	private Element[][] Map;
	private String[][] Map2;
	private ElementFactory factory;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		Map = new Element[25][25];
		Map2 = new String[25][25];
		factory = new ElementFactory();
		
		loadEntityPosition(level);
		makeMap(Tab);
		System.out.println(Arrays.deepToString(Map));
		
		//System.out.println(Tab);
		//System.out.println(Tab.get(0)[0];
	}

	private void setEntityPosition(final ArrayList<EntityPosition> Tab) {
		this.Tab = Tab;
		this.setChanged();
		this.notifyObservers();
		clearChanged();
		
	}

	public void loadEntityPosition(final int level) {
		try {
			final DAOLevel daolevel = new DAOLevel(DBConnection.getInstance().getConnection());
			this.setEntityPosition(daolevel.find(level));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}


	public Observable getObservable() {
		return this;
	}

	@Override
	public EntityPosition getEntityPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadEntityPosition(String code) {
		// TODO Auto-generated method stub
		
	}
	
	public void makeMap(ArrayList<EntityPosition> Tab){
		//int i =0;
			//for(i=0; i<625; i++)
		for (EntityPosition t:Tab){
			//if(t.getElement() != null){
				int x = t.getCoordX()-1;
				int y = t.getCoordY()-1;				
				String element = t.getElement();
				setOntheMap(x, y, element);
			    //this.Map2[x][y] = t.getElement();
				//i++;
				// System.out.println(x + "    " +y + "   " + element + "     "+i);
				
				
					
				
						
			}
		
		//}
		
	}
	
	private void setOntheMap(int x, int y, String element){
		
		switch ("element"){
        case "O":
        	this.Map[x][y] = this.factory.createRock();
        	this.Map[x][y].getElementPosition().setX(x);
        	this.Map[x][y].getElementPosition().setY(y);
        break;
        
        case "D":
        	this.Map[x][y] = this.factory.createDiamond();
        	this.Map[x][y].getElementPosition().setX(x);
        	this.Map[x][y].getElementPosition().setY(y);
        break;
        
        case "t":
        	this.Map[x][y] = this.factory.createDirt();	
 
        break;
            
        case "M":
        	this.Map[x][y] = this.factory.createBlock();
        break;
            
        case "V":
        	this.Map[x][y] = this.factory.createNothing();
        break;
        
        case "S":
        	this.Map[x][y] = this.factory.createPlayer();
        	this.player=this.Map[x][y];
        	player.getElementPosition().setX(x);
        	player.getElementPosition().setY(y);
        	
        break;
        
        case "P":
        	this.Map[x][y] = this.factory.createPortal();
        break;
        case "N":
        	this.Map[x][y] = this.factory.createBlock();
        break;
        case "X":
        	this.Map[x][y] = this.factory.createMonster();
        break;
         
        }
		
	}

	public void setLevel(Element Elm, Position pos) {
		if(pos.isTaken()){
			this.Map[pos.getX()][pos.getY()]=Elm;
			setChanged();
			notifyObservers();
			clearChanged();
		}
		
	}
	public Element[][] getLevel() {
		return Map;
	}

	public Element getPlayerPosition() {
		// TODO Auto-generated method stub
		return this.player;
	}
	
	
	public Element[][] getMap() {
		return Map;
	}

	public void setMap(Element[][] map) {
		Map = map;
	}
}
