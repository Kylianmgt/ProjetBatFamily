package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import Utility.ElementFactory;
import contract.IModel;
import element.Element;
import entity.EntityPosition;
import entity.EntityPosition;
import entity.HelloWorld;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {
	
	
	

	private int level= 1;
	private ArrayList<EntityPosition> Tab;
	private Element Map[][];
	private String Map2[][];
	private ElementFactory factory;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		Map = new Element[25][25];
		Map2 = new String[25][25];
		factory = new ElementFactory();
		
		loadEntityPosition(level);
		creationMap(Tab);
		System.out.println(Arrays.deepToString(Map));
		
		//System.out.println(Tab);
		//System.out.println(Tab.get(0)[0];
	}

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public ArrayList<EntityPosition> getTab() {
		return this.Tab;
	}

	/**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
	private void setEntityPosition(final ArrayList<EntityPosition> Tab) {
		this.Tab = Tab;
		this.setChanged();
		this.notifyObservers();
	}

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadEntityPosition(final int level) {
		try {
			final DAOLevel daolevel = new DAOLevel(DBConnection.getInstance().getConnection());
			this.setEntityPosition(daolevel.find(level));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
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
	
	public void creationMap(ArrayList<EntityPosition> Tab){
		//int i =0;
			//for(i=0; i<625; i++)
		for (EntityPosition t:Tab){
			//if(t.getElement() != null){
				int x = t.getCoordX()-1;
				int y = t.getCoordY()-1;				
				String element = t.getElement();
				setOntheMap(x, y, element);
				// this.Map2[x-1][y-1] = t.getElement();
				//i++;
				// System.out.println(x + "    " +y + "   " + element + "     "+i);
				
				
					
				
						
			}
		
		//}
		
	}
	
	private void setOntheMap(int x, int y, String element){
		
		switch ("element"){
        case "O":
        	this.Map[x][y] = this.factory.createRock();
        break;
        
        case "D":
        	this.Map[x][y] = this.factory.createDiamond();
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
}
