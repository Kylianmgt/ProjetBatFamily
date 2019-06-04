package Behaviors;

import Utility.Direction;
import model.Model;


public interface IMotion extends IBehavior{
	public void move(Model Model, Direction direction);
}
