package model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import element.Element;
import entity.EntityPosition;

public class ModelTest {
private Model model;
private DAOLevel dao;
private ArrayList<EntityPosition> position;
private Element[][] maping;
private final int level = 1; 
private final int levelTest = 2;






	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.model = new Model();
		this.dao = new DAOLevel(DBConnection.getInstance().getConnection());
		this.position = dao.find(level);
		this.model.makeMap(position);
		this.maping = this.model.getMap();
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
