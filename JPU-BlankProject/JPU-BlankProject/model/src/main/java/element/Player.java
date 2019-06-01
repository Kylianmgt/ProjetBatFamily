package element;

import java.util.ArrayList;

import Behaviors.IBlock;
import Behaviors.IExplode;
import Behaviors.IFall;
import Behaviors.IMotion;
import Utility.BagOfPossiblePositions;
import Utility.Direction;
import Utility.Position;
import model.Model;

public class Player extends Element implements IMotion, IExplode {
	Nothing nothing = new Nothing();
	Position initialPosition = new Position();

	int score = 0;

	public ArrayList<Direction> amIOnALedge(final Model model) {
		final ArrayList<Direction> ledges = new ArrayList<Direction>();
		if (this.getElementPosition().getX() == 0) {
			ledges.add(Direction.LEFT);
		}
		if (this.getElementPosition().getX() == (model.getX() - 1)) {
			ledges.add(Direction.RIGHT);
		}
		if (this.getElementPosition().getY() == 0) {
			ledges.add(Direction.UP);

		}
		if (this.getElementPosition().getY() == (model.getY() - 1)) {
			ledges.add(Direction.DOWN);
		}
		return ledges;

	}

	public boolean canIMove(final Direction direction, final Model model) {
		// TODO Auto-generated method stub

		final int[] intDir = this.convertDirectionIntoInt(direction);
		final ArrayList<Direction> amIOnALedge = this.amIOnALedge(model);

		if (amIOnALedge.contains(direction)) {
			return false;

		} else {

			return !(model.getLevel()[this.getElementPosition().getX() + intDir[0]][this.getElementPosition().getY()
					+ intDir[1]] instanceof IBlock);

		}

	}

	@Override
	public ArrayList<ArrayList<Position>> explode(final BagOfPossiblePositions bag, final Model model) {
		model.setLevel(this.nothing, this.getElementPosition());
		this.getElementPosition().setTaken(false);
		try {
			Thread.sleep(1500);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
		return new ArrayList<ArrayList<Position>>();
		// TODO Auto-generated method stub

	}

	public int getScore() {
		return this.score;
	}

	@Override
	public boolean interaction(final Direction direction, final Model model, final BagOfPossiblePositions bag,
			final Player player) {
		this.explode(bag, model);
		return true;
	}

	@Override
	public void move(final ArrayList<Position> position, final Model model, final Direction direction,
			final BagOfPossiblePositions bag) {
		// TODO Auto-generated method stub
		this.initialPosition = this.getElementPosition();
		final int[] vecteurDir = this.convertDirectionIntoInt(direction);
		final ArrayList<Direction> amIOnALedge = this.amIOnALedge(model);

		if (this.canIMove(direction, model)) {
			model.getLevel()[this.getElementPosition().getX()][this.getElementPosition().getY()] = this.nothing;
			model.getLevel()[this.getElementPosition().getX() + vecteurDir[0]][this.getElementPosition().getY()
					+ vecteurDir[1]] = this;

		} else {
			if (!amIOnALedge.contains(direction)) {
				if (model.getLevel()[this.getElementPosition().getX() + vecteurDir[0]][this.getElementPosition().getY()
						+ vecteurDir[1]].interaction(direction, model, null, null)) {
					model.getLevel()[this.getElementPosition().getX()][this.getElementPosition().getY()] = this.nothing;
					model.getLevel()[this.getElementPosition().getX() + vecteurDir[0]][this.getElementPosition().getY()
							+ vecteurDir[1]] = this;
				} else {
					return;
				}

			} else {
				return;
			}
		}
		this.tellIFallToFall(position, model, bag);
		this.getElementPosition().setX(this.getElementPosition().getX() + vecteurDir[0]);
		this.getElementPosition().setY(this.getElementPosition().getY() + vecteurDir[1]);

	}

	public void setScore(final int score) {
		this.score = score;
	}

	private void tellIFallToFall(final ArrayList<Position> position, final Model model,
			final BagOfPossiblePositions bag) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 0; j++) {
				if (this.isNotOutOfBounds(model, this.initialPosition.getX() + i, this.initialPosition.getY() + j)) {

					if (model.getLevel()[this.initialPosition.getY() - 1][this.initialPosition.getX() + i]
							.getClass() == IFall.class) {
						if (((IFall) model.getLevel()[this.initialPosition.getY() - 1][this.initialPosition.getX() + i])
								.canIStartToFall(model)
								&& !(bag.getPosition()[this.initialPosition.getY() - 1][this.initialPosition.getX() + i]
										.isTaken())) {
							position.add(bag.getPosition()[this.initialPosition.getY() - 1][this.initialPosition.getX()
									+ i]);
							bag.getPosition()[this.initialPosition.getY() - 1][this.initialPosition.getX() + i]
									.setTaken(true);
						}

					}

				}
			}

		}
	}

}
