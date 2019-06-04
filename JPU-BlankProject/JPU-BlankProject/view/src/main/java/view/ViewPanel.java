package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IModel;
import element.Player;
import model.Model;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {
	private IModel model;

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame, IModel model) {
		this.model=model;
		this.setViewFrame(viewFrame);
	}

	private String intToString(int score) {
		// TODO Auto-generated method stub
		return ""+ score;
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		graphics.setFont(new Font("impact", Font.BOLD, 45));
		graphics.setColor(new Color(255,0,0));
		//graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 10, 20);
		
		
		
		
			for(int x=0;x<25;x++){
		   
			for (int y=0;y<25;y++){
				graphics.drawImage((this.getViewFrame().getModel().getLevel()[x][y].getSprite().getImage()), x*this.getWidth()/25, y*this.getHeight()/25,this.getWidth()/25, this.getHeight()/25, this);
				if (x==24 && y == 1){
					
					 
					graphics.drawString(intToString(model.getPlayerPosition().getScore()),  (x*this.getWidth()/25)-5,  (y*this.getHeight()/25)+30);
				}
				
			}
			
		}
		

	}
}
