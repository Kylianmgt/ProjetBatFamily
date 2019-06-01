package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

public class Map extends Observable implements IMap {
	private int width;

	private int height;
	private IElement[][] onTheMap;

	Map(final String fileName) throws IOException {
		super();
		this.loadFile(fileName);
	}

	@Override
	public final int getHeight() {
		return this.height;
	}

	@Override
	public Observable getObservable() {
		return this;
	}

	@Override
	public final IElement getOnTheMap(final int x, final int y) {
		return this.onTheMap[x][y];
	}

	@Override
	public final int getWidth() {
		return this.width;
	}

	private void loadFile(final String fileName) throws IOException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line;
		int y = 0;
		line = buffer.readLine();
		this.setWidth(Integer.parseInt(line));
		line = buffer.readLine();
		this.setHeight(Integer.parseInt(line));
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		line = buffer.readLine();
		while (line != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
				this.setOnTheMap(Element.getFromFileSymbol(line.toCharArray()[x]), x, y);
			}
			line = buffer.readLine();
			y++;
		}
		buffer.close();
	}

	private void setHeight(final int height) {
		this.height = height;
	}

	@Override
	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	private void setOnTheMap(final IElement string, final int x, final int y) {
		this.onTheMap[x][y] = string;
	}

	private void setWidth(final int width) {
		this.width = width;
	}

}
