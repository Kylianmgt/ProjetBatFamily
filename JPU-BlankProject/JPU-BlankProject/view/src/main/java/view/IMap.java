package view;

import java.util.Observable;

public interface IMap {

	int getHeight();

	Observable getObservable();

	IElement getOnTheMap(int x, int y);

	int getWidth();

	void setMobileHasChanged();

}
