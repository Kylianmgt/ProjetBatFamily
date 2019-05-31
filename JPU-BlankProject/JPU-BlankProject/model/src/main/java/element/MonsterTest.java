package element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MonsterTest {
	private Element[][] map;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	map = new Element[5][5];
	creationMapTest();
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertDirectionIntoInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testCanImove() {
		fail("Not yet implemented");
	}
	public void creationMapTest(){
		for (int i = 0;i<5;i++){
			for (int j = 0;j<5;j++){
				map[i][j]= new Nothing();
			}
		}
		map[2][2] = new Dirt();
		
	}
}
