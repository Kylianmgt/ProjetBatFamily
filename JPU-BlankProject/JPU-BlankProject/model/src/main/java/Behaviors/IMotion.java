package Behaviors;

import java.util.ArrayList;


import Utility.Direction;
import Utility.Position;
import model.Model;


public interface IMotion extends IBehavior{
	public void move(Model Model, Direction direction);
}
