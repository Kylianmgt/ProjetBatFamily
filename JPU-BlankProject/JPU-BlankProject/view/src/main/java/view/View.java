package view;

import java.awt.FlowLayout;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import contract.IModel;
import contract.IView;
import element.Element;

public class View implements IView, Observer{
	IModel map;
	JFrame fenetre = new JFrame();
	JPanel panel  = new JPanel();
	JLabel texte = new JLabel();
	
	public View (IModel map){
		this.map=map;
		
		fenetre.setTitle("BoulderDash");
		fenetre.setVisible(true);
		fenetre.add(panel);
		fenetre.setDefaultCloseOperation(3);
		fenetre.setSize(50, 50);
		panel.setLayout(new FlowLayout());
		refreshView();
	}
	
	private void refreshView() {
		String str="";
		for (int i = 0; i<map.getX();i++){
			for (int j = 0 ; j<map.getY(); j++){
				str+=map.getLevel()[i][j].getSprite();
				
			}
			str+='\n';
		}
		this.fenetre.remove(texte);
		this.texte.setText(str);
		this.fenetre.add(texte);
		
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
