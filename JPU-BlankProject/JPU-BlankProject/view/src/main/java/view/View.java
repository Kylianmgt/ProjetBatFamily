package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import contract.IModel;
import contract.IView;
import element.Player;

public class View implements IView, Observer {
	public static void contentScore(final JPanel content) {
		final JPanel contentScore = new JPanel();
		contentScore.setBackground(Color.DARK_GRAY);

		content.add(contentScore, BorderLayout.EAST);
		final JLabel texteScore = new JLabel("Score :");
		texteScore.setForeground(Color.WHITE);
		contentScore.add(Player.getScore(), BorderLayout.CENTER);
	}

	IModel map;
	JFrame fenetre = new JFrame();
	JPanel panel = new JPanel();
	JPanel content = new JPanel();

	String score = new Player.score().toString();

	JLabel texte = new JLabel();

	public View(final IModel map) {
		this.map = map;

		this.fenetre.setTitle("BoulderDash");
		this.fenetre.setVisible(true);
		this.fenetre.add(this.panel);
		this.fenetre.setDefaultCloseOperation(3);
		this.fenetre.setSize(50, 50);
		this.panel.setLayout(new FlowLayout());
		this.refreshView();
	}

	@Override
	public void addListener(final KeyListener listener) {
		this.fenetre.addKeyListener(listener);
	}

	@Override
	public void followMyplayer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printMessage(final String message) {
		// TODO Auto-generated method stub

	}

	private void refreshView() {
		String str = "";
		for (int i = 0; i < this.map.getX(); i++) {
			for (int j = 0; j < this.map.getY(); j++) {
				str += this.map.getLevel()[i][j].getSprite();

			}
			str += '\n';
		}
		this.panel.remove(this.texte);
		this.texte.setText(str);
		this.panel.add(this.texte);

	}

	@Override
	public void update(final Observable arg0, final Object arg1) {
		this.refreshView();

	}

}
