package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import element.Block;
import element.Dirt;
import element.Nothing;
import element.Player;


public class PlayerTest {
	Model map = new Model();
	Player player= new Player();
	ArrayList<Position> position = new ArrayList<Position>();
	Direction direction;
	BagOfPossiblePositions bag = new BagOfPossiblePositions(5, 5);
	@Before
	public void setUp(){


	}

	@Test
	public void testMoveGauche() {
		map.getLevel()[1][0]=player;
		player.getElementPosition().setX(1);
		player.getElementPosition().setY(0);
		player.move(position, map, Direction.LEFT, bag);
		assertEquals( Nothing.class, map.getLevel()[1][0].getClass());
		assertEquals(player.getClass(), map.getLevel()[0][0].getClass());



	}

	@Test
	public void testMoveDroite() {
		map.getLevel()[0][0]=player;
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);
		player.move(position, map, Direction.RIGHT, bag);
		assertEquals(map.getLevel()[0][0].getClass(), Nothing.class);
		assertEquals(map.getLevel()[1][0].getClass(), player.getClass());


	}
	@Test
	public void testMoveDroiteWithBlockedPlayer() {
		map.getLevel()[0][0]=player;

		map.getLevel()[1][0]=new Block();
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);		
		player.move(position, map, Direction.RIGHT, bag);		

		assertEquals(false, player.canIMove(Direction.RIGHT, map));
		assertEquals( player.getClass(), map.getLevel()[0][0].getClass());
		assertEquals( Block.class, map.getLevel()[1][0].getClass());
		map.getLevel()[1][0]=new Nothing();



	}
	@Test
	public void testCanIMoveDroiteWhenIAmFullDroite(){
		map.getLevel()[map.getX()-1][0]=player;
		player.getElementPosition().setX(map.getX()-1);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.RIGHT, map), false);
	}
	@Test
	public void testCanIMoveGaucheWhenIAmFullGauche(){
		map.getLevel()[0][0]=player;
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.LEFT, map), false);
	}
	@Test
	public void testCanIMoveHautWhenIAmFullHaut(){
		map.getLevel()[0][0]=player;
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.UP, map), false);
	}
	@Test
	public void testCanIBasHautWhenIAmFullBas(){
		map.getLevel()[0][map.getY()-1]=player;
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(map.getY()-1);
		assertEquals(player.canIMove(Direction.DOWN, map), false);
	}
	@Test
	public void testCanIMoveGaucheWhenGaucheIsEmpty(){
		this.map.getLevel()[0][0]=new Nothing();
		this.map.getLevel()[1][0]=new Player();
		player.getElementPosition().setX(1);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.LEFT,map), true);


	}
	@Test
	public void testCanIMoveGaucheWhenGaucheIsDirt(){
		this.map.getLevel()[0][0]=new Dirt();
		this.map.getLevel()[1][0]=new Player();
		player.getElementPosition().setX(1);
		player.getElementPosition().setY(0);
		assertEquals(true,player.canIMove(Direction.LEFT,map));


	}
	@Test
	public void testCanIMoveDroiteWhenDroiteIsEmpty(){
		this.map.getLevel()[0][1]=new Nothing();
		this.map.getLevel()[0][0]=new Player();
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.RIGHT,map), true);


	}
	@Test
	public void testCanIMoveDroiteWhenDroiteIsDirt(){
		this.map.getLevel()[0][1]=new Dirt();
		this.map.getLevel()[0][0]=new Player();
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.RIGHT,map), true);


	}
	@Test
	public void testCanIMoveHautWhenHautIsEmpty(){
		this.map.getLevel()[0][0]=new Nothing();
		this.map.getLevel()[0][1]=new Player();
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(1);
		assertEquals(player.canIMove(Direction.UP,map), true);


	}
	@Test
	public void testCanIMoveHautWhenHautIsDirt(){
		this.map.getLevel()[0][0]=new Dirt();
		this.map.getLevel()[0][1]=new Player();
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(1);
		assertEquals(player.canIMove(Direction.UP,map), true);


	}
	@Test
	public void testCanIMoveBasWhenBasIsEmpty(){
		this.map.getLevel()[0][1]=new Nothing();
		this.map.getLevel()[0][0]=new Player();
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.DOWN,map), true);


	}
	@Test
	public void testCanIMoveBasWhenBasIsDirt(){
		this.map.getLevel()[0][1]=new Dirt();
		this.map.getLevel()[0][0]=new Player();
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);
		assertEquals(true, player.canIMove(Direction.DOWN,map));


	}
 
}
