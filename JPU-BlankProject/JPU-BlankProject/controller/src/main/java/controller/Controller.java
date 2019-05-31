package controller;

import java.util.Observable;
import java.util.Observer;

import javax.swing.text.View;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

public class Controller implements IController{
	IView view;
	IModel model;
	public Controller(IView view, IModel model){
		this.model= model;
		this.view = view;
		
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
