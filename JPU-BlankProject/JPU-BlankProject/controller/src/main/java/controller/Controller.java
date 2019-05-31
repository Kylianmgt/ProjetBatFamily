package controller;

import java.util.Observable;
import java.util.Observer;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public class Controller implements IController{
	IView view;
	IModel model;
	public Controller(IView view, IModel model){
		this.view = view;
		this.model= model;
	}

	@Override
	public void control() {
		model.

	}

	@Override
	public void orderPerform(ControllerOrder controllerOrder) {
		// TODO Auto-generated method stub

	}



}
