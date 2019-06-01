package model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.EntityPosition;

public class ModelTest {
	private  Observer observer;
	private DAOLevel dao;
    private Model model;
    private ArrayList<EntityPosition> P;
    private ArrayList<ArrayList<IElement>> maping;
    /* if idMap and idMapTest aren't equals the tests fail */
    private final int level = 1; 
    private final int levelTest = 1;
    
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.observer = new Observer();
		this.model = new Model(observer);
		try {
			this.dao= new DAOLevel(DBConnection.getInstance().getConnection());
		} catch (final SQLException e) {
			e.printStackTrace();
		this.P= dao.find(level);
		this.model.setLevel(, P);
			
		}
		this.Tab = new ArrayList<EntityPosition>();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadEntityPositionInt() {
		
	}

	@Test
	public void testCreationMap() {
		fail("Not yet implemented");
	}

}
