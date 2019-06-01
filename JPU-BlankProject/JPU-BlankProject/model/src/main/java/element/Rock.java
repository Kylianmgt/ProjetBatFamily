package element;






import Behaviors.IBePushed;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import contract.IModel;



public class Rock extends FallingElement implements IBePushed{
	@Override
	public boolean interaction( Direction direction, IModel model, BagOfPossiblePositions bag, Player player){
		return bePushed(direction, model);		
	}

	public boolean bePushed(Direction direction, IModel model) {
		int[] vecteurDir = this.convertDirectionIntoInt(direction);
		if (isNotOutOfBounds(model, this.getElementPosition().getX()+vecteurDir[0], this.getElementPosition().getY())){
			if (model.getLevel()[this.getElementPosition().getX()+vecteurDir[0]][this.getElementPosition().getY()].getClass()==Nothing.class){
				model.setLevel(new Nothing(), this.getElementPosition());
				this.getElementPosition().setX(this.getElementPosition().getX()+vecteurDir[0]);
				model.setLevel(this, this.getElementPosition());
				return true;
			}
		}

		return false;
	}




}
