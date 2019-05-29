package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;
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
	private String Map[][];

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		loadEntityPosition(level);
		creationMap(Tab);
		//System.out.println(Map);
		
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
		int i =1;
		for (EntityPosition t:Tab){
			if(t.getElement() != null){
				int x = t.getCoordX();
				int y = t.getCoordY();
				String element = t.getElement();
				setOntheMap(x, y, element);
				System.out.println(x + "    " +y + "   " + element + "     "+i);
				i++;
			}
			
		}
		
	}
	
	private final void setOntheMap(int x, int y, String element){
		
		this.Map[x][y] = element;
	}
}
