package element;

public class Map {
	private final int X=5;	
	private final int Y=5;
	private Element[][] Niveau = new Element[5][5];	
	
	public Map(){
		for (int i=0; i<this.X; i++){
			for(int j=0; j<this.Y;j++){
				this.Niveau[i][j]=new Nothing();
			}
			this.Niveau[2][2] = new Dirt();
		}	
		}
		public Element[][] getLevel() {
		return Niveau;
	}
	public void setLevel(Element[][] niveau) {
		Niveau = niveau;
	}
	public int getY() {
		return Y;
	}
	public int getX() {
		return X;
	}

}
