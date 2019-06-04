package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import Utility.Direction;
import Utility.Position;
import contract.IModel;
import element.Block;
import element.Dirt;
import element.Nothing;
import element.Player;


public class PlayerTest {
	IModel map = new Model();
	Model map2 = new Model();
	Player player= new Player();
	ArrayList<Position> position = new ArrayList<Position>();
	Direction direction;
	@Before
	public void setUp(){


	}

	@Test
	public void testMoveGauche() {
		map2.getLevel()[1][0]=player;
		player.getElementPosition().setX(1);
		player.getElementPosition().setY(0);
		player.move( map2, Direction.LEFT);
		assertEquals( Nothing.class, map2.getLevel()[1][0].getClass());
		assertEquals(player.getClass(), map2.getLevel()[0][0].getClass());



	}

	@Test
	public void testMoveDroite() {
		map2.getLevel()[0][0]=player;
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);
		player.move( map2, Direction.RIGHT);
		assertEquals(map2.getLevel()[0][0].getClass(), Nothing.class);
		assertEquals(map2.getLevel()[1][0].getClass(), player.getClass());


	}
	@Test
	public void testMoveDroiteWithBlockedPlayer() {
		map2.getLevel()[0][0]=player;

		map2.getLevel()[1][0]=new Block();
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);		
		player.move(map2, Direction.RIGHT);		

		assertEquals(false, player.canIMove(Direction.RIGHT, map));
		assertEquals( player.getClass(), map2.getLevel()[0][0].getClass());
		assertEquals( Block.class, map2.getLevel()[1][0].getClass());
		map2.getLevel()[1][0]=new Nothing();



	}
	@Test
	public void testCanIMoveDroiteWhenIAmFullDroite(){
		map2.getLevel()[map2.getX()-1][0]=player;
		player.getElementPosition().setX(map2.getX()-1);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.RIGHT, map2), false);
	}
	@Test
	public void testCanIMoveGaucheWhenIAmFullGauche(){
		map2.getLevel()[0][0]=player;
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.LEFT, map2), false);
	}
	@Test
	public void testCanIMoveHautWhenIAmFullHaut(){
		map2.getLevel()[0][0]=player;
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.UP, map2), false);
	}
	@Test
	public void testCanIBasHautWhenIAmFullBas(){
		map2.getLevel()[0][map2.getY()-1]=player;
		player.getElementPosition().setX(0);
		player.getElementPosition().setY(map2.getY()-1);
		assertEquals(player.canIMove(Direction.DOWN, map2), false);
	}
	@Test
	public void testCanIMoveGaucheWhenGaucheIsEmpty(){
		this.map2.getLevel()[0][0]=new Nothing();
		this.map2.getLevel()[1][0]=new Player();
		player.getElementPosition().setX(1);
		player.getElementPosition().setY(0);
		assertEquals(player.canIMove(Direction.LEFT,map2), true);


	}
	@Test
	public void testCanIMoveGaucheWhenGaucheIsDirt(){
		this.map2.getLevel()[0][0]=new Dirt();
		this.map2.getLevel()[1][0]=new Player();
		player.getElementPosition().setX(1);
		player.getElementPosition().setY(0);
		assertEquals(true,player.canIMove(Direction.LEFT,map2));


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
