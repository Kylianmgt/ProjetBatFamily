package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Behaviors.IBlock;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import element.Block;
import element.Dirt;
import element.Map;
import element.Nothing;
import element.Player;
import element.Rock;

public class PlayerTest {
	Map map = new Map();
	Player player= new Player();
	ArrayList<Position> position = new ArrayList<Position>();
	Direction direction;
	BagOfPossiblePositions bag = new BagOfPossiblePositions(5, 5);
	@Before
	public void setUp(){


	}

	@Test
	public void testMoveGauche() {
		map.getNiveau()[1][0]=player;
		player.getPositionElement().setX(1);
		player.getPositionElement().setY(0);
		player.move(position, map, Direction.LEFT, bag);
		assertEquals( Nothing.class, map.getNiveau()[1][0].getClass());
		assertEquals(player.getClass(), map.getNiveau()[0][0].getClass());
		


	}

	@Test
	public void testMoveDroite() {
		map.getNiveau()[0][0]=player;
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(0);
		player.move(position, map, Direction.RIGHT, bag);
		assertEquals(map.getNiveau()[0][0].getClass(), Nothing.class);
		assertEquals(map.getNiveau()[1][0].getClass(), player.getClass());


	}
	@Test
	public void testMoveDroiteWithBlockedPlayer() {
		map.getNiveau()[0][0]=player;
		
		map.getNiveau()[1][0]=new Block();
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(0);		
		player.move(position, map, Direction.RIGHT, bag);		
		
		assertEquals(false, player.canIMove(Direction.RIGHT, map));
		assertEquals( player.getClass(), map.getNiveau()[0][0].getClass());
		assertEquals( Block.class, map.getNiveau()[1][0].getClass());
		map.getNiveau()[1][0]=new Nothing();
		


	}
	@Test
	public void testCanIMoveDroiteWhenIAmFullDroite(){
		map.getNiveau()[map.getX()-1][0]=player;
		player.getPositionElement().setX(map.getX()-1);
		player.getPositionElement().setY(0);
		assertEquals(player.canIMove(Direction.RIGHT, map), false);
	}
	@Test
	public void testCanIMoveGaucheWhenIAmFullGauche(){
		map.getNiveau()[0][0]=player;
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(0);
		assertEquals(player.canIMove(Direction.LEFT, map), false);
	}
	@Test
	public void testCanIMoveHautWhenIAmFullHaut(){
		map.getNiveau()[0][0]=player;
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(0);
		assertEquals(player.canIMove(Direction.UP, map), false);
	}
	@Test
	public void testCanIBasHautWhenIAmFullBas(){
		map.getNiveau()[0][map.getY()-1]=player;
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(map.getY()-1);
		assertEquals(player.canIMove(Direction.DOWN, map), false);
	}
	@Test
	public void testCanIMoveGaucheWhenGaucheIsEmpty(){
		this.map.getNiveau()[0][0]=new Nothing();
		this.map.getNiveau()[1][0]=new Player();
		player.getPositionElement().setX(1);
		player.getPositionElement().setY(0);
		assertEquals(player.canIMove(Direction.LEFT,map), true);


	}
	@Test
	public void testCanIMoveGaucheWhenGaucheIsDirt(){
		this.map.getNiveau()[0][0]=new Dirt();
		this.map.getNiveau()[1][0]=new Player();
		player.getPositionElement().setX(1);
		player.getPositionElement().setY(0);
		assertEquals(true,player.canIMove(Direction.LEFT,map));


	}
	@Test
	public void testCanIMoveDroiteWhenDroiteIsEmpty(){
		this.map.getNiveau()[0][1]=new Nothing();
		this.map.getNiveau()[0][0]=new Player();
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(0);
		assertEquals(player.canIMove(Direction.RIGHT,map), true);


	}
	@Test
	public void testCanIMoveDroiteWhenDroiteIsDirt(){
		this.map.getNiveau()[0][1]=new Dirt();
		this.map.getNiveau()[0][0]=new Player();
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(0);
		assertEquals(player.canIMove(Direction.RIGHT,map), true);


	}
	@Test
	public void testCanIMoveHautWhenHautIsEmpty(){
		this.map.getNiveau()[0][0]=new Nothing();
		this.map.getNiveau()[0][1]=new Player();
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(1);
		assertEquals(player.canIMove(Direction.UP,map), true);


	}
	@Test
	public void testCanIMoveHautWhenHautIsDirt(){
		this.map.getNiveau()[0][0]=new Dirt();
		this.map.getNiveau()[0][1]=new Player();
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(1);
		assertEquals(player.canIMove(Direction.UP,map), true);


	}
	@Test
	public void testCanIMoveBasWhenBasIsEmpty(){
		this.map.getNiveau()[0][1]=new Nothing();
		this.map.getNiveau()[0][0]=new Player();
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(0);
		assertEquals(player.canIMove(Direction.DOWN,map), true);


	}
	@Test
	public void testCanIMoveBasWhenBasIsDirt(){
		this.map.getNiveau()[0][1]=new Dirt();
		this.map.getNiveau()[0][0]=new Player();
		player.getPositionElement().setX(0);
		player.getPositionElement().setY(0);
		assertEquals(true, player.canIMove(Direction.DOWN,map));


	}

}
