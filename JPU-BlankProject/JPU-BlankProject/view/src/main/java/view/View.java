package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import contract.IModel;
import contract.IView;
import controller.Controller;
import element.Element;
import view.sprites.Graph;

public class View implements IView, Observer{
	IModel map;
	JFrame fenetre = new JFrame();
	JPanel panel  = new JPanel();
	JLabel text = new JLabel();
	
	public View (IModel map){
		this.map=map;
		
		fenetre.setTitle("BoulderDash");
		fenetre.setVisible(true);
		fenetre.add(panel);
		fenetre.setDefaultCloseOperation(3);
		fenetre.setSize(500, 500);
		panel.setLayout(new FlowLayout());
		fenetre.setLocationRelativeTo(null);
	}
	
	public void refreshView() {
		String str="";
		for (int i = 0; i<map.getX();i++){
			for (int j = 0 ; j<map.getY(); j++){
				System.out.print(map.getLevel()[j][i].getSprite());
				str+=map.getLevel()[j][i].getSprite();
				
			}
			System.out.println();
		
			str+='\n';
		}
		System.out.println();
		this.panel.remove(text);
		this.text.setText(str);
		this.panel.add(text);
	
		
		
		
	}
	public void addListener(KeyListener listener){
		fenetre.addKeyListener(listener);
	}

	@Override
	public void followMyplayer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.refreshView();
		
	}

	

	

}
