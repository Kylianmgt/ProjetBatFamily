package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Utility.BagOfPossiblePositions;
import Utility.Position;
import element.Diamond;
import element.Map;
import element.Monster;
import element.Nothing;

public class MonsterTest {
	Map map;
	Nothing nothing;
	ArrayList<Position> position = new ArrayList<Position>();
	
	@Before
	public void setUp(){
		this.map=new Map();
		this.nothing=new Nothing();
		map.setNiveau(null, null);
		for (int i = 0; i<5 ; i++){
			for (int j = 0; j<5; j++){
				map.getNiveau()[i][j]=nothing;
			}
		}
	}
	

	@Test
	public void testExplodeMonster() {
		Monster monster = new Monster();
		map.getNiveau()[2][2]=monster;
		monster.getPositionElement().setX(2);
		monster.getPositionElement().setY(2);
		
		monster.explode(new BagOfPossiblePositions(5, 5),map);
		assertEquals(Diamond.class, map.getNiveau()[1][1].getClass());
		assertEquals(Diamond.class, map.getNiveau()[1][2].getClass());
		assertEquals(Diamond.class, map.getNiveau()[1][3].getClass());
		assertEquals(Diamond.class, map.getNiveau()[2][1].getClass());
		assertEquals(Diamond.class, map.getNiveau()[2][2].getClass());
		assertEquals(Diamond.class, map.getNiveau()[2][3].getClass());
		assertEquals(Diamond.class, map.getNiveau()[3][1].getClass());
		assertEquals(Diamond.class, map.getNiveau()[3][2].getClass());
		assertEquals(Diamond.class, map.getNiveau()[3][3].getClass());
		assertEquals(Nothing.class, map.getNiveau()[4][3].getClass());
		
	
	}

}
