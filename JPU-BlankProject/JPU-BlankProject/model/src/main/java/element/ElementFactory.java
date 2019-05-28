package element;

public class ElementFactory {
	public Dirt createDirt(){
		return new Dirt();		
	}
	public Rock createRock(){
		return new Rock();		
	}
	public Nothing createNothing(){
		return new Nothing();		
	}
	public Block createBlock(){
		return new Block();		
	}
	
	public Player createPlayer(){
		return new Player();		
	}
	public Monster createMonster(){
		return new Monster();		
	}
	public Diamond createDiamond(){
		return new Diamond();
	}
}
