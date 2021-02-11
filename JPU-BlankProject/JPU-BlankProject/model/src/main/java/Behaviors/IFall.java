package Behaviors;


import Utility.Direction;
import model.Model;


public interface IFall extends IBehavior{


	public boolean canIStartToFall( Model Model);
	public boolean canIFallDown(Model Model);
	public boolean canIContinueToFallDown(Model Model);
	public void canISlip(Model Model);
	
	public void fallDown(Model Model);
	public void slip(Direction direction, Model Model);


	public boolean continueToFall(Model Model);
	public boolean tryToFall(Model Model);
	public boolean isAmIFalling();

}
