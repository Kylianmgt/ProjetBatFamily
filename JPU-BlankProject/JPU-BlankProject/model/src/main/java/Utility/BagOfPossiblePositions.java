package Utility;

public class BagOfPossiblePositions {
	Position[][] position;
	public Position[][] getPosition() {
		return position;
	}
	public void setPosition(Position[][] position) {
		this.position = position;
	}
	public BagOfPossiblePositions(int x, int y){
		this.position=new Position[x][y];
		for (int i = 0; i<x; i++){
			for (int j = 0; j<y; j++){
				this.position[i][j]=new Position();
			}
		}
	}
	

}
