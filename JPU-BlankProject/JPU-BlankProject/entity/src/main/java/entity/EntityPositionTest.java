package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityPositionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCoordX() {
		EntityPosition position = new EntityPosition("O",0,0);
		int expected = 0;
		assertEquals(expected, position.getCoordX());
		
	}

	@Test
	public void testSetCoordX() {
		EntityPosition position = new EntityPosition("O",0,0);
		int expected = 1;
		position.setCoordX(1);
		assertEquals(expected, position.getCoordX());
	}

	@Test
	public void testGetCoordY() {
		EntityPosition position = new EntityPosition("O",0,0);
		int expected = 0;
		assertEquals(expected, position.getCoordY());
		
	}

	@Test
	public void testSetCoordY() {
		EntityPosition position = new EntityPosition("O",0,0);
		int expected = 1;
		position.setCoordY(1);
		assertEquals(expected, position.getCoordY());
	}

	@Test
	public void testGetElement() {
		EntityPosition position = new EntityPosition("O",0,0);
		String expected = "O";
		assertEquals(expected, position.getElement());
	}

	@Test
	public void testSetElement() {
		EntityPosition position = new EntityPosition("O",0,0);
		String expected = "Y";
		position.setElement("Y");
		assertEquals(expected, position.getElement());
	}

}
