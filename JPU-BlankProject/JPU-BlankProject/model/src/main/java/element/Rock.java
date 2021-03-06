package element;






import Behaviors.IBePushed;
import Behaviors.IFall;
import Utility.Direction;
import model.Model;

public class Rock extends FallingElement implements IBePushed, IFall{
	public Rock(){
		super();
		this.sprite = new Sprite("/rock.png");
	}
	@Override
	public boolean interaction( Direction direction, Model model,  Player player){
		return bePushed(direction, model);		
	}

	public boolean bePushed(Direction direction, Model model) {
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
