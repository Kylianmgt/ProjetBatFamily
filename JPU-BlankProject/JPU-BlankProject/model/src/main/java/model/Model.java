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
import element.Dirt;
import element.Element;
import element.Monster;
import element.Nothing;
import element.Player;
import element.Portal;
import entity.EntityPosition;



public  class Model extends Observable implements IModel{
	
	private boolean portalAppeared= false;
	private Player player; 
	private Portal portal;
	private final int X= 25;
	private final int Y= 25;
	
	/* (non-Javadoc)
	 * @see model.IModel#getX()
	 */
	/* (non-Javadoc)
	 * @see model.IModel#getX()
	 */
	@Override
	public int getX() {
		return X;
	}

	/* (non-Javadoc)
	 * @see model.IModel#getY()
	 */
	/* (non-Javadoc)
	 * @see model.IModel#getY()
	 */
	@Override
	public int getY() {
		return Y;
	}

	private int level= 4;
	private ArrayList<EntityPosition> Tab;
	private Element[][] Map;
	private String[][] Map2;
	private ElementFactory factory;
	private ArrayList<Monster> monsterlist;


	/* (non-Javadoc)
	 * @see model.IModel#getMonsterlist()
	 */
	@Override
	public ArrayList<Monster> getMonsterlist() {
		return monsterlist;
	}

	/* (non-Javadoc)
	 * @see model.IModel#setMonsterlist(java.util.ArrayList)
	 */
	@Override
	public void setMonsterlist(ArrayList<Monster> monsterlist) {
		this.monsterlist = monsterlist;
	}

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.Map = new Element[25][25];
		this.Map2 = new String[25][25];
		this.factory = new ElementFactory();
		this.monsterlist = new ArrayList<Monster>();
		loadEntityPosition(level);
		makeMap(Tab);
		System.out.println(Arrays.deepToString(Map));
		
		//System.out.println(Tab);
		//System.out.println(Tab.get(0)[0];
	}
	

	private void setEntityPosition(final ArrayList<EntityPosition> Tab) {
		this.Tab = Tab;
		this.setChanged();
		
		
	}

	/* (non-Javadoc)
	 * @see model.IModel#loadEntityPosition(int)
	 */
	/* (non-Javadoc)
	 * @see model.IModel#loadEntityPosition(int)
	 */
	@Override
	public void loadEntityPosition(final int level) {
		try {
			final DAOLevel daolevel = new DAOLevel(DBConnection.getInstance().getConnection());
			this.setEntityPosition(daolevel.find(level));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}


	/* (non-Javadoc)
	 * @see model.IModel#getObservable()
	 */
	/* (non-Javadoc)
	 * @see model.IModel#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}

	/* (non-Javadoc)
	 * @see model.IModel#getEntityPosition()
	 */
	/* (non-Javadoc)
	 * @see model.IModel#getEntityPosition()
	 */
	@Override
	public EntityPosition getEntityPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see model.IModel#loadEntityPosition(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see model.IModel#loadEntityPosition(java.lang.String)
	 */
	@Override
	public void loadEntityPosition(String code) {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see model.IModel#makeMap(java.util.ArrayList)
	 */
	/* (non-Javadoc)
	 * @see model.IModel#makeMap(java.util.ArrayList)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see model.IModel#setLevel(element.Element, Utility.Position)
	 */
	/* (non-Javadoc)
	 * @see model.IModel#setLevel(element.Element, Utility.Position)
	 */
	@Override
	public void setLevel(Element Elm, Position pos) {
		if(pos.isTaken()){
			this.Map[pos.getX()][pos.getY()]=Elm;
			setChanged();
			notifyObservers();
			clearChanged();
		}
		
	}
	/* (non-Javadoc)
	 * @see model.IModel#getLevel()
	 */
	/* (non-Javadoc)
	 * @see model.IModel#getLevel()
	 */
	@Override
	public Element[][] getLevel() {
		return Map;
	}

	/* (non-Javadoc)
	 * @see model.IModel#getPlayerPosition()
	 */
	/* (non-Javadoc)
	 * @see model.IModel#getPlayerPosition()
	 */
	@Override
	public Player getPlayerPosition() {
		// TODO Auto-generated method stub
		return this.player;
	}
	
	
	/* (non-Javadoc)
	 * @see model.IModel#getMap()
	 */
	/* (non-Javadoc)
	 * @see model.IModel#getMap()
	 */
	@Override
	public Element[][] getMap() {
		return Map;
	}

	/* (non-Javadoc)
	 * @see model.IModel#setMap(element.Element[][])
	 */
	/* (non-Javadoc)
	 * @see model.IModel#setMap(element.Element[][])
	 */
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
		// TODO Auto-generated method stub
		
	}
}
