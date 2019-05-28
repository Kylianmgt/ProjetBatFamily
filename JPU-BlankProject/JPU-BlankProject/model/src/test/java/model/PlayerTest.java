package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import element.Block;
import element.Direction;
import element.Dirt;
import element.Map;
import element.Nothing;
import element.Player;
import element.Position;
import element.Rock;

public class PlayerTest {
	Map map = new Map();
	Player player= new Player();
	Position positionJoueur = new Position();
	ArrayList<Position> position = new ArrayList<Position>();
	Direction direction;
	@Before
	public void setUp(){


	}

	@Test
	public void testMoveGauche() {
		map.getNiveau()[1][0]=player;
		positionJoueur.setX(1);
		positionJoueur.setY(0);
		player.move(position, map, Direction.GAUCHE, positionJoueur);
		assertEquals( Nothing.class, map.getNiveau()[1][0].getClass());
		assertEquals(player.getClass(), map.getNiveau()[0][0].getClass());
		


	}

	@Test
	public void testMoveDroite() {
		map.getNiveau()[0][0]=player;
		positionJoueur.setX(0);
		positionJoueur.setY(0);
		player.move(position, map, Direction.DROITE, positionJoueur);
		assertEquals(map.getNiveau()[0][0].getClass(), Nothing.class);
		assertEquals(map.getNiveau()[1][0].getClass(), player.getClass());


	}
	@Test
	public void testMoveDroiteWithBlockedPlayer() {
		map.getNiveau()[0][0]=player;
		map.getNiveau()[1][0]=new Block();
		positionJoueur.setX(0);
		positionJoueur.setY(0);
		player.move(position, map, Direction.DROITE, positionJoueur);
		assertEquals(false, player.canIMove(Direction.DROITE, map, positionJoueur));
		assertEquals( player.getClass(), map.getNiveau()[0][0].getClass());
		assertEquals( Block.class, map.getNiveau()[1][0].getClass());
		map.getNiveau()[1][0]=new Nothing();
		


	}
	@Test
	public void testCanIMoveDroiteWhenIAmFullDroite(){
		map.getNiveau()[map.getX()-1][0]=player;
		positionJoueur.setX(map.getX()-1);
		positionJoueur.setY(0);
		assertEquals(player.canIMove(Direction.DROITE, map, positionJoueur), false);
	}
	@Test
	public void testCanIMoveGaucheWhenIAmFullGauche(){
		map.getNiveau()[0][0]=player;
		positionJoueur.setX(0);
		positionJoueur.setY(0);
		assertEquals(player.canIMove(Direction.GAUCHE, map, positionJoueur), false);
	}
	@Test
	public void testCanIMoveHautWhenIAmFullHaut(){
		map.getNiveau()[0][0]=player;
		positionJoueur.setX(0);
		positionJoueur.setY(0);
		assertEquals(player.canIMove(Direction.HAUT, map, positionJoueur), false);
	}
	@Test
	public void testCanIBasHautWhenIAmFullBas(){
		map.getNiveau()[0][map.getY()-1]=player;
		positionJoueur.setX(0);
		positionJoueur.setY(map.getY()-1);
		assertEquals(player.canIMove(Direction.BAS, map, positionJoueur), false);
	}
	@Test
	public void testCanIMoveGaucheWhenGaucheIsEmpty(){
		this.map.getNiveau()[0][0]=new Nothing();
		this.map.getNiveau()[1][0]=new Player();
		positionJoueur.setX(1);
		positionJoueur.setY(0);
		assertEquals(player.canIMove(Direction.GAUCHE,map,positionJoueur), true);


	}
	@Test
	public void testCanIMoveGaucheWhenGaucheIsDirt(){
		this.map.getNiveau()[0][0]=new Dirt();
		this.map.getNiveau()[1][0]=new Player();
		positionJoueur.setX(1);
		positionJoueur.setY(0);
		assertEquals(true,player.canIMove(Direction.GAUCHE,map,positionJoueur));


	}
	@Test
	public void testCanIMoveDroiteWhenDroiteIsEmpty(){
		this.map.getNiveau()[0][1]=new Nothing();
		this.map.getNiveau()[0][0]=new Player();
		positionJoueur.setX(0);
		positionJoueur.setY(0);
		assertEquals(player.canIMove(Direction.DROITE,map,positionJoueur), true);


	}
	@Test
	public void testCanIMoveDroiteWhenDroiteIsDirt(){
		this.map.getNiveau()[0][1]=new Dirt();
		this.map.getNiveau()[0][0]=new Player();
		positionJoueur.setX(0);
		positionJoueur.setY(0);
		assertEquals(player.canIMove(Direction.DROITE,map,positionJoueur), true);


	}
	@Test
	public void testCanIMoveHautWhenHautIsEmpty(){
		this.map.getNiveau()[0][0]=new Nothing();
		this.map.getNiveau()[0][1]=new Player();
		positionJoueur.setX(0);
		positionJoueur.setY(1);
		assertEquals(player.canIMove(Direction.HAUT,map,positionJoueur), true);


	}
	@Test
	public void testCanIMoveHautWhenHautIsDirt(){
		this.map.getNiveau()[0][0]=new Dirt();
		this.map.getNiveau()[0][1]=new Player();
		positionJoueur.setX(0);
		positionJoueur.setY(1);
		assertEquals(player.canIMove(Direction.HAUT,map,positionJoueur), true);


	}
	@Test
	public void testCanIMoveBasWhenBasIsEmpty(){
		this.map.getNiveau()[0][1]=new Nothing();
		this.map.getNiveau()[0][0]=new Player();
		positionJoueur.setX(0);
		positionJoueur.setY(0);
		assertEquals(player.canIMove(Direction.BAS,map,positionJoueur), true);


	}
	@Test
	public void testCanIMoveBasWhenBasIsDirt(){
		this.map.getNiveau()[0][1]=new Dirt();
		this.map.getNiveau()[0][0]=new Player();
		positionJoueur.setX(0);
		positionJoueur.setY(0);
		assertEquals(true, player.canIMove(Direction.BAS,map,positionJoueur));


	}

}