package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import Utility.ElementFactory;
import Utility.Position;
import contract.IModel;
import element.Element;
import element.Monster;
import element.Player;
import element.Portal;
import entity.EntityPosition;


public  class Model extends Observable implements IModel{
	
	private boolean portalAppeared= false;
	private Player player; 
	private Portal portal;
	private final int X= 25;
	private final int Y= 25;
	private int level= 5;
	private ArrayList<EntityPosition> Tab;
	private Element[][] Map;
	private ElementFactory factory;
	private ArrayList<Monster> monsterlist;
	

	@Override
	public int getX() {
		return X;
	}

	@Override
	public int getY() {
		return Y;
	}

	@Override
	public ArrayList<Monster> getMonsterlist() {
		return monsterlist;
	}


	@Override
	public void setMonsterlist(ArrayList<Monster> monsterlist) {
		this.monsterlist = monsterlist;
	}

	
	public Model() {
		this.Map = new Element[25][25];
		this.factory = new ElementFactory();
		this.monsterlist = new ArrayList<Monster>();
		loadEntityPosition(level);
		makeMap(Tab);
		System.out.println(Arrays.deepToString(Map));
			
	}
	

	private void setEntityPosition(final ArrayList<EntityPosition> Tab) {
		this.Tab = Tab;
		this.setChanged();
	}

	@Override
	public void loadEntityPosition(final int level) {
		try {
			final DAOLevel daolevel = new DAOLevel(DBConnection.getInstance().getConnection());
			this.setEntityPosition(daolevel.find(level));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Observable getObservable() {
		return this;
	}

	@Override
	public EntityPosition getEntityPosition() {
		return null;
	}

	@Override
	public void loadEntityPosition(String code) {

	}
	
		@Override
	public void makeMap(ArrayList<EntityPosition> Tab){
		
		for (EntityPosition t:Tab){
				int x = t.getCoordX()-1;
				int y = t.getCoordY()-1;				
				String element = t.getElement();
				setOntheMap(x, y, element);
			    			}
	
	}
	
	private void setOntheMap(int x, int y, String element){
		
		switch (element){
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
        	this.player=(Player) this.Map[x][y];
        	player.getElementPosition().setX(x);
        	player.getElementPosition().setY(y);
        	
        break;
        
        case "P":
        	this.Map[x][y] = this.factory.createDirt();
        	this.portal=new Portal();
        	this.portal.getElementPosition().setX(x);
        	this.portal.getElementPosition().setY(y);
        	
        break;
        case "N":
        	this.Map[x][y] = this.factory.createBlock();
        break;
        case "X":
        	this.Map[x][y] = this.factory.createMonster();
        	Monster monster = this.factory.createMonster();
        	monster=(Monster)this.Map[x][y];
        	monster.getElementPosition().setX(x);
        	monster.getElementPosition().setY(y);
        	this.monsterlist.add((Monster) monster);
        break;
                 }
			}

	@Override
	public void setLevel(Element Elm, Position pos) {
		if(pos.isTaken()){
			this.Map[pos.getX()][pos.getY()]=Elm;
			setChanged();
			notifyObservers();
			clearChanged();
		}
		}

	@Override
	public Element[][] getLevel() {
		return Map;
	}

	@Override
	public Player getPlayerPosition() {
		return this.player;
	}
	
	@Override
	public Element[][] getMap() {
		return Map;
	}
	
	@Override
	public void setMap(Element[][] map) {
		Map = map;
	}

	public void portalAppear() {
		if (!this.portalAppeared){
			setLevel(this.portal, this.portal.getElementPosition());
			System.out.println("EXIT!!!");
			this.portalAppeared=true;
					}
		}
}
