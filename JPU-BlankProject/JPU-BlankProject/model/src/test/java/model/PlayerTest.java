package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import element.Direction;
import element.Map;
import element.Nothing;
import element.Player;
import element.Position;

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
	public void testMoveDroite() {
		player.move(position, map, direction, positionJoueur);
		
		Position positionJoueur2 = new Position();
		for (int i=0;i<map.getX();i++){
			for(int j=0;j<map.getY();j++){
				if (map.getNiveau()[i][j].getClass()==player.getClass()){
					positionJoueur2.setX(i);
					positionJoueur2.setY(j);
				}
				
			}
		}
		if (!player.canIMove(Direction.DROITE, map, positionJoueur)){
			assertEquals(positionJoueur.getX(), positionJoueur2.getX());
			assertEquals(positionJoueur.getY(), positionJoueur2.getY());
		}else{
			assertEquals(positionJoueur.getX()+1, positionJoueur2.getX());
			assertEquals(positionJoueur.getY(), positionJoueur2.getY());
		}
		
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
		this.map.getNiveau()[0][1]=new Player();
		positionJoueur.setX(1);
		positionJoueur.setY(0);
		assertEquals(player.canIMove(Direction.GAUCHE,map,positionJoueur), true);
		
	
	}
	@Test
	public void testCanIMoveGaucheWhenGaucheIsDirt(){
		this.map.getNiveau()[0][0]=new Dirt();
		this.map.getNiveau()[0][1]=new Player();
		positionJoueur.setX(1);
		positionJoueur.setY(0);
		assertEquals(player.canIMove(Direction.GAUCHE,map,positionJoueur), true);
		
	
	}

}
