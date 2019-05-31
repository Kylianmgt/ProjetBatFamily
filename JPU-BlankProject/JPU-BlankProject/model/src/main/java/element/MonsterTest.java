package element;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Utility.Direction;
import Utility.Position;

public class MonsterTest {
	private Element[][] Model;
	Map map = new Map();
	Monster monster= new Monster();
	Position positionMonster = new Position();
	ArrayList<Position> position = new ArrayList<Position>();
	Direction[] directionmonstre = {Direction.LEFT,Direction.UP,Direction.RIGHT,Direction.DOWN};

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
	public void testMove() {
		map.getLevel()[2][1]= monster;
		monster.getElementPosition().setX(1);
		monster.getElementPosition().setY(0);
		monster.move(position, model, direction, bag);
	}

	@Test
	public void testConvertDirectionIntoInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testCanImove() {
		fail("Not yet implemented");
	}

	
}
