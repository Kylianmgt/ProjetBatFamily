package entity;

public class EntityPosition extends Entity{
	
	private int coordX;
	private int coordY;
	private String element;
	
	
	


	public EntityPosition(String element, int coordX, int coordY ){
		this.setCoordX(coordX);
		this.setCoordY(coordY);
		this.setElement(element);
	}

	public EntityPosition(){
		this("",0,0);
	}


	public int getCoordX() {
		return coordX;
	}




	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}




	public int getCoordY() {
		return coordY;
	}




	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}


	
	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}


	
	

}
