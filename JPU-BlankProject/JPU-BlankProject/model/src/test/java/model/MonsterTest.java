package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import element.Diamond;
import element.Monster;
import element.Nothing;

public class MonsterTest {
	Model map;
	Nothing nothing;
	ArrayList<Position> position = new ArrayList<Position>();
	Direction[] directionmonstre = {Direction.LEFT,Direction.UP,Direction.RIGHT,Direction.DOWN};
	
	@Before
	public void setUp(){
		
		this.map=new Model();
		this.nothing=new Nothing();
		
		for (int i = 0; i<5 ; i++){
			for (int j = 0; j<5; j++){
				map.getLevel()[i][j]=nothing;
			}
		}
	}	

	@Test
	public void testExplodeMonster() {
		Monster monster = new Monster();
		map.getLevel()[2][2]=monster;
		monster.getElementPosition().setX(2);
		monster.getElementPosition().setY(2);
		
		monster.explode(new BagOfPossiblePositions(5, 5),map);
		assertEquals(Diamond.class, map.getLevel()[1][1].getClass());
		assertEquals(Diamond.class, map.getLevel()[1][2].getClass());
		assertEquals(Diamond.class, map.getLevel()[1][3].getClass());
		assertEquals(Diamond.class, map.getLevel()[2][1].getClass());
		assertEquals(Diamond.class, map.getLevel()[2][2].getClass());
		assertEquals(Diamond.class, map.getLevel()[2][3].getClass());
		assertEquals(Diamond.class, map.getLevel()[3][1].getClass());
		assertEquals(Diamond.class, map.getLevel()[3][2].getClass());
		assertEquals(Diamond.class, map.getLevel()[3][3].getClass());
		assertEquals(Nothing.class, map.getLevel()[4][3].getClass());
		
	
	}

	@Test
	public void testMove() {
		Monster monster = new Monster();
		map.getLevel()[2][1]=monster;
		monster.getElementPosition().setX(2);
		monster.getElementPosition().setY(1);
		monster.move(null, map, directionmonstre, null);
		int expectedMonsterX = 1; 
		int expectedMonsterY = 2; 
		
		assertEquals(expectedMonsterX, monster.getElementPosition().getX());
		assertEquals(expectedMonsterY, monster.getElementPosition().getY());
	}
	
}
