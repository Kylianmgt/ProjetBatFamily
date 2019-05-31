package element;






import Behaviors.IBePushed;
import Utility.BagOfPossiblePositions;
import Utility.Direction;



public class Rock extends FallingElement implements IBePushed{
	@Override
	public boolean interaction( Direction direction, Map map, BagOfPossiblePositions bag, Player player){
		return bePushed(direction, map);		
	}

	public boolean bePushed(Direction direction, Map map) {
		int[] vecteurDir = this.convertDirectionIntoInt(direction);
		if (isNotOutOfBounds(map, this.getPositionElement().getX()+vecteurDir[0], this.getPositionElement().getY())){
			if (map.getNiveau()[this.getPositionElement().getX()+vecteurDir[0]][this.getPositionElement().getY()].getClass()==Nothing.class){
				map.setNiveau(new Nothing(), this.getPositionElement());
				this.getPositionElement().setX(this.getPositionElement().getX()+vecteurDir[0]);
				map.setNiveau(this, this.getPositionElement());
				return true;
			}
		}

		return false;
	}




}
