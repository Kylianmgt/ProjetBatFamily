package element;






import Behaviors.IBePushed;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import model.Model;



public class Rock extends FallingElement implements IBePushed{
	@Override
	public boolean interaction( Direction direction, Model model, BagOfPossiblePositions bag, Player player){
		return bePushed(direction, model);		
	}

	public boolean bePushed(Direction direction, Model model) {
		int[] vecteurDir = this.convertDirectionIntoInt(direction);
		if (isNotOutOfBounds(model, this.getPositionElement().getX()+vecteurDir[0], this.getPositionElement().getY())){
			if (model.getNiveau()[this.getPositionElement().getX()+vecteurDir[0]][this.getPositionElement().getY()].getClass()==Nothing.class){
				model.setNiveau(new Nothing(), this.getPositionElement());
				this.getPositionElement().setX(this.getPositionElement().getX()+vecteurDir[0]);
				model.setNiveau(this, this.getPositionElement());
				return true;
			}
		}

		return false;
	}




}
